<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="<c:url value="/resources/css/login-form.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/form-block.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/error.css" />" rel="stylesheet" />
    <title><spring:message code="ip_adress" /></title>
</head>
<body>
<div id="block_body">
    <h1><spring:message code="welcome"/></h1>
    <div class="block_form_content">
        <div class="block_form">
            <f3 class="form-f3-title"><spring:message code="ip_adress" /></f3>
            <c:url var="ipsDo" value="/ips.do" />
            <form:form action="${ipsDo}" method="post" commandName="ips">
                <ul id="block_log_pass">
                    <c:if test="${not empty ok}"><span class="ok">${ok}</span></c:if>
                    <c:if test="${not empty error}"><span class="error">${error}</span></c:if>
                    <li><form:input class="formas" type="text" placeholder="${id}"  path="id" /></li>
                    <li><form:input class="formas" type="text" placeholder="${ip_adress}" path="ipAdress" /></li>
                    <li><input class="submit" name="action" type="submit" value="Add" /> || <input class="submit" name="action" type="submit" value="Edit" /></li>
                    <li><input class="submit" name="action" type="submit" value="Delete" /> || <input class="submit" name="action" type="submit" value="Search" /></li>
                    <li><a class="link" href="<c:url value='/home' />"><spring:message code="home"/></a> || <a class="link" href="<c:url value="/logout" />"><spring:message code="exit" /></a></li>
                    <li><a class="link" href="<c:url value="/ips?lang=en" />">en</a> || <a class="link" href="<c:url value="/ips?lang=ru" />">ru</a></li>
                </ul>
            </form:form>
        </div>
        <div class="block_content">
            <div class="block_table_content">
                <ul class="block_ul">
                    <h2><li><spring:message  code="id" /> || <spring:message code="ip_adress" /></li></h2>
                    <c:forEach items="${ipsList}" var="ips">
                        <li><c:out value="${ips.id}"/> || <c:out value="${ips.ipAdress}"/></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>


