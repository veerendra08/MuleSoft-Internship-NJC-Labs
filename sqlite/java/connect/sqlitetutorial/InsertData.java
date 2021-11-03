package sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

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

    public void insert(String name, String actor,String actress,int year,String director) {
        String sql = "INSERT INTO Movies(Name,Actor_Name,Actress_Name,Year_of_Release,Director) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, actor);
	    pstmt.setString(3, actress);
	    pstmt.setInt(4, year);
	    pstmt.setString(5, director);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

  
    public static void main(String[] args) {

        InsertData app = new InsertData();
        // insert three new rows
        app.insert("Dune", "Timothee Chalamet","Rebecca Ferguson",2021,"Denis Villeneuve");
        app.insert("Halloween Kills", "David Gordon Green","Jamie Lee Curtis",2021,"Judy Greer");
	app.insert("Eternals", "Chloe Zhao","Gemma Chan",2021,"Richard Madden");
    }

}
