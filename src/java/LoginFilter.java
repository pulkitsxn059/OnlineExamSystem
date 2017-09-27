
import static cons.Connections.closeConnection;
import static cons.Connections.getStatement;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {

    FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Cookie ck[] = req.getCookies();
        //String val=ck[0].getValue();
        String val = "";
        for (Cookie c : ck) {
            if (c.getName().equals("userdata")) {
                val = c.getValue();
            }
        }
        String data[] = val.split("#");
        String userid = data[1];
        File f = new File(config.getServletContext().getRealPath("/") + userid + "isuser.txt");
        boolean b = f.createNewFile();
        try {
            if (b) {
                Statement st = getStatement();
                ResultSet rs = st.executeQuery("select * from newusers where ROUND(TO_NUMBER(TO_CHAR(sysdate-logindate)),0)=0");
                boolean b11 = rs.next();
                if (b11) {
                    int n = rs.getInt(2);
                    st.executeUpdate("update newusers set notime=" + (n + 1) + "where ROUND(TO_NUMBER(TO_CHAR(sysdate-logindate)),0)=0");
                } else {
                    st.executeUpdate("insert into newusers values(sysdate,1)");
                }
                rs.close();
                closeConnection();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
