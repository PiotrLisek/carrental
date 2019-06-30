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
<form:form action="/booking/create" method="POST" modelAttribute="booking">
    Date of booking: <form:input path="dateOfBooking"/> <br />
    Beginning of rent: <form:input path="beginningOfRent"/> <br />
    End of rent: <form:input path="endOfRent"/> <br />
    Price: <form:input path="price"/> <br />
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>