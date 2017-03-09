<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register to Priyakart</title>
<%@include file="itemHeader.jsp" %>
<section id="template_content_wrapper">
  <div id="template_content">
  
   <form name="userForm" action="insertUser" method="POST"  onsubmit="return doValidateUserForm();">
	<table border="0" cellpadding="10" align="center">
	   <tr><th colspan="2">Register to Priyakart</th></tr>
	   <tr><td>Name</td><td><input type="text" name="userName" /></td></tr>
	   <tr><td>Email Id</td><td><input type="text" name="userEmail"></td></tr>
	   <tr><td>Mobile No</td><td><input type="text" name="mobileNum"></td></tr>
	   <tr><td>Address </td><td><textarea rows="5" cols="22" name="address" ></textarea><br></td></tr>
	   <tr><td colspan="2" align="center"><input type="submit" value="Submit">&nbsp;
		<input type="reset"value="Clear"> <br></td></tr>
    </table>
   </form>
	${msg}
   </div> <!-- end of content -->
</section>
<%@include file="itemFooter.jsp" %>