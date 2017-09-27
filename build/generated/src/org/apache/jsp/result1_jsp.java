package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import exam.engine.ManageConnection;

public final class result1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Result Page</title>\n");
      out.write("        <style>\n");
      out.write("            .result{\n");
      out.write("                width: 300px;\n");
      out.write("                height: auto;\n");
      out.write("                padding: 2%;\n");
      out.write("            }\n");
      out.write("            .tbl{\n");
      out.write("                width: 100%;\n");
      out.write("                height: auto;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .btn{\n");
      out.write("                width: 50px;\n");
      out.write("                height: 50px;\n");
      out.write("                border: 1px solid #000;\n");
      out.write("                color: #000000;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-image: url(images1.jpg); background-repeat: no-repeat; background-size: auto\">\n");
      out.write("    <center>\n");
      out.write("        <div class=\"result\">\n");
      out.write("          \n");
      out.write("        ");
 
            Object obj=session.getAttribute("answers");
            Object ans1=session.getAttribute("ans");
            int n[]=(int[]) obj;
            int a[]=(int[]) ans1;
            int total=n.length;
            int total1=a.length;
            int rows=total/4;
            if(rows%4!=0)
            {
             rows=rows+1;   
            }
        
      out.write("\n");
      out.write("        <table class=\"tbl\">\n");
      out.write("            ");

             int j=1;
             for(int i=0;i<rows;i++){
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                ");

                    for(int k=1;k<=4 && j<=total;k++,j++){
                    ManageConnection me=new ManageConnection();
                    int answer=me.getCorrectAns(a[j-1]);
                
      out.write("\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"submit\" class=\"btn\" value=");
      out.print(j );
      out.write("\n");
      out.write("                     ");
if(n[j-1]==answer)        
                     out.println("style='background-color:green;'");
                     else if(n[j-1]==0)
                     out.println("style='background-color:yellow;'");
                     else
                     out.println("style='background-color:red;'");
                     
      out.write(" >\n");
      out.write("                </td>\n");
      out.write("                ");
 
                  }
                
      out.write("\n");
      out.write("                  </tr>\n");
      out.write("                  ");

                      }
                  
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        <table style=\"margin-top: 20px;\">\n");
      out.write("            <tr>\n");
      out.write("                <td>CORRECT ANSWER</td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"submit\" value=\"CA\"  style=\"background-color: green\" class=\"btn\" >\n");
      out.write("                </td>\n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td>WRONG ANSWER</td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"submit\" value=\"WA\"  style=\"background-color: red\" class=\"btn\" >\n");
      out.write("                </td>\n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td>NOT ATTEMPTED</td>\n");
      out.write("                <td >\n");
      out.write("                    <input type=\"submit\" value=\"NA\" class=\"btn\" style=\"background-color: yellow\" >\n");
      out.write("                </td>\n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
