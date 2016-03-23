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
		<h3>通知設定</h3>
		<form name=sihutok method=POST action="Ok.jsp">
			<br>

			月初からログイン日付までの給料合計金額
			<select name="blood">
				<option value="" selected>表示</option>
				<option value="YOSI">非表示</option>
			</select><br><br>

			税金発生警報
			<select name="blood">
				<option value="" selected>表示</option>
				<option value="YOSI">非表示</option>
			</select><br><br>


			目標金額までの日数
			<select name="blood">
				<option value="" selected>表示</option>
				<option value="YOSI">非表示</option>
			</select><br><br>


			目標金額の設置<br>
			<input type="text" name="mokuhyou">

<br><br>

			<input type="submit" value="変更"> <br>
		</form>
<br><br>
		<A HREF="login.jsp">ログアウト</A> <br> <br>
		<A HREF="KarendaMein.jsp">戻る</A>
	</div>
</body>
</html>