<%--
  Created by IntelliJ IDEA.
  User: duy18
  Date: 07/04/2026
  Time: 7:10 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Employee Page</title>
</head>
<body>
<table border="1">
    <th>ID</th>
    <th>FullName</th>
    <th>Department</th>
    <th>Salary</th>
    <th>Đánh giá</th>
    <c:forEach items="${employees}" var="emp">
    <tr>
        <td>${emp.id}</td>
        <td>${emp.fullName}</td>
        <td>${emp.department}</td>
        <td>${emp.salary}</td>
        <td>${emp.salary > 10000 ? "Mức lương cao" : "Mức lương cơ bản"}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
