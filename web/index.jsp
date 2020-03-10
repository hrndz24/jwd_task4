<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cards parser</title>
</head>
<body>
    <h1>
        Choose parser
    </h1>

    <form action="/home" method="post" enctype="multipart/form-data">
        <input type="radio" value="sax_parser" name="parser" checked>SAX
        <input type="radio" value="stax_parser" name="parser">StAX
        <input type="radio" value="dom_parser" name="parser">DOM
        <br/>
        <br/>

        <input class="custom-file-input" type="file"
               name="file" accept=".xml">

        <br/>
        <br/>
        <input type="submit" value="Parse"/>
    </form>
</body>
</html>
