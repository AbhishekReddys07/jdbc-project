package com.BrightChamps.Servlets;


import java.io.IOException;

import com.BrightChamps.Dao.User_registration_dao;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Get the email and password from the login form
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Use User_registration_dao to check if user exists in the database
        User_registration_dao dao = new User_registration_dao();
        String result = dao.checkUserCredentials(email, password);

        if (result.equals(email)) {
            // User exists, redirect to success page or dashboard
            res.getWriter().write("Data is present in DB");; // Replace with actual success page
        } else {
            // User does not exist, redirect to the registration page
            res.sendRedirect("register.html");
        }
    }
}
