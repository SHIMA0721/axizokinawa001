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
		<h1>検索したい名前を入力してください</h1>
		<s:form action="name">

				<table border="0" width="300">
					<tr>
						<td bgcolor="skyblue">名前</td>
						<td bgcolor="khaki"><s:textfield key="name" /></td>
					</tr>
				</table>
				<s:submit value="検索" />
				<s:reset value="リセット" />
		</s:form>
	</div>
</body>

</html>