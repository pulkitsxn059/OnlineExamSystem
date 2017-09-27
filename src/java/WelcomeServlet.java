
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw=resp.getWriter();
        HttpSession ses=req.getSession();
        ses.setMaxInactiveInterval(1*60);
        Object obj=ses.getAttribute("username");
        if(obj!=null){
        String s=obj.toString();
        pw.println("<html>\n" +
"	<link href='styles1.css' rel='stylesheet'>\n" +
"	<div class=\"main\">\n" +
"		<img src=\"http://localhost:7070/WebApp4/image\" class=\"imgclass\" height='150' width='150'>\n" +
"		<div class='details'>\n" +
"		<a href='logout'><button class='btn'>Logout</button></a>\n" +
"               <a href='browse'><button class='btn'>ChangePicture</button>&nbsp;&nbsp; </a>\n" +
"               <a href='startexam'><button class='btn'>Start Exam</button>&nbsp;&nbsp; </a>\n" +
"		<span style='font-family: Tahoma;font-size: \n" +
"20px;float: right;margin-top: 3px;'>Hi \n" +
""+s+"&nbsp;&nbsp;&nbsp;</span>\n" +
"		</div>\n" +
" </div>");       
      RequestDispatcher rd=getServletContext().getRequestDispatcher("/Instructions.jsp");
      rd.include(req, resp);      
pw.println("</html>");
        
    }
        else
            resp.sendRedirect("sessionexp.html");
    }
   
}
