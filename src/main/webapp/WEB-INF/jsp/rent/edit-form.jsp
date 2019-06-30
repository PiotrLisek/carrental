<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit rent</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Edit rent form</h2>
<form:form action="/rent/edit/${rent.id}" method="POST" modelAttribute="rent">
    ID:  <br />
    <%--Beginning of rental: <form:input path="rent.beginningOfRental"/> <br />--%>
    Notes: <form:input path="notes"/> <br />
    <form:hidden path="id" />
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>