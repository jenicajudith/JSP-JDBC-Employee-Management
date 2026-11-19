<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>

    <h2>Update Employee Details</h2>

    <form action="${pageContext.request.contextPath}/Empcontroller"
          method="post">

        <input type="hidden" name="action" value="update">

        Employee ID:
        <input type="number" name="empid" required>
        <br><br>

        New Department:
        <input type="text" name="department" required>
        <br><br>

        New Salary:
        <input type="number" name="salary" step="0.01" required>
        <br><br>

        <button type="submit">Update Employee</button>

    </form>

    <h3>${message}</h3>

    <br>
    <a href="EmployeeRegister.jsp">Back to Registration</a>

</body>
</html>
