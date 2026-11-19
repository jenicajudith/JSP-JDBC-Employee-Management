<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>

    <h2>Employee Details</h2>

    <table border="1" cellpadding="10">

        <tr>
            <th>Employee ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Email</th>
        </tr>

        <%
        ArrayList<Employee> list =
            (ArrayList<Employee>) request.getAttribute("employees");

        if(list != null) {

            for(Employee emp : list) {
        %>

        <tr>
            <td><%= emp.getEmpid() %></td>
            <td><%= emp.getName() %></td>
            <td><%= emp.getAge() %></td>
            <td><%= emp.getDepartment() %></td>
            <td><%= emp.getSalary() %></td>
            <td><%= emp.getEmail() %></td>
        </tr>

        <%
            }
        }
        %>

    </table>

    <br>

    <a href="EmployeeRegister.jsp">Back to Registration</a>

</body>
</html>
