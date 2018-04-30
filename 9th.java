import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(&quot;/tcon&quot;)
public class tcon extends HttpServlet {
private static final long serialVersionUID = 1L;

public tcon() {
super();

}
protected void service(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

response.setContentType(&quot;text/html&quot;);
PrintWriter out=response.getWriter();
String[] Accessories={};
Accessories=request.getParameterValues(&quot;access&quot;);
String tshirtAccessories=&quot;&quot;;
String tshirtTagLine=request.getParameter(&quot;tagline&quot;);
String tshirtOption=request.getParameter(&quot;pocket&quot;);
String tcolor=request.getParameter(&quot;Tshirtcolor&quot;);
out.println(&quot;&lt;html&gt;&quot;);
out.println(&quot;&lt;head&gt;&lt;title&gt;T-shirt&lt;/title&gt;&lt;/head&gt;&quot;);
out.println(&quot;&lt;body&gt;&quot;);
try {
Statement stmt;
Class.forName(&quot;com.mysql.jdbc.Driver&quot;);
Connection conn =
DriverManager.getConnection(&quot;jdbc:mysql://localhost:3306/tshrit&quot;, &quot;root&quot;, &quot;&quot;);
if (conn != null) {
stmt= conn.createStatement();
String qu;
if(tshirtAccessories!=null &amp;&amp; tshirtTagLine!=null &amp;&amp; tshirtOption!=null
&amp;&amp; tcolor!=null){
for(String option:Accessories){
tshirtAccessories=tshirtAccessories+option;
}
qu=&quot;insert into Tshirts
values(&quot;+null+&quot;,&#39;&quot;+tshirtTagLine+&quot;&#39;,&#39;&quot;+tshirtAccessories+&quot;&#39;,&#39;&quot;+tcolor+&quot;&#39;,&#39;&quot;+tshirtOption+&quot;&#39;);&quot;;
stmt.executeUpdate(qu);
}
qu=&quot;select * from Tshirts;&quot;;
ResultSet rs =stmt.executeQuery(qu);
out.println(&quot;&lt;table border=2&gt;&quot;);
out.println(&quot;&lt;tr&gt;&quot;);
out.print(&quot;&lt;td&gt;OrderNo&lt;/td&gt;&quot;);
out.print(&quot;&lt;td&gt;T-shirt Accessories&lt;/td&gt;&quot;);
out.print(&quot;&lt;td&gt;T-shirt tag-line&lt;/td&gt;&quot;);
out.print(&quot;&lt;td&gt;T-shirt type&lt;/td&gt;&quot;);
out.print(&quot;&lt;td&gt;T-shirt color&lt;/td&gt;&quot;);
out.println(&quot;&lt;/tr&gt;&quot;);
if(!rs.isBeforeFirst()){
out.print(&quot;&lt;tr&gt;&quot;);

out.print(&quot;&lt;td&gt;100&lt;/td&gt;&quot;);
out.print(&quot;&lt;td&gt;NULL&lt;/td&gt;&quot;);

out.print(&quot;&lt;td&gt;NULL&lt;/td&gt;&quot;);
out.print(&quot;&lt;td&gt;NULL&lt;/td&gt;&quot;);
out.print(&quot;&lt;td&gt;NULL&lt;/td&gt;&quot;);
out.print(&quot;&lt;td&gt;NULL&lt;/td&gt;&quot;);
out.println(&quot;&lt;/tr&gt;&quot;);

}
while(rs.next()){
out.println(&quot;&lt;tr&gt;&quot;);

out.print(&quot;&lt;td&gt;&quot;+(Integer.parseInt(rs.getString(&quot;OrderNo&quot;))+100)+&quot;&lt;/td&gt;&quot;);
out.print(&quot;&lt;td&gt;&quot;+rs.getString(&quot;tshritAccessories&quot;)+&quot;&lt;/td&gt;&quot;);
out.print(&quot;&lt;td&gt;&quot;+rs.getString(&quot;tshritTagLine&quot;)+&quot;&lt;/td&gt;&quot;);
out.print(&quot;&lt;td&gt;&quot;+rs.getString(&quot;tcolor&quot;)+&quot;&lt;/td&gt;&quot;);
out.print(&quot;&lt;td&gt;&quot;+rs.getString(&quot;tshritOption&quot;)+&quot;&lt;/td&gt;&quot;);
out.println(&quot;&lt;/tr&gt;&quot;);
}
out.println(&quot;&lt;/table&gt;&quot;);
out.println(&quot;&lt;a href=\&quot;tshrit.jsp\&quot;&gt;click here&lt;/a&gt;&quot;);
out.println(&quot;&lt;/body&gt;&lt;/html&gt;&quot;);
}
}
catch (Exception e){
e.printStackTrace();
}
}
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
tshrit.jsp
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
&lt;html&gt;
&lt;head&gt;
&lt;meta http-equiv=&quot;Content- Type&quot; content=&quot;text/html; charset=ISO-8859- 1&quot;&gt;
&lt;title&gt;Insert title here&lt;/title&gt;
&lt;/head&gt;
&lt;body&gt;
&lt;form action=&quot;tcon&quot; method=&quot;post&quot;&gt;
T-Shirt Accessories&lt;input type=&quot;checkbox&quot; name=&quot;access&quot; value=&quot;Belt&quot;/&gt;Belt
&lt;input type=&quot;checkbox&quot; name=&quot;access&quot; value=&quot;Cap&quot;/&gt;Cap
&lt;input type=&quot;checkbox&quot; name=&quot;access&quot; value=&quot;Hair-Band&quot;/&gt;Hair- Band&lt;br&gt;
Tag-Line&lt;input type=&quot;text&quot; name=&quot;tagline&quot; size=&quot;50&quot;/&gt;&lt;br&gt;
T-Shirt Feature:&lt;input type=&quot;radio&quot; name=&quot;pocket&quot; value=&quot;ChestPocket&quot;/&gt;Chest Pocket
&lt;input type=&quot;radio&quot; name=&quot;pocket&quot; value=&quot;NoChestPocket&quot;/&gt;No Chest Pocket&lt;br&gt;
T-Shirt Color:&lt;select name=&quot;Tshirtcolor&quot;&gt;
&lt;option&gt;Blue&lt;/option&gt;
&lt;option&gt;Red&lt;/option&gt;
&lt;option&gt;Green&lt;/option&gt;

&lt;/select&gt;&lt;br&gt;
&lt;input type=&quot;submit&quot; value=&quot;Place Orders&quot;/&gt;
&lt;/form&gt;
&lt;/body&gt;
&lt;/html&gt;