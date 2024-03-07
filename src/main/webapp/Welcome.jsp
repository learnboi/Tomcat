<%--
  Created by IntelliJ IDEA.
  User: chait
  Date: 2024-03-06
  Time: 02:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Welcome, <%= request.getParameter("username")%></h1>
</body>
</html>
