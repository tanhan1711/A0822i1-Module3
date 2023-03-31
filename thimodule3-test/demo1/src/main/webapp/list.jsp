<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2023-03-27
  Time: 7:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>NhanVien list</title>
</head>
<body>
<h1>Nhan vien list</h1>

<a href="/nhanvien?action=create">Add new nhan vien</a>
<table border="1">
    <tr>
        <th>Manv</th>
        <th>Tennv</th>
        <th>Ngaysinh</th>
        <th>Diachi</th>
        <th>Ngaybatdau</th>
        <th>Ngatketthuc</th>
        <th>Luong</th>
        <th>Macv</th>
    </tr>
    <c:forEach var="NhanVien" items="${listNhanvien}">
        <tr>
            <td><c:out value="${NhanVien.manv}"/></td>
            <td><c:out value="${NhanVien.tennv}"/></td>
            <td><c:out value="${NhanVien.ngaysinh}"/></td>
            <td><c:out value="${NhanVien.diachi}"/></td>
            <td><c:out value="${NhanVien.ngaybatdau}"/></td>
            <td><c:out value="${NhanVien.ngayketthuc}"/></td>
            <td><c:out value="${NhanVien.luong}"/></td>
            <td><c:out value="${NhanVien.getCongviec().getMacv()}"/></td>
            <td>
                <a href="/nhanvien?action=edit&manv=${nhanvien.id}">Edit</a>
                <a href="/nhanvien?action=delete&manv=${nhanvien.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
