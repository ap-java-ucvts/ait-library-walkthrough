# AIT Library Walkthrough

With the AP exam behind us, it's time to get back to writing code. One of the last pieces of code you'll ever write for me. Sad, I know. But such is life, and the show must go on.

Before we begin, we'll need to configure our development environment. We're going to build a simple CRUD (create, read, update, delete) application, and we need more support than Java SE provides.

In just a few short weeks, you're going to gain some exposure to quite a few new technologies.

* Apache Tomcat
* Java EE
* MySQL
* Maven
* Java Database Connectivity (JDBC)
* Java Servlets &amp; Java Server Pages (JSP)
* JSP Standard Tag Library (JSTL)

Don't worry, we're going to walk through it together. On to the configuration steps...

## Installing Tomcat

You can [download the latest version of Tomcat from Apache](https://tomcat.apache.org/download-90.cgi). All of the downloads are in the `Binary Distributions` section. Choose the one applicable to your operating system.

The steps to install Apache's Tomcat server will differ based on your OS. I've found some helpful tutorials and videos that walk you through the process. Follow along and you'll be up-and-running in no time.

* [Windows](https://www.youtube.com/watch?v=QwExzQt0XGE)
* [macOS](https://wolfpaulus.com/tomcat/)

Assuming you kept the default port of `8080`, you can verify your Tomcat installation by navigating to `localhost:8080`. If you see the Tomcat page, you're good to go.

## Getting the Java EE Perspective

Java EE is the enterprise edition of the Java platform. It's what professional software developers use to create secure, multi-tiered, scalable web applications.

Eclipse has different perspectives tailored to the types of programs you're writing. We've been working with the standard edition all year, so Eclipse has shown us the default Java SE perspective. To get the Java EE perspective, we need to download and install a few things.

Navigate to `Help > Install New Software...` to bring up the `Available Software` dialog box.

Type `http://download.eclipse.org/releases/<YOUR-VERSION-TAG>` in the `Work with` textbox. I am using Eclipse 2020-03, so my URL ends in `2020-03`. Yours may be different.

![install-new-software](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/eclipse-software.png)

Expand the `Web, XML, Java EE and OSGi Enterprise Development` tree, and check the following components.

* `Eclipse Java EE Developer Tools`
* `Eclipse Java Web Developer Tools`
* `Eclipse Web Developer Tools`
* `JST Server Adapters`
* `JST Server Adapter Extensions`

You'll be asked to restart Eclipse to complete the installation.

Locate the `Open Perspective` button in the top-right of the window. It's the one with the little plus sign, and it'll open a dialog where you can choose a new perspective.

![eclipse-perspective](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/eclipse-perspective.png)

Select `Java EE` and click `Open` to launch the new perspective.

![eclipse-java-ee](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/eclipse-java-ee.png)

A few things have changed. Most notably, you have a range of new types of projects you can create. For now, though, we're going to focus on the `Servers` tab towards the bottom of the window.

## Adding Tomcat to Eclipse

Open the `Servers` tab, which is where we'll add our Tomcat instance.

![eclipse-servers-1](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/eclipse-servers-1.png)

There's nothing here except a link that says `No servers are available. Click this link to create a new server...` &ndash; take the link's advice, and it'll open the `New Server` dialog box.

![eclipse-servers-2](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/eclipse-servers-2.png)

Open the `Apache` folder, and click `Tomcat v9.0 Server`, which is what we downloaded and installed earlier.

![eclipse-servers-3](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/eclipse-servers-3.png)

Click `Next`, where you'll be asked to browse for your Apache installation directory.

![eclipse-servers-3](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/eclipse-servers-4.png)

If you did everything right, you'll see a `Tomcat` entry in the `Servers` tab at the bottom. There will also be a `Servers` folder in your `Project Explorer` pane.

![eclipse-servers-3](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/eclipse-servers-5.png)

## Installing MySQL

First, you'll need to [download the MySQL Community Server](https://dev.mysql.com/downloads/mysql/). Just like with Tomcat, choose the appropriate download based on your OS. You'll have to login with your Oracle Web Account, which most of you probably created when you downloaded Java. If you don't have an Oracle Web Account, it's simple enough to create one.

Regardless of OS, you'll be taken through your typical click-through installer. You can keep the defaults as-is. If you're asked to create a password for the `root` user, make sure you remember it! The `root` user is how you'll login to your MySQL instance later.

Once the database is installed, we'll want an easier way to work with it. [Download the MySQL Workbench](https://www.mysql.com/products/workbench/), which will help us create and query tables.

![mysql-workbench](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/mysql-workbench.png)

## Creating a Project

With the installation behind us, we're ready to create a new project. Go to `File > New > Dynamic Web Project`. If you want to name your project something else, that's fine. Make sure the rest of the settings match mine, though.

![new-dynamic-web-project-1](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/eclipse-dynamic-web-project-1.png)

Click `Finish` and the project will be added to your `Project Explorer`.

![new-dynamic-web-project-2](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/eclipse-dynamic-web-project-2.png)

## Converting to a Maven Project

Right-click the project and click `Configure > Convert to Maven Project`. Make sure your settings match mine, including selecting a `Packaging` of `WAR`.

![maven-project](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/maven-project.png)

After the project is converting to Maven, you should see a `pom.xml` file.

![maven-pom](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/maven-pom-1.png)

## Adding Maven Dependencies

Maven is a dependency management and build automation tool. It automatically tracks and downloads external project dependencies. Let's start adding ours.

```xml
<project
  xmlns="http://maven.apache.org/POM/4.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd"
>
  <modelVersion>4.0.0</modelVersion>
  <groupId>ait-library</groupId>
  <artifactId>ait-library</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>war</packaging>
  <name>ait-library</name>
  
  <dependencies>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>javax.servlet.jsp-api</artifactId>
      <version>2.3.3</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.20</version>
    </dependency>
  </dependencies>
</project>
```

Make sure the version numbers match between our `mysql` dependency and the version we downloaded earlier. The version on my machine is `8.0.20`, and my Maven dependency reflects this.

## Setting up the Database

Our database backs the entire application, so that's where we're going to start. The schema is pretty simple. We have a library, and it's going to store books.

First, we create the database and tell MySQL we'll be using it.

```sql
CREATE DATABASE `library`;
USE `library`;
```

Next, we create the `books` table. It's pretty straightforward. Every `book` gets an automatically assigned numeric `book_id`, along with a `title`, `author`, the number of `copies` the library has, and the number of books that are `available` (i.e., how many are not checked out).

```sql
CREATE TABLE IF NOT EXISTS `books` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `author` varchar(64) NOT NULL,
  `copies` int(3) NOT NULL,
  `available` int(3) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE = InnoDB DEFAULT CHARSET = latin1;
```

All of this should be written and executed in the MySQL Workbench.

![create-database-and-table](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/create-database-table.png)

Now, let's put some data in our database. We'll put five books into the `books` table.

```sql
INSERT INTO `books` (`title`, `author`, `copies`, `available`) VALUES ("In Search of Lost Time", "Marcel Proust", 3, 3);
INSERT INTO `books` (`title`, `author`, `copies`, `available`) VALUES ("Ulysses", "James Joyce", 7, 7);
INSERT INTO `books` (`title`, `author`, `copies`, `available`) VALUES ("Don Quixote", "Miguel de Cervantes", 10, 10);
INSERT INTO `books` (`title`, `author`, `copies`, `available`) VALUES ("The Great Gatsby", "F. Scott Fitzgerald", 12, 12);
INSERT INTO `books` (`title`, `author`, `copies`, `available`) VALUES ("One Hundred Years of Solitude", "Gabriel Garcia Marquez", 14, 14);
```

Just like last time, we're doing this through the MySQL Workbench.

![insert-data](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/insert-data.png)

## Testing Connectivity

As we dive more deeply into this application, we'll do things much differently. We just want to verify that our application is connecting to and reading data from our database.

Right-click the project in Eclipse and click `New > Class`. Enter a `Package` of `application`, a `Name` of `Main`, and check the `main` method stub.

![create-main-class](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/create-main-class.png)

Let's wire up some quick code to make sure our application can talk to our database. We'll just read everything in our `books` table, and print it to the console.

```java
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main
{
  public static void main(String[] args) throws SQLException
  {
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
```

And here's what it looks like in Eclipse, including the expected output of all five books.

![main-method-test-output](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/main-method-output.png)

Eclipse might ask you if you want to `Run on Server` or as a `Java Application`. For now, choose to run the program as a `Java Application`. Later, we'll work on the server side.

## Modeling the Data

Now that we know everything is wired up correctly, let's start writing some more code. We'll start with a class to model the books in the database. Right-click the project and click `New > Class`. We'll be putting our `Book` class in a new package called `library`.

![new-book-class](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/new-book-class.png)

Let's add some code. We want to model the database entities, so we'll create an instance variable for each column in the `books` table.

* `id`
* `title`
* `author`
* `copies`
* `available`

We'll create a constructor using each of these fields, as well as some getters and setters. The `id`, `title`, and `author` never change, so we only need getters for those three. `copies` and `available` can change over time, so we'll need getters and setters for those two.

```java
package library;

public class Book
{
  private int id;
  private String title;
  private String author;
  private int copies;
  private int available;

  public Book(int id, String title, String author, int copies, int available)
  {
    super();

    this.id = id;
    this.title = title;
    this.author = author;
    this.copies = copies;
    this.available = available;
  }
  
  public int getId()
  {
    return id;
  }

  public String getTitle()
  {
    return title;
  }
    
  public String getAuthor()
  {
    return author;
  }

  public int getCopies()
  {
    return copies;
  }
    
  public void setCopies(int copies)
  {
    this.copies = copies;
  }
    
  public int getAvailable()
  {
    return available;
  }
    
  public void setAvailable(int available)
  {
    this.available = available;
  }
}
```

## Creating a Data Access Layer

Now that we have a `Book` class to model books in the database, we need a class to provide the CRUD (create, read, update, delete) operations pertaining to a book. This is called a data access layer.

Again, right-click the project and click `New > Class`. We'll call this class `BookDAO`, and we'll put it in the `library` package, too.

![new-book-dao-class](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/new-book-dao-class.png)

We're going to put our JDBC methods in this class so we can use it to interact with the database. Let's take a minute to think about some of the interactions we'll want the ability to have.

* Retrieving a single book from the database
* Retrieving all books from the database
* Inserting a book into the database
* Updating a single book in the database
* Deleting a single book from the database

And obviously, we'll need the ability to connect to the database. So let's get programming.

```java
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
  
  public boolean insertBook(Book book) throws SQLException
  {
    final String sql = "INSERT INTO books (title, author, copies, available) " +
        "VALUES (?, ?, ?, ?)";
    
    Connection conn = getConnection();
    PreparedStatement pstmt = conn.prepareStatement(sql);
    
    pstmt.setString(1, book.getTitle());
    pstmt.setString(2, book.getAuthor());
    pstmt.setInt(3, book.getCopies());
    pstmt.setInt(4, book.getAvailable());
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
```

One point of emphasis. `Connection`, `Statement`, `PreparedStatement`, and `ResultSet` objects need to be closed when you're done using them, and they should be closed in reverse order relative to the order in which they were created.

## Adding some JSP

Java Server Pages (JSP) represent the view of our application. These pages are responsible for displaying data in the browser. We're going to create a very simple one to show the books in our database.

Right-click the project and click `New > JSP File`. Select `WebContent` as the parent folder, and name the file `inventory.jsp`.

![add-jsp](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/add-inventory-jsp.png)

JSP files look a lot like HTML, but there are some important differences. We can use programming constructs that look a lot like Java to conditionally render information. Notice the special tags at the top? That's what allows us to run code inside our JSP files.

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>AIT Library</title>
  </head>
  <body>
    <div>
      <h1>Inventory Management</h1>
      <h2><a href="/books">View All</a></h2>
    </div>
    <div>
      <table border="1">
        <caption>All Books in Collection</caption>
        
        <tr>
          <td>Title</td>
          <td>Author</td>
          <td>Copies</td>
          <td>Available</td>
        </tr>
        <c:forEach var="book" items="${books}">
          <tr>
            <td><c:out value="${book.title}" /></td>
            <td><c:out value="${book.author}" /></td>
            <td><c:out value="${book.copies}" /></td>
            <td><c:out value="${book.available}" /></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
```

The second tag in this file denotes a `prefix`. We use that prefix to start all code blocks within our JSP file. See the `forEach` section? It starts with `<c:`, which tells JSP that we're about to run some Java code.

This file is pretty simple. It creates a table, loops through our collection of books, and renders them on the page. It's not fancy, there's very little styling, but it works.

## Creating the Servlet

The Java servlet will act as our controller, which routes requests and responses between the browser and our application. It's the most complicated part of the project, so we're going to start slow.

First, right-click the project and click `New > Class`. We're going to call this class `Controller`. We'll put this in our `application` folder, and extend the `HttpServlet` class. You can browse for this in Eclipse during class creation.

![add-controller](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/add-controller.png)

At this point, we have our database, model (`Book.java`), and data access layer (`BookDAO.java`) created, and we just added `inventory.jsp`. Our servlet is what allows the JSP file to communicate with the data access later (and by extension, the database).

We'll add to this later. For now, we just want a proof-of-concept that we can access our database from the web and display its contents in the browser.

```java
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
    final String url = "jdbc:mysql://localhost:3306/library?serverTimezone=EST";
    final String username = "root";
    final String password = "rootpwd";
    
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
}
```

The `doPost` and `doGet` methods are overridden from the `HttpServlet` class. They're responsible for accepting requests from the browser, processing them as needed, and sending responses back. Our `doGet` method does all the work here. It calls the `getBooks` method from the `BookDAO` class, and sends the list of books back to the browser.

Remember the `iventory.jsp` file? We setup a variable in our `forEach` loop called `books`. The `viewBooks` method is assigning the list of books retrieved from the database to that attribute. Now, the browser will have access to the data when it tries to render it.

We're going to come back to this class a few times to improve it. We want to be able to add, edit, and delete books, so we'll need to add routes to recognize and process those actions. And we're going to get rid of the plaintext configuration and credentials in our constructor. That's very bad practice, so we'll clean that up, too.

## Configurations

To allow our servlet to recognize and respond to web requests, we need to do some configuration. All of our configuration is going to go in a file called `web.xml`. Right-click the project and click `New > File`. Put this file in the `WebContent/WEB-INF` folder.

![web-xml-configuration](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/configure-web-xml.png)

We're going to add just what we need at the moment, but we will be back to add more.

```xml
<?xml version="1.0" encoding="UTF-8"?>

<web-app
  xmlns="http://xmlns.jcp.org/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
  version="4.0"
>
  <display-name>AIT Library</display-name>
  
  <context-param>
    <param-name>JDBC-URL</param-name>
    <param-value>jdbc:mysql://localhost:3306/library?serverTimezone=EST</param-value>
  </context-param>
  <context-param>
    <param-name>JDBC-USERNAME</param-name>
    <param-value>root</param-value>
  </context-param>
  <context-param>
    <param-name>JDBC-PASSWORD</param-name>
    <param-value>rootpwd</param-value>
  </context-param>
  
  <servlet>
    <servlet-name>Controller</servlet-name>
    <servlet-class>application.Controller</servlet-class>
  </servlet>
  
  <servlet-mapping>
    <servlet-name>Controller</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
</web-app>
```

You'll see references to our MySQL username and password, so make sure you enter the information you setup while installing MySQL. The username and password values are specific to my instance.

## Revising the Servlet

Now that we are storing our JDBC settings in `web.xml`, we can and should remove the plaintext references to the `url`, `username`, and `password`. Take a look at the `init` method in `Controller.java`.

Replace the following lines of old code:

```java
final String url = "jdbc:mysql://localhost:3306/library?serverTimezone=EST";
final String username = "root";
final String password = "rootpwd";
```

with this newly refactored code, which references the `web.xml` file:

```java
final String url = getServletContext().getInitParameter("JDBC-URL");
final String username = getServletContext().getInitParameter("JDBC-USERNAME");
final String password = getServletContext().getInitParameter("JDBC-PASSWORD");
```

The new `init` method, in its entirely, should look like this now.

```java
public void init()
{
  final String url = getServletContext().getInitParameter("JDBC-URL");
  final String username = getServletContext().getInitParameter("JDBC-USERNAME");
  final String password = getServletContext().getInitParameter("JDBC-PASSWORD");

  dao = new BookDAO(url, username, password);
}
```

Much better! Our servlet is just a little more secure. While we're at it, we don't need `Main.java` anymore. You can go ahead and delete it.

## Deployment Assembly

One more thing to do before we test our code. We need to make sure Eclipse knows to include our Maven dependencies in the deployment. Right-click the project and click `Properties`, then select `Deployment Assembly`.

![deployment-assembly-1](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/deployment-assembly-1.png)

See? Our Maven dependencies are nowhere to be found. Let's change that. Click the `Add` button, then select `Java Build Path Entries`.

![deployment-assembly-2](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/deployment-assembly-2.png)

Now, click `Next >` and select `Maven Dependencies`.

![deployment-assembly-3](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/deployment-assembly-3.png)

Click `Finish`, and you should now see a reference to the `Maven Dependencies` folder. Click `Apply and Close`.

![deployment-assembly-3](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/deployment-assembly-4.png)

## Testing our Application

Starting Tomcat is easy. Open the `Servers` tab. You should see `Tomcat v9.0 Server at localhost` (or whatever you named your server). Either way, it'll indicate that it's not running. Right-click it and click `Start`.

In your browser, navigate to `http://localhost:8080/ait-library/`. If you did everything right, you should see our books rendering on the page.

![in-progress-test](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/in-progress-test-app.png)

Things are finally starting to come together! Next, we'll start adding feature to allow users to add, modify, and delete books from the library's collection. Stay tuned...

## Renting and Returning Books

Now that our application renders some basic information, let's start working on adding the desired functionality. First, let's add a few things to `inventory.jsp`.

In first `div` underneath `Inventory Management`, replace the existing `h2` and `a` tag with:

```jsp
<a href="${pageContext.request.contextPath}/">VIEW ALL</a>
<a href="${pageContext.request.contextPath}/add">ADD A BOOK</a> 
```

Next, add one more column (and the associated data) to our `table`. This is where a user of our application, such as a librarian, would rent, return, or edit books.

```jsp
<table border="1">
  <caption>All Books in Collection</caption>
  
  <tr>
    <td>Title</td>
    <td>Author</td>
    <td>Copies</td>
    <td>Available</td>
    <td>Actions</td>
  </tr>
  <c:forEach var="book" items="${books}">
    <tr>
      <td><c:out value="${book.title}" /></td>
      <td><c:out value="${book.author}" /></td>
      <td><c:out value="${book.copies}" /></td>
      <td><c:out value="${book.available}" /></td>
      <td>
        <a href="${pageContext.request.contextPath}/update?action=rent&id=
	  <c:out value="${book.id}" />">RENT
	</a>
        <a href="${pageContext.request.contextPath}/update?action=return&id=
	  <c:out value="${book.id}" />">RETURN
	</a>
        <a href="${pageContext.request.contextPath}/edit?id=
	  <c:out value="${book.id}" />">EDIT
	</a>
      </td>
    </tr>
  </c:forEach>
</table>
```

Let's start with the `RENT` and `RETURN` features. When a user clicks one of these, the number of available books should either decrease or increase. We'll begin by modifying the `Book` class.

First, remove the `setAvailable` method. Since users are going to be renting and returning books, it makes sense to have `rentMe` and `returnMe` methods. These will be in charge of updating the number of available copies, as well as verifying that this is even possible. We can't rent a book if all of our copies are already check out!

Here's the new-and-improved `Book` class. The new methods are at the bottom.

```java
package library;

public class Book
{  
  private int id;
  private String title;
  private String author;
  private int copies;
  private int available;
    
  public Book(int id, String title, String author, int copies, int available)
  {
    super();
    
    this.id = id;
    this.title = title;
    this.author = author;
    this.copies = copies;
    this.available = available;
  }
  
  public int getId()
  {
    return id;
  }
  
  public String getTitle()
  {
    return title;
  }
  
  public String getAuthor()
  {
    return author;
  }
  
  public int getCopies()
  {
    return copies;
  }
  
  public void setCopies(int copies)
  {
    this.copies = copies;
  }
  
  public int getAvailable()
  {
    return available;
  }
  
  public void rentMe()
  {
    if (available > 0) {
      available--;
    }
  }
  
  public void returnMe()
  {
    if (available < copies) {
      available++;
    }
  }
}
```

Now, on to our servlet. We'll update the `switch` statement in our `doGet` method.

```java
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
{
  final String action = request.getServletPath();
  
  try {
    switch (action) {
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
```

And, since we're calling a new method from within that `switch` statement, we'll write that method, too.

```java
private void updateBook(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException
{	
  final String action = request.getParameter("action");
  final int id = Integer.parseInt(request.getParameter("id"));
  
  Book book = dao.getBook(id);
  switch (action) {
    case "rent":
      book.rentMe();
      break;
    case "return":
      book.returnMe();
      break;
  }
  dao.updateBook(book);
  
  response.sendRedirect(request.getContextPath() + "/");
}
```

Perfect. Now, we can click those `RENT` and `RETURN` links and the number of available copies will change accordingly.

## Adding, Editing, and Deleting Books

Now that we can rent and return a book, we need a way to add, edit, and delete books. We're going to use a single JSP file to represent these actions. Right-click the `WebContent` folder and click `New > JSP File`.

![add-edit-bookform](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/bookform-jsp.png)

In our newly created JSP file, we're going to construct a dual purpose form: adding new books, and editing or deleting existing ones.

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>AIT Library</title>
  </head>
  <body>
    <div>
      <h1>Inventory Management</h1>
      
      <div>
        <a href="${pageContext.request.contextPath}/">VIEW ALL</a>
        <a href="${pageContext.request.contextPath}/add">ADD A BOOK</a> 
      </div
    </div>
    <div>
      <c:if test="${book != null}">
        <h2>Edit Book</h2>
        <form action="update" method="post">
          <input type="hidden" name="id" value="<c:out value="${book.id}" />" />
          
          <label>
            Title
            <input type="text" name="title" value="<c:out value="${book.title}" />" />
          </label>
          <label>
            Author
            <input type="text" name="author" value="<c:out value="${book.author}" />" />
          </label>
          <label>
            # of Copies
            <input type="text" name="copies" value="<c:out value="${book.copies}" />" />
          </label>
          <input type="submit" value="Save" name="submit" />
          <input type="submit" value="Delete" name="submit" />
        </form>
      </c:if>
      <c:if test="${book == null}">
        <h2>Add Book</h2>
        <form action="insert" method="post">
          <input type="hidden" name="id" />
          
          <label>
            Title
            <input type="text" name="title" />
          </label>
          <label>
            Author
            <input type="text" name="author" />
          </label>
          <label>
            # of Copies
            <input type="text" name="copies" />
          </label>
          <input type="submit" value="Add" name="submit" />
        </form>
      </c:if>
    </div>
  </body>
</html>
```
We display one of two forms, depending on whether there is a valid instance of the `Book` class.

In the `Controller` class, again we'll be updating our `switch` statement.

```java
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
```

We're intentionally falling through in our `switch` statement here. We want the `showEditForm` method to run for both `/add` and `/edit` paths.

```java
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
```

We still need to implement the form functionality, but we do have two successfully rendering forms. The form for adding new books to the library.

![add-book-form](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/add-book-form.png)

And another for editing (or deleting) existing books.

![edit-book-form](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/edit-book-form.png)

Let's get the editing form up and running. We've got two jobs: editing and deleting. And even though we intially left out setters for `title`, `author`, and `available`, we're going to let users edit those values. Maybe someone typed them in wrong when adding a book. It happens. And if we change total copies, we'll need to change the number of copies available, too.

Add setters for those two fields in the `Book` class.

```java
public void setTitle(String title)
{
  this.title = title;
}

public void setAuthor(String author)
{
  this.author = author;
}

public void setAvailable(int available)
{
  this.available = available;
}
```

Let's make our error-handling a little easier, too. We don't want to check every time if the user entered a number. We're going to force their hand with a dropdown menu. Replace the `input` tag in `bookform.jsp` for `# of Copies` with this `select` tag.

```jsp
<select name="copies">
  <c:forEach begin="1" end="10" varStatus="loop">
    <option value="${loop.index}" <c:if test="${book.copies == loop.index}">selected</c:if>>
      ${loop.index}
    </option>
  </c:forEach>
</select>
```

And last, but not least, we'll modify our `Controller`. Let's revise the `updateBook` method, and add a `deleteBook` method.

```java
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
```

Now we can rent, return, edit, and delete books! Let's get started on adding books.

We need to make a quick change to our `BookDAO` class. We aren't going to have a `book` object when inserting, because we won't yet have an `id`. We need to modify our `insertBook` method to accept the individual values.

```java
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
```

Perfect. Now we can go ahead and update the `Controller`. This will involve changes to `doGet`, as well as the creation of an `insertBook` method.

```java
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

private void insertBook(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException
{
  String title = request.getParameter("title");
  String author = request.getParameter("author");
  int copies = Integer.parseInt(request.getParameter("copies"));
	
  dao.insertBook(title, author, copies, copies);
  response.sendRedirect(request.getContextPath() + "/");
}
```
