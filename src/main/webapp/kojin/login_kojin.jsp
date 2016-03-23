<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<s:fielderror />
		<s:actionerror/>

		<h3>ログイン</h3>
		<s:form action="log" theme="simple">

			<table border="0" width="300">
				<tr>
					<td bgcolor="#aaeb49">ユーザID</td>
					<td bgcolor="#ffffff"><s:textfield key="User_Id" /></td>
				</tr>

				<tr>
					<td bgcolor="#aaeb49">パスワード</td>
					<td bgcolor="#ffffff"><s:password key="pass" /></td>
					<s:hidden key="ProcessStatus" value="1" />
				</tr>
			</table>
			<center>
				<s:submit value="ログイン" />
				<s:reset value="リセット" />
			</center>
		</s:form>
	</div>
</body>
</html>