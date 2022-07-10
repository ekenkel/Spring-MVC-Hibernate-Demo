<%--
  Created by IntelliJ IDEA.
  User: ekenk
  Date: 7/9/2022
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>New Customer</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h2>New Customer</h2>
            <form:form action="saveCustomer" modelAttribute="customer" method="post">
                <form:hidden path="id"></form:hidden>
                <table class="table table-striped">
                    <tbody>
                    <tr>
                        <td>
                            <label>First Name:</label>
                        </td>
                        <td>
                            <form:input path="firstName" cssClass="form-control"></form:input>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Last Name:</label>
                        </td>
                        <td>
                            <form:input path="lastName" cssClass="form-control"></form:input>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Email:</label>
                        </td>
                        <td>
                            <form:input path="email" cssClass="form-control"></form:input>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Save" class="btn btn-info">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form:form>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/customer/list" role="button">Back to List</a>
        </div>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
