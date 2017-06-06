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
<div class="logo-login">
    <a href="/welcome" class="logo"><img width="200" , height="166" src="../../resources/img/lolo.png"
                                         alt="Привет, меня зовут Ри!"></a>
</div>

<div class="container">
<div class="login-form registration">
<c:choose>
    <c:when test="${admin}">
        <c:choose>
            <c:when test="${edit}">
                <h1>Редактировать пользователя</h1>
                <c:url var="act" value="/admin/edit-user-${username}"/>
            </c:when>
            <c:otherwise>
                <h1>Новый пользователь</h1>
                <c:url var="act" value="/admin/newUser"/>
            </c:otherwise>
        </c:choose>
    </c:when>
    <c:otherwise>
        <h1>Регистрация</h1>
        <c:url var="act" value="/registration"/>
    </c:otherwise>
</c:choose>
    <fieldset>
    <form:form method="post" action="${act}" modelAttribute="user">
        <table>
            <tr>
                <td><form:label path="username">Логин:</form:label></td>
                <td><c:choose>
                    <c:when test="${edit}">
                        <form:input type="text" id="username" path="username"
                                    disabled="true"/>
                        <div class="has-error">
                            <form:errors path="username"/>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <form:input type="text" path="username" id="username"/>
                        <div class="has-error">
                            <form:errors path="username"/>
                        </div>
                    </c:otherwise>
                </c:choose>
                </td>

            </tr>
            <tr>
                <td><label for="password">Пароль:</label></td>
                <td><form:input type="password" path="password" id="password"/>
                    <div>
                        <form:errors class="has-error" path="password"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td><label for="email">Email:</label></td>
                <td><form:input type="text" path="email" id="email"/>
                    <div>
                        <form:errors class="has-error" path="email"/>
                    </div>
                </td>

            </tr>

            <tr>
                <td><label for="telephone">Телефон:</label></td>
                <td><form:input type="text" path="telephone" id="telephone" required="true"/>
                    <div class="has-error">
                        <form:errors path="telephone"/>
                    </div>
                </td>

            </tr>

            <c:if test="${admin}">
                <tr>
                    <td><label for="roles">Роли:</label></td>
                    <td><form:select path="roles" id="roles" items="${roles}" multiple="true" itemValue="id"
                                     itemLabel="role"/>
                        <div class="has-error">
                            <form:errors path="roles"/>
                        </div>
                    </td>
                </tr>
            </c:if>
        </table>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>

        <c:choose>
            <c:when test="${admin}">
                <c:choose>
                    <c:when test="${edit}">
                        <a href="<c:url value='/admin/edit-user-${username}'/>"><input type="button" value="Отменить"> </a>
                        <input type="submit" value="Обновить"/>
                    </c:when>
                    <c:otherwise>
                        <div>
                            <a href="<c:url value='/admin/list'/>"><input type="button" value="Назад"> </a>
                            <input type="submit" value="Создать"/>
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:when>
            <c:otherwise>
                <div>
                    <a href="<c:url value='/welcome'/>"><input type="button" value="Отменить"> </a>
                    <input type="submit" value="Зарегистрироваться"/>
                </div>
            </c:otherwise>
        </c:choose>


    </form:form>
    </fieldset>
    </div>
    </div>
    </body>
    </html>
