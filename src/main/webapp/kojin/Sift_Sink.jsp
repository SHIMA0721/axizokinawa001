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
		<h3>新規アルバイト</h3>
		<form name=sihutok method=POST action="Ok.html">
			<p>
				仕事先：<input type="text" name="sihutname">
			</p>
			<br>
			<p>
				時給：<input type="text" name="sihutname">
			</p>
			<br>
			<p>
				交通費：<input type="text" name="sihutname">
			</p>
			<br>
			<p>
				目標金額：<input type="text" name="sihutname">
			</p>
			<br>
			<p>
				深夜手当て：<input type="text" name="sihutname">
			</p>
			<br>
			<p>
				早朝手当て：<input type="text" name="sihutname">
			</p>
			<input type="submit" value="作成"> <br>

		</form>
		<br> <br> <A HREF="login.jsp">ログアウト</A> <br> <br>
		<A HREF="Arubait_Sentaku.jsp">戻る</A>
	</div>
</body>
</html>