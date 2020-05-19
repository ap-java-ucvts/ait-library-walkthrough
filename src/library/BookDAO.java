package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO
{
    private final String url;
    private final String username;
    private final String password;
    
    public BookDAO(String url, String username, String password)
    {
	super();
	
	this.url = url;
	this.username = username;
	this.password = password;
    }
    
    public Book getBook(int id) throws SQLException
    {
	final String sql = "SELECT * FROM books WHERE book_id = ?";
	
	Book book = null;
	Connection conn = getConnection();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	pstmt.setInt(1, id);
	ResultSet rs = pstmt.executeQuery();
	
	if (rs.next()) {
	    String title = rs.getString("title");
	    String author = rs.getString("author");
	    int copies = rs.getInt("copies");
	    int available = rs.getInt("available");
	    
	    book = new Book(id, title, author, copies, available);
	}
	
	rs.close();
	pstmt.close();
	conn.close();
	
	return book;
    }
    
    public List<Book> getBooks() throws SQLException
    {
	final String sql = "SELECT * FROM books ORDER BY book_id ASC";
	
	List<Book> books = new ArrayList<>();
	Connection conn = getConnection();
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	while (rs.next()) {
	    int id = rs.getInt("book_id");
	    String title = rs.getString("title");
	    String author = rs.getString("author");
	    int copies = rs.getInt("copies");
	    int available = rs.getInt("available");
	    
	    books.add(new Book(id, title, author, copies, available));
	}
	
	rs.close();
	stmt.close();
	conn.close();
	
	return books;
    }
    
    public boolean insertBook(String title, String author, int copies, int available)
	    throws SQLException
    {
	final String sql = "INSERT INTO books (title, author, copies, available) " +
		"VALUES (?, ?, ?, ?)";
	
	Connection conn = getConnection();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1, title);
	pstmt.setString(2, author);
	pstmt.setInt(3, copies);
	pstmt.setInt(4, available);
	int affected = pstmt.executeUpdate();
	
	pstmt.close();
	conn.close();
	
	return affected == 1;
    }
    
    public boolean updateBook(Book book) throws SQLException
    {
	final String sql = "UPDATE books SET title = ?, author = ?, copies = ?, available = ? " +
		"WHERE book_id = ?";
	
	Connection conn = getConnection();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1, book.getTitle());
	pstmt.setString(2, book.getAuthor());
	pstmt.setInt(3, book.getCopies());
	pstmt.setInt(4, book.getAvailable());
	pstmt.setInt(5, book.getId());
	int affected = pstmt.executeUpdate();
	
	pstmt.close();
	conn.close();
	
	return affected == 1;
    }
    
    public boolean deleteBook(Book book) throws SQLException
    {
	final String sql = "DELETE FROM books WHERE book_id = ?";
	
	Connection conn = getConnection();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	pstmt.setInt(1, book.getId());
	int affected = pstmt.executeUpdate();
	
	pstmt.close();
	conn.close();
	
	return affected == 1;
    }
    
    private Connection getConnection() throws SQLException
    {
	final String driver = "com.mysql.cj.jdbc.Driver";
	
	try {
	    Class.forName(driver);
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	
	return DriverManager.getConnection(url, username, password);
    }
}
