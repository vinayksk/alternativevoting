<%--
  Created by IntelliJ IDEA.
  User: aweso
  Date: 5/13/2017
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Election</title>
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
</head>

<body>
    <b><% out.println("Hello World!"); %></b>
    <b><% out.println("graph"); %></b>
    <h1>
        hello
    </h1>
    <div id="tester" style="width:600px;height:250px;"></div>
</body>

<script>
    TESTER = document.getElementById('tester');
    Plotly.plot( TESTER, [{
        x: [1, 2, 3, 4, 5],
        y: [1, 2, 4, 8, 16] }], {
        margin: { t: 0 } } );
</script>


</html>
