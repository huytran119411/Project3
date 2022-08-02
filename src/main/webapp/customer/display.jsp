<%--
  Created by IntelliJ IDEA.
  User: haphong
  Date: 26/07/2022
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/customer/login.jsp">Login</a>
<a href="/customer/signup.jsp">Sign Up</a>
<table border="1" width="300px">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Phone Number</th>
        <th>Email</th>
        <th>Address</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach items="${customers}" var="c">
        <tr>
            <td>${c.getId()}</td>
            <td>${c.getUsername()}</td>
            <td>${c.getPhonenumber()}</td>
            <td>${c.getEmail()}</td>
            <td>${c.getAddress()}</td>
            <td><button><a href="/Customer?action=edit&id=${c.getId()}">Edit</a></button></td>
            <td><button><a href="/Customer?action=delete&id=${c.getId()}">Delete</a></button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>