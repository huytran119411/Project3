<%--
  Created by IntelliJ IDEA.
  User: haphong
  Date: 03/08/2022
  Time: 00:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${songArrayList}" var="s">
    <p>${s.getId()}</p>
</c:forEach>
</body>
</html>
