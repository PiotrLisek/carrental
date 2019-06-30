<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Rents list</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Rents list</h2>

<c:forEach items="${rents}" var="rent">
    ID: ${rent.id}<br />
    Beginning of rental: ${booking.beginningOfRental} <br />
    Notes: ${rent.notes} <br />
    <a href="edit/${rent.id}">Edit</a> |
    <a href="delete-rent?id=${rent.id}">Delete</a>
    <br /><br /><br />
</c:forEach>
</body>
</html>