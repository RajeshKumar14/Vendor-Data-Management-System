
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Log in to Priyakart </title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
    <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
    <link href='../css/header.css' type='text/css' rel='stylesheet'/>

<!-- Start of template_header_wrapper -->
<header id="template_header_wrapper">
  <div id="template_header"> 
      <nav id='template_menu1'>
        <ul>
          <li><a href="priyakart">Sell on Priyakart</a></li>
          <li><a href="#">GiftCard </a></li>
          <li><a href="#">Customer Care </a></li>
          <li><a href="#">Track Order</a></li>
          <li><a href="regUser">SignUp </a></li>
          <li><a href="showLogin">LogIn </a></li>
        </ul>
      </nav>
	
	  <div id="site_title"><h1><a href="index.jsp"><img  width="149" src="../imgs/logo.png" alt="Priyakart" /></a></h1></div>
	  <div id="search_box">
          <form action="#" method="post">
              <input type="text"  id="searchfield" placeholder="Search for Product,Brands and More">
              <button type="submit"  id="btn_search" name="search"><img width="60" height="30" src="../imgs/search_icon.ico"/></button>
          </form>
	  </div>
	  <div id="cart_button">
	    <button type="submit" name="cart" value="CART" id="cart"><img width="60" height="30" src="../imgs/cart.png"/></button>
	 </div>
	 
  </div> <!-- end of template_header -->
</header> <!-- end of template_header_wrapper -->

<section id="template_content_wrapper">
  <div id="template_content">
   <form name="loginForm" action="loginUser" method="post">
     <table border="0" align="center" cellpadding="10">
      <tr><th colspan="2">Log In to Priyakart</th></tr>
      <tr><td><input type="text" name="userId" placeholder="Email Address or Phone NO."></td></tr> 
      <tr><td><input type="password" name="password" placeholder="Password"></td></tr>
      <tr><td align="center"><input type="submit" name="LogIn"  size="60" value="Log In"></td></tr>
     </table>
   </form>
    <p align="center"><a href="regUser">New to Priyakart? SignUp</a></p> 
  </div> <!-- end of content -->
</section>
<%@include file="itemFooter.jsp" %>