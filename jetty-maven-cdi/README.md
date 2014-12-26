README
======

This is an extremely simple setup for testing CDI ([Red Hat JBoss Weld]
(https://docs.jboss.org/weld/reference/latest/en-US/html/)) and Jetty using the 
[jetty-maven-plugin](http://www.eclipse.org/jetty/documentation/current/jetty-maven-plugin.html)

+ Jetty 9.2.5.v20141112
+ Weld 2.2.7.Final (CDI 1.2)

### Running this example Application

+ Check if Java 8 is used
+ Clone this git repository
+ Go to root directory of this subproject, `jetty-maven-cdi`
+ Start Jetty and go to `http://localhost:8080/` to view the result in your browser

````shell
$ mvn --version
Apache Maven 3.2.2 (45f7c06d68e745d05611f7fd14efb6594181933e; 2014-06-17T15:51:42+02:00)
Maven home: /usr/share/maven/apache-maven-3.2.2
Java version: 1.8.0_25, vendor: Oracle Corporation
Java home: /usr/lib/jvm/jdk1.8.0_25/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "3.13.0-43-generic", arch: "amd64", family: "unix"
$ git clone https://github.com/rmuller/java8-examples.git
Cloning into 'java8-examples'...
remote: Counting objects: 43, done.
remote: Compressing objects: 100% (26/26), done.
remote: Total 43 (delta 4), reused 38 (delta 2)
Unpacking objects: 100% (43/43), done.
Checking connectivity... done.
$ cd java8-examples/jetty-maven-cdi/
$ mvn jetty:run
````

### Notes

+ CDI injection is available in 
    + Servlets and Filters (Jetty 7.2+)
    + Listeners (Jetty 9.1.1+)
+ [Jetty 9.1.0+ requires Weld 2.2.0+](https://issues.jboss.org/browse/WELD-1561)
+ Transactional events not available in a non-Java EE environment 

### References

+ [The Java EE Tutorial, Contexts and Dependency Injection]
(https://docs.oracle.com/javaee/7/tutorial/partcdi.htm#GJBNR)
+ [Weld - CDI: Contexts and Dependency Injection for the Java EE platform]
(https://docs.jboss.org/weld/reference/latest/en-US/html/index.html)
+ [Introduction to JNDI](http://archive.oreilly.com/pub/a/onjava/excerpt/java_servlets_ch12/index.html?page=3)
+ [Working with Jetty JNDI](http://www.eclipse.org/jetty/documentation/current/using-jetty-jndi.html)
