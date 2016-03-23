<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- %@ taglib prefix="s" uri="/struts-tags"% -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>メニュー</h1>
		<!-- ログイン結果メッセージ -->
		<table border="0" width="300">
			<tr>
				<td bgcolor="khaki">ユーザ</td>
				<td bgcolor="khaki">
					<!-- s:property value="userId" / --></td>
			</tr>
			<tr>
				<td bgcolor="khaki">パスワード</td>
				<td bgcolor="khaki">
					<!-- s:property value="pass" / --></td>
			</tr>

		</table>
		<ul>
			<li><a href="login.jsp">戻る</a></li>
		</ul>
	</div>
</body>
</html>