<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/common/meta.jsp"%>
</head>
<body>
	<div class="row">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">Login</div>
				<div class="panel-body">
					<form role="form" method="post" action="${ctx}<passport-security:authconstant value='login_url'/>">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="E-mail" name="<passport-security:authconstant value='username'/>" type="email" autofocus="" />
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password" name="<passport-security:authconstant value='password'/>" type="password" value="" />
							</div>
							<div class="checkbox">
								<label> <input name="remember" type="checkbox" value="Remember Me" />Remember Me
								</label>
							</div>
							<button class="btn btn-primary " type="submit">Login</button>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<!-- /.col-->
	</div>
	<!-- /.row -->
	<%@ include file="/common/footer.jsp"%>
</body>

</html>