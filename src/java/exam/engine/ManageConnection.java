/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.engine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SIVALI
 */
    
    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ManageConnection {
public Statement makeConnection() throws ClassNotFoundException,SQLException{
Class.forName("oracle.jdbc.driver.OracleDriver");
    c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","DBMS","dbms");
     st=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
     return st;
}
Statement st;
Connection c;
public void closeConnection() throws SQLException{
st.close();
c.close();
}
public String[] getData(int qno){
    String data[]=new String[7];
    try{
    st=makeConnection();
    ResultSet rs=st.executeQuery("select * from questions where qno='"+qno+"'");
    if(rs.next()){
    data[0]=rs.getString(2);
    data[1]=rs.getString(3);
    data[2]=rs.getString(4);
    data[3]=rs.getString(5);
    data[4]=rs.getString(6);
    data[5]=rs.getString(7);
    data[6]=rs.getString(8);
    }
    closeConnection();
    }
catch(Exception e){
System.out.println(e);
}    
    return data;
}
public int totalQuestions(){
    int qn=0;
    try{
makeConnection();
ResultSet rs=st.executeQuery("select count(*) from questions");
if(rs.next()){
    qn=Integer.parseInt(rs.getString(1));
 }
    }catch(Exception e){
    e.printStackTrace();
    }
    return qn;
}

public int getCorrectAns(int qno)
{
    int ans=0;
    try{
        makeConnection();
        ResultSet rs=st.executeQuery("select ans from questions where qno="+qno);
        rs.next();
        ans=Integer.parseInt(rs.getString("ans"));
        closeConnection();  
    }catch(Exception e)
    {
        System.out.println(e);
    }
    return ans;
    }
}
