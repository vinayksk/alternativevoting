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
<jsp:plugin type="applet" codebase="project.jar" code="VoterApplet.class" width="400" height="400">
    <jsp:fallback> <p>Unable to load applet</p>
    </jsp:fallback>
</jsp:plugin>
</body>
</html>
