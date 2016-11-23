<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page session="false" %>
<html>
<head>
    <title>Users Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }

    </style>

</head>
<body>
<a href="../../index.jsp">Back to main menu</a>
<br/>
<br/>

<a href="/fill"> Fill data</a>

<br/>
<br/>

<h2>Add a User</h2>

<c:url var="addAction" value="/user/add"/>

<form:form action="${addAction}" commandName="user">
    <div class="container">

        <form:label path="id">
            <spring:message text="ID:    "/>
        </form:label>
        <form:input path="id" readonly="true" size="8" disabled="true"/>
        <form:hidden path="id"/>


        <form:label path="admin">
            <spring:message text="is Admin?:"/>
        </form:label>
        <form:checkbox path="admin"/>

        <br/>
        <br/>
        <form:label path="name">
            <spring:message text="Name:  "/>
        </form:label>
        <form:input path="name"/>

        <br/>
        <br/>
        <form:label path="age">
            <spring:message text="Age:   "/>
        </form:label>
        <form:input path="age"/>

        <c:if test="${empty user.name}">
            <button type="submit" class="btn btn-success" size="Big">Add user</button>
        </c:if>

        <c:if test="${!empty user.name}">
            <button type="submit" class="btn btn-warning" size="Big">Edit user</button>
        </c:if>
    </div>

</form:form>

<h2>User List</h2>

<c:if test="${!empty listUsers}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="80">Age</th>
            <th width="60">Admin</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listUsers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td><a href="/userdata/${user.id}" target="_blank">${user.name}</a></td>
                <td>${user.age}</td>
                <td>${user.admin}</td>
                <td><a href="<c:url value='/edit/${user.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${user.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
