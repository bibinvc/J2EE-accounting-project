<%-- 
    Document   : index
    Created on : 12-Apr-2020, 14:33:56
    Author     : bvcbi
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<HTML>
    <HEAD>
        <TITLE>
            Titre
        </TITLE>
    </HEAD>
    <BODY>
        <FORM METHOD="GET"   
              ACTION="http://localhost:8080/Final_Project/NewServlet">
            <table border="1" cellpadding="5">
                <caption><h2>Input New Users</h2></caption>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>User Name</th>
                        <th>Action</th>
                    </tr>
                <c:forEach var="i" begin="0" end="3" step="1">
                    <tr>
                    <td><INPUT TYPE="TEXT" NAME="firstname"/></td>  
                    <td><INPUT TYPE="TEXT" NAME="lastname"/></td>  
                    <td><INPUT TYPE="TEXT" NAME="username"/></td>
                    <td><INPUT TYPE="submit" value="*" name="*" width=".5" height=".5"/></td>
                    </TR>
                 </c:forEach>  
            </TABLE>
                <INPUT TYPE="submit" value="Submit"/>
        </FORM>
    </BODY>
</HTML>