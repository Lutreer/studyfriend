<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %> 
<!DOCTYPE html>
<html ng-app="xueyouApp" id="html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>STUDY friend</title>
    <link rel="shortcut icon" href="" />
    <!-- Load CSS files-->
    <link href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="static/css/plugin/bootstrap/bootstrap-datetimepicker.min.css" rel="stylesheet"/>   
    <link href="static/css/plugin/bootstrap/font-awesome.min.css" rel="stylesheet"/>   
    <link href="static/css/customer/common.css" rel="stylesheet"/>   
    <link href="static/css/customer/index.css" rel="stylesheet"/>   
    <link href="static/css/customer/app.css" rel="stylesheet"/>   
</head>
<body id="body">
	<header>
		<nav class="navbar navbar-inverse nav_top navbar-fixed-top top_nav">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">STUDY friend 撒旦法萨芬</a>
				</div>
			</div>
		</nav>
	</header>
	<div class="col-sm-12 all_view">
		<div class="col-sm-3 app_list"><applist></applist></div>
		<div class="col-sm-9 data_ui_view_class" data-ui-view=""></div>
	</div>
	<footer>
		<div class="footer_div">
			<div class="footer_header col-sm-12">
				<i class="fa fa-github-alt"></i>
				<i class="fa fa-envelope-o"></i>
				<i class="fa fa-info-circle"></i>
			</div>
			<div class="col-sm-5">
				<div class="col-sm-12 git_email_detail">
					<i class="fa fa-github-alt"></i><a href="https://github.com/Lutreer/studyfriend" target="_blank">github.com/Lutreer/studyfriend.git</a>
				</div>
				<div class="col-sm-12 git_email_detail">
					<i class="fa fa-envelope-o"></i>lxuidesigner@gmail.com
				</div>
				<div class="col-sm-12 git_email_detail">
					<i class="fa fa-info-circle"></i>Version:1.0.0.20150724_alpha 
				</div>
			</div>
		</div>
	</footer>
	<!-- å¬å±æç¤ºæ¡ -->
	<!-- æ­¤å¤bs-example-modal-lg modal-lg æ ·å¼å°æ¨¡ææ¡è®¾ç½®ä¸ºå¤§æ¡ ï¼å¦æä¸ºbs-example-modal-sm modal-små³ä¸ºå°æ¡-->
	<div class="modal fade bs-example-modal-sm" id="alert_dialog" role="dialog" aria-label="myModalLabel" aria-hidden="true">
		<div id="modal_dialog" class="modal-dialog modal-sm">
			<div class="modal-content">
				<div id="dialog_header" class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>			
					</button>
					<h4 class="modal-title">[Title]</h4>
				</div>
				<div class="modal-body">
				    <p>[Message]</p>
				</div>
				<div class="modal-footer">
				    <button type="button" id="dialog_ok_button" class="btn btn-primary ok" data-dismiss="modal">
				    [BtnOk]
				    </button>
	 			    <button type="button" id="dialog_cancel_button" class="btn btn-default cancel" data-dismiss="modal">
				    [BtnCancel]
				    </button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Load plugin js file-->
	<script src="http://cdn.bootcss.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="static/js/plugin/bootstrap/bootstrap-datetimepicker.min.js"></script>
	<!-- <script src="static/js/plugin/bootstrap/bootstrap-datetimepicker.zh-CN.js"></script> -->
	<script src="static/js/plugin/angular/angular.js"></script>
	<!-- <script src="/static/js/plugin/flatui/flat-ui.min.js" th:src="@{/js/plugin/flatui/flat-ui.min.js}"></script> -->
	<script src="static/js/plugin/angular/angular-route.min.js"></script>
	<script src="static/js/plugin/angular/angular-resource.min.js"></script>
	
	<!-- <script src="../static/js/plugin/angular/angular-loader.min.js" th:src="@{/js/plugin/angular/angular-loader.min.js"></script> -->
	
	<script src="static/js/plugin/angular/angular-ui-router.js"></script>
	<script src="static/js/plugin/angular/angular-file-upload-shim.min.js"></script>
	<script src="static/js/plugin/angular/angular-file-upload.min.js"></script>
	<script src="static/js/plugin/angular/angular-base64-upload.min.js"></script>
	<!-- Load custom js file -->
	<script src="static/js/customer/common/app.js"></script>
	<script src="static/js/customer/common/directive.js"></script>
	<script src="static/js/customer/common/common.js"></script>
	<script src="static/js/customer/common/style.js"></script>
	<script src="static/js/customer/cumt/cumtCtrl.js"></script>
	<script src="static/js/customer/cumt/cumtService.js"></script>
</body>
</html>