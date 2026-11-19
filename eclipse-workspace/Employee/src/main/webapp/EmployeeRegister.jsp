
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Registration</title>
</head>
<body>

    <h2>Employee Registration</h2>

    <form action="${pageContext.request.contextPath}/Empcontroller"
          method="post">

        <input type="hidden" name="action" value="add">

        Employee ID:
        <input type="number" name="empid" required>
        <br><br>

        Name:
        <input type="text" name="name" required>
        <br><br>

        Age:
        <input type="number" name="age" required>
        <br><br>

        Department:
        <input type="text" name="department" required>
        <br><br>

        Salary:
        <input type="number" name="salary" step="0.01" required>
        <br><br>

        Email:
        <input type="email" name="email" required>
        <br><br>

        <button type="submit">Register Employee</button>

    </form>

    <h3>${message}</h3>

    <br>

    <a href="${pageContext.request.contextPath}/Empcontroller?action=view">
        View All Employees
    </a>

</body>
</html>
