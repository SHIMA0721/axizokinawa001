<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>名前がありました！</h1>

				<s:iterator value="list">
				<table border="1" align="center">
				<tr>
  				<th><s:property value="UserName" /></th>
				</tr>
				</TABLE>
				</s:iterator>
				<br clear="all">

		<ul>
			<li><a href="name.jsp">戻る</a></li>
		</ul>
	</div>
</body>
</html>