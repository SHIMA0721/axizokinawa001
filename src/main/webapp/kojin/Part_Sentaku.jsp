<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<h3>アルバイト管理</h3>

		<input type="button" value="新規作成"onClick="location.href='Sift_Sink.jsp'">

<form name=sihutok method=POST action="Ok.jsp">
	<table>
		<tr>
			<th>名前</th>
			<th>時給</th>
			<th>交通費</th>
			<th>深夜手当て</th>
			<th>早期手当て</th>
			</tr>
			<tr>
			<td width="40%"><input type="checkbox"><a href="Sift_Henkou.jsp" >吉野家</a></td><td>700円</td><td>1000円</td><td>1000円</td><td>1000円</td>
			</tr>
			<tr>
			<td><input width="40%" type="checkbox">マック</td><td>800円</td><td>1000円</td>
			</tr>
			<tr>
			<td><input width="40%" type="checkbox">ブルーシール</td><td>1000円</td><td>900円</td>
			</tr>
		</table>

		<input type="submit" value="削除">
		</form>

		 <br> <br>
		<A HREF="login.jsp">ログアウト</A> <br> <br> <A
			HREF="KarendaMein.jsp">戻る</A>
	</div>
</body>
</html>