package com.kaishengit.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kaishengit.cumt.pojo.ErrorPojo;


@Controller
public class HelloController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	
	@RequestMapping(value="/cumt", method = { RequestMethod.POST })
	public void index(@RequestParam String modifyDate,@RequestParam String randomMin,@RequestParam String randomMax,
			@RequestParam("file") MultipartFile file,@RequestParam String fileName,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		if (request.getCharacterEncoding() == null) {  
            request.setCharacterEncoding("UTF-8");  
        }
		ErrorPojo error = null;
		@SuppressWarnings("unused")
		boolean isError = false;
		try {
			System.out.println("dfsgsdfg水电费水电费水电费水电费"+fileName);
			String[] date = modifyDate.split("-");
			String oldFileName = fileName;
			oldFileName = new String(oldFileName.getBytes(),"UTF-8");
			String[] oldFileNameArr = oldFileName.split("\\.");
			String oldDate = oldFileNameArr[0].substring(oldFileNameArr[0].length()-10, oldFileNameArr[0].length());
			
			String newFileName = oldFileNameArr[0].replaceAll(oldDate, modifyDate) + "." +oldFileNameArr[1];
			newFileName = new String(newFileName.getBytes(),"UTF-8");
			error = new ErrorPojo(); 
			
			HSSFWorkbook wb = new HSSFWorkbook(file.getInputStream());
			HSSFSheet sheet = wb.getSheetAt(0);
			
			//获取总行数
			int rowNum = sheet.getLastRowNum();//索引从0开始
			int columnNum;
			if(rowNum < 3){//少于4行
				isError = true;
				error.setCode(1);
				error.setErrorMessage("文件“"+file.getName()+"”中出现格式错误（Excel少于4行），请检查后重新上传！");
			}else{
				//获取总列数
				columnNum = sheet.getRow(1).getPhysicalNumberOfCells();
				if(columnNum < 8){
					isError = true;
					error.setCode(1);
					error.setErrorMessage("文件“"+file.getName()+"”中出现格式错误（Excel少于9列），请检查后重新上传！");
				}else{
					//仪器型号:  Trimble DiNi 03    监测日期:  2015  年  07  月  11  日      天气:    晴
					String oldDateStr = sheet.getRow(1).getCell(0).getStringCellValue();
					String[] oldDateStrArr = oldDateStr.split(":");
					String newDateStr = oldDateStrArr[0] + ":" + oldDateStrArr[1] + ":    "
										+ date[0] + "  年  " + date[1] + "  月  " + date[2] + "  日    " + "    天气:" + oldDateStrArr[3];
					sheet.getRow(1).getCell(0).setCellValue(newDateStr);
					
					//变形速率(mm/天)
					Float max = Float.parseFloat(randomMax);
					Float min = Float.parseFloat(randomMin);
					Float random = max-min;
					String BXSLFormula = randomMin+"+RAND()*("+random.toString()+")";
					for(int j = 3; j < rowNum-1; j++){
						sheet.getRow(j).getCell(5).setCellFormula(BXSLFormula);
					}
					
					//本次沉降量(mm)
					for(int j = 3; j < rowNum-1; j++){
						String BCCDLtTargetColumn = "F";
						int targetRow = j+1;
						String BCCDLFormula = BCCDLtTargetColumn + targetRow;
						sheet.getRow(j).getCell(2).setCellFormula(BCCDLFormula);
					}
					//前次累计  沉降量(mm)
					for(int j = 3; j < rowNum-1; j++){
						String QCLJCDLTargetColumnE = "E";
						String QCLJCDLTargetColumnC = "C";
						int targetRow = j+1;
						QCLJCDLTargetColumnE = QCLJCDLTargetColumnE + targetRow;
						QCLJCDLTargetColumnC = QCLJCDLTargetColumnC + targetRow;
						sheet.getRow(j).getCell(3).setCellFormula(QCLJCDLTargetColumnE+"-"+QCLJCDLTargetColumnC);
					}
					
					response.setContentType("application/vnd.ms-excel");     
					response.setHeader("Content-disposition", "attachment;filename=" + newFileName);
					
					OutputStream out = response.getOutputStream();
					
					wb.write(out);  
					out.flush();          
					out.close();
				}
			}
		} catch (Exception e) {
			isError = true;
			error.setCode(1);
			error.setErrorMessage("文件格式错误！");
			e.printStackTrace();
		}
		
       /* if(isError){
        	return  new ResponseEntity<Object>(new Resource<ErrorPojo>(error), HttpStatus.BAD_REQUEST);
        }else{
        	return  new ResponseEntity<Object>(new Resource<ErrorPojo>(error), HttpStatus.OK);
        }*/
		
		
	}
	
}
