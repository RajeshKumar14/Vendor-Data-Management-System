<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sell on Priykart</title>
<link href='../css/seller_hub.css' type='text/css' rel='stylesheet'/>
<link href='../css/header.css' type='text/css' rel='stylesheet'/>
<%@include file="sellerHeader.jsp" %>

<section id="template_content_wrapper">
	<div id="template_content">
    
<table border="1"><thead><tr><th>Item</th>
<th>Amount (Rs.)</th>
</tr></thead><tbody><tr><th scope="row">Selling Price (decided by you)</th>
<td>1500</td>
</tr><tr><th scope="row">Commission Fee<span style="font-size:12px;"> (varies across sub-categories/verticals)</span></th>
<td>150 (assuming 10%)</td>
</tr><tr><th scope="row">Shipping Fee<span style="font-size:12px;"> (Local shipping , weight 500 grams)</span></th>
<td>30</td>
</tr><tr><th scope="row">Collection Fee<span style="font-size:12px;"> (2 % on the Order item value)</span></th>
<td>30</td>
</tr><tr><th scope="row">Fixed Fee</th>
<td>30</td>
</tr><tr><th scope="row">Total Marketplace Fee</th>
<td>240</td>
</tr><tr><th scope="row">Service Tax<span style="font-size:12px;"> (15% of Marketplace Fee including Swachh Bharat &amp; Krishi Kalyan cess)</span></th>
<td>36</td>
</tr><tr><th scope="row"><b>Total deductions</b></th>
<td><b>276</b></td>
</tr><tr><th scope="row"><b>Settlement Value(Amount credited to you)</b></th>
<td><b>1224</b></td>
</tr></tbody></table>

<br><br><br><br><br><br>

<table border="1"><thead><tr><th>Weight slab</th>
<th>Local (Intracity)<br>
			in Rs.</th>
<th>Zonal (Intrazone)<br>
			in Rs.</th>
<th>National (Interzone)<br>
			in Rs.</th>
</tr></thead><tbody><tr><th scope="row">0.0 Kg - 0.5 Kg&nbsp;( For every 0.5 kg )</th>
<td>30</td>
<td>50</td>
<td>70</td>
</tr><tr><th scope="row">0.5 Kg - 5.0 Kg&nbsp;( For every 0.5 kg )</th>
<td>30</td>
<td>35</td>
<td>45</td>
</tr><tr><th scope="row">&gt; 5.0 Kg&nbsp;( For every 1 kg )</th>
<td>5</td>
<td>10</td>
<td>20</td>
</tr></tbody></table>
    
    </div> <!-- end of content -->
    
</section>
<%@include file="sellerFooter.jsp" %>