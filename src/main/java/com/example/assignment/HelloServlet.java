package com.example.assignment;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/login")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        PrintWriter pw = response.getWriter();
        RequestDispatcher rd;
        if(Username.equals("admin") && Password.equals("admin")){
            pw.write("<h1>Hello " + Password + "</h1>");
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
                            rd = request.getRequestDispatcher("/Welcome.html");
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
