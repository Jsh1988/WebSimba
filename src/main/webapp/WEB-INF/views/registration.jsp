<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/login-form.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/error.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/form-block.css" />" rel="stylesheet" />
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
    <script type="text/javascript">
        function doAjax() {
            $.ajax({
                url: 'checkStrength',
                data: ({password : $('#password').val()}),
                success: function(data) {
                    $('#strengthValue').html(data);
                }
            });
        }
    </script>
    <title><spring:message code="registration"/></title>
</head>
<body>
<div id="block_body">
    <h1><spring:message code="welcome"/></h1>
    <div id="block_avtorizaciya">
        <c:url var="regUrl" value="/reg" />
        <form:form method="post" commandName="reg_user" action="${regUrl}" >
            <h3 class="form-f3-title"><spring:message code="registration"/></h3>
            <ul id="block_log_pass">
                <c:if test="${not empty reg_ok}"><span class="ok">${reg_ok}</span></c:if>
                <c:if test="${not empty error}"><span class="error">${error}</span></c:if>
                <li><form:input class="formas"  type="text" placeholder="${login}"  path="login"/></li>
                <form:errors path="login" cssClass="error" />
                <li><form:input class="formas"  type="password" placeholder="${password}"  path="password" onkeyup="doAjax()" /></li>
                <form:errors path="password" cssClass="error" />
                <span id="strengthValue"></span>
                <li><form:input class="formas"  type="password" placeholder="${confirm_password}"  path="confirmPassword"/></li>
                <c:if test="${not empty confirm_password_error}"><span class="error">${confirm_password_error}</span></c:if>
                <li><form:input class="formas"  type="text" placeholder="${email}"  path="email"/></li>
                <form:errors path="email" cssClass="error" />
                <li>
                    <form:select path="country" class="formas" >
                        <c:forEach items="${country}" var="name">
                        <form:option value="${name}"><c:out value="${name}"/></form:option>
                        </c:forEach>
                    </form:select>
                </li>
                <li><form:checkbox path="check"/><span class="check"><spring:message code="check_robot"/></span></li>
                <li><input class="submit" name="reg_submit" type="submit" value="${registration}"> || <a class="link" href="<c:url value='/' />"><spring:message code="home"/></a></li>
                <li><a class="link" href="<c:url value="/registration?lang=en" />">en</a> || <a class="link" href="<c:url value="/registration?lang=ru" />">ru</a></li>
            </ul>
        </form:form>
    </div>
</div>
</body>
</html>
