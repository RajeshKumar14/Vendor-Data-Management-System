<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CustomerData</title>
</head>
<body>
<%@include file="vdmHeader.jsp" %>
<br>
<table border="1"  align="center" cellpadding="10">
<tr><th colspan="8">Customer Details</th></tr>
<tr>
 <th>Id</th><th>Name</th><th>Email ID</th><th>Mobile No</th><th>Reg.No</th><th>Type</th><th>Address</th><th></th>
</tr>
<c:forEach items="${custListObj}" var="cust">
<tr>
<td><a href="updateCust?CustId=<c:out value="${cust.custId}"/>">
<c:out value="${cust.custId}"/></a></td>
<td><c:out value="${cust.custName}"/></td>
<td><c:out value="${cust.custEmail}"/></td>
<td><c:out value="${cust.custMobile}"/></td>
<td><c:out value="${cust.custRegNum}"/></td>
<td><c:out value="${cust.custType}"/></td>
<td><c:out value="${cust.custAddress}"/></td>
<td><a href="deleteCust?CustId=<c:out value="${cust.custId}"/>">Delete</a></td>
</tr>
</c:forEach>
</table>
<%@include file="vdmFooter.jsp" %>
</body>
</html>