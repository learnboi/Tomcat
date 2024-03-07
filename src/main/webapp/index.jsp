<%--
  Created by IntelliJ IDEA.
  User: chait
  Date: 2024-03-06
  Time: 02:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<form action="login" method="get">
    <table>
        <tr>
            <td>
                <label for="username">Username</label>
            </td>
            <td>
                <input type="text" name="username" id="username">
            </td>
        </tr>
        <tr>
            <td>
                <label for="password">Password</label>
            </td>
            <td>
                <input type="password" name="password" id="password">
            </td>
        </tr>
    </table>
    <input type="submit" value="Submit">
    <input type="reset" value="Clear">
</form>
</body>
</html>
