<%--
  Created by IntelliJ IDEA.
  User: aweso
  Date: 5/13/2017
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="alternativevoting.FusionCharts" %>
<html>
<script type="text/javascript" src="http://static.fusioncharts.com/code/latest/fusioncharts.js"></script>

<head>
    <title>Election</title>
</head>
<body>
<body><b><% out.println("Hello World!"); %></b>
<b><% out.println("graph"); %></b>
<b><%
    FusionCharts area2dChart = new FusionCharts(
            "Area2D",// chartType
            "myFirstChart",// chartId
            "600","400",// chartWidth, chartHeight
            "chart",// chartContainer
            "json",// dataFormat
            "{\"chart\":{\"caption\":\"Harry\\'sSuperMart\",\"subCaption\":\"Top 5 stores in last month by revenue\",\"numberPrefix\":\"$\",\"theme\":\"ocean\"},\"data\":[{\"label\":\"Bakersfield Central\",\"value\":\"880000\"},{\"label\":\"Garden Grooveharbour\",\"value\":\"730000\"},{\"label\":\"Los Angeles Topanga\",\"value\":\"590000\"},{\"label\":\"Compton-Rancho Dom\",\"value\":\"520000\"},{\"label\":\"Daly City Serramonte\",\"value\":\"330000\"}]}"
    );
%></b>
<%=area2dChart.render()%>
</body>

</body>
</html>
