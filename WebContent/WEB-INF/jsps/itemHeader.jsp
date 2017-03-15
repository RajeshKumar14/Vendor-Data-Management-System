
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
    <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
    <link href='../css/design.css' type='text/css' rel='stylesheet'/>
    <style>
         #dyn{float:right;padding-right:40px;font-size:18px;}
   </style>
    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- Start of home_header_wrapper -->
<header id="home_header_wrapper">
  <div id="home_header"> 
      <nav id='item_top_menu'>
        <ul>
          <li><a href="priyakart">Sell on Priyakart</a></li>
          <li><a href="#">GiftCard </a></li>
          <li><a href="#">Customer Care </a></li>
          <li><a href="#">Track Order</a></li>
	<c:choose>
	   <c:when test="${userName eq null}">
		  <li><a href="regUser">SignUp </a></li>
          <li><a href="showLogin">LogIn </a></li>
	   </c:when>
	   <c:otherwise>
		   <div>Hi <b> ${userName} !</b></div>
	   </c:otherwise>
     </c:choose>
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
	  
	  <nav id='item_bottom_menu'>
        <ul>
         <li><a href="#">ELECTRONICS</a></li>
         <li><a href="#">MEN</a></li>
         <li><a href="#">WOMEN</a></li>
         <li><a href="#">HOME&FURNITURE </a></li>
         <li><a href="#">BABY&KIDS </a></li>
         <li><a href="#">APPLIANCES</a></li>
         <li><a href="#">BOOKS&MORE </a></li>
        </ul>
      </nav>	
      
  </div> <!-- end of Home_header -->
</header> <!-- end of Home_header_wrapper -->
