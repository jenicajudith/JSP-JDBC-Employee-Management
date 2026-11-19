<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <title>Search Employee</title>
</head>
<body>

    <h2>Search Employees by Department</h2>

    <form action="${pageContext.request.contextPath}/Empcontroller"
          method="post">

        <input type="hidden" name="action" value="search">

        Department:
        <input type="text" name="department" required>

        <button type="submit">Search</button>

    </form>

    <br>

    <%
    ArrayList<Employee> list =
        (ArrayList<Employee>) request.getAttribute("employees");

    if(list != null) {

        if(!list.isEmpty()) {
    %>

    <h3>Search Results</h3>

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
        %>

    </table>

    <%
        } else {
    %>

    <h3>No employees found in this department.</h3>

    <%
        }
    }
    %>

    <br>
    <a href="EmployeeRegister.jsp">Back to Registration</a>

</body>
</html>
