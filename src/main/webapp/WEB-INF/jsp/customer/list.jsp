<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customers list</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Customers list</h2>

<c:forEach items="${customers}" var="customer">
    First name: ${customer.firstName}<br />
    Last name: ${customer.lastName} <br />
    Phone number: ${customer.phoneNumber} <br />
    Address: ${customer.address} <br /><br />
    <a href="edit/${customer.id}">Edit</a> |
    <a href="delete-customer?id=${customer.id}">Delete</a>
    <br /><br /><br />
</c:forEach>
</body>
</html>