<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create booking</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Create booking form</h2>
<form:form action="/booking/create/${booking.car.department.id}/finish" method="POST" modelAttribute="cars">
    Radio buttons
    <%--Company: <form:input path="id"/> <br />--%>
    <%--Model: <form:input path="model"/> <br />--%>
    <%--Category: <form:input path="category"/> <br />--%>
    <%--Year: <form:input path="year"/> <br />--%>
    <%--Color: <form:input path="color"/> <br />--%>
    <%--Mileage: <form:input path="mileage"/> <br />--%>
    <%--Status: <form:input path="status"/> <br />--%>
    <%--Price per day: <form:input path="pricePerDay"/> <br />--%>
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>