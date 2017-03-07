
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in to Priyakart </title>
<style>
/* content */
#template_content {
	width: 400px;
	height:200px;
	margin: 0 auto;
	padding: 40px 40px;
	background-color:#FDFEFE;
}
   #div{
     font-size: 14px;
     text-align: center;
     width: 20px;
     height: 10px;
     
  }
   
</style>
<%@include file="Header.jsp" %>
<section id="template_content_wrapper">
  <div id="template_content">
   <form name="loginForm" action="loginUser" method="post">
     <table border="0" align="center" cellspacing="20px;">
      <tr><td><input type="text" name="userId" placeholder="Email Address or Phone NO."></td></tr> 
      <tr><td><input type="password" name="password" placeholder="Password"></td></tr>
      <tr><td><input type="submit" name="LogIn"  size="20" value="Log In"></td></tr>
     </table>
   </form>
    <p align="center"> No account?? <a href="regUser">Click Here</a></p> 
  </div> <!-- end of content -->
</section>
<%@include file="Footer.jsp" %>