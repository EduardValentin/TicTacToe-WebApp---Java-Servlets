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
      
       
        <% 
            if(session.getAttribute("message") != null) {
                out.println("<div class=\"message-popup collumn-flex-container\">" + session.getAttribute("message") + "</div>");

                session.removeAttribute("message");
            }
        %>
  
        <form action="Register" method="POST" class="collumn-flex-container user-form" />
            <div class="label-wrap">
                <label for="first-name">First Name:</label>
                <input type="text" id="first-name" name="first_name" placeholder="First name" value=""/>
            </div> 
            <div class="label-wrap">
                <label for="last-name">Last Name:</label>
                <input type="text" id="last-name" name="last_name" placeholder="Last name" value="" />
            </div>
            <div class="label-wrap">
                <label for="email">Email:</label>
                <input type="text" id="email" name="email" placeholder="Email" value=""/>
            </div>
            <div class="label-wrap">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" placeholder="Username" value="" />
            </div>
            <div class="label-wrap">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="Password" value="" />
            </div>
            <input type="submit" class="custom-button" value="Register"/>
        </form>
    </body>
</html>
