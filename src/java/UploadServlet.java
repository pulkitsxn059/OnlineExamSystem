
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = {"/upload"})
@MultipartConfig(maxRequestSize =10*1024*1024)
public class UploadServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String email=req.getParameter("email");
        String lbl=req.getParameter("sbt");
        if(lbl.equals("UPLOAD")){
        try{
        Part p=req.getPart("file");
        InputStream in=p.getInputStream();
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","DBMS","dbms");
        PreparedStatement pst=c.prepareStatement("insert into imagedetails values(?,?)");
        pst.setString(1,email);
        pst.setBlob(2,in);
        pst.executeUpdate();
        pst.close();
        c.close();
        resp.sendRedirect("browse");
        }
        catch(Exception e){
        System.out.println(e);
        }
        }
        else if(lbl.equals("PROCEED")){
                resp.sendRedirect("welcome");
                }
        }
    }
