<%--
  Created by IntelliJ IDEA.
  User: duy18
  Date: 06/04/2026
  Time: 8:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Declaration Page</title>
</head>
<body>
  <%!
    public String getGreeting(){
      return "Hello From JSP";
    }
    String greeting = getGreeting();
  %>
  <p>Greeting: <%= greeting%></p>
</body>
</html>
