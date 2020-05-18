package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    
    public static void main(String[] args) throws SQLException {
	final String driver = "com.mysql.cj.jdbc.Driver";
	final String url = "jdbc:mysql://localhost:3306/library?serverTimezone=EST";
	final String username = "root";
	final String password = "rootpwd";
	
	try {
	    Class.forName(driver);
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	
	Connection conn = DriverManager.getConnection(url, username, password);
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT * FROM books");
	
	System.out.println("Books in the Library:\n");
	while (rs.next()) {
	    String title = rs.getString("title");
	    String author = rs.getString("author");
	    int copies = rs.getInt("copies");
	    int available = rs.getInt("available");
	    
	    System.out.println(" --> " + title + " by " + author + " (" + available + " of " + copies + ")");
	}
	
	rs.close();
	stmt.close();
    }
}
