README
======

This is an simple setup for testing CDI ([Red Hat JBoss Weld]
(https://docs.jboss.org/weld/reference/latest/en-US/html/)) and Jetty using the 
[jetty-maven-plugin](http://www.eclipse.org/jetty/documentation/current/jetty-maven-plugin.html)

+ Jetty 9.2.5.v20141112
+ Weld 2.2.7.Final (CDI 1.2)

### Running this example Application

+ Check if Java 8 is used
+ Clone this git repository
+ Go to project directory, `java8-examples`
+ Execute `mvn clean install`
+ Go to root directory of this subproject, `jetty-maven-cdi`
+ Start Jetty and go to `http://localhost:8080/` to view the result in your browser

````bash
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
$ cd java8-examples/
$ mvn clean install
[INFO] Scanning for projects...
...
$ cd jetty-maven-cdi/
$ mvn jetty:run
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building jetty-maven-cdi 1.0.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
...
2014-12-26 15:49:20.915:INFO:oejs.ServerConnector:main: Started ServerConnector@2a685eba{HTTP/1.1}{0.0.0.0:8080}
2014-12-26 15:49:20.916:INFO:oejs.Server:main: Started @3828ms
[INFO] Started Jetty Server
````

### Jetty configuration

To enable CDI, you need to configure Jetty first. Several online resources describe the 
configuration in a different way. Most importantly the official Jetty and Weld documentation
are not consistent.

+ [Jetty documentation](http://www.eclipse.org/jetty/documentation/current/framework-weld.html)
+ [Weld documentation](https://docs.jboss.org/weld/reference/latest/en-US/html/environments.html)

### How to setup a CDI enabled application?

+ Add `javax.enterprise:cdi-api:1.2`, scope `provided` to your (maven) dependencies
+ Add `org.jboss.weld.servlet:weld-servlet:2.2.7.Final` as a dependency for
`jetty-maven-plugin`
+ Managed beans must have a default constructor and may not be `final` (must be proxiable)
+ Managed beans declaring a passivating scope must be passivation capable, 
implement `java.io.Serializable` and all `@Interceptors` must be Serializable as well

### Notes

+ CDI injection is available in 
    + Servlets and Filters (Jetty 7.2+)
    + Listeners (Jetty 9.1.1+)
+ [Jetty 9.1.0+ requires Weld 2.2.0+](https://issues.jboss.org/browse/WELD-1561)
+ Transactional events not available in a non-Java EE environment 

### References

+ [JSR 299: Contexts and Dependency Injection for the Java EE platform]
(https://jcp.org/en/jsr/detail?id=299). CDI 1.0, Part of Java EE 6
+ [JSR 346: Contexts and Dependency Injection for Java EE 1.1]
(https://jcp.org/en/jsr/detail?id=346). CDI 1.1, Part of Java EE 7 release and [CDI 1.2]
(http://www.cdi-spec.org/news/2014/04/14/CDI-1_2-released/) maintenance release 
+ [The Java EE Tutorial, Contexts and Dependency Injection]
(https://docs.oracle.com/javaee/7/tutorial/partcdi.htm#GJBNR)
+ [Weld - CDI: Contexts and Dependency Injection for the Java EE platform]
(https://docs.jboss.org/weld/reference/latest/en-US/html/index.html)
+ [Must read about CDI 2.0](http://www.next-presso.com/2014/03/forward-cdi-2-0/)
+ [Introduction to JNDI](http://archive.oreilly.com/pub/a/onjava/excerpt/java_servlets_ch12/index.html?page=3)
+ [Working with Jetty JNDI](http://www.eclipse.org/jetty/documentation/current/using-jetty-jndi.html)
