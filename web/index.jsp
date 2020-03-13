<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Card XML Parser</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="css/mdb.min.css">

</head>

<body>

<div class="container">
    <h1 class="h1">
        Choose parser
    </h1>
    <form action="${pageContext.request.contextPath}/controller" method="post" enctype="multipart/form-data">
        <input type="radio" value="sax_parser" name="parser" checked>SAX
        <input type="radio" value="stax_parser" name="parser">StAX
        <input type="radio" value="dom_parser" name="parser">DOM
        <br/>
        <br/>

        <input class="btn btn-blue-grey" type="file"
               name="file" accept=".xml">

        <br/>
        <br/>
        <input class="btn btn-elegant" type="submit" value="Parse"/>
    </form>
</div>

<!-- jQuery -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="js/mdb.min.js"></script>


</body>
</html>
