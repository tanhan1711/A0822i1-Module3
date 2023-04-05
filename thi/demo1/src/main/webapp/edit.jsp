<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2023-04-03
  Time: 6:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Sach</title>
</head>
<body>
<center>
    <h1>List sach</h1>
    <h2>
        <a href="/product">List Nhan Vien</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit sach
                </h2>
            </caption>

            <tr>
                <th> id:</th>
                <td>
                    <input type="text" name="id" size="45" readonly
                           value="<c:out value='${p.id}' />"
                    />
                </td>
            <tr>
                <th> Product Name</th>
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
                           value="<c:out value='${p.price}' />"
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
                           value="<c:out value='${p.color}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <input type="text" name="idcategory" size="15"
                           value="<c:out value='${p.category.idCategory}' />"
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
