<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>ID、PASSの登録お願いします。</h3>
		<form name=sihutok method=POST action="Ok.jsp">

			<p>
				ID：<input type="text" name="ID">
			</p>
			<p>
				PASS：<input type="Password" name="Pass">
			</p>
			<p>
				PASS(再入力)：<input type="Password" name="Pass">
			</p>

			<input type="submit" value="変更"> <br>
		</form>
		<br>
		<A HREF="login.jsp">戻る</A>
		</div>
</body>
</html>