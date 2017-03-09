<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Data</title>
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
<table border="1"  align="center" cellpadding="10">
<tr><th colspan="6">Vendor Details</th></tr>
<tr>
 <th>Id</th><th>Name</th><th>Location</th><th>Email Id</th><th>Mobile No</th><th></th>
</tr>
<c:forEach items="${venListObj}" var="ven">
<tr>
<td><a href="updateVen?VenId=<c:out value="${ven.venId}"/>">
<c:out value="${ven.venId}"/></a></td>
<td><c:out value="${ven.venName}"/></td>
<td><c:out value="${ven.loc.locName}"/></td>
<td><c:out value="${ven.venEmail}"/></td>
<td><c:out value="${ven.venMobile}"/></td>
<td><a href="deleteVen?VenId=<c:out value="${ven.venId}"/>">Delete</a></td>
</tr>
</c:forEach>
</table>
<a href="venExcelExport">Download Excel</a>
| <a href="venPdfExport">Download PDF</a>
<%@include file="vdmFooter.jsp" %>
</body>
</html>