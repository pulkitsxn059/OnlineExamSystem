
import cons.Connections;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import questions.paper.QuestionPaper;

@WebServlet(urlPatterns = {"/startexam"})
public class StartExam extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
        Statement st=Connections.makeConnection();
        ResultSet rs=st.executeQuery("select count(*) from questions");
        rs.next();
        int total=rs.getInt(1);
        rs.close();
        Connections.closeConnection();
        int n[]=getRandomArray(total);
        HttpSession ses=req.getSession();
        ses.setAttribute("ans", n);
        QuestionPaper qp=new QuestionPaper(n);
        //HttpSession ses=req.getSession();
        ses.setAttribute("qp",qp);
        resp.sendRedirect("NewExamPage.jsp");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public int[] getRandomArray(int total)
    {
        int n[]=new int[6];
        int index=0;
        while(index<6)
        {
            int num=(int)(6*Math.random());
            boolean b=true;
            for(int i=0;i<index;i++)
            {
                if(n[i]==num){
                    b=false;
                    break;
                }
            }
            if(b)
            {
                n[index++]=num;
            }
        }
        return n;
    }    
}
