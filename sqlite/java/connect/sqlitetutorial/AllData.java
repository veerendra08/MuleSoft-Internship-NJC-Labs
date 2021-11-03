package sqlitetutorial;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AllData {

   
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

    
   
    public void selectAll(){
        String sql = "SELECT Name,Actor_Name,Actress_Name,Year_of_Release,Director FROM Movies";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
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
        AllData app = new AllData();
        app.selectAll();
    }

}
