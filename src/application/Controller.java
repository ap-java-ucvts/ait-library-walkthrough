package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.Book;
import library.BookDAO;

public class Controller extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private BookDAO dao;

    public void init()
    {
	final String url = getServletContext().getInitParameter("JDBC-URL");
	final String username = getServletContext().getInitParameter("JDBC-USERNAME");
	final String password = getServletContext().getInitParameter("JDBC-PASSWORD");
	
	dao = new BookDAO(url, username, password);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException
    {
	doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException
    {
	final String action = request.getServletPath();
	
	try {
	    switch (action) {
	    	case "/add":
	    	case "/edit":
	    	    showEditForm(request, response);
	    	    break;
	    	case "/insert":
	    	    insertBook(request, response);
	    	    break;
	    	case "/update":
	    	    updateBook(request, response);
	    	    break;
	    	default:
	    	    viewBooks(request, response);
	    	    break;
	    }   
	} catch (SQLException e) {
	    throw new ServletException(e);
	}
    }
    
    private void viewBooks(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, ServletException, IOException
    {
	List<Book> books = dao.getBooks();
	request.setAttribute("books", books);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("inventory.jsp");
	dispatcher.forward(request, response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, ServletException, IOException
    {
	try {
	    final int id = Integer.parseInt(request.getParameter("id"));
	    
	    Book book = dao.getBook(id);
	    request.setAttribute("book", book);
	} finally {
	    RequestDispatcher dispatcher = request.getRequestDispatcher("bookform.jsp");
	    dispatcher.forward(request, response);
	}
    }
    
    private void insertBook(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, ServletException, IOException
    {
	String title = request.getParameter("title");
	String author = request.getParameter("author");
	int copies = Integer.parseInt(request.getParameter("copies"));
	
	dao.insertBook(title, author, copies, copies);
	response.sendRedirect(request.getContextPath() + "/");
    }
    
    private void updateBook(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, ServletException, IOException
    {
	final String action = request.getParameter("action") != null
		? request.getParameter("action")
		: request.getParameter("submit").toLowerCase();
	final int id = Integer.parseInt(request.getParameter("id"));
	
	Book book = dao.getBook(id);
	switch (action) {
	    case "rent":
    	    	book.rentMe();
    	    	break;
	    case "return":
    	    	book.returnMe();
    	    	break;
	    case "save":
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int copies = Integer.parseInt(request.getParameter("copies"));
		int available = book.getAvailable() + (copies - book.getCopies());
		
		book.setTitle(title);
		book.setAuthor(author);
		book.setCopies(copies);
		book.setAvailable(available);
		
		break;
	    case "delete":
		deleteBook(id, request, response);
		return;
	}
	
	dao.updateBook(book);
	response.sendRedirect(request.getContextPath() + "/");
    }
    
    private void deleteBook(final int id, HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, ServletException, IOException
    {	
	dao.deleteBook(dao.getBook(id));	
	response.sendRedirect(request.getContextPath() + "/");
    }
}
