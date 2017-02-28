<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LocationReg</title>
<style type="text/css">
table tr th{
	color: white;
	background-color: black;
}
</style>
</head>
<body>
<%@include file="Master.jsp" %>
   <br>
	<form name="locForm" action="insertLoc" method="post" onsubmit="return doValidateLocForm();">
		<table border="1" cellpadding="10" align="center">
			<tr><th colspan="2">Location Registration</th></tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="locName" /> <span id="locNameErr"></span></td>
			<tr>
				<td>Type</td>
				<td><input type="radio" name="locType" value="Urban" />Urban 
				<input type="radio" name="locType" value="Rural" />Rural <span id="locTypeErr"></span></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save" />
				<input type="reset" value="Clear" /></td>
			</tr>
		</table>
	</form>
${msg}<br/>
<a href="viewAllLoc">View All Records</a>

<%@include file="Footer.jsp" %>
</body>
</html>