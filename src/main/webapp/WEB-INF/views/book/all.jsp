<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Books</title>
</head>
<body>
<div align="center">
    <h1>All Books</h1>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Author</th>
            <th>Date Of Issue</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.dateOfIssue}</td>
                <td>${book.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
