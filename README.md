spring-security-bootstrap
=========================

Simple bootstrap application for Spring Security, uses JavaConfig and Spring 4 milestone-2. 
Creates a Spring 4 web application with SpringSecurity support. 
The application uses JavaConfig for both ApplicationContext setup and SpringSecurity. This makes the application more or less XML-Free. ( Except a default web.xml, which is there to avoid FileNotFoundException in some servlet containers).

Application contains 3 web pages: index.html, login.html and admin/admin.html. 
The admin page is a protected resource and can only be seen if you login with an admin user. The public webfolder is not part of the security chain. 

Username: admin
Password: password

Note: 
This requires a Servlet container that supports Servlet 3.0 API, i.e. Tomcat 7.



