
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(urlPatterns = {"/verify"})
public class VerifiedServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        try{
        String s=req.getParameter("e");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","DBMS","dbms");
        Statement sta=con.createStatement();
       int num= sta.executeUpdate("update userdetails set verified ='Y' where random_id='"+s+"'");
        sta.close();
        con.close();
        PrintWriter pw=resp.getWriter();
        if(num!=0)
        pw.println("Email verified");
        else
        pw.println("Email Invalid or does not exist");
        }
        catch(Exception e){
        System.out.println(e);
        }
        
    }

}
