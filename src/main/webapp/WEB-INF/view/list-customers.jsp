<%--
  Created by IntelliJ IDEA.
  User: ekenk
  Date: 7/9/2022
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<html>
    <head>
        <title>List Customers</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div id="wrapper">
                <div id="header">
                    <h2>CRM - Customer Relationship Manager</h2>
                </div>
            </div>
            <div id="container">
                <div id="content">
                    <div class="row">
                        <a class="btn btn-primary col-2" href="showFormForAdd" role="button">Add Customer</a>
                        <!--  add a search box -->
                        <div class="col-10">
                            <form action="/customer/search" method="GET" class="form-inline row mb-0">
                                <div class="col-6">
                                    <input type="text" placeholder="Search" class="form-control" name="searchName" />
                                </div>
                                <input type="submit" value="Search" class="btn btn-outline-secondary col-2" />
                            </form>
                        </div>
                    </div>
                    <table class="table table-striped table-hover mt-4">
                        <thead class="table-dark">
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${customerList.size() > 0}">
                                    <c:forEach var = "tempCustomer" items="${customerList}">
                                        <tr>
                                            <td>${tempCustomer.firstName}</td>
                                            <td>${tempCustomer.lastName}</td>
                                            <td>${tempCustomer.email}</td>
                                            <td>
                                                <a href="/customer/showFormForUpdate?customerId=${tempCustomer.id}">Update</a>
                                                <span> | </span>
                                                <a href="/customer/delete?customerId=${tempCustomer.id}"
                                                   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
                                                    Delete
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td>No customers with given search.</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
