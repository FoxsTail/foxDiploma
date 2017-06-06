<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 016 16.05.17
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users List</title>
    <link href="<c:url value='/resources/css/simple.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"></link>
</head>

<body>
<header>
    <div class="container">
        <a href="/" class="logo"><img width="200" , height="166" src="../../resources/img/lolo.png"></a>
        <nav>
            <ul class="menu-main">
                <li><a href="/admin/main">На главную</a></li>
                <li class="hovered"><a href="/user/profile">Пользователи</a></li>
                <li><a href="/user/myDictionary">Редактор норы</a></li>
            </ul>
        </nav>
        <div class="search">
            <form action="" method="post">
                <input  type="search" name="" placeholder="Поиск"/>
                <input type="submit" name="" value="Найти" />
            </form>
        </div>
    </div>

</header>
<div class="container">
<c:if test="${param.success}">
    <div class="alert-my-success alert-success">
        <p>Пользовательно успешно изменен!</p>
    </div>
</c:if>
    <table>
        <caption><h1>List of Users </h1></caption>
        <thead>
        <tr>
            <th>Username</th>
            <th>Email</th>
            <th>Telephone</th>
            <th>Enabled</th>
            <th>Creation Date</th>
            <th width="100"></th>
            <th width="100" class="adder"><a href='/admin/newUser'>Add New User</a></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
        <tr>

            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.telephone}</td>
            <td>${user.enabled}</td>
            <td>${user.creation_date}</td>
            <td class="table-edit"><a href='/admin/edit-user-${user.username}'><input type="button" value="Edit"></a></td>
            <td class="table-delete"><a href="/admin/delete-user-${user.username}"><input type="button" value="Delete"></a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>