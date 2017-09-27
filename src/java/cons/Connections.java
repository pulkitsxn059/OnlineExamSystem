package cons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connections {
    static Connection c;
    static Statement st;
    static PreparedStatement pst;
    
    public static Statement getStatement(){
        try{
   Class.forName("oracle.jdbc.driver.OracleDriver");
   c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","DBMS","dbms");
   st=c.createStatement();
    }catch(Exception e){
        System.out.println(e);
}
        return st;
    }
    
    public static PreparedStatement getPreStatement(String sql){
    try{
   Class.forName("oracle.jdbc.driver.OracleDriver");
   c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","DBMS","dbms");
   pst=c.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    }catch(Exception e){
        System.out.println(e);
}
        return pst;
    }
    
     public static Statement makeConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","DBMS","dbms");
            st = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
        return st;
    }
     
    public static void closeConnection(){
        try{
    if(st!=null)
        st.close();
    if(pst!=null)
        pst.close();
        c.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}   
    
