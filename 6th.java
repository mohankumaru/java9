public class myFrame extends JFrame
{
myFrame()
{
super(&quot;My Jframe Example&quot;);
JLabel jlrep = new JLabel(&quot;Representative Information&quot;);
JLabel jl11 = new JLabel(&quot;Enter RepNo&quot;);
final JTextField jtf11 = new JTextField();
JLabel jl12 = new JLabel(&quot;Enter RepName&quot;);
final JTextField jtf12 = new JTextField();
JLabel jl13 = new JLabel(&quot;Enter State&quot;);
final JTextField jtf13 = new JTextField();
JLabel jl14 = new JLabel(&quot;Enter Commission&quot;);
final JTextField jtf14 = new JTextField();
JLabel jl15 = new JLabel(&quot;Enter Rate&quot;);
final JTextField jtf15 = new JTextField();
JButton jb1 = new JButton(&quot;Submit&quot;);
JLabel jlcus = new JLabel(&quot;Customer Information&quot;);
JLabel jl21 = new JLabel(&quot;Enter CustomerNo&quot;);
final JTextField jtf21 = new JTextField();
JLabel jl22 = new JLabel(&quot;Enter CustomerName&quot;);
final JTextField jtf22 = new JTextField();
JLabel jl23 = new JLabel(&quot;Enter State&quot;);
final JTextField jtf23 = new JTextField();
JLabel jl24 = new JLabel(&quot;Enter Credit limit&quot;);
final JTextField jtf24 = new JTextField();
JLabel jl25 = new JLabel(&quot;Enter RepNo&quot;);
final JTextField jtf25 = new JTextField();
JButton jb2 = new JButton(&quot;Submit&quot;);
JPanel panel = new JPanel();
final JTextArea jta = new JTextArea();
jta.setRows(10);
jta.setColumns(5);
JButton jb3 = new JButton(&quot;click&quot;);
panel.add(jl11);
panel.add(jtf11);
panel.add(jl12);
panel.add(jtf12);
panel.add(jl13);
panel.add(jtf13);
panel.add(jl14);
panel.add(jtf14);
panel.add(jl15);
panel.add(jtf15);
panel.add(jb1);
panel.add(jl21);

panel.add(jtf21);
panel.add(jl22);
panel.add(jtf22);
panel.add(jl23);
panel.add(jtf23);
panel.add(jl24);
panel.add(jtf24);
panel.add(jl25);
panel.add(jtf25);
panel.add(jb2);
panel.add(jta);
panel.add(jb3);
jb1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
try
{
Statement stmt;
Class.forName(&quot;com.mysql.jdbc.Driver&quot;);
Connection conn =

DriverManager.getConnection(&quot;jdbc:mysql://localhost:3306/test&quot;, &quot;root&quot;, &quot;deek&quot;);

if (conn != null)
{
System.out.println(&quot;Connection successful !!!&quot;);
String Repno = jtf11.getText();
String Repname = jtf12.getText();
String state = jtf13.getText();
String commission = jtf14.getText();
String rate = jtf15.getText();
stmt = (Statement) conn.createStatement();
System.out.println(Repno + Repname + state + commission);
String query1 = &quot;insert into Representative values(&#39;&quot;
+ Repno + &quot;&#39;,&#39;&quot; + Repname + &quot;&#39;,&#39;&quot; + state
+ &quot;&#39;,&#39;&quot; + commission + &quot;&#39;,&#39;&quot; + rate + &quot;&#39;);&quot;;

stmt.executeUpdate(query1);
}
else
System.out.println(&quot;Connection not successful !!!&quot;);

}
catch (SQLException ex)
{
System.out.println(ex.getMessage());
}
catch (ClassNotFoundException exx)
{
System.out.println(exx.getMessage());
}
}
});

jb2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
try
{
Statement stmt2;
Class.forName(&quot;com.mysql.jdbc.Driver&quot;);

Connection conn = DriverManager.getConnection(&quot;jdbc:mysql://localhost:3306/test&quot;, &quot;root&quot;, &quot;deek&quot;);

if (conn != null)
{
System.out.println(&quot;Connection successful !!!&quot;);
String Custno = jtf21.getText();
String CustName = jtf22.getText();
String state = jtf23.getText();
String Credit = jtf24.getText();
int cr = Integer.parseInt(Credit);
String Rno = jtf25.getText();
stmt2 = (Statement) conn.createStatement();
System.out.println(Custno + CustName + state + cr + Rno);
String query2 = &quot;insert into Customer values(&#39;&quot;+ Custno + &quot;&#39;,&#39;&quot; +
CustName + &quot;&#39;,&#39;&quot; + state+ &quot;&#39;,&#39;&quot; + cr + &quot;&#39;,&#39;&quot; + Rno + &quot;&#39;);&quot;;
stmt2.executeUpdate(query2);
}
else
System.out.println(&quot;Connection not successful !!!&quot;);

}
catch (SQLException ex)
{
System.out.println(ex.getMessage());
}
catch (ClassNotFoundException exx)
{
System.out.println(exx.getMessage());
}
}
});
jb3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
try {
Statement stmt;
Class.forName(&quot;com.mysql.jdbc.Driver&quot;);
Connection conn = DriverManager.getConnection(
&quot;jdbc:mysql://localhost:3306/test&quot;, &quot;root&quot;, &quot;deek&quot;);
if (conn != null)
{
stmt = (Statement) conn.createStatement();

String query3=&quot;SELECT * FROM Representative
WHERE RepNo IN (SELECT RepNo FROM Customer WHERE Credit_Limit &gt; 15000 )&quot;;
ResultSet rs = stmt.executeQuery(query3);
while (rs.next())
{
jta.append(&quot;Representative Information&quot;);
jta.append(&quot;\n&quot;);
jta.append(&quot;Number:&quot;);
jta.append(rs.getString(&quot;RepNo&quot;));
jta.append(&quot;\n&quot;);
jta.append(&quot;Name:&quot;);
jta.append(rs.getString(&quot;RepName&quot;));
jta.append(&quot;\n&quot;);
jta.append(&quot;State:&quot;);
jta.append(rs.getString(&quot;State&quot;));
jta.append(&quot;\n&quot;);
jta.append(&quot;Comission:&quot;);
jta.append(rs.getString(&quot;Comission&quot;));
jta.append(&quot;\n&quot;);
jta.append(&quot;Rate:&quot;);
jta.append(rs.getString(&quot;Rate&quot;));
jta.append(&quot;\n&quot;);
}
System.out.println(&quot;Connection successful !!!&quot;);
}
else
System.out.println(&quot;Connection not successful !!!&quot;);

}
catch (SQLException ex)
{
System.out.println(ex.getMessage());
}
catch (ClassNotFoundException exx)
{
System.out.println(exx.getMessage());
}
}
});
setContentPane(panel);
}
public static void main(String[] args) {
myFrame mf = new myFrame();
mf.getContentPane().setLayout(

new BoxLayout(mf.getContentPane(), BoxLayout.Y_AXIS));

mf.setVisible(true);
mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
mf.pack();