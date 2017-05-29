<%@ page import="java.applet.*" %>
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
    <title>Voter Screen</title>
</head>
<form action="welcome.jsp" method="post">

    Hello and welcome to the TEST election! <br/><br/>

    Please put your name:<input type="text" name="userName"/><br/><br/>
    What is your age?:<input type="number" name="age"/><br/><br/>
    Please rank candidates from 1 to N, where N is the number of candidates you like. N can be less than the total number of candidates. Do NOT repeat. You may leave candidate names blank. <br/><br/>
    Cand1:<input type="number" name="vote1"/><br/><br/>
    Cand2:<input type="number" name="vote2"/><br/><br/>
    Cand3:<input type="number" name="vote3"/><br/><br/>
    <br/><br/>
    <input type="submit" value="submit vote"/>
    <input type="reset" value="try again">
</form>
</html>
