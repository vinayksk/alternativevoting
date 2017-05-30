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
<form action="voter" id="fat" method="post">
    <% String name = request.getParameter("query");
        heroku a = new heroku();
        ArrayList<String> list = a.retrieve(name);
        out.println("Hello and welcome to the " + name + " election!"); %>
    <br/><br/>

    <script> var cands = [<% for (int i = 0; i < list.size(); i++) { %>"<%= list.get(i) %>"<%= i + 1 < list.size() ? ",":"" %><% } %>]; </script>

    Please put your name:<input type="text" name="userName"/><br/><br/>
    <br/><br/>
    Please rank candidates from 1 to N, where N is the number of candidates you like. N can be less than the total number of candidates. Do NOT repeat. You may leave candidate names blank. <br/><br/>
    <br/><br/>
    <% int numCands = list.size();
        out.println("There are a total of " + numCands + " candidates."); %> <br/><br/>
    <% for(int i=1;i<=numCands;i++){String candName="vote"+i;%>
    <% out.print(list.get(i-1) + ":");%> <input type="number" name=voteName/><br/><br/>
    <% } %>

    <br/><br/>



    <input type="hidden" value=name name="electionName" />
    <input type="hidden" id="asdf" name="number" />
    <input type="submit" value="submit vote"/>
    <input type="reset" value="try again">
    <script>
        var numberCands = parseInt(<%=numCands%>);

    document.getElementById("asdf").value=numberCands</script>

</form>
</html>