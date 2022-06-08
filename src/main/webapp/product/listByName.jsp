<%--
  Created by IntelliJ IDEA.
  User: w
  Date: 6/8/2022
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="text-align: center; border: 1px solid black">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Sale</th>

    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.quantity}</td>
            <c:if test="${item.price > 200}">
                <td>Sale 10%</td>
            </c:if>
            <c:if test="${item.price < 200}">
                <td>Sale 20%</td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>
