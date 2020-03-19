<!DOCTYPE html>
<html lang="en">
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
    </style>
</head>

<body>

<div class="container">
    <h1 class="h1">
        <p class="text-light">Choose cards parser</p>
    </h1>
    <form action="${pageContext.request.contextPath}/controller" method="post" enctype="multipart/form-data">
        <input type="radio" value="sax_parser" name="parser" checked>
        <p class="text-light">SAX</p>
        <input type="radio" value="stax_parser" name="parser">
        <p class="text-light">StAX</p>
        <input type="radio" value="dom_parser" name="parser">
        <p class="text-light">DOM</p>
        <br/>
        <br/>
        <input class="btn btn-elegant" type="file"
               name="file" accept=".xml">
        <br/>
        <br/>
        <input class="btn btn-light font-weight-bold" type="submit" value="Parse"/>
    </form>

</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/mdb.min.js"></script>

</body>
</html>
