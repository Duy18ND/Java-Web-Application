<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: duy18
  Date: 08/04/2026
  Time: 4:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Page</title>
</head>
<body>
        <c:forEach items="orders" var="0">
            <p>${o}</p>
        </c:forEach>
</body>
</html>
