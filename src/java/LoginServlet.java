
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String s1 = req.getParameter("txt1");
            String s2 = req.getParameter("pass");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "DBMS", "dbms");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select *from userdetails where email='" + s1 + "'and password='" + s2 + "'");
            PrintWriter pw = resp.getWriter();
            if (rs.next()) {
                String v = rs.getString("VERIFIED");
                String gender = rs.getString("gender");
                String n = rs.getString("name");
                if (v.equals("Y")) {
                    Cookie ck = new Cookie("userdata", gender + "#" + s1 + "#" + n);
                    ck.setMaxAge(15 * 24 * 60 * 60);
                    resp.addCookie(ck);
                    HttpSession ses = req.getSession();
                    ses.setAttribute("username", n);
                    ses.setAttribute("userid", s1);
                    File f = new File(getServletContext().getRealPath("/") + s1 + "isuser.txt");
                    if (!f.exists()) {
                        resp.sendRedirect("browse?gender=" + gender + "&userid=" + s1 + "&name=" + n + "");
                    } else if (f.exists()) {
                        resp.sendRedirect("welcome");
                    }
                } else {
                    pw.println("Not a verified user");
                }
            } else {
                pw.println("Login Failed");
            }
            c.close();
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
