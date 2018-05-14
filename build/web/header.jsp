<%@page import="utility.AuthUser"%>
<nav class="row-flex-container">
            <div id="nav-title">
                <a href="index.jsp"><h1>Super TicTacToe</h1></a>
            </div>
            <div class="row-flex-container forms">
                <% if(AuthUser.userIsLoggedIn(request)) { %>
               
                <%=
                    new String("<form action=\"Logout\" method=\"POST\"><input type=\"submit\" value=\"Logout\"/></form>")
                %>
               
                <% } %>
                <form action="login.jsp" method="POST" />
                    <input type="submit" value="Login"  />
                </form>
                
                <form action="register.jsp" method="POST"  />
                    <input type="submit" value="Register"/>
                </form>
            </div>
</nav>
