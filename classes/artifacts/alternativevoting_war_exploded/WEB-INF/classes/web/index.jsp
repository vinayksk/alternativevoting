<%@ page import="java.util.ArrayList" %>
<%@ page import="static jdk.nashorn.internal.objects.NativeArray.join" %><%--
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
    <script>

        <%!
               // --- Create two Java Arrays

                public ArrayList<Integer> months = new ArrayList<Integer>();
                public ArrayList<Integer> users = new ArrayList<Integer>();
        %>
        <%

               // --- Loop 10 times and create 10 string dates and 10 users
                int counter = 1;
                while(counter < 11)
                {
                    months.add(counter);
                    users.add(counter);
                    counter++;
                }
          %>





        // --- add a comma after each value in the array and convert to javascript string representing an array
        var monthData = months.toString();
        monthData = monthData.replace("[","");
        monthData = monthData.replace("]","");
        monthData = monthData.split(",");
        console.log(monthData);

    </script>
</head>

<body>
    <b><% out.println("Hello World!"); %></b>
    <b><% out.println("graph"); %></b>
    <h1>
        hello
    </h1>
    <div id="tester" style="width:600px;height:250px;"></div>
</body>


<%--<script>--%>
    <%--window.onload = function () {--%>
        <%--TESTER = document.getElementById('tester');--%>
        <%--Plotly.plot( TESTER, [{--%>
            <%--x: monthData,--%>
            <%--y: userData }], {--%>
            <%--margin: { t: 0 } } );--%>
    <%--}--%>
    <%----%>
<%--</script>--%>


</html>
