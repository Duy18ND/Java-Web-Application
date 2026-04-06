<%--
  Created by IntelliJ IDEA.
  User: duy18
  Date: 06/04/2026
  Time: 9:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Khai báo thư viện JSTL cho Tomcat 10+ (Sử dụng namespace jakarta) --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<html>
<head>
  <title>Danh sách Đơn hàng</title>
</head>
<body>
<%-- Đọc dữ liệu từ Session Scope --%>
<h2>Xin chào, <c:out value="${sessionScope.loggedUser}"/>!
  Vai trò: <c:out value="${sessionScope.role}"/></h2>

<a href="<c:url value='/logout'/>" style="color: red;">Đăng xuất</a>
<hr/>

<h3>Danh sách đơn hàng cần xử lý</h3>
<table border="1" cellpadding="8" style="border-collapse: collapse;">
  <tr style="background-color: #f2f2f2;">
    <th>Mã đơn</th>
    <th>Sản phẩm</th>
    <th>Tổng tiền</th>
    <th>Ngày đặt</th>
  </tr>

  <%-- Vòng lặp JSTL --%>
  <c:forEach items="${orderList}" var="order">
    <tr>
      <td>${order.id}</td>
      <td><c:out value="${order.productName}"/></td>

        <%-- Định dạng Tiền tệ VNĐ --%>
      <td>
        <fmt:formatNumber value="${order.totalAmount}" type="currency" currencySymbol="VNĐ" maxFractionDigits="0"/>
      </td>

        <%-- Định dạng Ngày tháng --%>
      <td>
        <fmt:formatDate value="${order.orderDate}" pattern="dd/MM/yyyy HH:mm"/>
      </td>
    </tr>
  </c:forEach>
</table>

<br/>
<%-- Đọc dữ liệu từ Application Scope --%>
<p style="font-weight: bold; color: blue;">
  Tổng lượt xem đơn hàng toàn hệ thống: ${applicationScope.totalViewCount}
</p>

</body>
</html>