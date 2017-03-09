<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LocationEdit</title>

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
	<form name="locForm"action="locUpdate" method="post" onsubmit="return doValidateLocForm();">
		<table border="1"  cellpadding="10" align="center">
		
			<tr><th colspan="2">Edit Location</th></tr>
			<tr>
				<td>Id</td>
				<td><input type="text" name="locId" value="${locObj.locId}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="locName" value="${locObj.locName}"/><span id="locNameErr"></span></td>
			<tr>
				<td>Type</td>
				<td>
				<c:choose>
				 <c:when test="${locObj.locType eq 'Urban'}">
					<input type="radio" name="locType" value="Urban" checked="checked"/>Urban 
				    <input type="radio" name="locType" value="Rural" />Rural <span id="locTypeErr"></span>
				 </c:when>
				 <c:otherwise>
				   <input type="radio" name="locType" value="Urban" />Urban 
				   <input type="radio" name="locType" value="Rural" checked="checked" />Rural <span id="locTypeErr"></span>
				 </c:otherwise>
			    </c:choose></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form>
	${msg}<br/>
<%@include file="vdmFooter.jsp" %>
</body>
</html>