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
									<button type="button" class="btn btn-primary btn-xs">删除</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pager">
					<li class="previous"><a href="your/nice/url">«</a></li>
					<li><a href="your/nice/url">1</a></li>
					<li class="active"><a href="your/nice/url">2</a></li>
					<li><a href="your/nice/url">3</a></li>
					<li><a href="your/nice/url">4</a></li>
					<li><a href="your/nice/url">5</a></li>
					<li class="next"><a href="your/nice/url">»</a></li>
				</ul>
			</div>
		</div>
	</div>
	<%@ include file="/common/footer.jsp"%>
</body>
</html>