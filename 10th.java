JDBClogin.java
~~~~~~~~~~~~~~~~~~~~~~~~
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings(&quot;serial&quot;)
@WebServlet(urlPatterns={&quot;/javaConnection&quot;})
public class JDBClogin extends HttpServlet {

static Connection getConnection() throws Exception {

String driver = &quot;com.mysql.jdbc.Driver&quot;;
String url = &quot;jdbc:mysql://localhost/onlinedirectory&quot;;
String username = &quot;root&quot;;
String password = &quot;&quot;;
Class.forName(driver);
Connection conn = DriverManager.getConnection(url, username,
password);
return conn;
}
public void doGet(HttpServletRequest request, HttpServletResponse
response) throws IOException {
PrintWriter out = response.getWriter();
//out.print(&quot;Working&quot;);

boolean flag = false;
Connection conn = null;
Statement stmt = null;

java.sql.ResultSet rs = null;
try {
conn = getConnection();
stmt = conn.createStatement();
out.print(&quot;Working&quot;);
long inp;

try
{
inp =Long.parseLong(request.getParameter(&quot;phone&quot;));
out.println(&quot;&quot;+inp);
rs = stmt.executeQuery(&quot;SELECT * FROM tele_dir where
contact=&quot;+inp);
}
catch(Exception e)
{
String name=request.getParameter(&quot;phone&quot;);
// out.println(&quot;&quot;+name);
rs = stmt.executeQuery(&quot;SELECT * FROM tele_dir where
name=&#39;&quot;+name+&quot;&#39;&quot;);

}
if(rs.next()) {
String name = rs.getString(1);
long contact = rs.getLong(2);
String address = rs.getString(3);
String company = rs.getString(4);
int pin =rs.getInt(5);
out.println(&quot;name&quot;+name);
out.println(&quot;contact:&quot;+contact);
out.println(&quot;address:&quot;+address);
out.println(&quot;company:&quot;+company);
out.println(&quot;pin:&quot;+pin);


}
else
{
out.println(&quot;no contact found&quot;);
}


} catch (ClassNotFoundException e) {
System.out.println(&quot;Error: failed to load MySQL driver.&quot;);
e.printStackTrace();
} catch (SQLException e) {
System.out.println(&quot;Error: failed to create a connection
object.&quot;);
e.printStackTrace();
} catch (Exception e) {
System.out.println(&quot;Error: unknown&quot;);
e.printStackTrace();
}


finally {
try {
stmt.close();
conn.close();
} catch (Exception e) {
e.printStackTrace();
}
}


}

}
~~~~~~~~~~~~~~~~~~~~~~~~
insert1.java
~~~~~~~~~~~~~~~~~~~~~~~~
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings(&quot;serial&quot;)
@WebServlet(urlPatterns = { &quot;/ins&quot; })
public class insert1 extends HttpServlet {
static Connection getConn() throws Exception {
String driver = &quot;com.mysql.jdbc.Driver&quot;;
String url = &quot;jdbc:mysql://localhost/onlinedirectory&quot;;
String username = &quot;root&quot;;
String password = &quot;&quot;;
Class.forName(driver);
Connection conn = DriverManager.getConnection(url, username,
password);
return conn;
}

Connection conn1 = null;
public void doGet(HttpServletRequest request, HttpServletResponse
response)
throws IOException {
PrintWriter out = response.getWriter();
// out.print(&quot;Working&quot;);
boolean flag = false;
Connection conn = null;
Statement stmt = null;

java.sql.ResultSet rs = null;
try {
// conn = getConn();
String driver = &quot;com.mysql.jdbc.Driver&quot;;
String url = &quot;jdbc:mysql://localhost:3306/onlinedirectory&quot;;
String username = &quot;root&quot;;
String password = &quot;&quot;;
Class.forName(driver);
conn1 = DriverManager.getConnection(url, username,
password);
if (conn1 != null)
System.out.println(&quot;Successful&quot;);
stmt = conn1.createStatement();
out.print(&quot;Working&quot;);
String name = request.getParameter(&quot;nam&quot;);
long contact = Long.parseLong(request.getParameter(&quot;cnt&quot;));
String address = request.getParameter(&quot;address&quot;);
String company = request.getParameter(&quot;company&quot;);
int pin = Integer.parseInt(request.getParameter(&quot;pin&quot;));
out.println(&quot;name&quot; + name);
out.println(&quot;contact:&quot; + contact);
out.println(&quot;address:&quot; + address);
out.println(&quot;company:&quot; + company);
out.println(&quot;pin:&quot; + pin);
stmt.executeUpdate(&quot;insert into tele_dir values(&#39;&quot; + name +
&quot;&#39;,&quot; + contact + &quot;,&#39;&quot; + address + &quot;&#39;,&#39;&quot; + company + &quot;&#39;,&quot; + pin + &quot;);&quot;);
out.println(&quot;updated the records&quot;);
} catch (ClassNotFoundException e) {
System.out.println(&quot;Error: failed to load MySQL driver.&quot;);
e.printStackTrace();
} catch (SQLException e) {
System.out.println(&quot;Error: failed to create a connection
object.&quot;);
e.printStackTrace();
} catch (Exception e) {
System.out.println(&quot;Error: unknown&quot;);
e.printStackTrace();
} finally {
try {
stmt.close();
conn1.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}

}
~~~~~~~~~~~~~~~~~~~~~~~~
Index.jsp
~~~~~~~~~~~~~~~~~~~~~~~~
&lt;html&gt;
&lt;head&gt;
&lt;meta http-equiv=&quot;Content- Type&quot; content=&quot;text/html; charset=ISO-8859- 1&quot;&gt;
&lt;title&gt;Insert title here&lt;/title&gt;
&lt;/head&gt;
&lt;body&gt;
&lt;form action=&quot;javaConnection&quot; method=&quot;get&quot;/&gt;
Enter name or phone:&lt;input type=&quot;text&quot; name=&quot;phone&quot; /&gt;&lt;br/&gt;
&lt;input type=&quot;submit&quot; /&gt;
&lt;/form&gt;
&lt;a href=&quot;insert.html;&quot;&gt;insert into directory&lt;/a&gt;
&lt;/body&gt;
&lt;/html&gt;
~~~~~~~~~~~~~~~~~~~~~~~~
insert.html
~~~~~~~~~~~~~~~~~~~~~~~~
&lt;html&gt;
&lt;head&gt;
&lt;meta charset=&quot;ISO-8859- 1&quot;&gt;
&lt;title&gt;Insert title here&lt;/title&gt;
&lt;/head&gt;
&lt;body&gt;
&lt;form action=&quot;ins&quot; method=&quot;get&quot; &gt;
name:&lt;input type=&quot;text&quot; name=&quot;nam&quot; /&gt;&lt;br/&gt;
contact:&lt;input type=&quot;text&quot; name=&quot;cnt&quot; /&gt;&lt;br/&gt;
address:&lt;input type=&quot;text&quot; name=&quot;address&quot; /&gt;&lt;br/&gt;
company:&lt;input type=&quot;text&quot; name=&quot;company&quot; /&gt;&lt;br/&gt;
pincode:&lt;input type=&quot;text&quot; name=&quot;pin&quot; /&gt;
&lt;input type=&quot;submit&quot; /&gt;
&lt;/form&gt;
&lt;/body&gt;
&lt;/html&gt;

