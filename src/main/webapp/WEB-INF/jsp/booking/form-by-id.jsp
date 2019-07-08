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
<form:form action="/booking/by-id/${car.id}" method="POST" modelAttribute="car">
    <c:forEach items="${bookings}" var="booking">
        <input type="radio" name="car" value="car.id">
        Company: ${car.company}<br />
        Model: ${car.model} <br />
        Category: ${car.category} <br />
        Year: ${car.year} <br />
        Color: ${car.color}<br />
        Mileage: ${car.mileage} <br />
        Status: ${car.status} <br />
        Price per day: ${car.pricePerDay} <br />
        <br /><br /><br />
    </c:forEach>
</form:form>

<br/><br/><br/>
<%--Cars: <select name="car">--%>
<%--<c:forEach items="${cars}" var="car">--%>
<%--<option value="${car.id}">${car.company} ${car.model}</option>--%>
<%--</c:forEach>--%>
<%--</select><br />--%>
<%--<form:form action="/booking/create" method="POST" modelAttribute="booking">--%>
<%--Date of booking: <form:input path="dateOfBooking"/> <br/>--%>
<%--Beginning of rent: <form:input path="beginningOfRent"/> <br/>--%>
<%--End of rent: <form:input path="endOfRent"/> <br/>--%>
<%--Price: <form:input path="price"/> <br/>--%>
<%--<input type="submit" value="Create"/>--%>
<%--</form:form>--%>
</body>
</html>