/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Tanner1309
 */
public class conexion {
    public  Connection con;
    public conexion (){
          try{
              Class.forName("com.mysql.jdbc.Driver");
              con=DriverManager.getConnection("jdbc:mysql://189.141.43.72:3306/ahorcado","anonimo","YoJuegoLoL14.13");
    }catch (Exception e){
       System.err.println("Error:"+e);
    } 
          
    }
    public static void main(String[] args){
        conexion cn=new conexion();
        Statement st;
        ResultSet rs;
        try{
        st=(Statement) cn.con.createStatement();
        rs=st.executeQuery("select * from palabras");
        while (rs.next()){
            System.out.println(rs.getInt("id")+" "+rs.getString("palabra")+" "+rs.getString("pista")+" "+rs.getString("campo"));
        }
        cn.con.close();
        }catch (Exception e){
        }
    }
    
    
}
