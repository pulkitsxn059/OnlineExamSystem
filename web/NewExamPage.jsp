<%@page import="exam.engine.ManageConnection" %>
<%@page import="questions.paper.QuestionPaper"  %>
<html xmlns="http://www.w3.org/1999/xhtml">
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

	<body>
            <% 
               
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
            %>
            <jsp:useBean id="qp" scope="session" class="questions.paper.QuestionPaper"/>
            <jsp:setProperty name="qp" property="q" value="<%=q%>"/>
            <form action="" method="post">
		<div class=nav>
                    <input type="submit" name="sbt" value="Previous" class="btn" <%if(q==1){out.println("disabled");} %>   >
			<input type="submit" name="sbt" value="Next" class="btn" <%if(q==total){out.println("disabled");} %> >
			<input type="submit" name="sbt" value="End Exam" class="btn" style="background-color: red">
			<input type="checkbox" name="bookmark" value="1" style="margin-left: 20px;">
			<span>BookMark Your Question</span>
			<span style="font-size: 25px; margin-left: 25px;">Positive Marking:<jsp:getProperty name="qp" property="pos"/></span>
			<span style="font-size: 25px; margin-left: 25px;">Negative Marking:<jsp:getProperty name="qp" property="neg"/></span>
                        <input type="hidden" name="qn" value="<%=q%>">
		</div>
		<div class="ques">
	         <%=q%>. <jsp:getProperty name="qp" property="ques"/>	
		</div>
		<div class="ans">
                    <input type="radio" name="rad" value="1" style="margin-top: 35px; margin-left: 20px;"<%if(n[q-1]==1) {out.println("checked");} %> ><jsp:getProperty name="qp" property="op1"/>
                
		</div>
		<div class="ans">
		<input type="radio" name="rad" value="2" style="margin-top: 35px; margin-left: 20px;" <%if(n[q-1]==2) {out.println("checked");} %>
                     ><jsp:getProperty name="qp" property="op2"/>	
		</div>
		<div class="ans">
		<input type="radio" name="rad" value="3" style="margin-top: 35px; margin-left: 20px;" <%if(n[q-1]==3) {out.println("checked");} %>><jsp:getProperty name="qp" property="op3"/>	
		</div>
		<div class="ans">
		<input type="radio" name="rad" value="4" style="margin-top: 35px; margin-left: 20px;" <%if(n[q-1]==4) {out.println("checked");} %>><jsp:getProperty name="qp" property="op4"/>
		</div>
            </form>
	</body>
</html>