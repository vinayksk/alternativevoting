<%@ page import="java.util.ArrayList" %>
<%@ page import="static jdk.nashorn.internal.objects.NativeArray.join" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: aweso
  Date: 5/13/2017
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Election</title>
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>

</head>

<body>
    <b><% out.println("Hello World!"); %></b>
    <b><% out.println("graph"); %></b>
    <h1>
        hello
    </h1>
    <div id="tester" style="width:600px;height:250px;"></div>
</body>
<script>

    <%!
           // --- Create two Java Arrays
            public ArrayList<Integer> months = new ArrayList<Integer>();
            public ArrayList<String> users = new ArrayList<String>();
    %>
    <%
            String hostName = "warowac";
            String dbName = "testDB";
            String user = "warowac";
            String password = "XoFruitL00ps";
            String url = String.format("jdbc:sqlserver://%s.database.windows.net:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
            Connection connection = null;

            try{
                connection = DriverManager.getConnection(url);
                Statement mystat = connection.createStatement();
                String lit = connection.getSchema();
                System.out.println("Success " + lit);


                ResultSet myRs = mystat.executeQuery("select * from warowac2");

                while(myRs.next()){
                    users.add(myRs.getString("name"));
                    months.add(myRs.getInt("byby"));
                }

            }
            catch(Exception exc){
                exc.printStackTrace();
            }
      %>

    // --- add a comma after each value in the array and convert to javascript string representing an array
    var jsArray = [<% for (int i = 0; i < months.size(); i++) { %>"<%= months.get(i) %>"<%= i + 1 < months.size() ? ",":"" %><% } %>];
    var jsArray2 = [<% for (int i = 0; i < users.size(); i++) { %>"<%= users.get(i) %>"<%= i + 1 < users.size() ? ",":"" %><% } %>];
    console.log(jsArray);

    TESTER = document.getElementById('tester');
    Plotly.plot( TESTER, [{
        x: jsArray2,
        y: jsArray,
        type: 'bar'}], {
        margin: { t: 0 } } );
</script>
</html>
