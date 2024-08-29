package com.BrightChamps.Servlets;

import java.io.IOException;

import com.BrightChamps.Dao.User_registration_dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	  /**
	 * 
	 */
	private static final long serialVersionUID = -1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        // Retrieve form parameters
	        String username = req.getParameter("name");
	        String email = req.getParameter("email");
	        String password = req.getParameter("password");

	        // Print the received values to the server console
	        System.out.println("Name: " + username);
	        System.out.println("Email: " + email);
	        System.out.println("Password: " + password);

	        // Create an instance of Connect_DB_register and save to the database
       User_registration_dao dbRegister = new User_registration_dao();
       dbRegister.saveToDatabase(username,email,password); // Call method to save to database

	        // Send response back to the client
	        res.sendRedirect("login.html");
	    }
	


}
