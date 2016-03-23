<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="db.UserInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	ArrayList<UserInfo> list  = (ArrayList<UserInfo>)request.getAttribute("list");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>
<body>
  ログインできました。<br>
 <br>
 ユーザの一覧を表示します。<br>
 <table border="1">
   <tr>
     <th>user_id</th>
     <th>user_name</th>
     <th>password</th>
   </tr>
   <%
     for (int i = 0;i< list.size();i++) {
       UserInfo user = list.get(i);
       out.print("<tr>");
       out.print("<td>"+ user.getUserId()+"</td>");
       out.print("<td>"+ user.getUserName()+"</td>");
       out.print("<td>"+ user.getPassword()+"</td>");
       out.print("</tr>");
     }
   %>
  </table>
</body>
</html>