<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>拿云信息股票预测服务</title>
<meta name="description" content="稳定可靠的股票预测服务" />
<meta name="keywords"
	content="dassmeta, nayun, nayun.info, nayun, 拿云, 拿云信息,stock,股票,预测" />
<meta name="author" content="nayun.info" />
<!-- <link rel="shortcut icon" href="favicon.ico"> -->
<!-- Bootstrap -->
<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/datepicker3.css" rel="stylesheet">
<link href="${ctx}/css/styles.css" rel="stylesheet">
</head>
<body>

	<div class="row">
		<div
			class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">Log in</div>
				<div class="panel-body">
					<form role="form">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="E-mail" name="email"
									type="email" autofocus="">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password"
									name="password" type="password" value="">
							</div>
							<div class="checkbox">
								<label> <input name="remember" type="checkbox"
									value="Remember Me">Remember Me </label>
							</div>
							<a href="index.html" class="btn btn-primary">Login</a>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<!-- /.col-->
	</div>
	<!-- /.row -->



	<script src="${ctx}/js/jquery-1.11.1.min.js"></script>
	<script src="${ctx}/js/bootstrap.min.js"></script>
	<script src="${ctx}/js/chart.min.js"></script>
	<script src="${ctx}/js/chart-data.js"></script>
	<script src="${ctx}/js/easypiechart.js"></script>
	<script src="${ctx}/js/easypiechart-data.js"></script>
	<script src="${ctx}/js/bootstrap-datepicker.js"></script>
	<script>
		!function($) {
			$(document)
					.on(
							"click",
							"ul.nav li.parent > a > span.icon",
							function() {
								$(this).find('em:first').toggleClass(
										"glyphicon-minus");
							});
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function() {
			if ($(window).width() > 768)
				$('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function() {
			if ($(window).width() <= 767)
				$('#sidebar-collapse').collapse('hide')
		})
	</script>
</body>
</html>