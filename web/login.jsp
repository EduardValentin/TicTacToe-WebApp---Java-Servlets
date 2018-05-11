<%-- 
    Document   : login
    Created on : May 11, 2018, 8:36:10 AM
    Author     : Eduard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TicTacToe - Login</title>
    </head>
    <body>
        <h1>Login Here</h1>
        
        <% 
            /*if(request.getAttribute("message") != null) {
                out.println(request.getAttribute("message"));
                request.removeAttribute("message");                             
            }*/
            
            if(session.getAttribute("message") != null) {
                out.println(session.getAttribute("message"));
                session.removeAttribute("message");
            }
        %>
        
        <form action="Login" method="POST">
            <input type ="text" placeholder="Username"  name="username"/>
            <input type ="password" placeholder="Password"  name="password"/>
            <input type="submit" value="Send" /> 
        </form>
    </body>
</html>
