<%--
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
</head>
<body>
<center><h1 style="font-family: 'Segoe UI Light'; font-size: 72px; padding-top: 3vh">Welcome to Warowac</h1>
    <button class="button button1" type="button" onclick="results.jsp">Vote</button>
    <button class="button button1" type="button" name="create" onclick="create()">Create</button>
    <form action="results.jsp" method="post" id="createElection" style="visibility: hidden">
        <input type="text" name="query">
        <input type="submit" value="Enter">
    </form>
    <script type="text/javascript">
        function create()
        { document.getElementById('createElection').style.visibility="visible"; }
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
    }

    .button1 {
        background-color: white;
        color: black;
        border: 2px solid #008CBA;
    }

    .button1:hover {
        background-color: #008CBA;
        color: white;
    }

</style>
</html>
