<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2023-03-28
  Time: 11:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý nhân viên</title>
</head>
<body>
<center>
    <h1>Thêm mới nhân viên</h1>
    <h2>
        <a href="nhanvien?action=nhanvien">Danh sách nhân viên</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Chỉnh sửa thông tin nhân viên
                </h2>
            </caption>
            <tr>
                <th>Mã nhân viên:</th>
                <td>
                    <input type="text" name="maNhanVien" size="45"
                           value="<c:out value='${NhanVien.manv}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Họ tên:</th>
                <td>
                    <input type="text" name="hoTen" size="45"
                           value="<c:out value='${NhanVien.tennv}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Ngày sinh:</th>
                <td>
                    <input type="date" name="ngaySinh" size="45"
                           value="<c:out value='${nhanVien.ngaysinh}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <td>
                    <input type="text" name="diaChi" size="15"
                           value="<c:out value='${NhanVien.diachi}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Ngày bắt đầu làm:</th>
                <td>
                    <input type="date" name="ngayBatDauLam" size="15"
                           value="<c:out value='${NhanVien.ngaybatdau}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Ngày kết thúc làm:</th>
                <td>
                    <input type="date" name="ngayKetThucLam" size="15"
                           value="<c:out value='${NhanVien.ngayketthuc}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Lương:</th>
                <td>
                    <input type="text" name="luong" size="15"
                           value="<c:out value='${NhanVien.luong}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Mã công việc:</th>
                <td>
                    <select name="maCongViec">
                        <c:forEach items="${listCongViec}" var="congViec">
                            <option value="${congViec.macv}"><c:out value="${congViec.tencv}"></c:out></option>
                        </c:forEach>
                    </select>
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
