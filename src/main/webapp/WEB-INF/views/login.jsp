<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 020 20.04.17
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title"/></title>
</head>
<body>

<a href="<c:url value="/welcome" />">
    <spring:message code="label.users"/>
</a><br/>

<c:if test="${param.error != null}">
  <font color="red"> <spring:message code="label.loginerror"/><br>
      <spring:message code="label.errorReason"/>:  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</font>

</c:if>

<c:if test="${not empty param.logout}">
    <font color="red">
        <p>You have been logged out successfully.</p>
    </font>
</c:if>
<form method="POST" action="<c:url value="/login"/>">
    <table>
        <tr>
            <td align="right"><spring:message code="label.login"/></td>
            <td><input type="text" name="j_username"/></td>
        </tr>
        <tr>
            <td align="right"><spring:message code="label.password"/></td>
            <td><input type="password" name="j_password"/></td>
        </tr>
        <tr>
            <td align="right"><spring:message code="label.remember"/></td>
            <td><input type="checkbox" name="_spring_security_remember_me"/></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="Login"/>
                <input type="reset" value="Reset"/></td>
        </tr>
    </table>

    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
</body>
</html>