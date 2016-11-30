<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title><spring:message code="error"/></title>
</head>
<body>
<h1><spring:message code="error"/></h1>
<p><spring:message code="page"/>${page_error}</p>
</body>
</html>
