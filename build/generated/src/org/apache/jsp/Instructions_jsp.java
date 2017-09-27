package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Instructions_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title></title>\n");
      out.write("</head>\n");
      out.write("<body style=\"background-image: url(Elegant_Background-2.jpg);\">\n");
      out.write("<h1 align=\"center\"> INSTRUCTIONS </h1>\n");
      out.write("<p style=\"font-weight: bold;font-size: 30px;\">\n");
      out.write("1. Before\t beginning\t the\t exam:<br/>\n");
      out.write("1. Make\t sure\t you\t have\t a\t good\tinternet\t connection.<br/>\n");
      out.write("2. Log\t out\t of\t Blackboard\t and\t then\t back\t in\t to\t Blackboard\t before\t you\tbegin.This\t will\t  help\t with\t connectivity\t issues.<br/>\t  \n");
      out.write("3. If\t you\t are\t taking\t the\t exam\t late\t in\t the\t day,\t it\t is  recommended\t that\t you\t reboot\t your\t  computer\t before\t beginning\t to\t free\t up\t memory  resources\t from\t other\t programs\t on\t  your\t computer.<br/>\n");
      out.write("4. Shut\t down all\t Instant\t Messaging  tools\t (Skype,\t AIM,\t MSN\t Messenger)\tand\t Email\t  programs\t as\t they\t can\t conflict\t with  Blackboard.<br/>\t  \n");
      out.write("5. Enter\t the\t Blackboard\t course\t using\t Firefox.\t \t Do\t not\t use\t any\tother  internet\t browser.<br/>\t  \n");
      out.write("6. Maximize\t your\t browser\t window\t before\t starting\t the\t test.\t   Minimizing\tthe\t browser\t  window\t during\t the\t exam\t can\t prevent\t the\t submission\t of\t your  exam.<br/>\t  \n");
      out.write("7. When\t you\t begin\t the\t exam\t click\t the\t link\t only\t ONCE\t to\t launch\t the\t test.\t   Double\t  clicking\t can\t lock\t the\t test.\n");
      out.write("<br/>\n");
      out.write("During\t the\t exam:<br/>\t  \n");
      out.write("1. Do\t not\t resize\t (minimize)\t the  browser\t during\t the\ttest.<br/>\n");
      out.write("2. Never\t click\t the\t ?Back?\t button\t on\t the\t browser.\t \t This\t will  take\t you\t out\t of\t the\t test\t and\t  prevent\t Blackboard\t from\t tracking\t your\t selected\t answers.<br/>   \n");
      out.write("3.Avoid\tusing the scroll button\ton your mouse if present.<br/>\t  \n");
      out.write("4.Click\t the\t ?Submit?  button\t to\t submit\t your\t exam.\t \t Do\t not\t press\t?Enter?\t on\t the\t  keyboard\t to\t submit\t the  exam.<br/>\t  \n");
      out.write("5.Save\t your test using\t the ?Save?\t button\t periodically\t during\t the\t exam.Instructions for accessing the Exam.<br/>\t  \n");
      out.write("</p>\n");
      out.write("</body>\n");
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
