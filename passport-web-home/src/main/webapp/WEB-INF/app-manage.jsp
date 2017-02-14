<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/common/meta.jsp"%>
<!-- Bootstrap -->
<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/bootstrap-theme.min.css" rel="stylesheet">
<script src="${ctx}/js/jquery-1.11.1.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<%@ include file="/common/top.jsp"%>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>应用名称</th>
							<th>应用地址</th>
							<th>应用简介</th>
							<th>创建时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${appList}" var="item">
							<tr>
								<td>${item.id}</td>
								<td>${item.appName}</td>
								<td>${item.appUrl}</td>
								<td>${item.description}</td>
								<td>${item.createTime}</td>
								<td><button type="button" class="btn btn-primary btn-xs">定制菜单</button>
									<button type="button" class="btn btn-primary btn-xs">编辑</button>
									<button type="button" class="btn btn-primary btn-xs">删除</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pagination">
					<li><a href="#">Prev</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">Next</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>