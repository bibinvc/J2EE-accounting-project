<%-- 
    Document   : display
    Created on : 29-Apr-2019, 14:34:49
    Author     : bvcbi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Page</title>
    </head>
    <body>    
    <%--  <c:forEach items="${key}" var="data">
        <div class="Firstname">   
            <br>
           <c:out value="${data['firstname']}" />
        </div>
        <div class="Lastname">   
            <br>
           <c:out value="${data['lastname']}" />
        </div>
        <div class="username">
            <c:choose>
                <c:when test="${data['username']==0}">No Values Entered</c:when>
                <c:otherwise>${data['username']}</c:otherwise>
            </c:choose>  
    
     </c:forEach>  --%>
    <%! int count =1; %>
    <%! int counti =1; %>
    <c:forEach items="${key}" var="item">
        <%=counti++%>
        </c:forEach> 
    <h3><% out.println("Total User Count"+(counti-1)); %></h3>
                    
                    <table border="1" cellpadding="5">
            <caption><h2>Details</h2></caption>
           <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>User Name</th>
            </tr>
<c:forEach items="${key}" var="item">
<tr>
 <td>   <% out.println(count); %></td>  
<td>${item.firstname}</td>  
 <td>${item.lastname}</td>  
 <td><c:choose>
                <c:when test="${item['username']==0}">No Values Entered</c:when>
                <c:otherwise>${item['username']}</c:otherwise>
            </c:choose> </td>  
   
    </tr>
     <%=count++%>
</c:forEach>  
                    </table>
    <table>
        <caption><h2>Search For Users</h2></caption>
        <tr>
            <td>
                <select>
                    <option value="names">All Names</option>
                    <c:forEach items="${key}" var="items">
                           <option value="${items.firstname}">${items.firstname}</option>
                    </c:forEach> 
                </select>
            </td>
            <td>
               <input type="text" name="name" id="name">
            </td>
            <td>
                <input type="submit" name="submit" value="Search">
            </td>
        </tr>
    </table>
                    
    </body>
</html>






