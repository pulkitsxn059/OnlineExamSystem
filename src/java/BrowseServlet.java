
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static cons.Connections.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
@WebServlet(urlPatterns = {"/browse"})
public class BrowseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String n=req.getParameter("name");
        String userid=req.getParameter("userid");
        String gen=req.getParameter("gender");
        if(n==null && userid==null &&gen==null){
        Cookie[] ck=req.getCookies();
        //String data=ck[0].getValue();
        String val="";
        for(Cookie c:ck){
        if(c.getName().equals("userdata"))
           val=c.getValue();
        }
        
        String arr[]=val.split("#");
        gen=arr[0];
        userid=arr[1];
        n=arr[2];
        }
        PrintWriter pw=resp.getWriter();
        pw.println("<html>");
        pw.println("<link href=\"styles.css\" rel=\"stylesheet\">");
        pw.println("<center>");
        pw.println("<div class=\"maindiv\">");
        pw.println("<div class=\"namediv\">HI USER!!! "+n+"</div>");
        pw.println("<div class=\"imgdiv\">");
        try{
        PreparedStatement pst=getPreStatement("select * from imagedetails where id=?");
        pst.setString(1,userid);
        ResultSet rs=pst.executeQuery();
        if(rs.last()){
            Blob b=rs.getBlob(2);
            InputStream in=b.getBinaryStream();
            BufferedImage image=ImageIO.read(in);
           ByteArrayOutputStream bout=new ByteArrayOutputStream();
           //int imgname=(int)(100000000*Math.random());
           ImageIO.write(image,"JPG",bout);
           byte content[]=bout.toByteArray();
           String b64=javax.xml.bind.DatatypeConverter.printBase64Binary(content);       
           closeConnection();
         pw.println("<img src='data:image/jpg;base64, "+b64+"' height=150 width=150>");
        }
        else if(gen.equals("male")){
        pw.println("<img src=\"images/male.jpg\" height:150px; width:150px>");
        }
        else if(gen.equals("female")){
        pw.println("<img src=\"images/female.jpg\" height:150px; width:150px>");
        }
        closeConnection();
        }
        catch(Exception e){
        System.out.println(e);
        }
        pw.println("</div>");
        pw.println("<form action='upload' method='post' enctype='multipart/form-data'>");
        pw.println("<div class=\"sidediv\">");
        pw.println("<div class=\"bdiv\">");
        pw.println("<input type=\"file\" name=file>");
        pw.println("<input type=hidden name=email value="+userid+" >");
        pw.println("</div>");
        pw.println("<div class=\"btdiv\"><input type=\"submit\" name=sbt value=\"UPLOAD\" class=btn><input type=\"submit\" name=sbt value=\"PROCEED\" class=btn></div>");
        pw.println("</form></div></center></html>");
      
        
    }

}
