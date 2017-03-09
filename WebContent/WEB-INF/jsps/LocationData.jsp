<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
     
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LocationData</title>
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
<table border="1" align="center" cellpadding="10">
<tr><th colspan="4">Location Details</th></tr>
<tr>
 <th>Id</th><th>Name</th><th>Type</th><th></th>
</tr>
<c:forEach items="${locListObj}" var="loc">
<tr>
<td><a href="updateLoc?LocId=<c:out value="${loc.locId}"/>"><c:out value="${loc.locId}"/></a></td>
<td><c:out value="${loc.locName}"/></td>
<td><c:out value="${loc.locType}"/></td>
<td><a href="deleteLoc?LocId=<c:out value="${loc.locId}"/>">Delete</a></td>
</tr>
</c:forEach>
</table>
<%@include file="vdmFooter.jsp" %>
</body>
</html>