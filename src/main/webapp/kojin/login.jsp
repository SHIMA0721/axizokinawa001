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
	<h2>給料速報！</h2>
	<form action="KarendaMein.jsp" method="POST">
		<table>
				<tr>
					<th>ユーザID</th>
					<td><s:textfield key="userId" /></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><s:password key="pass" /></td>
				</tr>
		</table>
		<input type="submit" value="ログイン">
		</form>

<br><br>
<A HREF="Syoki_User.jsp">初めての方はこちら！</A>
	</div>
</body>

</html>