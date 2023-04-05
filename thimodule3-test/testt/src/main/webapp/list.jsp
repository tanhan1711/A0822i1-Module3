<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2023-03-28
  Time: 11:48 CH
  To change this template use File | Settings | File Templates.
--%><%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: HP--%>
<%--  Date: 29-Mar-23--%>
<%--  Time: 6:17 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Employee Management</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div>--%>
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
    <title>Quản lý nhân viên</title>
</head>
<body>
<center>
    <div class="container">
        <h1>Quản lý nhân viên</h1>
        <h2>
            <a href="/nhanvien?action=create" class="btn btn-success btn-lg" style="float: left">Thêm mới</a>
            <a href="/nhanvien" class="btn btn-success btn-lg" style="float: right">Tải lại</a>
        </h2>
        <div class="search">
            <form action="/nhanvien" method="post">
                <h2>Tìm kiếm nhân viên</h2>
                <input type="text" name="search_tencongviec" placeholder="Tìm theo tên công việc...">
                <input type="submit" value="search" name="action">
            </form>
            <div align="center">
                <table style="" border="1" cellpadding="5">
                    <tr>
                        <th>Mã nhân viên</th>
                        <th>Họ tên</th>
                        <th>Ngày sinh</th>
                        <th>Địa chỉ</th>
                        <th>Ngày bắt đầu làm việc</th>
                        <th>Ngày kết thúc làm việc</th>
                        <th>Lương</th>
                        <th>Tên công việc</th>
                    </tr>
                    <c:forEach var="s" items="${searchtencongviec}">
                        <tr>
                            <td>${s.maNhanVien}</td>
                            <td>${s.hoTen}</td>
                            <td><fmt:formatDate value="${s.ngaySinh}" pattern="dd/MM/yyyy"/></td>
                            <td>${s.diaChi}</td>
                            <td><fmt:formatDate value="${s.ngayBatDauLam}" pattern="dd/MM/yyyy"/></td>
                            <td><fmt:formatDate value="${s.ngayKetThucLam}" pattern="dd/MM/yyyy"/></td>
                            <td>${s.luong}</td>
                            <td>${s.maCongViec.tenCongViec}</td>

                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
</center>
<div align="center">
    <caption><h2>List Nhan Vien</h2></caption>

    <table border="1" cellpadding="5">

        <tr>
            <th>Mã nhân viên</th>
            <th>Họ tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ngày bắt đầu làm việc</th>
            <th>Ngày kết thúc làm việc</th>
            <th>Lương</th>
            <th>Ma công việc</th>
            <th>Ten công việc</th>
        </tr>
        <c:forEach items="${listNhanVien}" var="nhanVien">
            <tr>
                <td><c:out value="${nhanVien.maNhanVien}"/></td>
                <td><c:out value="${nhanVien.hoTen}"/></td>
                <td><fmt:formatDate value="${nhanVien.ngaySinh}" pattern="dd/MM/yyyy"/></td>
                <td><c:out value="${nhanVien.diaChi}"/></td>
                <td><fmt:formatDate value="${nhanVien.ngayBatDauLam}" pattern="dd/MM/yyyy"/></td>
                <td><fmt:formatDate value="${nhanVien.ngayKetThucLam}" pattern="dd/MM/yyyy"/></td>
                <td><fmt:formatNumber value="${nhanVien.luong}" pattern="###,###"/></td>
                <td><c:out value="${nhanVien.maCongViec.maCongViec}"/></td>
                <td><c:out value="${nhanVien.maCongViec.tenCongViec}"/></td>
                <td>
                    <a href="/nhanvien?action=edit&maNhanVien=${nhanVien.maNhanVien}">Edit</a>
                    <a href="/nhanvien?action=delete&maNhanVien=${nhanVien.maNhanVien}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</div>
</body>
</html>