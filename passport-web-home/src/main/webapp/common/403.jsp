<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<style type="text/css">  
			.alpha{ 
			   filter:alpha(opacity=50); 
			}  
		</style>
		<script type="text/javascript">
		function gotohome(){
			if(parent.myFrame != null && parent.myFrame.name == 'myFrame'){
				parent.parent.location.href = "${ctx}/";
			} else {
				document.location.href = "${ctx}/";
			}
		}
		
		</script>
	</head>
	<body style="width:100%; height:100%; margin:0px; padding:0px; color:#FFFFFF; font-size:12px;">
<img id="imgbg" src="../images/qx_bg.jpg" width="100%" height="100%" style="right:0; bottom:0; position:absolute; top:0; left:0; z-index: -1" />
	
		<table width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<td height="60">&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		  </tr>
		  <tr>
			<td width="7%" height="62">&nbsp;</td>
			<td width="33%"><img src="../images/wqx.png" /></td>
			<td width="57%">&nbsp;</td>
			<td width="3%">&nbsp;</td>
		  </tr>
		  <tr>
			<td>&nbsp;</td>
			<td style="color:#FF0000; font-size:12px; text-align:center;" valign="top">
				<a href="javascript:gotohome();">返回首页</a>
				<a href="<c:url value="/specter_security_login_out"/>">退出登录</a>
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		  </tr>
		</table>
	</body>
</html>