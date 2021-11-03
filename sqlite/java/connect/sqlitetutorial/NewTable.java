package sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class NewTable {

   
    public static void createNewTable() {
      
        String url = "jdbc:sqlite:C://sqlite/db/Movies.db";
        
      
         String sql = "CREATE TABLE IF NOT EXISTS Movies (\n"
                + "	Name text PRIMARY KEY,\n"
                + "	Actor_Name text NOT NULL,\n"
                + "	Actress_Name text,\n"
		+ "	Year_of_Release integer,\n"
		+ "	Director text\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
         
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public static void main(String[] args) {
        createNewTable();
    }

}
