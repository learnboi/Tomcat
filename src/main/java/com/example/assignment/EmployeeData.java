package com.example.assignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    public List<Employee> fetchemployeedata() throws SQLException {
        List<Employee> employeeslist = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/login";
        String user = "root";
        String pass = "root";
        Connection conn = DriverManager.getConnection(url,user,pass);
        String Sql = "SELECT * FROM employeedata;";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(Sql);
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String city = resultSet.getString("city");
            Employee e = new Employee();
            e.setId(id);
            e.setName(name);
            e.setCity(city);
            employeeslist.add(e);
        }
        return employeeslist;
    }
}
