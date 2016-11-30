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
    <title><spring:message code="upload" /></title>
</head>
<body>
<div id="block_body">
    <h1><spring:message code="welcome" /></h1>
    <div id="block_avtorizaciya">
        <h3 class="form-f3-title"><spring:message code="upload"/></h3>
        <ul id="block_log_pass">
            <c:if test="${not empty filename}"><span class="ok">${filename}</span></c:if>
            <li><a class="link" href="<c:url value="/" />"><spring:message code="home"/></a></li>
                <form:form method="post" enctype="multipart/form-data" modelAttribute="uploadedFile" action="uploadFile">
                    <li><input type="file" name="file" /></li>
                     <li><form:errors path="file" /></li>
                    <li><input class="submit" type="submit" value="Upload" /></li>
                </form:form>
            <li><a class="link" href="<c:url value="/logout" />"><spring:message code="exit" /></a></li>

        </ul>
    </div>
</div>
</body>
</html>

