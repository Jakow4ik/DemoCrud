<%--
  Created by IntelliJ IDEA.
  User: Nick
  Date: 13.01.2018
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.democrud.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit users</title>

    <style>
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        .editbox {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>

</head>
<body>
<%@include file="menu.html"%>

<div class="editbox">
<form method="POST" action="/controller" name="editUser">
    <% String action = request.getParameter("action");
        System.out.println(action);
        User user = (User)request.getAttribute("user");
    %>
    <% if (action.equalsIgnoreCase("edit")) {               %>

    User id:        <input  type="text" name="id" value="<% out.print(user.getId()); %>" readonly> <br />
    User Name:      <input type="text" name="uname" value="<% out.print(user.getLogin()); %>">  <br />
    User Pas:       <input type="text" name="pass" value="<% out.print(user.getPassword()); %>">  <br />
    User e-mail:    <input type="text" name="email" value="<% out.print(user.getEmail()); %>">  <br />
    User phone:     <input type="text" name="phone" value="<% out.print(user.getPhone()); %>">  <br />
    <%} else if (action.equalsIgnoreCase("add")){%>
    User Name:      <input type="text" name="uname" placeholder="Login user...">  <br />
    User Pas:       <input type="text" name="pass" placeholder="Passwors...">  <br />
    User e-mail:    <input type="text" name="email" placeholder="E-mail...">  <br />
    User phone:     <input type="text" name="phone" placeholder="Phone number...">  <br />
    <% } %>
    <input type="submit" value="Submin" name="submit" />
</form>
</div>
</body>
</html>



