<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 004 04.04.17
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><spring:message code="label.title"/></title>
</head>
<body>

<sec:authorize access="isAuthenticated()">
    <a href="<c:url value="/logout" />">Logout</a>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="<c:url value="/admin/main"/> ">To admin page</a>
</sec:authorize>

<h2><spring:message code="label.title"/></h2>

<form:form method="post" action="add" commandName="user">

    <table>
        <tr>
            <td><form:label path="username">
                <spring:message code="label.name"/>
            </form:label></td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td><form:label path="email">
                <spring:message code="label.email"/>
            </form:label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td><form:label path="telephone">
                <spring:message code="label.telephone"/>
            </form:label></td>
            <td><form:input path="telephone"/></td>
        </tr>
        <tr>
            <td><form:label path="password">
                <spring:message code="label.password"/>
            </form:label> </td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.adduser"/>"/></td>
        </tr>
    </table>
</form:form>

<h3><spring:message code="label.users"/></h3>
<c:if test="${!empty userList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.name"/></th>
            <th><spring:message code="label.email"/></th>
            <th><spring:message code="label.telephone"/></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.telephone}</td>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                <td><a href="delete/${user.username}"><spring:message code="label.delete"/></a></td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>