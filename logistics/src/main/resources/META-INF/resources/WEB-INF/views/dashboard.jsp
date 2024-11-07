<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ecom.logistics.model.User" %> <!-- Assuming you have a User class in this package -->
<%@ include file="navbar.jsp" %> <!-- Include navbar here -->
<!DOCTYPE html>
<html>
<head>
    <title>Logistics User Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container-fluid">
        <nav class="navbar navbar-light bg-light mb-4">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Logistics User Dashboard</a>
            </div>
        </nav>
        <div class="row mt-4">
            <div class="col-sm-3"></div>
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        Add New User
                    </div>
                    <div class="card-body">
                        <form method="post" action="/add-user">
                            <div class="form-group row">
                                <label for="username" class="col-sm-2 col-form-label">Username</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
                                </div>
                            </div>
                            <div class="form-group row mt-2">
                                <label for="password" class="col-sm-2 col-form-label">Password</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                                </div>
                            </div>
                            <div class="form-group row mt-2">
                                <label for="email" class="col-sm-2 col-form-label">Email</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
                                </div>
                            </div>
                            <input type="submit" value="Add User" class="btn btn-primary mt-3">
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-sm-3"></div>
        </div>

        <div class="row mt-4">
            <div class="col-sm-12">
                <div class="card">
                    <div class="card-header">
                        User List
                    </div>
                    <div class="card-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>User ID</th>
                                    <th>Username</th>
                                    <th>Email</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% 
                                    List<User> users = (List<User>) request.getAttribute("listUsers");
                                    if (users != null) {
                                        for (User user : users) {
                                %>
                                <tr>
                                    <td><%= user.getUserId() %></td>
                                    <td><%= user.getUsername() %></td>
                                    <td><%= user.getEmail() %></td>
                                    <td>
                                        <a href="/soft-delete-user?id=<%= user.getUserId() %>" class="btn btn-warning btn-sm">Soft Delete</a>
                                        <a href="/delete-user?id=<%= user.getUserId() %>" class="btn btn-danger btn-sm">Delete</a>
                                    </td>
                                </tr>
                                <% 
                                        }
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
