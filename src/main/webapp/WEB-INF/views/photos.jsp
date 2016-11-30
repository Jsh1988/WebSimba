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
    <title><spring:message code="images" /></title>
</head>
<body>
<div id="block_body">
    <h1><spring:message code="welcome"/></h1>
    <div class="block_form_content">
        <div class="block_form">
            <f3 class="form-f3-title"><spring:message code="images" /></f3>
            <c:url var="photosDo" value="/photos.do" />
            <form:form action="${photosDo}" method="post" commandName="photos">
                <ul id="block_log_pass">
                    <c:if test="${not empty ok}"><span class="ok">${ok}</span></c:if>
                    <c:if test="${not empty error}"><span class="error">${error}</span></c:if>
                    <li><form:input class="formas" type="text" placeholder="${id}"  path="idPhoto" /></li>
                    <li><form:input class="formas" type="text" placeholder="${title}" path="title" /></li>
                    <li><form:input class="formas" type="text" placeholder="${images}" path="photo" /></li>
                    <li><form:input class="formas" type="text" placeholder="${parent}" path="parent" /></li>
                    <li><form:input class="formas" type="text" placeholder="${photoDescription}" path="photoDescription" /></li>
                    <li><form:input class="formas" type="text" placeholder="${link}" path="link" /></li>
                    <li><form:input class="formas" type="text" placeholder="${mark}" path="mark" /></li>

                    <li><input class="submit" name="action" type="submit" value="Add" /> || <input class="submit" name="action" type="submit" value="Edit" /></li>
                    <li><input class="submit" name="action" type="submit" value="Delete" /> || <input class="submit" name="action" type="submit" value="Search" /></li>
                    <li><a class="link" href="<c:url value='/home' />"><spring:message code="home"/></a> || <a class="link" href="<c:url value="/logout" />"><spring:message code="exit" /></a></li>
                    <li><a class="link" href="<c:url value="/photos?lang=en" />">en</a> || <a class="link" href="<c:url value="/photos?lang=ru" />">ru</a></li>
                </ul>
            </form:form>
        </div>
        <div class="block_content">
            <div class="block_table_content">
                <ul class="block_ul">
                    <h2><li><spring:message  code="id" /> || <spring:message code="title" /> || <spring:message code="images" /> || <spring:message code="parent" /> || <spring:message code="photoDescription" /> || <spring:message code="link" /> || <spring:message code="mark" /></li></h2>
                    <c:forEach items="${photosList}" var="photos">
                        <li><c:out value="${photos.idPhoto}"/> || <c:out value="${photos.title}"/> || <c:out value="${photos.photo}"/> || <c:out value="${photos.parent}"/> || <c:out value="${photos.photoDescription}"/> || <c:out value="${photos.link}"/> || <c:out value="${photos.mark}"/></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>


