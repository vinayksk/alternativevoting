<%@ page import="java.util.ArrayList" %>
<%@ page import="alternativevoting.heroku" %>
<%@ page import="java.sql.DriverManager" %>
<%--
  Created by IntelliJ IDEA.
  User: aweso
  Date: 5/23/2017
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warowac</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
<center>
    <h1 style="font-family: 'Segoe UI Light'; font-size: 72px; padding-top: 3vh">Enter candidates for <%out.println(request.getParameter("electionName"));%></h1>
    <div>
        <form action="thanksCreate.jsp" id="list" method="post" onsubmit="push()">
            <input type="hidden" id="pass" name="urlPop">
        </form>
    </div>
    <script>
    var toAdd = document.createDocumentFragment();
    <%int cand = Integer.parseInt(request.getParameter("numberCand"));%>
    var inte = parseInt(<%=cand%>);
    console.log(inte);
    for(var i = 1; i <= inte; i++){
        var newDiv = document.createElement('input');
        newDiv.id = 'r'+ i;
        newDiv.className = 'ansbox';
        var newString = document.createElement('span');
        newString.textContent = 'Candidate ' + i + "  ";
        newString.className = 'rep';
        toAdd.appendChild(newString);
        toAdd.appendChild(newDiv);
        toAdd.appendChild(document.createElement('br'));
        toAdd.appendChild(document.createElement('br'));
    }
    var button = document.createElement('input');
    button.className = 'button';
    button.setAttribute('type', 'submit');
    toAdd.appendChild(button);
    document.getElementById('list').appendChild(toAdd);

    function push() {
        var names = "";
        for(var i = 1; i <= inte ; i++) {
            var id = "r" + i;
            names = names + (document.getElementById(id).value) + " ";
        }
        document.getElementById('pass').value = names;
    }

    </script>
    <style>
        .rep{
            font-family: "Segoe UI Light";
        }
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
</center>

</body>
</html>
