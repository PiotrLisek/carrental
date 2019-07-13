<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bookings list</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Income list</h2>
<c:forEach items="${accounts}" var="account">
    Transaction ID: ${account.bookingId}
    Transaction Money: ${account.amount}
    <br /><br /><br />
</c:forEach>


</body>
</html>