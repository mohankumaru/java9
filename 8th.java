import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ITreturns extends HttpServlet {
private static final long serialVersionUID = 1L;

public ITreturns() {
super();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
String name=request.getParameter(&quot;name&quot;);
String gender=request.getParameter(&quot;gender&quot;);
String salary=request.getParameter(&quot;salary&quot;);
String tax=request.getParameter(&quot;tax&quot;);
PrintWriter out=response.getWriter();
File file = new File(&quot;/home/mahen/1.txt&quot;);
file.createNewFile();
FileOutputStream fout = new FileOutputStream(file);
out.println(&quot;&quot;+name+gender+salary+tax);
fout.write((&quot;hello&quot;+name+gender+salary+tax).getBytes());
fout.close();

}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
}
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
info.jsp
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
&lt;html&gt;
&lt;head&gt;
&lt;meta http-equiv=&quot;Content- Type&quot; content=&quot;text/html; charset=UTF-8&quot;&gt;
&lt;title&gt;Insert title here&lt;/title&gt;
&lt;/head&gt;
&lt;body&gt;
&lt;form action=&quot;ITreturns&quot; method=&quot;get&quot; &gt;

name:&lt;input type=&quot;text&quot; name=&quot;name&quot;/&gt;
&lt;select name=&quot;gender&quot;&gt;
&lt;option&gt;male&lt;/option&gt;
&lt;option&gt;fe&lt;/option&gt;
&lt;/select&gt;
sal:&lt;input type=&quot;text&quot; name=&quot;salary&quot;/&gt;
tax:&lt;input type=&quot;text&quot; name=&quot;tax&quot;/&gt;
&lt;input type=&quot;submit&quot;/&gt;
&lt;/form&gt;
&lt;/body&gt;
&lt;/html&gt;