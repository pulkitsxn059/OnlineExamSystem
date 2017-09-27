package questions.paper;

import cons.Connections;
import java.sql.ResultSet;
import java.sql.Statement;

public class QuestionPaper {
private int[] qnos;
int q,pos,neg;
private String ques,op1,op2,op3,op4;

public QuestionPaper(int[] qnos)
{
    this.qnos=qnos;
}
 
public QuestionPaper()
{
    
}

    public int[] getQnos() {
        return qnos;
    }

    public void setQnos(int[] qnos) {
        this.qnos = qnos;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getNeg() {
        return neg;
    }

    public void setNeg(int neg) {
        this.neg = neg;
    }

    public String getQues() {
        try {
            Statement st =Connections.makeConnection();
            int ind=getQ();
            int arr[]=getQnos();
            int qn=arr[ind-1];
            ResultSet rs = st.executeQuery("select * from questions where qno=" + qn);
            if(rs.next()){
            ques = rs.getString(2);
            op1 = rs.getString(3);
            op2 = rs.getString(4);
            op3 = rs.getString(5);
            op4 = rs.getString(6);
            pos = rs.getInt(7);
            neg = rs.getInt(8);
            Connections.closeConnection();
        }
        } catch (Exception e) {
            System.out.println(e);
        }   
        
        return ques;
        
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public String getOp4() {
        return op4;
    }

    public void setOp4(String op4) {
        this.op4 = op4;
    }

    
}
