<%-- 
    Document   : register
    Created on : May 13, 2018, 10:20:01 AM
    Author     : eduar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <link href="Assets/styles.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        
        <h1>Hello World!</h1>
        
        <form action="Register" method="POST"  />
            <input type="text" name="first_name" placeholder="First name" value=""/>
            <input type="text" name="last_name" placeholder="Last name" value="" />
            <input type="text" name="email" placeholder="Email" value=""/>
            <input type="text" name="username" placeholder="Username" value="" />
            <input type="password" name="password" placeholder="Password" value="" />
            <input type="submit" value="Register"/>
        </form>
    </body>
</html>
