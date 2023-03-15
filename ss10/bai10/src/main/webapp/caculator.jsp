<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2023-03-15
  Time: 8:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="CaculateServlet" method="post">
    <input type="text" name="n1" value="nhap so thu nhat">
    <input type="text" name="n2" value="nhap so thu hai">
    <select name = "operator">
        <option>Addition</option>
        <option>Subtraction</option>
        <option>Multiplication</option>
        <option>Division</option>
    </select>
    <button type="submit" name="caculate"></button>
</form>
</body>
</html>
