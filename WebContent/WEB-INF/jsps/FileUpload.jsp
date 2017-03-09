<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Document</title>
<style type="text/css">
a {
 text-decoration: none;
 color: black;
}
</style>
</head>
<body>
<%@include file="Master.jsp" %>
<br>
<form action="uploadData" method="post" enctype="multipart/form-data">
<table border="1" cellpadding="10" align="center">
<tr>
<td>Document</td>
<td><input type="file" name="filessobj" ></td>
<td rowspan="2" align="center"><input type="submit"  value="Upload"></td>
</tr>
</table>
</form>
<br>

<table border="1"  align="center" cellpadding="10">
<tr>
 <th>Id</th><th>Name</th><th></th>
</tr>
<c:forEach items="${obList}" var="fOb">
<tr>
<td><c:out value="${fOb[0]}"/></td>
<td><a href='downloadFile?fileId=<c:out value="${fOb[0]}"/>'>
<c:out value="${fOb[1]}"/></a></td>
<td><a href='deleteFile?FileId=<c:out value="${fOb[0]}"/>'>Delete</a></td>
</tr>
</c:forEach>
</table>
<%@include file="vdmFooter.jsp" %>
</body>
</html>