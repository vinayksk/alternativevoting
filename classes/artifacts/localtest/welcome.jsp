<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: aweso
  Date: 5/18/2017
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <script
            src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous"></script>
</head>
<body>
<%
    ArrayList<String> election = new ArrayList<>();
    String electionName = "";
%>
<center><h1 style="font-family: 'Segoe UI Light'; font-size: 72px; padding-top: 3vh">Welcome to <span style="color: #008CBA;">Warowac</span></h1>
    <button class="button button1" type="button" id="vote" onclick="change()">Vote</button>
    <button class="button button1" type="button" id="create" onclick="change1()">Create</button>
    <div id="workspace">
    </div>
    <div id="workspace2">
    </div>
    <div id="enterElection" style="display: none;">
        <p style="font-family: 'Segoe UI Light'">Enter the election code:</p>
        <form action="voter.jsp" method="post">
            <input type="text" name="query">
            <input class="button1" type="submit" value="Enter" style="font-family: 'Segoe UI Light'">
        </form>
    </div>
    <div id="createElection" style="display: none;">
        <form action="candidateEntry.jsp" method="post">
            <p style="font-family: 'Segoe UI Light'">What is the name of the election?</p>
            <input type="text" name="electionName">
            <p style="font-family: 'Segoe UI Light'">How many candidates?</p>
            <input type="text" name="numberCand">
            <br>
            <br>
            <input class="button1" type="submit" value="Submit" style="font-family: 'Segoe UI Light'">
        </form>
    </div>
    <script>
        function change() {
            var test = $('#enterElection').html();
            $('#workspace').html(test);
        };
        function change1() {
            var test = $('#createElection').html();
            $('#workspace').html(test);
        };
    </script>
</center>
</body>
<style>
    .button {
        background-color: #4CAF50; /* Green */
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
</html>
