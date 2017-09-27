
<%@page import="exam.engine.ManageConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
        <style>
            .result{
                width: 300px;
                height: auto;
                padding: 2%;
            }
            .tbl{
                width: 100%;
                height: auto;
                text-align: center;
            }
            .btn{
                width: 50px;
                height: 50px;
                border: 1px solid #000;
                color: #FF0000;
            }
        </style>
    </head>
    <body>
    <center>
        <div class="result">
        <% 
            Object obj=session.getAttribute("answers"); 
            int n[]=(int[]) obj;   
            int total=n.length;
            int rows=total/4;
            if(rows%4!=0)
            {
             rows=rows+1;   
            }
        %>
        <table class="tbl">
            <%
             int j=1;  
             for(int i=0;i<rows;i++){
            %>
            <tr>
                <%
                    for(int k=1;k<=4 && j<=total;k++,j++){
                    ManageConnection me=new ManageConnection();
                    int a=me.getCorrectAns(j);
                %>
                <td>
                    <input type="submit" class="btn" value=<%=j %>
                     <%if(n[j-1]==a)        
                     out.println("style='background-color:green; color:#ffffff'");
                     else if(n[j-1]==0)
                     out.println("style='background-color:yellow; color:#ffffff'");
                     else
                     out.println("style='background-color:red; color:#ffffff'");
                     %> >
                </td>
                <% 
                  }
                %>
                  </tr>
                  <%
                      }
                  %>
        </table>
        </div>
    </center>
    </body>
</html>
