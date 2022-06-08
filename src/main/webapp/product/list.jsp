<%--
  Created by IntelliJ IDEA.
  User: w
  Date: 6/8/2022
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1 ><a href="/products">List nhá</a></h1>
<form action="/products">
    <input type="hidden" name="action" value="findByName">
    <input type="text" name="nameSearch">
    <br>
    <button>Find by name</button>
</form>
<br>
<br>
<br>
<form action="/products">
    <input type="hidden" name="action" value="findByPrice">
    <input type="text" name="priceStart"> Price Start
    <br>
    <input type="text" name="priceEnd"> Price End
    <br>
    <button>Find by price</button>
</form>


<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Quantity</th>
        <th scope="col">Sale</th>

    </tr>
    </thead>
    <tbody>
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


    </tbody>
</table>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</html>
