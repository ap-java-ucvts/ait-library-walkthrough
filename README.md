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

## Downloading and Installing Tomcat

You can [download the latest version of Tomcat from Apache](https://tomcat.apache.org/download-90.cgi). All of the downloads are in the `Binary Distributions` section. Choose the one applicable to your operating system.

The steps to install Apache's Tomcat server will differ based on your OS. I've found some helpful tutorials and videos that walk you through the process. Follow along and you'll be up-and-running in no time.

* [Windows](https://www.youtube.com/watch?v=QwExzQt0XGE)
* [macOS](https://wolfpaulus.com/tomcat/)

Assuming you kept the default port of `8080`, you can verify your Tomcat installation by navigating to `localhost:8080`. If you see the Tomcat page, you're good to go.

## Get the Java EE Perspective in Eclipse

Java EE is the enterprise edition of the Java platform. It's what professional software developers use to create secure, multi-tiered, scalable web applications.

Eclipse has different perspectives tailored to the types of programs you're writing. We've been working with the standard edition all year, so Eclipse has shown us the default Java SE perspective. To get the Java EE perspective, we need to download and install a few things.

Navigate to `Help > Install New Software...` to bring up the `Available Software` dialog box.

Type `http://download.eclipse.org/releases/<YOUR-VERSION-TAG>` in the `Work with` textbox. I am using Eclipse 2020-03, so my URL ends in `2020-03`. Yours may be different.

![install-new-software-1](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/eclipse-software-1.png)

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

## Add Tomcat to Eclipse

Open the `Servers` tab, which is where we'll add our Tomcat instance.

![eclipse-servers-1](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/eclipse-servers-1.png)

There's nothing here except a link that says `No servers are available. Click this link to create a new server...` &ndash; take the link's advice, and it'll open the `New Server` dialog box.

![eclipse-servers-2](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/eclipse-servers-2.png)

Open the `Apache` folder, and click `Tomcat v9.0 Server`, which is what we downloaded and installed earlier.

![eclipse-servers-3](https://github.com/ap-java-ucvts/ait-library-walkthrough/blob/master/images/eclipse-servers-3.png)

If you did everything right, you'll see a `Tomcat` entry in the `Servers` tab at the bottom. There will also be a `Servers` folder in your `Project Explorer` pane.
