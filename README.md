# AIT Library Walkthrough

With the AP exam behind us, it's time to get back to writing code. The last piece of code you'll ever write for me. Sad, I know. But such is life, and the show must go on.

Before we begin, we'll need to configure our development environment. We're going to build a simple CRUD (create, read, update, delete) application, and we need more support than Java SE provides.

In just a few short weeks, you're going to gain some exposure to quite a few new technologies.

* Apache Tomcat
* Java EE
* MySQL
* Java Servlets &amp; Java Server Pages (JSP)
* JSP Standard Tag Library (JSTL)
* Java Database Connectivity (JDBC)
* Maven

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
