<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Owners</title>
</head>
<body>
<h2>Owners</h2>


<c:if test="${empty owners}">
    <h3>Sorry, no records found... :(</h3>
</c:if>



<c:forEach items="${owners}" var="owner">
    First name: ${owner.firstName} <br/>
    Last name: ${owner.lastName} <br/>
    Address: ${owner.address} <br/>
    City: ${owner.city} <br/>
    Telephone: ${owner.telephone} <br/>
    <a href="/owner/edit/${owner.id}">Edit</a>
    <a href="/owner/delete/${owner.id}">Delete</a>
    <a href="/pet/create/${owner.id}">Add animal</a>
    <br /><br />
    <c:forEach items="${owner.pets}" var="pet">
        Name: ${pet.name}<br />
        Birthday: ${pet.birthday}<br />
        <a href="/visit/create/${pet.id}">Add visit</a> <br /><br />
        <br /><br />
    </c:forEach>
    <br/><br/><br/><br />
</c:forEach>
</body>
</html>