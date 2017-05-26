<%--
  Created by IntelliJ IDEA.
  User: aweso
  Date: 5/25/2017
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thank You - Warowac</title>
</head>
<body>
    <h1 style="font-family: 'Segoe UI Light'; font-size: 72px; padding-top: 3vh">Thanks for creating the election.</h1>
    <script>
        var jk = "";
        <%String lit = (request.getParameter("urlPop"));%>
        jk = <%=lit%>;
    </script>
</body>
</html>
