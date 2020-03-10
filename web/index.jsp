<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cards parser</title>
</head>
    <body>
        <h1>
            Choose parser
        </h1>
        <form action="/home" method="post">
            <input type="radio" value="sax_parser" name="parser">SAX
            <input type="radio" value="stax_parser" name="parser">StAX
            <input type="radio" value="dom_parser" name="parser">DOM

            <input type="submit" value="Parse">
        </form>
    </body>
</html>
