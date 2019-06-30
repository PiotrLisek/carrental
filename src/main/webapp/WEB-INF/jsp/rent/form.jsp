<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create rent</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Create rent form</h2>
<form:form action="/rent/create" method="POST" modelAttribute="rent">
    ID:  <br />
    <%--Beginning of rental: <form:input path="rent.beginningOfRental"/> <br />--%>
    Notes: <form:input path="notes"/> <br />
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>
