
package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import service.Empservice;

@WebServlet("/Empcontroller")
public class Empcontroller extends HttpServlet {

    Empservice service = new Empservice();

    // REGISTER, UPDATE, DELETE AND SEARCH
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // 1. ADD EMPLOYEE
        if ("add".equals(action)) {

            int empid = Integer.parseInt(request.getParameter("empid"));
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String department = request.getParameter("department");
            double salary = Double.parseDouble(request.getParameter("salary"));
            String email = request.getParameter("email");

            Employee emp = new Employee(empid, name, age,
                    department, salary, email);

            boolean result = service.addEmployee(emp);

            if (result) {
                request.setAttribute("message", "Employee added successfully!");
            } else {
                request.setAttribute("message", "Employee registration failed!");
            }

            request.getRequestDispatcher("EmployeeRegister.jsp")
                    .forward(request, response);
        }

        // 2. UPDATE EMPLOYEE
        else if ("update".equals(action)) {

            int empid = Integer.parseInt(request.getParameter("empid"));
            String department = request.getParameter("department");
            double salary = Double.parseDouble(request.getParameter("salary"));

            boolean result = service.updateEmployee(empid, department, salary);

            if (result) {
                request.setAttribute("message", "Employee updated successfully!");
            } else {
                request.setAttribute("message", "Employee update failed!");
            }

            request.getRequestDispatcher("EmployeeUpdate.jsp")
                    .forward(request, response);
        }

        // 3. DELETE EMPLOYEE
        else if ("delete".equals(action)) {

            int empid = Integer.parseInt(request.getParameter("empid"));

            boolean result = service.deleteEmployee(empid);

            if (result) {
                response.sendRedirect("Empcontroller?action=view");
            } else {
                request.setAttribute("message", "Employee not found!");
                request.getRequestDispatcher("EmployeeDelete.jsp")
                        .forward(request, response);
            }
        }

        // 4. SEARCH BY DEPARTMENT
        else if ("search".equals(action)) {

            String department = request.getParameter("department");

            ArrayList<Employee> list =
                    service.searchByDepartment(department);

            request.setAttribute("employees", list);

            request.getRequestDispatcher("EmployeeSearch.jsp")
                    .forward(request, response);
        }
    }

    // DISPLAY ALL EMPLOYEES
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("view".equals(action)) {

            ArrayList<Employee> list = service.viewEmployees();

            request.setAttribute("employees", list);

            request.getRequestDispatcher("EmployeeView.jsp")
                    .forward(request, response);
        }
    }
}
