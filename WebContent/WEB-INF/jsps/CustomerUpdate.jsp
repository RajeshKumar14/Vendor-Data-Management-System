<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CustomerUpdate</title>
</head>
<body>
<%@include file="vdmHeader.jsp" %>
   <br>
	<form name="custForm" action="custUpdate" method="post"  onsubmit="return doValidateCustForm();">
		<table border="1" cellpadding="10" align="center">
			<tr><th colspan="2">Edit Customer</th></tr>
			<tr>
				<td>CustID</td>
				<td><input type="text" name="custId" value="${custObj.custId}" readonly="readonly"/></td>
			<tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="custName" value="${custObj.custName}"/><span id="custNameErr"></span></td>
			<tr>
			  <td>Email Id</td>	
		      <td><input type="text" name="custEmail" value="${custObj.custEmail}"><span id="custEmailErr"></span></td>
			</tr>
			<tr>
			  <td>Mobile No</td>	
		      <td><input type="text" name="custMobile" value="${custObj.custMobile}"><span id="custMobileErr"></span></td>
			</tr>
			<tr>
				<td>Reg. Num</td>
				<td><input type="text" name="custRegNum"  value="${custObj.custRegNum}"/><span id="custRegNumErr"></span></td>
			<tr>
			<tr>
			    <td>Type</td>
				<td><c:choose>
				 <c:when test="${custObj.custType eq 'Consumer'}">
					<select name="custType">
					    <option value="-1">--select--</option>
				        <option value="Seller">Seller</option>
				        <option value="Consumer" selected="selected">Consumer</option>
                  </select>
				 </c:when>
				 <c:otherwise>
				  <select name="custType">
				        <option value="-1">--select--</option>
				        <option value="Seller" selected="selected">Seller</option>
				        <option value="Consumer">Consumer</option>
                  </select>
				 </c:otherwise>
			    </c:choose><br></td>
			<tr>
			<tr>
				<td>Address </td>
				<td><textarea rows="5" cols="15" name="custAddress" >${custObj.custAddress}</textarea><span id="custAddressErr"></span><br></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="Update"> <br></td>
			</tr>
		</table>
	</form>
<%@include file="vdmFooter.jsp" %>
</body>
</html>