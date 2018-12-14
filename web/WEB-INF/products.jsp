<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 13.12.2018
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<table border="1">
    <c:forEach items="${products}" var="products">
        <tr>
            <td>${products.id}</td>
            <td>${products.name}</td>
            <td>${products.cost}</td>
            <td>
                <a href="delete?id=${products.id}">
                    <img src="delete.jpg">
                </a>
            </td>
        </tr>
    </c:forEach>
    <form action="/add" method="post">
        <tr>
            <td colspan="2">
                <input name="name" type="text">
            </td>
            <td colspan="3">
                <input name="cost" type="text">
            </td>
            <td>
                <input type="submit" class="like" value="Внести в базу">
            </td>
        </tr>
    </form>
</table>
</body>
</html>
