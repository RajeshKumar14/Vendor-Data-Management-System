<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Vendor</title>
</head>
<body>
<%@include file="vdmHeader.jsp" %>
   <br>
	<form action="venUpdate" method="post">
		<table border="1"  cellpadding="10" align="center">
		
			<tr><th colspan="2">Edit Vendor</th></tr>
			<tr>
				<td>Id</td>
				<td><input type="text" name="venId" value="${venObj.venId}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="venName" value="${venObj.venName}" /></td>
				</tr>
			<tr>
				<td>Location</td>
				<td>
				<select name="loc.locId">
                <c:forEach items="${locListObj}" var="loc">
                     <c:if test="${loc.locId eq venObj.loc.locId}">
                <option value="${loc.locId}" selected="selected"><c:out value="${loc.locName}"/></option>
                     </c:if>
                     <c:if test="${loc.locId != venObj.loc.locId}">
                <option value="${loc.locId}"><c:out value="${loc.locName}"/></option>
                     </c:if>
                 
                 </c:forEach>
             </select> </td>
			</tr>
			<tr>
				<td>Email ID</td>
				<td><input type="text" name="venEmail" value="${venObj.venEmail}" /></td>
				</tr>
				
			<tr>
				<td>Mobile No</td>
				<td><input type="text" name="venMobile" value="${venObj.venMobile}" /></td>
				</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form>
	<%@include file="vdmFooter.jsp" %>
</body>
</html>