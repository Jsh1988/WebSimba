<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <title><spring:message code="user" /></title>
</head>
<body>
<div id="block_body">
    <h1><spring:message code="welcome"/></h1>
    <div class="block_form_content">
        <div class="block_form">
            <f3 class="form-f3-title"><spring:message code="user" /></f3>
            <c:url var="usersDo" value="/users.do" />
            <form:form action="${usersDo}" method="post" commandName="users">
                <ul id="block_log_pass">
                    <c:if test="${not empty ok}"><span class="ok">${ok}</span></c:if>
                    <c:if test="${not empty error}"><span class="error">${error}</span></c:if>
                    <li><form:input class="formas"  type="text" placeholder="${id}"  path="id"/></li>
                    <li><form:input class="formas"  type="text" placeholder="${login}"  path="login"/></li>
                    <form:errors path="login" cssClass="error" />
                    <li><form:input class="formas"  type="password" placeholder="${password}"  path="password" onkeyup="doAjax()" /></li>
                    <form:errors path="password" cssClass="error" />
                    <span id="strengthValue"></span>
                    <li><form:input class="formas"  type="text" placeholder="${email}"  path="email"/></li>
                    <form:errors path="email" cssClass="error" />
                    <li><form:input class="formas"  type="text" placeholder="${first_name}"  path="firstname"/></li>
                    <li><form:input class="formas"  type="text" placeholder="${surname}"  path="surname"/></li>
                    <li><form:input class="formas"  type="text" placeholder="${phone}"  path="phone"/></li>
                    <li>
                        <form:select path="country" class="formas" >
                            <c:forEach items="${country}" var="name">
                                <form:option value="${name}"><c:out value="${name}"/></form:option>
                            </c:forEach>
                        </form:select>
                    </li>
                    <li><form:input class="formas"  type="text" placeholder="${region}"  path="region"/></li>
                    <li><form:input class="formas"  type="text" placeholder="${city}"  path="city"/></li>
                    <li><form:input class="formas"  type="text" placeholder="${index}"  path="indexs"/></li>
                    <li><form:input class="formas"  type="text" placeholder="${street}"  path="street"/></li>
                    <li><form:input class="formas"  type="text" placeholder="${house}"  path="house"/></li>
                    <li><form:input class="formas"  type="text" placeholder="${admin}"  path="isAdmin"/></li>
                    <li><input class="submit" name="action" type="submit" value="Add" /> || <input class="submit" name="action" type="submit" value="Edit" /></li>
                    <li><input class="submit" name="action" type="submit" value="Delete" /> || <input class="submit" name="action" type="submit" value="Search" /></li>
                    <li><a class="link" href="<c:url value='/' />"><spring:message code="home"/></a> || <a class="link" href="<c:url value="/logout" />"><spring:message code="exit" /></a></li>
                    <li><a class="link" href="<c:url value="/users?lang=en" />">en</a> || <a class="link" href="<c:url value="/users?lang=ru" />">ru</a></li>
                </ul>
            </form:form>
        </div>
        <div class="block_content">
            <div class="block_table_content">
                <ul class="block_ul">
                    <h2><li><spring:message  code="id" /> || <spring:message code="login" /> || <spring:message code="password" /> || <spring:message code="email" /> || <spring:message code="first_name" /> || <spring:message code="sur_name" /> || <spring:message code="country" /> || <spring:message code="admin" /></li></h2>
                    <c:forEach items="${usersList}" var="users">
                        <li><c:out value="${users.id}"/> || <c:out value="${users.login}"/> || <c:out value="${users.password}"/> || <c:out value="${users.email}"/> || <c:out value="${users.firstname}"/> || <c:out value="${users.surname}"/> || <c:out value="${users.country}"/> || <c:out value="${users.isAdmin}"/></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
