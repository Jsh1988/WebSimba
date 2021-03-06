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
    <title><spring:message code="slider" /></title>
</head>
<body>
<div id="block_body">
    <h1><spring:message code="welcome"/></h1>
    <div class="block_form_content">
        <div class="block_form">
            <f3 class="form-f3-title"><spring:message code="slider" /></f3>
            <c:url var="sliderDo" value="/bxslider.do" />
            <form:form action="${sliderDo}" method="post" commandName="bxslider">
                <ul id="block_log_pass">
                    <c:if test="${not empty ok}"><span class="ok">${ok}</span></c:if>
                    <c:if test="${not empty error}"><span class="error">${error}</span></c:if>
                    <li><form:input class="formas" type="text" placeholder="${id}"  path="id" /></li>
                    <li><form:input class="formas" type="text" placeholder="${title}" path="title" /></li>
                    <li><form:input class="formas" type="text" placeholder="${images}" path="images" /></li>
                    <li><form:input class="formas" type="text" placeholder="${url}" path="url" /></li>
                    <li><input class="submit" name="action" type="submit" value="Add" /> || <input class="submit" name="action" type="submit" value="Edit" /></li>
                    <li><input class="submit" name="action" type="submit" value="Delete" /> || <input class="submit" name="action" type="submit" value="Search" /></li>
                    <li><a class="link" href="<c:url value='/home' />"><spring:message code="home"/></a> || <a class="link" href="<c:url value="/logout" />"><spring:message code="exit" /></a></li>
                    <li><a class="link" href="<c:url value="/bxslider?lang=en" />">en</a> || <a class="link" href="<c:url value="/bxslider?lang=ru" />">ru</a></li>
                </ul>
            </form:form>
        </div>
        <div class="block_content">
            <div class="block_table_content">
                <ul class="block_ul">
                    <h2><li><spring:message  code="id" /> || <spring:message code="title" /> || <spring:message code="images" /> || <spring:message code="url" /></li></h2>
                    <c:forEach items="${bxsliderList}" var="bxslider">
                        <li><c:out value="${bxslider.id}"/> || <c:out value="${bxslider.title}"/> || <c:out value="${bxslider.images}"/> || <c:out value="${bxslider.url}"/></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>

