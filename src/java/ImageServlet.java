import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static cons.Connections.*;
import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
@WebServlet(urlPatterns = {"/image"})
public class ImageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses=req.getSession();
        Object obj=ses.getAttribute("userid");
        String userid=obj.toString();
        try{
        PreparedStatement pst=getPreStatement("select *from imagedetails where id=?");
        pst.setString(1,userid);
        ResultSet rs=pst.executeQuery();
        if(rs.last()){
            Blob b=rs.getBlob(2);
            ServletOutputStream out=resp.getOutputStream();
            BufferedImage img=ImageIO.read(b.getBinaryStream());
            ImageIO.write(img,"JPG" , out);
            rs.close();
            closeConnection();
        }
        }catch(Exception e){
        System.out.println(e);
        }
    }

}
