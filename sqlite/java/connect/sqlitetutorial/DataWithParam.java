package sqlitetutorial;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.*;

public class DataWithParam {

 private Connection connect() {
       
        String url = "jdbc:sqlite:C://sqlite/db/Movies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
        
    public void getMovieWithName(String name){
               String sql = "SELECT Name,Actor_Name,Actress_Name,Year_of_Release,Director FROM Movies WHERE Actor_Name = ?";
        	 
        try (Connection conn = this.connect();PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
           
            pstmt.setString(1,name);
            
            ResultSet rs  = pstmt.executeQuery();
            
           
            while (rs.next()) {
                System.out.println(rs.getString("Name") +  "\t" + 
                                   rs.getString("Actor_Name") + "\t" +
				   rs.getString("Actress_Name") + "\t" +
				   rs.getInt("Year_of_Release") + "\t" +
                                   rs.getString("Director"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
  
    public static void main(String[] args) {
        DataWithParam app = new DataWithParam();
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Actor Name");
	String ac = sc.nextLine();
	app.getMovieWithName(ac);
    }

}
