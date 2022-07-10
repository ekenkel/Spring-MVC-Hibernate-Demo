package com.ekenkel.dbTest;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // setup connection variables
        String user = "springstudent";
        String pass = "springstudent";

        String schemaName = "web_customer_tracker";
        String jdbcUrl = "jdbc:mysql://localhost:3306/" + schemaName + "?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";
        // get connection to database
        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to db: " + jdbcUrl);

            Class.forName(driver);

            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);

            out.println("Connection successful.");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
        //
    }
}
