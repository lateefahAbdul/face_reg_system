

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conectoBanco {
        public Statement stm;
        public ResultSet rs;
        
        public Connection conn;
        
        private final String driver = "org.mysql.Driver";
        private final String root = "jdbc:mysql://127.0.0.1/facial_recognition";
        private final String user = "root";
        private final String pass = "";
        
        
        public void Conecxao (){
            try {
                
            System.setProperty("jdbc.Driver", driver);
            conn = DriverManager.getConnection(root, user, pass);
            
            System.out.println("OK");
            
            } catch (SQLException e) {
                System.out.println("error: " + e);
                
                
            }
        }
               
        public void desconnecto(){
            try {
                conn.close();
           
            } catch (SQLException e) {
                System.out.println("error: " + e);  
                
                
            }
        }         
        public void executeSQL (String SQL){
             try {
                 
             stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
             rs = stm.executeQuery(SQL);
            } catch (SQLException e){
                System.out.println("error: " + e);
            }
        
        }
         
          }
          
              
            

    
    
  
    
           
        
            
        
        
    

