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
				<div class="container-fluid">
					<div class="row-fluid">
						<div class="span12">
							<div class="page-header">
								<h1>
									<small>注册新应用</small>
								</h1>
							</div>
							<form class="form-horizontal" id="app-create-form">
								<table id="app-create-table" class="table table-bordered table-hover table-condensed">
									<tbody>
										<tr>
											<td style="text-align: right;"><label class="control-label" for="appCode">应用代码&nbsp;&nbsp;</label></td>
											<td><div>
													<input id="appCode" name="appCode" placeholder="应用代码" size="60" type="text" />
												</div></td>
										</tr>
										<tr>
											<td style="text-align: right;"><label class="control-label" for="appName">应用名称&nbsp;&nbsp;</label></td>
											<td><div>
													<input id="appName" name="appName" placeholder="应用名称" size="60" type="text" />
												</div></td>
										</tr>
										<tr>
											<td style="text-align: right;"><label class="control-label" for="appUrl">应用地址&nbsp;&nbsp;</label></td>
											<td><div>
													<input id="appUrl" name="appUrl" placeholder="应用地址" size="60" type="text" />
												</div></td>
										</tr>
										<tr>
											<td style="text-align: right;"><label class="control-label" for="ssoAction">单点登录地址&nbsp;&nbsp;</label></td>
											<td><div>
													<input id="ssoAction" name="ssoAction" placeholder="单点登录地址" size="60" type="text" />
												</div></td>
										</tr>
										<tr>
											<td style="text-align: right;"><label class="control-label" for="nameKey">用户名参数&nbsp;&nbsp;</label></td>
											<td><div>
													<input id="nameKey" name="nameKey" placeholder="用户名参数" size="60" type="text" />
												</div></td>
										</tr>
										<tr>
											<td style="text-align: right;"><label class="control-label" for="passKey">密码参数&nbsp;&nbsp;</label></td>
											<td><div>
													<input id="passKey" name="passKey" placeholder="密码参数" size="60" type="text" />
												</div></td>
										</tr>
										<tr>
											<td style="text-align: right;"><label class="control-label" for="isShow">系统是否显示&nbsp;&nbsp;</label></td>
											<td><div>
													<input id="isShow" name="isShow" placeholder="系统是否显示" size="60" type="text" /><label style="color: red;">&nbsp;&nbsp; *数字0显示，1不显示</label>
												</div></td>
										</tr>
										<tr>
											<td style="text-align: right;"><label class="control-label" for="sort">排序字段&nbsp;&nbsp;</label></td>
											<td><div>
													<input id="sort" name="sort" placeholder="排序字段" size="60" type="text" /><label style="color: red;">&nbsp;&nbsp;*数字</label>
												</div></td>
										</tr>
										<tr>
											<td style="text-align: right;"><label class="control-label" for="description">应用描述&nbsp;&nbsp;</label></td>
											<td><div>
													<textarea id="description" name="description" cols="80" rows="6" placeholder="应用描述"></textarea>
												</div></td>
										</tr>
										<tr>
											<td><label class="control-label" for="description"></label></td>
											<td><div>
													<button id="app-create-save-btn" style="margin-left: 80px;" class="btn btn-primary btn-sm" type="button">保&nbsp;&nbsp;存</button>
													<button id="app-create-reset-btn" style="margin-left: 120px;" class="btn btn-primary btn-sm" type="button">重&nbsp;&nbsp;置</button>
													<button id="app-create-return-btn" style="margin-left: 120px;" class="btn btn-primary btn-sm" type="button">返&nbsp;&nbsp;回</button>
												</div></td>
										</tr>
									</tbody>
								</table>
							</form>
							<div class="modal fade" tabindex="-1" role="dialog" id="app-create-modal">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title">Modal title</h4>
										</div>
										<div class="modal-body">
											<p></p>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/common/footer.jsp"%>
	<script src="${ctx }/js/model/app-create.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>