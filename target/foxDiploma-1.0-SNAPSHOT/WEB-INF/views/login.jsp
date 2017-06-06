<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 020 20.04.17
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Login page</title>
    <%--<link href="<c:url value='/resources/css/bootstrap.css' />"  rel="stylesheet"></link>--%>
    <link href="<c:url value='/resources/css/simple.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css"
          href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css"/>
</head>
<body>
<header>
<div class="logo-login">
    <a href="/welcome" class="logo"><img width="200" , height="166" src="../../resources/img/lolo.png" alt="Привет, меня зовут Ри!"></a>
</div>
</header>
<div class="container">
    <div class="login-form log">
        <h1>Авторизация</h1>
        <c:url var="loginUrl" value="/login"/>

        <fieldset>
            <form action="${loginUrl}" method="post">
                <c:if test="${param.error != null}">
                    <div class="alert alert-danger">
                        <p>Неправильное имя пользователя или пароль.</p>
                    </div>
                </c:if>
                <c:if test="${param.logout != null}">
                    <div class="alert alert-success">
                        <p>Вы успешно вышли из системы.</p>
                    </div>
                </c:if>

                <label for="username"/>
                <input type="text" id="username" name="j_username" placeholder="<spring:message code="label.login"/>"
                       required><br><br>
                <label for="password"/>
                <input type="password" id="password" name="j_password"
                       placeholder="<spring:message code="label.password"/>"
                       required>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>

                <a href="<c:url value='/welcome' />"><input type="button" value="Назад"></a>
                <input type="submit" value="Войти">
            </form>
        </fieldset>
    </div>
</div>
</body>
</html>