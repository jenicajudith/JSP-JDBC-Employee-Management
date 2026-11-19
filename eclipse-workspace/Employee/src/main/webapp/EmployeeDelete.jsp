<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <title>Delete Employee</title>
</head>
<body>

    <h2>Delete Employee</h2>

    <form action="${pageContext.request.contextPath}/Empcontroller"
          method="post">

        <input type="hidden" name="action" value="delete">

        Employee ID:
        <input type="number" name="empid" required>
        <br><br>

        <button type="submit"
                onclick="return confirm('Are you sure you want to delete this employee?')">
            Delete Employee
        </button>

    </form>

    <h3>${message}</h3>

    <br>
    <a href="EmployeeRegister.jsp">Back to Registration</a>

</body>
</html>
