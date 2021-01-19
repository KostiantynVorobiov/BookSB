<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Book</title>
</head>
<body>
<div align="center">
    <h2>New Book</h2>
    <form:form action="${pageContext.request.contextPath}/book" method="POST" modelAttribute="book">
        <table border="0" cellpadding="5">
            <tr>
                <td>Name: </td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Author: </td>
                <td><form:input path="author" /></td>
            </tr>
            <tr>
                <td>Date Of Issue: </td>
                <td><form:input path="dateOfIssue" /></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><form:input path="price" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
