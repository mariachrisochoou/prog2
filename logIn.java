import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
   
public class Loguser {  
	 
   
    private Connection connect() {  
        // SQLite connection string  
       DbConnection dbconnection = new DbConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava"); 
			Connection con = null;
        try {  
            conn = dbconnection.getConnection();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
   
  
    public void selectData(String username,String password)){  
        String sql = "SELECT username , password,
                   FROM user,
                   WHERE USERNAME = uname";
                   boolean flag;

          
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement(sql);  
            ResultSet ps    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (ps.next()) {  
                System.out.println(rs.getString("username") +  "\t" +   
                                   rs.getString("password") + "\t" );  
            }  
		} catch (Exception e) {
	           flag = false;
        } catch (SQLException e) {  
            flag = false; 
        }  
    }  
      
