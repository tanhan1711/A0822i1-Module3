<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2023-03-15
  Time: 9:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/home.css">
</head>
<body>
<table>
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="c" items="${customer}" varStatus="no">
        <tr>
            <td>${c.name}</td>
            <td>${c.date}</td>
            <td>${c.address}</td>
            <td>
                <img src="${c.avatar}">
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
