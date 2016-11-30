<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/login-form.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/form-block.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/error.css" />" rel="stylesheet" />
    <title><spring:message code="menu" /></title>
</head>
<body>
<div id="block_body">
    <h1><spring:message code="welcome" /></h1>
    <div id="block_avtorizaciya">
        <h3 class="form-f3-title"><spring:message code="menu"/></h3>
        <ul id="block_log_pass">
            <c:if test="${not empty login_ok}"><span class="ok">${login_ok}</span></c:if>
            <c:if test="${not empty login_error}"><span class="error">${login_error}</span></c:if>
            <c:if test="${not empty filename}"><span class="ok">${filename}</span></c:if>
            <li><a class="link" href="<c:url value="/" />"><spring:message code="home"/></a></li>
            <li><a class="link" href="<c:url value="/acategories" />"><spring:message code="acategories" /></a></li>
            <li><a class="link" href="<c:url value="/bxslider" />"><spring:message code="slider" /></a></li>
            <li><a class="link" href="<c:url value="/categories" />"><spring:message code="categories" /></a></li>
            <li><a class="link" href="<c:url value="/comments" />"><spring:message code="comments" /></a></li>
            <li><a class="link" href="<c:url value="/forgot" />"><spring:message code="forgot" /></a></li>
            <li><a class="link" href="<c:url value="/ips" />"><spring:message code="ip_adress" /></a></li>
            <li><a class="link" href="<c:url value="/pages" />"><spring:message code="page" /></a></li>
            <li><a class="link" href="<c:url value="/photos" />"><spring:message code="images" /></a></li>
            <li><a class="link" href="<c:url value="/products" />"><spring:message code="products" /></a></li>
            <li><a class="link" href="<c:url value="/role" />"><spring:message code="role" /></a></li>
            <li><a class="link" href="<c:url value="/users" />"><spring:message code="user" /></a></li>
            <li><a class="link" href="<c:url value="/visits" />"><spring:message code="visits" /></a></li>
            <li><a class="link" href="<c:url value="/persistent" />"><spring:message code="persistentLogins" /></a></li>
            <li><a class="link" href="<c:url value="/upload" />"><spring:message code="upload" /></a></li>
            <li><a class="link" href="<c:url value="/logout" />"><spring:message code="exit" /></a></li>
        </ul>
    </div>
</div>
</body>
</html>
