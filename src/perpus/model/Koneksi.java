/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package perpus.model;

import java.sql.*;
   
public class Koneksi {
    Connection conn = null;
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   PreparedStatement stm = null;
    public Koneksi() throws ClassNotFoundException, SQLException{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/perpus","hamim","hamim");
   }    
   
   public int login(String user, String pass) throws SQLException{
       int rowCount = 0;
        stm = conn.prepareStatement("SELECT count(*) FROM user where nama=? and password=?");
        //SELECT count(*) FROM user where nama='admin' and password='admin'
        stm.setString(1, user); 
        stm.setString(2, pass);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) { 
            rowCount = rs.getInt(1);
        }
        return rowCount;
   }
}
