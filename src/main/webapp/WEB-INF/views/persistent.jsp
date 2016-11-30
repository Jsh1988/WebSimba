<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="<c:url value="/resources/css/login-form.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/form-block.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/error.css" />" rel="stylesheet" />
    <title><spring:message code="persistentLogins" /></title>
</head>
<body>
<div id="block_body">
    <h1><spring:message code="welcome"/></h1>
    <div class="block_form_content">
        <div class="block_form">
            <f3 class="form-f3-title"><spring:message code="persistentLogins" /></f3>
            <c:url var="persistentLoginssDo" value="/persistent.do" />
            <form:form action="/persistent.do" method="post" commandName="persistent">
                <ul id="block_log_pass">
                    <c:if test="${not empty ok}"><span class="ok">${ok}</span></c:if>
                    <c:if test="${not empty error}"><span class="error">${error}</span></c:if>
                    <li><form:input class="formas" type="text" placeholder="${user}"  path="username" /></li>
                    <li><input class="submit" name="action" type="submit" value="Delete" /></li>
                    <li><a class="link" href="<c:url value='/home' />"><spring:message code="home"/></a> || <a class="link" href="<c:url value="/logout" />"><spring:message code="exit" /></a></li>
                    <li><a class="link" href="<c:url value="/persistent?lang=en" />">en</a> || <a class="link" href="<c:url value="/persistent?lang=ru" />">ru</a></li>
                </ul>
            </form:form>
        </div>
        <div class="block_content">
            <div class="block_table_content">
                <ul class="block_ul">
                    <h2><li><spring:message code="user" /> || <spring:message code="series" /> || <spring:message code="date" /></li></h2>
                    <c:forEach items="${persistentList}" var="persistent">
                        <li><c:out value="${persistent.username}"/> || <c:out value="${persistent.series}"/> || <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${persistent.lastUsed}" /></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>





