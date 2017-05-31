<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 025 25.05.17
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fox's Dan</title>
    <link href="<c:url value='/resources/css/simple.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"></link>
</head>
<body>
<header>
    <div class="container">
        <a href="/" class="logo"><img width="200" , height="160" src="../../resources/img/lolo.png"
                                      alt="Привет, меня зовут Ри!"></a>
        <nav>
            <ul class="menu-main">
                <li><a href="/user/profile">Профиль</a></li>
                <li><a href="/user/myDictionary">Мои словари</a></li>
                <li class="hovered"><a href="/user/foxsDan">Лисья нора</a></li>
                <li><a href="/user/training">Тренировка</a></li>
            </ul>
        </nav>
        <div class="search">
            <form action="/" method="post">
                <input  type="search" name="" placeholder="Поиск"/>
                <input type="submit" name="" value="Найти" />
            </form>
        </div>
    </div>
</header>
<div class="container">
    <table>
        <caption><h1>Fox's starter pack</h1></caption>
        <thead>
        <tr>
            <th>Title</th>
            <th>Words amount</th>
            <th width="100"></th>
            <th width="100"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dictionariesPublic}" var="dictionary">
            <tr>
                <td><a href="/user/${dictionary.name}">${dictionary.name}</a></td>
                <td></td>
                <td class="table-edit"><a href='/'><input type="button" value="Edit"></a></td>
                <td class="table-delete"><a href="/"><input type="button" value="Delete"></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<footer>
    <div class="container">
        <div class="col-1-2"><a href="/admin/main">Admin Page</a></div>
        <div class="col-1-2"><a href="/logout">LogOut</a></div>
    </div>
</footer>
</body>
</html>

