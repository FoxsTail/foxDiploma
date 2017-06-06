<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 005 05.05.17
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Fox Language</title>
    <link href="<c:url value='/resources/css/simple.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"></link>

</head>
<header>
    <div class="container">
        <a href="/" class="logo"><img width="400" , height="300" src="../../resources/img/lolo.png" alt="Привет, меня зовут Ри!"></a>
        <nav>
            <ul class="menu-main">
                <li><a href="/login">Войти</a></li>
                <li><a href="/registration">Регистрация</a></li>
            </ul>
        </nav>
    </div>
</header>

<div class="main">
    <div class="container">
        <div class="row row-one">
            <br><br>
            <div>
                <c:if test="${success}">

                </c:if>

                <c:choose>
                    <c:when test="${success}">
                        ${user.username}, вы успешно зарегистрировались, пожалуйста, войдите в систему!=)
                    </c:when>
                    <c:otherwise>
                        <h1> Добро пожаловать в приложение Fox Language!</h1><br>
                        Учите языки и запоминайте новые слова легче с лисом Ри.<br>
                        Для того, чтобы использовать приложение войдите или зарегистрируйетсь.<br>
                        Удачи!=)
                        <br><br><br><br>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
    </div>
</div>

</body>
</html>
