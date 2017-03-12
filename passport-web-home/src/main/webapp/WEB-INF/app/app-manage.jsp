<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/common/meta.jsp"%>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<%@ include file="/common/top.jsp"%>
				<div id="toolbar">
					<button id="app-manage-add-btn" class="btn btn-success">
						<i class="glyphicon glyphicon-add"></i>注册新应用
					</button>
				</div>
				<table id="app-manage-table"></table>
			</div>
		</div>
	</div>
	<%@ include file="/common/footer.jsp"%>
	<script src="${ctx }/js/model/app-manage.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>