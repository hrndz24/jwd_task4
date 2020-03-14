<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parsed cards</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/mdb.min.css">
    <style>
        body {
            background-image: url(../img/background.jpg);
        }

        td, th {
            color: white;
        }
    </style>
</head>
<body>
<table class="table">
    <thead class="grey">
    <tr>
        <th class="text-dark font-weight-bold" scope="col">Id</th>
        <th class="text-dark font-weight-bold" scope="col">Author</th>
        <th class="text-dark font-weight-bold" scope="col">Theme</th>
        <th class="text-dark font-weight-bold" scope="col">Type</th>
        <th class="text-dark font-weight-bold" scope="col">Country</th>
        <th class="text-dark font-weight-bold" scope="col">Year</th>
        <th class="text-dark font-weight-bold" scope="col">Value</th>
        <th class="text-dark font-weight-bold" scope="col">Sending date</th>
    </tr>

    </thead>
    <c:forEach var="card" items="${cards}">
        <tr>
            <th class="text-light" scope="row"><c:out value="${card.id}"/></th>
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
