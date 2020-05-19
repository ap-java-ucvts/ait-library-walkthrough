<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>AIT Library</title>
  </head>
  <body>
    <div>
      <h1>Inventory Management</h1>
      
      <div>
        <a href="${pageContext.request.contextPath}/">VIEW ALL</a>
        <a href="${pageContext.request.contextPath}/add">ADD A BOOK</a> 
      </div>
    </div>
    <div>
      <table border="1">
        <caption>All Books in Collection</caption>
        
        <tr>
          <td>Title</td>
          <td>Author</td>
          <td>Copies</td>
          <td>Available</td>
          <td>Actions</td>
        </tr>
        <c:forEach var="book" items="${books}">
          <tr>
            <td><c:out value="${book.title}" /></td>
            <td><c:out value="${book.author}" /></td>
            <td><c:out value="${book.copies}" /></td>
            <td><c:out value="${book.available}" /></td>
            <td>
              <a href="${pageContext.request.contextPath}/update?action=rent&id=<c:out value="${book.id}" />">RENT</a>
              <a href="${pageContext.request.contextPath}/update?action=return&id=<c:out value="${book.id}" />">RETURN</a>
              <a href="${pageContext.request.contextPath}/edit?id=<c:out value="${book.id}" />">EDIT</a>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>