package com.kaishengit.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Utils {
	/**
	 * 压缩文件
	 * @param srcfile File[]  需要压缩的文件列表
	 * @param zipfile File    压缩后的文件
	 */
	public static void ZipFiles(File[] srcfile, File zipfile) {
	  byte[] buf = new byte[1024];
	  try {
	    // Create the ZIP file
	    ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
	    // Compress the files
	    for (int i = 0; i < srcfile.length; i++) {
	      FileInputStream in = new FileInputStream(srcfile[i]);
	      // Add ZIP entry to output stream.
	      out.putNextEntry(new ZipEntry(srcfile[i].getName()));
	      // Transfer bytes from the file to the ZIP file
	      int len;
	      while ( (len = in.read(buf)) > 0) {
	        out.write(buf, 0, len);
	      }
	      // Complete the entry
	      out.closeEntry();
	      in.close();
	    }
	    // Complete the ZIP file
	    out.close();
	    System.out.println("压缩完成.");
	  }
	  catch (IOException e) {
	    e.printStackTrace();
	  }
	}
	
	
	public static String toUtf8String(String s){
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<s.length();i++){
		char c = s.charAt(i);
		if (c >= 0 && c <= 255){sb.append(c);}
		else{
		byte[] b;
		try { b = Character.toString(c).getBytes("utf-8");}
		catch (Exception ex) {
		System.out.println(ex);
		b = new byte[0];
		}
		for (int j = 0; j < b.length; j++) {
		int k = b[j];
		if (k < 0) k += 256;
		sb.append("%" + Integer.toHexString(k).toUpperCase());
		}
		}
		}
		return sb.toString();
		}
	
	
	
}