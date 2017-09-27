
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
                align-content: center;
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
                color: #000000;
            }
        </style>
    </head>
    <body>
    <center>
        <div class="result">
        <% 
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
                    int answer=me.getCorrectAns(a[j-1]);
                %>
                <td>
                    <input type="submit" class="btn" value=<%=j %>
                     <%if(n[j-1]==answer)        
                     out.println("style='background-color:green;'");
                     else if(n[j-1]==0)
                     out.println("style='background-color:yellow;'");
                     else
                     out.println("style='background-color:red;'");
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
        
        <table style="margin-top: 20px;">
            <tr>
                <td>CORRECT ANSWER</td>
                <td>
                    <input type="submit" value="CA"  style="background-color: green" class="btn" >
                </td>
                
            </tr>
            
            <tr>
                <td>WRONG ANSWER</td>
                <td>
                    <input type="submit" value="WA"  style="background-color: red" class="btn" >
                </td>
                
            </tr>
            
            <tr>
                <td>NOT ATTEMPTED</td>
                <td >
                    <input type="submit" value="NA" class="btn" style="background-color: yellow" >
                </td>
                
            </tr>
        </table>
        </div>
        
    </center>
    </body>
</html>
