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
    <title><spring:message code="comments" /></title>
</head>
<body>
<div id="block_body">
    <h1><spring:message code="welcome"/></h1>
    <div class="block_form_content">
        <div class="block_form">
            <f3 class="form-f3-title"><spring:message code="comments" /></f3>
            <c:url var="commentsDo" value="/comments.do" />
            <form:form action="${commentsDo}" method="post" commandName="comments">
                <ul id="block_log_pass">
                    <c:if test="${not empty ok}"><span class="ok">${ok}</span></c:if>
                    <c:if test="${not empty error}"><span class="error">${error}</span></c:if>
                    <li><form:input class="formas" type="text" placeholder="${id}"  path="id" /></li>
                    <li><form:input class="formas" type="text" placeholder="${first_name}"  path="firstname" /></li>
                    <li><form:input class="formas" type="text" placeholder="${sur_name}"  path="surname" /></li>
                    <li><form:textarea class="formas"   path="content"  /></li>
                    <li><form:input class="formas" type="text" placeholder="${parent}"  path="parent" /></li>
                    <li><form:input class="formas" type="text" placeholder="${idProduct}"  path="idProduct" /></li>
                    <li><form:input path="strDate" class="formas" type="text" placeholder="${date}"/></li>
                    <li><form:input class="formas" type="text" placeholder="${admin}" path="isAdmin" /></li>
                    <li><input class="submit" name="action" type="submit" value="Add" /> || <input class="submit" name="action" type="submit" value="Edit" /></li>
                    <li><input class="submit" name="action" type="submit" value="Delete" /> || <input class="submit" name="action" type="submit" value="Search" /></li>
                    <li><a class="link" href="<c:url value='/home' />"><spring:message code="home"/></a> || <a class="link" href="<c:url value="/logout" />"><spring:message code="exit" /></a></li>
                    <li><a class="link" href="<c:url value="/comments?lang=en" />">en</a> || <a class="link" href="<c:url value="/comments?lang=ru" />">ru</a></li>
                </ul>
            </form:form>
        </div>
        <div class="block_content">
            <div class="block_table_content">
                <ul class="block_ul">
                    <h2><li><spring:message  code="id" /> || <spring:message code="date" /> || <spring:message code="first_name" /> || <spring:message code="sur_name" /> || <spring:message code="content" /> || <spring:message code="idProduct" /></li></h2>
                    <c:forEach items="${commentsList}" var="comments">
                        <li><c:out value="${comments.id}"/> || <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${comments.date}" /> || <c:out value="${comments.firstname}"/> || <c:out value="${comments.surname}"/> || <c:out value="${comments.content}"/> || <c:out value="${comments.idProduct}"/></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>



