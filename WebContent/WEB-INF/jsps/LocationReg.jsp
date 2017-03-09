<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='../css/header.css' type='text/css' rel='stylesheet'/>

<title>Location</title>

<%@include file="vdmHeader.jsp" %>
<section id="template_content_wrapper">
  <div id="template_content">
    <form name="locForm" action="insertLoc" method="post" onsubmit="return doValidateLocForm();">
	  <table border="1" cellpadding="10" align="center">
		<tr><th colspan="2">Location Registration</th></tr>
		<tr><td>Name</td><td><input type="text" name="locName" /> <span id="locNameErr"></span></td>
		<tr><td>Type</td>
			<td><input type="radio" name="locType" value="Urban" />Urban 
			<input type="radio" name="locType" value="Rural" />Rural <span id="locTypeErr"></span></td>
	    </tr>
		<tr><td colspan="2" align="center"><input type="submit" value="Save" />
			<input type="reset" value="Clear" /></td>
		</tr>
	  </table>
	</form>
    </div> <!-- end of content -->
</section>
${msg}<br/>
<a href="viewAllLoc">View All Records</a>
<%@include file="vdmFooter.jsp" %>
