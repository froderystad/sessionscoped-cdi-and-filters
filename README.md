SessionScoped CDI and Filters
=============================

I created this small project to experiment with SessionScoped CDI beans and WebFilters in JSF-applications, 
to figure out the best way to handle user context information. 
Other than that, it does nothing useful :)

It requires Java 1.7 (or higher) and Maven to build, and a Java EE 7 application server to run.

Build with:

    mvn clean package

If you have Wildfly 8 installed to `$JBOSS_HOME`, this command will deploy the application, so you can [access it here] (http://localhost:8180/).

    mvn cargo:run -P wildfly-8-final