<%@ page import="java.applet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="alternativevoting.heroku" %>
<%@ page import="alternativevoting.Candidate" %>
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
<body style="font-family: 'Segoe UI Light'">
<center>
<form action="voter" method="post">
    <% String elecname = request.getParameter("query");
        heroku a = new heroku();
        ArrayList<String> list = a.retrieve(elecname);%>
    <h1>Hello and welcome to the <span style="color: #008CBA;"><%out.print(elecname);%></span> election!</h1>
    <br/>

    Please enter your name: <input type="text" name="userName"/><br/><br/>
    <br/>
    Please rank candidates from 1 to N, where N is the number of candidates you like. N can be less than the total number of candidates. Do NOT repeat. You may leave candidate names blank. <br/><br/>
    <br/>
    <% int numCands = list.size();
        out.println("There are a total of " + numCands + " candidates."); %><br><br>
    <% for(int i=1;i<=numCands;i++){String voteName="vote"+i;%>
    <b><span style="color: #008CBA;"><% out.print(list.get(i-1) + ": ");%></span></b><input type="number" name="<%=voteName%>"/><br/><br/>
    <% } %>

    <br/><br/>
    <input type="hidden" id = "elec" name="electionName" />
    <input type="hidden" id="n" name="number" />
    <input type="submit" class="button button1" value="Submit Vote"/>
    <input type="reset" class="button button1" value="Try Again">
    <script>var num = "<%=numCands%>";
    var fat = "<%=elecname%>";
    document.getElementById("elec").value = fat;
    document.getElementById("n").value = num;</script>
</form>
    <style>
        .rep{
            font-family: "Segoe UI Light";
        }
        .button {
            background-color: #008CBA; /* Green */
            border: none;
            color: white;
            padding: 16px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
            cursor: pointer;
            font-family: 'Segoe UI Light'
        }

        .button1 {
            background-color: white;
            color: #008CBA;
            border: 2px solid #008CBA;
        }

        .button1:hover {
            background-color: #008CBA;
            color: white;
        }
    </style>
</center>
</body>
</html>