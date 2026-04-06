<%--
  Created by IntelliJ IDEA.
  User: duy18
  Date: 06/04/2026
  Time: 9:33 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Khai báo thư viện JSTL chuẩn Jakarta EE 10 --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>

<html>
<head>
  <title>Tìm kiếm Sự kiện</title>
  <style>
    .table { width: 100%; border-collapse: collapse; margin-top: 15px; }
    .table th, .table td { border: 1px solid #ddd; padding: 8px; text-align: left; }
    .badge-free { background-color: #28a745; color: white; padding: 4px 8px; border-radius: 4px; font-weight: bold; }
    .text-red { color: red; font-weight: bold; }
    .text-orange { color: #d39e00; font-weight: bold; }
    .text-green { color: green; font-weight: bold; }
    .btn { padding: 6px 12px; text-decoration: none; border: 1px solid #ccc; background: #f9f9f9; color: #333; display: inline-block;}
    .btn-disabled { background: #eee; color: #aaa; cursor: not-allowed; }
  </style>
</head>
<body>

<%-- PHẦN A: HEADER --%>
<h2>Kết quả tìm kiếm cho: <c:out value="${keyword}"/></h2>
<p>Tìm thấy ${totalFound} sự kiện.</p>

<%-- Xử lý trường hợp Empty --%>
<c:if test="${empty events}">
  <p style="color: red; font-style: italic;">Không tìm thấy sự kiện nào phù hợp.</p>
</c:if>

<%-- PHẦN B: BẢNG KẾT QUẢ --%>
<c:if test="${not empty events}">
  <table class="table">
    <thead>
    <tr>
      <th>STT</th>
      <th>Tên sự kiện</th>
      <th>Ngày tổ chức</th>
      <th>Giá vé</th>
      <th>Vé còn lại</th>
      <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${events}" var="event" varStatus="loop">
      <tr>
          <%-- STT tự động --%>
        <td>${loop.count}</td>

          <%-- Chống XSS tên sự kiện (Đỡ đòn bẫy <script> từ Database) --%>
        <td><c:out value="${event.name}" /></td>

        <td>${event.eventDate}</td>

          <%-- Logic Giá vé --%>
        <td>
          <c:choose>
            <c:when test="${event.price == 0}">
              <span class="badge-free">MIỄN PHÍ</span>
            </c:when>
            <c:otherwise>
              <fmt:formatNumber value="${event.price}" type="number" maxFractionDigits="0"/> VNĐ
            </c:otherwise>
          </c:choose>
        </td>

          <%-- Logic Tình trạng vé --%>
        <td>
          <c:choose>
            <c:when test="${event.remainingTickets == 0}">
              <span class="text-red">HẾT VÉ</span>
            </c:when>
            <c:when test="${event.remainingTickets < 10}">
              <span class="text-orange">Sắp hết (còn ${event.remainingTickets} vé)</span>
            </c:when>
            <c:otherwise>
              <span class="text-green">${event.remainingTickets}</span>
            </c:otherwise>
          </c:choose>
        </td>

          <%-- Logic Nút Đặt vé --%>
        <td>
          <c:choose>
            <c:when test="${event.remainingTickets == 0}">
              <span class="btn btn-disabled">Đặt vé</span>
            </c:when>
            <c:otherwise>
              <a href="<c:url value='/events/${event.id}/book'/>" class="btn">Đặt vé</a>
            </c:otherwise>
          </c:choose>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</c:if>

<hr/>

<%-- PHẦN C: FOOTER --%>
<%-- Guard Null an toàn trước khi gọi toUpperCase trên phần tử đầu tiên --%>
<c:if test="${not empty events}">
  <p><strong>Sự kiện đầu nổi bật:</strong> ${fn:toUpperCase(events[0].name)}</p>
</c:if>

<p>Số ký tự của từ khóa tìm kiếm: <strong>${fn:length(keyword)}</strong> ký tự.</p>

</body>
</html>