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
    <title><spring:message code="products" /></title>
</head>
<body>
<div id="block_body">
    <h1><spring:message code="welcome"/></h1>
    <div class="block_form_content">
        <div class="block_form">
            <f3 class="form-f3-title"><spring:message code="products" /></f3>
            <c:url var="productsDo" value="/products.do" />
            <form:form action="${productsDo}" method="post" commandName="products">
                <ul id="block_log_pass">
                    <c:if test="${not empty ok}"><span class="ok">${ok}</span></c:if>
                    <c:if test="${not empty error}"><span class="error">${error}</span></c:if>
                    <li><form:input class="formas" type="text" placeholder="${id}"  path="id" /></li>
                    <li><form:input class="formas" type="text" placeholder="${title}"  path="title" /></li>
                    <li><form:input class="formas" type="text" placeholder="${alias}"  path="alias" /></li>
                    <li><form:input class="formas" type="text" placeholder="${parent}"  path="parent" /></li>
                    <li><form:textarea class="formas"   path="discription"  /></li>
                    <li><form:textarea class="formas"   path="content"  /></li>
                    <li><form:input class="formas" type="text" placeholder="${images}"  path="img" /></li>
                    <li><form:input class="formas" type="text" placeholder="${price}"  path="price" /></li>
                    <li><form:input class="formas" type="text" placeholder="${description}"  path="descriptions" /></li>
                    <li><form:input class="formas" type="text" placeholder="${keywords}"  path="keywords" /></li>
                    <li><form:input path="strDate" class="formas" type="text" placeholder="${date}"/></li>
                    <li><form:input class="formas" type="text" placeholder="${hosts}" path="hosts" /></li>
                    <li><form:input class="formas" type="text" placeholder="${views}" path="views" /></li>
                    <li><input class="submit" name="action" type="submit" value="Add" /> || <input class="submit" name="action" type="submit" value="Edit" /></li>
                    <li><input class="submit" name="action" type="submit" value="Delete" /> || <input class="submit" name="action" type="submit" value="Search" /></li>
                    <li><a class="link" href="<c:url value='/home' />"><spring:message code="home"/></a> || <a class="link" href="<c:url value="/logout" />"><spring:message code="exit" /></a></li>
                    <li><a class="link" href="<c:url value="/products?lang=en" />">en</a> || <a class="link" href="<c:url value="/products?lang=ru" />">ru</a></li>
                </ul>
            </form:form>
        </div>
        <div class="block_content">
            <div class="block_table_content">
                <ul class="block_ul">
                    <h2><li><spring:message  code="id" /> || <spring:message code="date" /> || <spring:message code="title" /> || <spring:message code="alias" /></li></h2>
                    <c:forEach items="${productsList}" var="products">
                        <li><c:out value="${products.id}"/> || <fmt:formatDate pattern="yyyy-MM-dd" value="${products.date}" /> || <c:out value="${products.title}"/> || <c:out value="${products.alias}"/></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>




