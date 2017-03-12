
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Log in to Priyakart </title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
    <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
    <link href='../css/header.css' type='text/css' rel='stylesheet'/>

<!-- Start of home_header_wrapper -->
<header id="home_header_wrapper">
  <div id="home_header"> 
      <nav id='item_top_menu'>
        <ul>
          <li><a href="priyakart">Sell on Priyakart</a></li>
          <li><a href="#">GiftCard </a></li>
          <li><a href="#">Customer Care </a></li>
          <li><a href="#">Track Order</a></li>
          <li><a href="regUser">SignUp </a></li>
          <li><a href="showLogin">LogIn </a></li>
        </ul>
      </nav>
	
	  <div id="priyakart_title">
        <h1><a href="index.jsp"><img  width="149" src="../imgs/logo.png" alt="Priyakart" /></a></h1>
      </div>
	  <div id="item_search_box">
          <form action="#" method="post">
              <input type="text"  id="item_search_input" placeholder="Search for Product,Brands and More">
              <button type="submit"  id="item_search_button" name="search"><img width="60" height="30" src="../imgs/search_icon.ico"/></button>
          </form>
	  </div>
	  <div id="item_cart_button">
	    <button type="submit" name="cart" value="CART" id="cart"><img width="60" height="30" src="../imgs/cart.png"/></button>
	 </div>
  </div> <!-- end of Home_header -->
</header> <!-- end of Home_header_wrapper -->

<section id="content_wrapper">
  <div id="content">
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