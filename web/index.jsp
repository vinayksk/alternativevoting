<%@ page import="static jdk.nashorn.internal.objects.NativeArray.join" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %><%--
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
    <h1>hello</h1>
    <div id="tester" style="width:600px;height:250px;"></div>
</body>
<script>
    <%
            Map<String, Integer> map = new HashMap<String, Integer>();
            ArrayList<String> users = new ArrayList<>();
            ArrayList<Integer> candidate1 = new ArrayList<>();
            String hostName = "warowac";
            String dbName = "testDB";
            String user = "warowac";
            String password = "XoFruitL00ps";
            String url = String.format("jdbc:sqlserver://%s.database.windows.net:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
            Connection connection = null;

            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(url);
                Statement mystat = connection.createStatement();

                ResultSet myRs = mystat.executeQuery("select * from demo");
                ResultSetMetaData metaData = myRs.getMetaData();
                int count = metaData.getColumnCount();
                for(int i = 2; i <= count; i ++){
                    users.add(metaData.getColumnName(i));
                    map.put(metaData.getColumnName(i), 0);
                }

                while(myRs.next()){
                    for(int i = 0; i < users.size(); i++ ){
                        int val = map.get(users.get(i)) + myRs.getInt(users.get(i));
                        map.put(users.get(i), val );
                    }
                }
                Collection<Integer> collection = map.values();
                Iterator<Integer> iter = collection.iterator();
                while(iter.hasNext()){
                    candidate1.add(iter.next());
                }


            }
            catch(Exception exc){
                exc.printStackTrace();
            }
      %>

    // --- add a comma after each value in the array and convert to javascript string representing an array
    var jsArray1 = [<% for (int i = 0; i < users.size(); i++) { %>"<%= users.get(i) %>"<%= i + 1 < users.size() ? ",":"" %><% } %>];
    var jsArray2 = [<% for (int i = 0; i < candidate1.size(); i++) { %>"<%= candidate1.get(i) %>"<%= i + 1 < candidate1.size() ? ",":"" %><% } %>];
    console.log(jsArray1);
    console.log(jsArray2);

    TESTER = document.getElementById('tester');
    Plotly.plot( TESTER, [{
        x: jsArray1,
        y: jsArray2,
        type: 'bar'}], {
        margin: { t: 0 } } );
</script>
</html>
