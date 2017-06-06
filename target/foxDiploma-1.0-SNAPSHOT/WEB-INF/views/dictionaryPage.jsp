<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 024 24.05.17
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${dictionary.name}</title>
    <link href="<c:url value='/resources/css/simple.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"></link>
</head>
<body>

<header>
    <div class="container">
        <a href="#win1" id="win_pop"><img class="logo" width="200" , height="160" src="../../resources/img/lolo.png"></a>

        <a href="#x" class="overlay" id="win1"></a>
        <div class="popup">
            <p>sum fuk?</p>
            <a class="close"title="Закрыть" href="#close"></a>
        </div>

        <nav>
            <ul class="menu-main">
                <li><a href="/user/profile">Профиль</a></li>
                <li><a href="/user/myDictionary">Мои словари</a></li>
                <li><a href="/user/foxsDan">Лисья нора</a></li>
                <li><a href="/user/training">Тренировка</a></li>
            </ul>
        </nav>
        <a href="/user/myDictionary"><h4>Back</h4></a>
    </div>
</header>
<div class="container">
    <table>
        <caption><h1>${dictionary.name}</h1></caption>
        <thead>
        <tr>
            <th>Word</th>
            <th width="100" class="adder"><a href='/user/${dictionary.name}/addWord'>Add New Word</a></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${words}" var="word">
            <tr>
                <td onclick="show('block')"><h3>${word.name}</h3></td>
                <td class="table-delete"><a href="/"><input type="button" value="Delete"></a></td>
            </tr>
            <br/>
        </c:forEach>
        </tbody>
    </table>
</div>
<script type="text/javascript">
    function show(state) {
        document.getElementById('window').style.display = state;
        document.getElementById('wrap').style.display = state;
    }
</script>
<div onclick="show('none')" id="wrap" style="display: none;"></div>
<div id='window' style="display: none;">
    <p>Привет=)</p>
    <p onclick="show('none')" class="close" title="Закрыть"/>
</div>

</body>
</html>
