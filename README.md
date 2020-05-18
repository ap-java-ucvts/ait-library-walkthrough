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
```

And here's what it looks like in Eclipse, including the expected output of all five books.

![main-method-test-output](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/main-method-output.png)

Eclipse might ask you if you want to `Run on Server` or as a `Java Application`. For now, choose to run the program as a `Java Application`. Later, we'll work on the server side.
