<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
<style type="text/css">
table tr th{
	color: white;
	background-color: black;
}
</style>
</head>
<body>
<%@include file="vdmHeader.jsp" %>
   <br>
	<form name="custForm" action="insertCust" method="post"  onsubmit="return doValidateCustForm();">
		<table border="1" cellpadding="10" align="center">
			<tr><th colspan="2">Customer Registration</th></tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="custName" /><span id="custNameErr"></span></td>
			<tr>
			  <td>Email Id</td>	
		      <td><input type="text" name="custEmail"><span id="custEmailErr"></span></td>
			</tr>
			<tr>
			  <td>Mobile No</td>	
		      <td><input type="text" name="custMobile"><span id="custMobileErr"></span></td>
			</tr>
			<tr>
				<td>Reg. Num</td>
				<td><input type="text" name="custRegNum" /><span id="custRegNumErr"></span></td>
			<tr>
			<tr>
			    <td>Type</td>
				<td><select name="custType">
				        <option value="-1">--select--</option>
				        <option value="Seller">Seller</option>
				        <option value="Consumer">Consumer</option>
                  </select><br></td>
			<tr>
			<tr>
				<td>Address </td>
				<td><textarea rows="5" cols="15" name="custAddress" ></textarea><span id="custAddressErr"></span><br></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="Register">&nbsp;
				<input type="reset"value="Reset"> <br></td>
			</tr>
		</table>
	</form>
${msg}<br/>
<a href="viewAllCust">View All Records</a>
<%@include file="vdmFooter.jsp" %>
</body>
</html>