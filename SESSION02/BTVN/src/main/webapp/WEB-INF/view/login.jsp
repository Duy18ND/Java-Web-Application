<%--
  Created by IntelliJ IDEA.
  User: duy18
  Date: 06/04/2026
  Time: 9:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head><title>Đăng nhập hệ thống</title></head>
<body>
<h2>Đăng nhập cửa hàng</h2>

<%-- Hiển thị lỗi từ Request Scope --%>
<c:if test="${not empty error}">
  <p style="color: red;">${error}</p>
</c:if>

<form action="<c:url value='/login'/>" method="post">
  <label>Tài khoản:</label>
  <input type="text" name="username" required /><br/><br/>

  <label>Mật khẩu:</label>
  <input type="password" name="password" required /><br/><br/>

  <button type="submit">Đăng nhập</button>
</form>
</body>
</html>