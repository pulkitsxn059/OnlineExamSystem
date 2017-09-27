<%@page import="exam.engine.ManageConnection" %>
<html>
	<head>
		<title>EXAM PAGE</title>
		<style>
		.nav{
			width:100%;
			height: 80px;
		    background-color: yellow;
		    margin-top: 25px;
		    border-radius: 10px;

		}
		.btn{
			background-color: blue;
			width: 110px;
			height: 40px;
			margin-left: 20px;
			border-radius: 6px;
			margin-top: 20px;
			font-family: Georgia, "Times New Roman", Times, serif;
			font-size: 20px;
		}
		.ques{
			width: 95%;
			min-height: 100px;
			background-color:#D8D8D8;
			margin-top: 25px;
			border-radius: 10px;
                        font-family: Georgia, "Times New Roman", Times, serif;
                        font-size: 30px;
		}
		.ans{
                        font-family:serif;
                        font-size: 25px;
			width:90%;
			height:80px;
			background-color: #F4F4F4;
			margin-top: 20px;

		}



		</style>
	</head>
        <%
            int qno,opt,oldqno,n[],total=0;
            ManageConnection mc=new ManageConnection();
            try{
           qno=Integer.parseInt(request.getParameter("qn")); 
           try{
           opt=Integer.parseInt(request.getParameter("rad"));
           }
           catch(Exception e)
           {
               opt=0;
           }           
           oldqno=qno;
           String s=request.getParameter("sbt");
           if(s.equals("Next")){
           qno=qno+1;
           }
           else if(s.equals("Previous")){
           qno=qno-1;
           }
           else if(s.equals("End Exam"))
           {
               response.sendRedirect("result.jsp");
           }
           }catch(Exception e)
            {
                qno=1;
                opt=0;
                oldqno=1;
            }
            String data[]=mc.getData(qno);
            total=mc.totalQuestions();
           Object obj=session.getAttribute("answers");
           if(obj==null){
            n=new int[total];
            }
               else
                   {
                      n=(int[])obj;
                      n[oldqno-1]=opt;
                   }
           session.setAttribute("answers", n);
            %>
	<body>
            <form action="">
		<div class=nav>
			<input type="submit" name="sbt" value="Previous" class="btn" <%if(qno==1){out.println("disabled");}%>   >
			<input type="submit" name="sbt" value="Next" class="btn" <%if(qno==total){out.println("disabled");}%> >
			<input type="submit" name="sbt" value="End Exam" class="btn" style="background-color: red">
			<input type="checkbox" name="bookmark" value="1" style="margin-left: 20px;">
			<span>BookMark Your Question</span>
			<span style="font-size: 25px; margin-left: 25px;">Positive Marking:<%=data[5]%></span>
			<span style="font-size: 25px; margin-left: 25px;">Negative Marking:<%=data[6]%></span>
                        <input type="hidden" name="qn" value="<%=qno%>">
		</div>
		<div class="ques">
		<%=qno%> <%=data[0] %>			
		</div>
		<div class="ans">
		<input type="radio" name="rad" value="1" style="margin-top: 35px; margin-left: 20px;"
                    <% if(n[qno-1]==1){out.println("checked");} %> >
                <%=data[1] %>
		</div>
		<div class="ans">
		<input type="radio" name="rad" value="2" style="margin-top: 35px; margin-left: 20px;"
                    <% if(n[qno-1]==2){out.println("checked");} %>   > <%=data[2]%>	
		</div>
		<div class="ans">
		<input type="radio" name="rad" value="3" style="margin-top: 35px; margin-left: 20px;"
                    <% if(n[qno-1]==3){out.println("checked");} %>   ><%=data[3]%>	
		</div>
		<div class="ans">
		<input type="radio" name="rad" value="4" style="margin-top: 35px; margin-left: 20px;"
                  <% if(n[qno-1]==4){out.println("checked");} %> ><%=data[4]%>
		</div>
            </form>
	</body>
</html>