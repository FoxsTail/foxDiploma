<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 020 20.04.17
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>AccessDenied page</title>
    <link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<header>
    <div class="container">
        <a href="/" class="logo"><img width="200" , height="160" src="../../resources/img/lolo.png"></a>
        <nav>
            <ul class="menu-main">
                <li><a href="/user/main">На главную</a></li>
                <li>
                    <a href="/logout">LogOut</a>
                </li>
            </ul>
        </nav>
    </div>
</header>
<div class="container container-error">
    <div class="row row-one">
        <br><br>
        <div>
            <h1>Ошибка доступа!</h1><br>
            <h3>Дорогой <strong>${user}</strong>, вам сюда нельзя.</h3>
        </div>
    </div>
</div>
</body>
</html>