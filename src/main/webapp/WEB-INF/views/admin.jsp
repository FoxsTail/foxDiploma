<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 005 05.05.17
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Admin page</title>
    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/resources/css/simple.css' />" rel="stylesheet"></link>
</head>
<body>
<header>
    <div class="container">
        <a href="/" class="logo"><img width="200" , height="166" src="../../resources/img/lolo.png"></a>
        <nav>
            <ul class="menu-main">
                <li><a href="/admin/list">Пользователи</a></li>
                <li><a href="/user/myDictionary">Редактор норы</a></li>

            </ul>
        </nav>
    </div>
</header>

<div class="main">
    <div class="container">
        <div class="row row-one">
            <br><br>
            <div>
                <h1> Великий Аматерасу наделил тебя, ${user}, правами админа.
                    <br> Используй их с умом! </h1>
            </div>
        </div>
    </div>
</div>

<footer>
    <div class="container">
        <div class="col-1-2"><a href="/user/main">User Page</a></div>

        <div class="col-1-2"><a href="/logout">LogOut</a></div>

    </div>
</footer>
</body>
</html>