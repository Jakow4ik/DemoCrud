<%--
  Created by IntelliJ IDEA.
  User: Nick
  Date: 14.01.2018
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body><br><br><br><br><br>
<center><h1>Login</h1></center>
<br><br>
<form action="/loginservlet" method="post">
    <table align="center">
        <tr>
            <th align="right">UserNmae:</th>
            <td><input type="text" name="txtusername"> </td>
        </tr>
        <tr>
            <th align="right">Password:</th>
            <td><input type="password" name="txtpassword"></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="Log In">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
