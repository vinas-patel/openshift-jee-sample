package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckConnection")
public class CheckConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckConnection() {
        super();
    }
	String host = "mysql";
	String port = "3306";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		String result = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/test","empcrud","empcrud");
			if(con!=null)
				result = "Connected !";
		} catch (ClassNotFoundException | SQLException e) {
				result = "Connection Error: " + e.getMessage();
				e.printStackTrace();
		} finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					result = "Error while clossing Connection " + e.getMessage();
				}
		}
		response.getWriter().write(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
