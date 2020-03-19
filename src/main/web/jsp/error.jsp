<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="error" value="${not empty param.error ? param.error : 'Something went wrong :('}" scope="session" />
<html>
<head>
    <title>Oops</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/mdb.min.css">
    <style>
        body {
            background-image: url(../img/background.jpg);
        }
    </style>
</head>
<body>
<div class="container">
<h1 class="text-white ">
    ${error}
</h1>
</div>
</body>
</html>
