<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parsed cards</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Author</th>
        <th>Theme</th>
        <th>Type</th>
        <th>Country</th>
        <th>Year</th>
        <th>Value</th>
        <th>Sending date</th>
    </tr>
    <c:forEach var="card" items="${cards}">
        <tr>
            <td><c:out value="${card.id}"/></td>
            <td><c:out value="${card.author}"/></td>
            <td><c:out value="${card.theme}"/></td>
            <td><c:out value="${card.type}"/></td>
            <td><c:out value="${card.country}"/></td>
            <td><c:out value="${card.year}"/></td>
            <td><c:out value="${card.value}"/></td>
            <td><c:out value="${card.sendingDate}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
