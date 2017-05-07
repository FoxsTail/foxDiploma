<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 020 20.04.17
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Error</title>
</head>
<body>
HTTP Status 403 - Access is denied

${user}, you are not allowed to get here =)

<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>
