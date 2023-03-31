<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2023-03-29
  Time: 12:53 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Nhan Vien</title>
</head>
<body>
<center>
    <h1>List Nhan Vien</h1>
    <h2>
        <a href="/nhanvien">List Nhan Vien</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Nhan Vien
                </h2>
            </caption>

            <tr>
                <th>NhanVien maNhanVien:</th>
                <td>
                    <input type="text" name="maNhanVien" size="45" readonly
                           value="<c:out value='${nhanVien.maNhanVien}' />"
                    />
                </td>
            <tr>
                <th>NhanVien hoTen:</th>
                <td>
                    <input type="text" name="hoTen" size="45"
                           value="<c:out value='${nhanVien.hoTen}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Ngay Sinh:</th>
                <td>
                    <input type="text" name="ngaySinh" size="45"
                    <fmt:formatDate value="${nhanVien.ngaySinh}" pattern="dd/MM/yyyy"/></td>
                    />
                </td>
            </tr>
            <tr>
                <th>Dia Chi:</th>
                <td>
                    <input type="text" name="diachi" size="15"
                           value="<c:out value='${nhanVien.diaChi}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Ngay bat dau:</th>
                <td>
                    <input type="text" name="ngaybatdau" size="45"
                    <fmt:formatDate value="${nhanVien.ngayBatDauLam}" pattern="dd/MM/yyyy"/></td>
                />
                </td>
            </tr>
            <tr>
                <th>Ngay Ket Thuc:</th>
                <td>
                    <input type="text" name="ngayketthuc" size="45"
                    <fmt:formatDate value="${nhanVien.ngayKetThucLam}" pattern="dd/MM/yyyy"/></td>
                />
                </td>
            </tr>
            <tr>
                <th>Luong:</th>
                <td>
                    <input type="text" name="luong" size="15"
                           value="<c:out value='${nhanVien.luong}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Ma Cong Viec:</th>
                <td>
                    <input type="text" name="maCongViec" size="15"
                           value="<c:out value='${nhanVien.maCongViec.maCongViec}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
