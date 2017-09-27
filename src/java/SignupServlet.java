import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
@WebServlet(urlPatterns = {"/signup"})
public class SignupServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        
        String s1=req.getParameter("txt1");
        String s2=req.getParameter("txt2");
        String s3=req.getParameter("txt3");
        String s4=req.getParameter("pass2");
        String s5=req.getParameter("rad");
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521","DBMS","dbms");
        Statement st=c.createStatement();
        String rs=getRandomString();
        st.executeUpdate("insert into userdetails(name,email,contact,password,gender,random_id) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+rs+"')");
        st.close();
        c.close();
        sendMail(s2,rs);
        PrintWriter pw=resp.getWriter();
        pw.println("Values Saved");
        }
        catch(Exception e){
        System.out.println(e);
        }
    }
    public String getRandomString(){
    String res="";
    String req="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    int len=req.length();
    for(int i=1;i<=20;i++){
    int index=(int)(len*Math.random());
    char ch=req.charAt(index);
    res=res+ch;
    }
    return res;
    }
    public void sendMail(String email,String rs)
    {
        try{
    String user="examserver17";
    String pass="pulkitfirstapp";
    String host="smtp.gmail.com";
    String port="465";
    String sender="examserver17@gmail.com";
    Properties props=new Properties();
    props.put("mail:smtp:user",user);
    props.put("mail:smtp:password",pass);
    props.put("mail:smtp:host",host);
    props.put("mail:smtp:port",port);
    props.put("mail:smtps:auth",true);
        Session ses=Session.getDefaultInstance(props);
        MimeMessage message=new MimeMessage(ses);
        message.setSubject("Conformation mail from Exam server");
        InternetAddress from=new InternetAddress(sender);
        InternetAddress to=new InternetAddress(email);
        InetAddress address=InetAddress.getLocalHost();
        String ip=address.getHostAddress();
        message.setSender(from);
        message.setRecipient(Message.RecipientType.TO,to);
        message.setContent("Dear Student,<br><>br>Greetings from Examserver,<br>Thank you for choosing ExamServer<br>Please help us by clicking the following link:http://"+ip+":7070/WebApp4/verify?e="+rs+"<br>For Any query please contact our help forums<br>THANKS,<br>Support team","text/html");
        Transport transport=ses.getTransport("smtps");
        transport.connect(host,user,pass);
        transport.sendMessage(message,message.getAllRecipients());
    }
catch(Exception e){
System.out.println(e);
}
    }
}
    



