<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<%@include file="Master.jsp" %>
   <br>
	<form name="userForm" action="insertUser" method="POST"  onsubmit="return doValidateUserForm();">
		<table border="1" cellpadding="10" align="center">
			<tr><th colspan="2">User Registration</th></tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="userName" /></td>
			<tr>
			  <td>Email Id</td>	
		      <td><input type="text" name="userEmail"></td>
			</tr>
			<tr>
			  <td>Mobile No</td>	
		      <td><input type="text" name="mobileNum"></td>
			</tr>
			<tr>
				<td>Address </td>
				<td><textarea rows="5" cols="15" name="address" ></textarea><br></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="Submit">&nbsp;
				<input type="reset"value="Clear"> <br></td>
			</tr>
		</table>
	</form>
<%@include file="Footer.jsp" %>
</body>
</html>