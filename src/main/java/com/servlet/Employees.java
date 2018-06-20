package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.GetEmployees;
import com.bean.Employee;

@WebServlet("/Employees")
public class Employees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Employees() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> list = new GetEmployees().getEmployees();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table>");
		for(Employee emp : list) {
			out.println("<tr>");
			out.println("<td>");
			out.println("Employee Name: "+emp.getName());
			out.println("</td>");
			out.println("<td>");
			out.println("Employee Id: "+emp.getId());
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
