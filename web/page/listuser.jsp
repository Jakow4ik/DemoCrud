<%@ page import="com.democrud.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%--
<%--
  Created by IntelliJ IDEA.
  User: Nick
  Date: 02.01.2018
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>All users</title>
    <%--<link href="/mystyle.css" rel="stylesheet" type="text/css">--%>
    <style>
        table {
            border-collapse: collapse;
            border-spacing: 0;
            border: 1px solid #ddd;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even){background-color: #f2f2f2}
    </style>
</head>
<body>

<%@include file="menu.html"%>

<%--<style>--%>
    <%--<%@include file='/mystyle.css' %>--%>
<%--</style>--%>
<!-- provide an html table start tag -->
<table style="border: 1px solid;">
    <thead>
    <tr>
        <th>Id</th>
        <th>Login</th>
        <th>Password</th>
        <th>Email</th>
        <th>Phone</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <!--get the collection from the attrbiute from appropriate scope (here, request) -->
    <% ArrayList<User> users = (ArrayList<User>)request.getAttribute("userlist"); %>
    <tbody>
      <%  for (User u:users) {%>
        <tr>
            <td><% out.print(u.getId()); %></td>
            <td><% out.print(u.getLogin()); %></td>
            <td><% out.print(u.getPassword()); %></td>
            <td><% out.print(u.getEmail()); %></td>
            <td><% out.print(u.getPhone()); %></td>
            <td><a href="/controller?action=edit&userId=<%out.print(u.getId());%>" /><img src="/icon/edit_icon.png" alt="Edit user" border="0" height="20" width="20" /></td>
            <td><a href="/controller?action=delete&userId=<%out.print(u.getId());%>" /><img src="/icon/delete_icon.png" alt="Delete user" border="0" height="20" width="20"/></td>
        </tr>
    </tbody>
    <%    }
    %>
    <!-- close table -->

</table>




        <%--${userlist} hh--%>
        <%--<%--%>
            <%--List<User> list = (List<User>) request.getAttribute("userlist");--%>
            <%--for (User user:list) {--%>
                <%--out.println(user);--%>
            <%--}--%>
        <%--%>--%>


</body>
</html>
