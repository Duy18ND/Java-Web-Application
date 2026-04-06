<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- BƯỚC 1: Khai báo thư viện JSTL Core để dùng các thẻ c: --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <%-- BƯỚC 2: Dùng JSP Comment để ẩn ghi chú khỏi trình duyệt của khách hàng --%>
    <%-- Tiêu đề trang báo cáo --%>
    <title>Báo cáo điểm</title>
</head>
<body>

<%-- BƯỚC 3: Dùng EL ${} thay cho request.getAttribute --%>
<h1>${reportTitle}</h1>

<%-- Đã xóa hoàn toàn đoạn mã hiển thị lượt xem chứa lỗi Race Condition --%>

<table border="1">
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Điểm</th>
        <th>Xếp loại</th>
    </tr>

    <%-- BƯỚC 4: Dùng c:forEach thay cho vòng lặp for của Java.
         varStatus="loop" giúp lấy ra các thông tin của vòng lặp như số thứ tự (count) --%>
    <c:forEach items="${studentList}" var="sv" varStatus="loop">
        <tr>
                <%-- In số thứ tự (Bắt đầu từ 1) --%>
            <td>${loop.count}</td>

                <%-- BƯỚC 5: Dùng c:out để tự động mã hóa ký tự đặc biệt, chặn đứng lỗ hổng XSS --%>
            <td><c:out value="${sv.fullName}" /></td>

                <%-- Dùng EL truy xuất thuộc tính. Tự động gọi hàm getScore() mà không cần () hay dấu ; --%>
            <td>${sv.score}</td>

                <%-- BƯỚC 6: Dùng c:choose / c:when / c:otherwise thay thế cấu trúc if/else if/else --%>
            <td>
                <c:choose>
                    <c:when test="${sv.score >= 90}">Xuất sắc</c:when>
                    <c:when test="${sv.score >= 80}">Giỏi</c:when>
                    <c:when test="${sv.score >= 70}">Khá</c:when>
                    <c:when test="${sv.score >= 60}">Trung bình khá</c:when>
                    <c:when test="${sv.score >= 50}">Trung bình</c:when>
                    <c:otherwise>Yếu</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>