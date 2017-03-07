
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<img src="../imgs/banner.jpg" width="1100" height="120"/><br><br>

<form name="loginForm" action="loginUser" method="post">
  <table border="1" cellpadding="10" align="center" >
  <tr>
  <td colspan="2" align="center">User Login </td>
  </tr>
  <tr> 
      <td>   User ID</td>
      <td><input type="text" name="userId"></td>
  </tr>
  <tr> 
      <td>   Password</td>
      <td><input type="password" name="password"></td>
  </tr>
  <tr> 
       <td colspan="2" align="center"><input type="submit" value="Login"></td>
  </tr>
  </table>
  </form>
  ${msg}<br/>
  No account?? <a href="regUser">Click Here</a>
  <%@include file="Footer.jsp" %>
  </body>
  </html>