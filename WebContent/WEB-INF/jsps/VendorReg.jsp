<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VendorReg</title>
</head>
<body>
<%@include file="Master.jsp" %>
   <br>
	<form name="venForm" action="insertVen" method="post"   enctype="multipart/form-data"  onsubmit="return doValidateVenForm();">
		<table border="1" cellpadding="10" align="center">
			<tr><th colspan="2">Vendor Registration</th></tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="venName" /><span id="venNameErr"></span></td>
			<tr>
			  <td>Location</td>	
		<td><select name="loc.locId">
                <c:forEach items="${locListObj}" var="loc">
          <option value="${loc.locId}"><c:out value="${loc.locName}"/></option>
                 </c:forEach>
             </select><span id="venLocationErr"></span> </td>
			</tr>
			<tr>
				<td>E-Mail ID</td>
				<td><input type="text" name="venEmail" /><span id="venEmailErr"></span></td>
			<tr>
			<tr>
				<td>Mobile No.</td>
				<td><input type="text" name="venMobile" /><span id="venMobileErr"></span></td>
			</tr>
			<tr>
			    <td>Attachment</td>
				<td><input type="file" name="inpFile"/></td>
			<tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save" />
				<input type="reset"  value="Clear" /></td>
			</tr>
		</table>
	</form>
${msg}<br/>
<a href="viewAllVen">View All Records</a>
<%@include file="Footer.jsp" %>
</body>
</html>