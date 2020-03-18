<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%--<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />--%>
<%--<fmt:setLocale value="${language}"/>--%>
<c:if test="${empty sessionScope.language}">
    <fmt:setLocale value="es"/>
</c:if>
<c:if test="${not empty sessionScope.language}">
    <fmt:setLocale value="${sessionScope.language}"/>
</c:if>
<fmt:setBundle basename="resources.locale" var="locale"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Card XML Parser</title>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/mdb.min.css">
    <style>
        body {
            background-image: url(img/background.jpg);
        }

        select {
            position: absolute;
            top: 20px;
            right: 50px;
        }
    </style>
</head>

<body>

<div class="container">
    <h1 class="h1 col-6">
        <p class="text-light"><fmt:message bundle="${locale}" key="menu.main_title"/></p>
    </h1>
    <form action="/controller" method="post" enctype="multipart/form-data">
        <input type="radio" value="sax_parser" name="command" checked>
        <p class="text-light"><fmt:message key="parser.sax"/></p>
        <input type="radio" value="stax_parser" name="command">
        <p class="text-light">StAX</p>
        <input type="radio" value="dom_parser" name="command">
        <p class="text-light">DOM</p>
        <br/>
        <br/>
        <input class="btn btn-elegant" type="file"
               name="file" accept=".xml">
        <br/>
        <br/>
        <input class="btn btn-light text-dark font-weight-bold" type="submit" value="Parse"/>
        <form action="/controller" method="post" enctype="multipart/form-data" onchange="submit()">
            <select id="language" name="command" style="width: 8rem"
                    class="btn-light browser-default custom-select mb-3">
                <option value="en" selected>English</option>
                <option value="es" >Spanish</option>
                <option value="ru" >Russian</option>
            </select>
        </form>
    </form>
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/mdb.min.js"></script>

</body>
</html>
