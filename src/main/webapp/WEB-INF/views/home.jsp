<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html >
<head>
    <link href="<c:url value="/resources/css/login-form.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/error.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/form-block.css" />" rel="stylesheet" />
    <title><spring:message code="home"/></title>
</head>
<body>
<div id="block_body">
    <h1><spring:message code="welcome"/></h1>
    <div id="block_avtorizaciya">
        <c:url var="loginUrl" value="/menu" />
        <form:form method="post" commandName="user" action="${loginUrl}" >
            <ul id="block_log_pass">
                <h3><spring:message code="entrance"/></h3>
                <c:if test="${not empty npe}"><span class="error">${npe}</span></c:if>
                <li><form:input class="formas"  type="text"  placeholder="${login}"  path="login"/></li>
                <form:errors path="login" cssClass="error" />
                <li><form:input class="formas"  type="password"  placeholder="${password}" path="password" /></li>
                <form:errors path="password" cssClass="error" />
                <li><input class="submit" name="auth_sub" type="submit" value="${entrance}"> || <a class="link" href="<c:url value="/registration" />"><spring:message code="registration"/></a></li>
                <li><form:checkbox path="check" /><span class="check"><spring:message code="simple_input"/></span></li>
                <li><a class="link" href="<c:url value="/home?lang=en" />">en</a> || <a class="link" href="<c:url value="/home?lang=ru" />">ru</a></li>
            </ul>
        </form:form>
    </div>
</div>
<%--<jsp:useBean id="categoriesDao" class="com.websimba.spring.dao.impl.CategoriesDaoImpl" scope="application"/>--%>
<%--<c:out value="${categoriesDao.test()}"/>--%>
</body>
</html>
