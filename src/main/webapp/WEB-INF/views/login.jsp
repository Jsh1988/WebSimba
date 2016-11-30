<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/login-form.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/error.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/form-block.css" />" rel="stylesheet" />
    <title><spring:message code="security"/></title>
</head>
<body>

<div id="block_body">
    <h1><spring:message code="welcome"/></h1>
    <div id="block_avtorizaciya">
        <c:url var="loginUrl" value="/j_spring_security_check" />
        <form:form method="post" commandName="user" action="${loginUrl}" >
            <ul id="block_log_pass">
                <h3><spring:message code="entrance"/></h3>
                <li><input class="formas"  type="text"  id="auth_log" placeholder="${login}"  name="s_login"/></li>
                <c:if test="${not empty error}"><span class="error">${error}</span></c:if>
                <li><input class="formas"  type="password" placeholder="${password}" name="s_password" /></li>
                <li><input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" /></li>
                <li><input type="checkbox" name="remember-me"  /><span class="check"><spring:message code="remember_me"/></span></li>
                <li><input class="submit" name="auth_sub" type="submit" value="${entrance}"> || <a class="link" href="<c:url value='/' />"><spring:message code="home"/></a></li>
            </ul>

        </form:form>

        </div>
</div>
</body>
</html>
