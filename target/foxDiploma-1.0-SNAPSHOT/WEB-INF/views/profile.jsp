<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 005 05.05.17
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>User Registration Form</title>
    <link href="<c:url value='/resources/css/simple.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"></link>

</head>
<body>

<div class="container">
    <a href="/" class="logo"><img width="200" , height="160" src="../../resources/img/lolo.png"
                                  alt="Привет, меня зовут Ри!"></a>
    <nav>
        <ul class="menu-main">
            <li class="hovered"><a href="/user/profile">Профиль</a></li>
            <li><a href="/user/myDictionary">Мои словари</a></li>
            <li><a href="/user/foxsDan">Лисья нора</a></li>
            <li><a href="/user/training">Тренировка</a></li>
        </ul>
    </nav>

    <div class="login-form profile">
        <h1>Мой профиль</h1>

        <fieldset>
            <c:if test="${success}">
                <div class="alert alert-success">
                    <p>Вы успешно обновили профиль.</p>
                </div>
            </c:if>
            <form:form method="post" action="/user/profile-edit-${user.username}" modelAttribute="user">
                <table>
                    <tr>
                        <td><label for="username">Логин:</label></td>
                        <td>
                                <form:input type="text" id="username" path="username"
                                            disabled="true"/>
                                <div class="has-error">
                                    <form:errors path="username"/>
                                </div>
                        </td>

                    </tr>
                    <tr>
                        <td><label for="password">Пароль:</label></td>
                        <td><form:input type="password" path="password" id="password"/>
                            <div >
                                <form:errors class="has-error" path="password"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="email">Email:</label></td>
                        <td><form:input type="text" path="email" id="email"/>
                            <div >
                                <form:errors class="has-error" path="email"/>
                            </div></td>

                    </tr>

                    <tr>
                        <td><label for="telephone">Телефон:</label></td>
                        <td><form:input type="text" path="telephone" id="telephone" required="true"/>
                            <div class="has-error">
                                <form:errors path="telephone"/>
                            </div>
                        </td>
                    </tr>

                </table>

                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>

                <a href="<c:url value='/user/profile' />"><input type="button" value="Отменить"> </a>
                                <input type="submit" value="Обновить"/>


            </form:form>
        </fieldset>
    </div>
</div>
</body>
</html>
