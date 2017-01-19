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
<link href="${ctx}/css/bootstrap-table.css" rel="stylesheet">
<link href="${ctx}/css/styles.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>Lumino</span>Admin</a>
				<ul class="user-menu">
					<li class="dropdown pull-right"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><span
							class="glyphicon glyphicon-user"></span> User <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><span class="glyphicon glyphicon-user"></span>
									Profile</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-cog"></span>
									Settings</a></li>
							<li><a href="#"><span
									class="glyphicon glyphicon-log-out"></span> Logout</a></li>
						</ul></li>
				</ul>
			</div>

		</div>
		<!-- /.container-fluid -->
	</nav>

	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li><a href="index.html"><span
					class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
			<li><a href="widgets.html"><span
					class="glyphicon glyphicon-th"></span> Widgets</a></li>
			<li><a href="charts.html"><span
					class="glyphicon glyphicon-stats"></span> Charts</a></li>
			<li class="active"><a href="/stocks"><span
					class="glyphicon glyphicon-list-alt"></span> Stocks</a></li>
			<li><a href="forms.html"><span
					class="glyphicon glyphicon-pencil"></span> Forms</a></li>
			<li><a href="panels.html"><span
					class="glyphicon glyphicon-info-sign"></span> Alerts &amp; Panels</a></li>
			<li class="parent "><a href="#"> <span
					class="glyphicon glyphicon-list"></span> Dropdown <span
					data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em
						class="glyphicon glyphicon-s glyphicon-plus"></em></span>
			</a>
				<ul class="children collapse" id="sub-item-1">
					<li><a class="" href="#"> <span
							class="glyphicon glyphicon-share-alt"></span> Sub Item 1
					</a></li>
					<li><a class="" href="#"> <span
							class="glyphicon glyphicon-share-alt"></span> Sub Item 2
					</a></li>
					<li><a class="" href="#"> <span
							class="glyphicon glyphicon-share-alt"></span> Sub Item 3
					</a></li>
				</ul></li>
			<li role="presentation" class="divider"></li>
			<li><a href="login.html"><span
					class="glyphicon glyphicon-user"></span> Login Page</a></li>
		</ul>
		<div class="attribution">
			Dassmeta <a href="http://stock.dassmeta.com/" target="_blank"
				title="stock spider">Trading Reason Service</a>
		</div>
	</div>
	<!--/.sidebar-->

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">Stocks</li>
			</ol>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<table id="stocks-table">
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/.main-->

	<script src="${ctx}/js/jquery-1.11.1.min.js"></script>
	<script src="${ctx}/js/bootstrap.min.js"></script>
	<script src="${ctx}/js/chart.min.js"></script>
	<script src="${ctx}/js/chart-data.js"></script>
	<script src="${ctx}/js/easypiechart.js"></script>
	<script src="${ctx}/js/easypiechart-data.js"></script>
	<script src="${ctx}/js/bootstrap-datepicker.js"></script>
	<script src="${ctx}/js/bootstrap-table.js"></script>
	<script src="${ctx}/js/bootstrap-table-zh-CN.min.js"></script>
	<script src="${ctx}/js/stock-spider/stocks.js"></script>
</body>
</html>