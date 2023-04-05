<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2023-04-03
  Time: 6:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<!-- Add Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Add jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Add Popper.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Add Bootstrap JS -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- Add custom style -->
<link rel="stylesheet" href="webjars/izitoast/1.4.0/dist/css/iziToast.min.css">
<style>
    body {
        background-image: url("https://free.vector6.com/wp-content/uploads/2020/09/Free-vector-000455-hinh-nen-bau-troi-cho-hoi-nghi-truyen-hinh.jpg");
        background-repeat: no-repeat;
        background-size: cover;
    }

    h1 {
        font-family: Broadway, sans-serif;
        text-align: center;
        margin-top: 20px;
        margin-bottom: 20px;
        color: coral;
    }

    table tr:hover {
        background-color: greenyellow;
    }
</style>
<head>
    <title>Quản lý Product</title>
</head>
<body>
<center>
    <div class="container">
        <h1>Quản lý Product</h1>
        <h2>
            <a href="/product?action=create" class="btn btn-success btn-lg" style="float: left">Thêm mới</a>
            <a href="/product" class="btn btn-success btn-lg" style="float: right">Tải lại</a>
        </h2>
        <div class="search">
            <form action="/product" method="post">
                <h2>Tìm kiếm nhân viên</h2>
                <input type="text" name="searchname" placeholder="Tìm theo tên công việc...">
                <input type="submit" value="search" name="action">
            </form>
            <div align="center">
                <table style="" border="1" cellpadding="5">
                    <tr>
                        <th>STT</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Color</th>
                        <th>Category</th>
                    </tr>
                    <c:forEach var="s" items="${search_name}">
                        <tr>
                            <td><c:out value="${s.id}"/></td>
                            <td><c:out value="${s.name}"/></td>
                            <td><fmt:formatNumber value="${s.price}" pattern="###,###"/></td>
                            <td><c:out value="${s.quantity}"/></td>
                            <td><c:out value="${s.color}"/></td>
                                <%--                <td><c:out value="${p.category.idCategory}"/></td>--%>
                            <td><c:out value="${s.category.nameCategory}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
</center>
<div align="center">
    <caption><h2>List product</h2></caption>

    <table border="1" cellpadding="5">

        <tr>
            <th>STT</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th>Danh muc</th>
<%--            <th>Ten loai sach</th>--%>
        </tr>
        <c:forEach items="${productlist}" var="p">
            <tr>
                <td><c:out value="${p.id}"/></td>
                <td><c:out value="${p.name}"/></td>
                <td><fmt:formatNumber value="${p.price}" pattern="###,###"/></td>
                <td><c:out value="${p.quantity}"/></td>
                <td><c:out value="${p.color}"/></td>
<%--                <td><c:out value="${p.category.idCategory}"/></td>--%>
                <td><c:out value="${p.category.nameCategory}"/></td>
                <td>
                    <a href="/product?action=edit&id=${p.id}">Edit</a>
                    <a href="/product?action=delete&id=${p.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</div>
</body>
</html>
