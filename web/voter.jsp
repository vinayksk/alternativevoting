<%@ page import="alternativevoting.VoterApplet" %>
<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 5/19/2017
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test voter</title>
</head>
<body>
    <jsp:plugin align="middle" height="500" width="500"
        type="applet"  code="alternativevoting.VoterApplet.class" name="clock" codebase="localhost:8080"></jsp:plugin>
</body>
</html>