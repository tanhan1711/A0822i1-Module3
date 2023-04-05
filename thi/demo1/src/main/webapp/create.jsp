<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2023-04-03
  Time: 6:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý product</title>
</head>
<body>
<center>
    <h1>Thêm mới product</h1>
    <h2>
        <a href="product?action=product">Danh sách nhân viên</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
<%--                    Chỉnh sửa thông tin sach--%>
                </h2>
            </caption>
            <%--            <tr>--%>
            <%--                <th>Mã nhân viên:</th>--%>
            <%--                <td>--%>
            <%--                    <input type="text" name="maNhanVien" size="45"--%>
            <%--                           value="<c:out value='${nhanVien.maNhanVien}' />"--%>
            <%--                    />--%>
            <%--                </td>--%>
            <%--            </tr>--%>
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${p.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" size="15"
                           value="<c:out value='${p.price}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="text" name="quantity" size="15"
                           value="<c:out value='${p.quantity}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Color:</th>
                <td>
                    <input type="text" name="color" size="15"
                           value="<c:out value='${p.color}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <select name="idcategory">
                        <c:forEach items="${listcategory}" var="c">
                            <option value="${c.idCategory}"><c:out value="${c.nameCategory}"></c:out></option>
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

