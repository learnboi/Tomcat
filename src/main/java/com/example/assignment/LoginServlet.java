package com.example.assignment;

import java.io.*;
import java.sql.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        PrintWriter pw = response.getWriter();
        RequestDispatcher rd;
        if(Username.equals("admin") && Password.equals("admin")){
            EmployeeData ed = new EmployeeData();
            try {
                List<Employee> employeeList = ed.fetchemployeedata();
                request.setAttribute("list",employeeList);
                rd = request.getRequestDispatcher("Employeedata.jsp");
                rd.forward(request,response);
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        } else{
            try {
                String url ="jdbc:mysql://localhost:3306/login";
                String username = "root";
                String password = "root";

                try (Connection conn = DriverManager.getConnection(url, username, password)) {
                    String sql = "SELECT username, password FROM logindata WHERE username = ?";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setString(1, Username);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        String storedPassword = resultSet.getString("password");
                        if (Password.equals(storedPassword)) {
                            rd = request.getRequestDispatcher("/Welcome.jsp");
                            rd.forward(request,response);
                        } else {
                            rd = request.getRequestDispatcher("/Error.html");
                            rd.forward(request,response);
                        }
                    } else {
                        rd = request.getRequestDispatcher("/Error.html");
                        rd.forward(request,response);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
