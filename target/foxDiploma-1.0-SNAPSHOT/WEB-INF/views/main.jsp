<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 021 21.05.17
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
    <link href="<c:url value='/resources/css/simple.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"></link>
</head>
<body>
<header>
    <%--    <div class="container">
            <a href="/" class="logo"><img width="200" , height="160" src="../../resources/img/lolo.png" alt="Привет, меня зовут Ри!" ></a>
            <nav>
                <ul class="menu-main">
                    <li><a href="/user/profile">Профиль</a></li>
                    <li><a href="/user/myDictionary">Мои словари</a></li>
                    <li><a href="/user/foxsDan">Лисья нора</a></li>
                    <li><a href="/user/training">Тренировка</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <div class="main">
        <div class="container">
            <div class="row row-one">
                <br><br>
                <div>
                   <h1> Привет, ${user}, я - Ри, заходи в нору, там должно быть что-то новое :)</h1>
                </div>
            </div>
        </div>
    </div>--%>


    <div class="container">
        <a href="/" class="logo"><img width="200" , height="160" src="../../resources/img/lolo.png"
                                      alt="Привет, меня зовут Ри!"></a>
        <nav>
            <ul class="menu-main">
                <li><a href="/user/profile">Профиль</a></li>
                <li><a href="/user/myDictionary">Мои словари</a></li>
                <li><a href="/user/foxsDan">Лисья нора</a></li>
                <li><a href="/user/training">Тренировка</a></li>
            </ul>
        </nav>
    </div>
</header>
<table>
    <caption><h1>${user}'s Words</h1></caption>
    <thead>
    <tr>
        <th>Word</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${words}" var="word">
        <tr>
            <td onclick="show('block')"><h3>${word.name}</h3></td>
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

<footer>
    <div class="container">
        <div class="col-1-2"><a href="/admin/main">Admin Page</a></div>

        <div class="col-1-2"><a href="/logout">LogOut</a></div>

    </div>
</footer>
</body>
</html>
