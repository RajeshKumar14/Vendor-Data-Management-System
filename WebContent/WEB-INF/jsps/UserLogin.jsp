
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link href='../css/header.css' type='text/css' rel='stylesheet'/>   
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in to Priyakart </title>
<%@include file="itemHeader.jsp" %>
<section id="template_content_wrapper">
  <div id="template_content">
   <form name="loginForm" action="loginUser" method="post">
     <table border="0" align="center" cellpadding="10">
      <tr><th colspan="2">Log In to Priyakart</th></tr>
      <tr><td><input type="text" name="userId" placeholder="Email Address or Phone NO."></td></tr> 
      <tr><td><input type="password" name="password" placeholder="Password"></td></tr>
      <tr><td align="center"><input type="submit" name="LogIn"  size="60" value="Log In"></td></tr>
     </table>
   </form>
    <p align="center"><a href="regUser">New to Priyakart? SignUp</a></p> 
  </div> <!-- end of content -->
</section>
<%@include file="itemFooter.jsp" %>