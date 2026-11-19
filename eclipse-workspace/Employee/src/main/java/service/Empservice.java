
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Employee;
import model.Dbconnection;

public class Empservice {

    // 1. ADD EMPLOYEE
    public boolean addEmployee(Employee emp) {

        boolean status = false;

        try {
            Connection con = Dbconnection.dbconnection();

            String query = "insert into employee(empid,name,age,department,salary,email) values(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, emp.getEmpid());
            ps.setString(2, emp.getName());
            ps.setInt(3, emp.getAge());
            ps.setString(4, emp.getDepartment());
            ps.setDouble(5, emp.getSalary());
            ps.setString(6, emp.getEmail());

            int result = ps.executeUpdate();

            if(result > 0) {
                status = true;
            }

            ps.close();
            con.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return status;
    }


    // 2. DISPLAY ALL EMPLOYEES
    public ArrayList<Employee> viewEmployees() {

        ArrayList<Employee> list = new ArrayList<>();

        try {
            Connection con = Dbconnection.dbconnection();

            String query = "select * from employee";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Employee emp = new Employee(
                    rs.getInt("empid"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("department"),
                    rs.getDouble("salary"),
                    rs.getString("email")
                );

                list.add(emp);
            }

            rs.close();
            ps.close();
            con.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }


    // 3. UPDATE EMPLOYEE
    public boolean updateEmployee(int empid, String department, double salary) {

        boolean status = false;

        try {
            Connection con = Dbconnection.dbconnection();

            String query = "update employee set department=?, salary=? where empid=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, department);
            ps.setDouble(2, salary);
            ps.setInt(3, empid);

            int result = ps.executeUpdate();

            if(result > 0) {
                status = true;
            }

            ps.close();
            con.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return status;
    }


    // 4. DELETE EMPLOYEE
    public boolean deleteEmployee(int empid) {

        boolean status = false;

        try {
            Connection con = Dbconnection.dbconnection();

            String query = "delete from employee where empid=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, empid);

            int result = ps.executeUpdate();

            if(result > 0) {
                status = true;
            }

            ps.close();
            con.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return status;
    }


    // 5. SEARCH EMPLOYEE BY DEPARTMENT
    public ArrayList<Employee> searchByDepartment(String department) {

        ArrayList<Employee> list = new ArrayList<>();

        try {
            Connection con = Dbconnection.dbconnection();

            String query = "select * from employee where department=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, department);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Employee emp = new Employee(
                    rs.getInt("empid"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("department"),
                    rs.getDouble("salary"),
                    rs.getString("email")
                );

                list.add(emp);
            }

            rs.close();
            ps.close();
            con.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
}
