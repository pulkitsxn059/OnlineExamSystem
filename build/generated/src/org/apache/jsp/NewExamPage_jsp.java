package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import exam.engine.ManageConnection;
import questions.paper.QuestionPaper;

public final class NewExamPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("\t<head>\n");
      out.write("\t\t<title>EXAM PAGE</title>\n");
      out.write("\t\t<style>\n");
      out.write("\t\t.nav{\n");
      out.write("\t\t\twidth:100%;\n");
      out.write("\t\t\theight: 80px;\n");
      out.write("\t\t    background-color: yellow;\n");
      out.write("\t\t    margin-top: 25px;\n");
      out.write("\t\t    border-radius: 10px;\n");
      out.write("\n");
      out.write("\t\t}\n");
      out.write("\t\t.btn{\n");
      out.write("\t\t\tbackground-color: blue;\n");
      out.write("\t\t\twidth: 110px;\n");
      out.write("\t\t\theight: 40px;\n");
      out.write("\t\t\tmargin-left: 20px;\n");
      out.write("\t\t\tborder-radius: 6px;\n");
      out.write("\t\t\tmargin-top: 20px;\n");
      out.write("\t\t\tfont-family: Georgia, \"Times New Roman\", Times, serif;\n");
      out.write("\t\t\tfont-size: 20px;\n");
      out.write("\t\t}\n");
      out.write("\t\t.ques{\n");
      out.write("\t\t\twidth: 95%;\n");
      out.write("\t\t\tmin-height: 100px;\n");
      out.write("\t\t\tbackground-color:#D8D8D8;\n");
      out.write("\t\t\tmargin-top: 25px;\n");
      out.write("\t\t\tborder-radius: 10px;\n");
      out.write("                        font-family: Georgia, \"Times New Roman\", Times, serif;\n");
      out.write("                        font-size: 30px;\n");
      out.write("\t\t}\n");
      out.write("\t\t.ans{\n");
      out.write("                        font-family:serif;\n");
      out.write("                        font-size: 25px;\n");
      out.write("\t\t\twidth:90%;\n");
      out.write("\t\t\theight:80px;\n");
      out.write("\t\t\tbackground-color: #F4F4F4;\n");
      out.write("\t\t\tmargin-top: 20px;\n");
      out.write("\n");
      out.write("\t\t}\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t</style>\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("\t<body>\n");
      out.write("            ");
 
               
            int q,oldqno,n[],opt,total=0;
            ManageConnection mc=new ManageConnection();
            try{
              q=Integer.parseInt(request.getParameter("qn"));
              try{
              opt=Integer.parseInt(request.getParameter("rad"));
              }
              catch(Exception e)
              {
                  opt=0;
              }
              oldqno=q;
              
              String sbt=request.getParameter("sbt");
              if(sbt.equals("Next"))
                  q=q+1;
              else if(sbt.equals("Previous"))
                  q=q-1;
              else if(sbt.equals("End Exam"))
                  response.sendRedirect("result1.jsp");
            }
            catch(Exception e)
            {
               q=1;
               oldqno=1;
               opt=0;
            }
            total=mc.totalQuestions();
            Object obj=session.getAttribute("answers");
            if(obj==null)
            {
                n=new int[total];
            }
            else{
            n=(int[])obj;
            n[oldqno-1]=opt;
            
             } 
             session.setAttribute("answers",n);
            
      out.write("\n");
      out.write("            ");
      questions.paper.QuestionPaper qp = null;
      synchronized (session) {
        qp = (questions.paper.QuestionPaper) _jspx_page_context.getAttribute("qp", PageContext.SESSION_SCOPE);
        if (qp == null){
          qp = new questions.paper.QuestionPaper();
          _jspx_page_context.setAttribute("qp", qp, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("qp"), "q",
q);
      out.write("\n");
      out.write("            <form action=\"\" method=\"post\">\n");
      out.write("\t\t<div class=nav>\n");
      out.write("                    <input type=\"submit\" name=\"sbt\" value=\"Previous\" class=\"btn\" ");
if(q==1){out.println("disabled");} 
      out.write("   >\n");
      out.write("\t\t\t<input type=\"submit\" name=\"sbt\" value=\"Next\" class=\"btn\" ");
if(q==total){out.println("disabled");} 
      out.write(" >\n");
      out.write("\t\t\t<input type=\"submit\" name=\"sbt\" value=\"End Exam\" class=\"btn\" style=\"background-color: red\">\n");
      out.write("\t\t\t<input type=\"checkbox\" name=\"bookmark\" value=\"1\" style=\"margin-left: 20px;\">\n");
      out.write("\t\t\t<span>BookMark Your Question</span>\n");
      out.write("\t\t\t<span style=\"font-size: 25px; margin-left: 25px;\">Positive Marking:");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((questions.paper.QuestionPaper)_jspx_page_context.findAttribute("qp")).getPos())));
      out.write("</span>\n");
      out.write("\t\t\t<span style=\"font-size: 25px; margin-left: 25px;\">Negative Marking:");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((questions.paper.QuestionPaper)_jspx_page_context.findAttribute("qp")).getNeg())));
      out.write("</span>\n");
      out.write("                        <input type=\"hidden\" name=\"qn\" value=\"");
      out.print(q);
      out.write("\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"ques\">\n");
      out.write("\t         ");
      out.print(q);
      out.write('.');
      out.write(' ');
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((questions.paper.QuestionPaper)_jspx_page_context.findAttribute("qp")).getQues())));
      out.write("\t\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"ans\">\n");
      out.write("                    <input type=\"radio\" name=\"rad\" value=\"1\" style=\"margin-top: 35px; margin-left: 20px;\"");
if(n[q-1]==1) {out.println("checked");} 
      out.write(' ');
      out.write('>');
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((questions.paper.QuestionPaper)_jspx_page_context.findAttribute("qp")).getOp1())));
      out.write("\n");
      out.write("                \n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"ans\">\n");
      out.write("\t\t<input type=\"radio\" name=\"rad\" value=\"2\" style=\"margin-top: 35px; margin-left: 20px;\" ");
if(n[q-1]==2) {out.println("checked");} 
      out.write("\n");
      out.write("                     >");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((questions.paper.QuestionPaper)_jspx_page_context.findAttribute("qp")).getOp2())));
      out.write("\t\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"ans\">\n");
      out.write("\t\t<input type=\"radio\" name=\"rad\" value=\"3\" style=\"margin-top: 35px; margin-left: 20px;\" ");
if(n[q-1]==3) {out.println("checked");} 
      out.write('>');
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((questions.paper.QuestionPaper)_jspx_page_context.findAttribute("qp")).getOp3())));
      out.write("\t\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"ans\">\n");
      out.write("\t\t<input type=\"radio\" name=\"rad\" value=\"4\" style=\"margin-top: 35px; margin-left: 20px;\" ");
if(n[q-1]==4) {out.println("checked");} 
      out.write('>');
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((questions.paper.QuestionPaper)_jspx_page_context.findAttribute("qp")).getOp4())));
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("            </form>\n");
      out.write("\t</body>\n");
      out.write("</html>");
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
