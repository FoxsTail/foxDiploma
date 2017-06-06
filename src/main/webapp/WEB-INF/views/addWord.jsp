<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 030 30.05.17
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddWord</title>
</head>
<body>
<form method="post" action="/user/${dictionaryName}/addWord">
    <label for="name">Слово</label>
    <input type="text" name="name" id="name">
    <label for="translation">Перевод</label>
    <input type="text" name="translation" id="translation">
    <input type="submit">
    <a href="<c:url value='/user/${dictionaryName}/addWord'/>">Cancel</a>

    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
</body>
</html>
