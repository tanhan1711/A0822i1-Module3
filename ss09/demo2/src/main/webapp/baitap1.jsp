<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2023-03-13
  Time: 6:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Currency Converter</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Product</h2>
<form action="baitap1Servlet" method="post">
  <input type="text" name="Product Description">
  <input type="text" name="List Price">
  <input type="text" name="Discount Percent">
  <input type="submit" id="submit" value="Calculate Discount">

</form>
</body>
</html>
