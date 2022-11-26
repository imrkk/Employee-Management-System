package com.code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coder.beans.AddEmpDetails;
import com.coder.dao.SelectDetails;


@WebServlet("/UpdateDetailsSer")
public class UpdateDetailsSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Update Employee</h1>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		AddEmpDetails e = SelectDetails.getEmployeeById(id);
		
		out.println("<form action='UpdateDetails2' method='post'>");
		out.println("<table>");
		out.println("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"' /></td></tr>");
		out.println("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"' /></td></tr>");
		out.println("<tr><td>Password:</td><td><input type='text' name='password' value='"+e.getPassword()+"' /></td></tr>");
		out.println("<tr><td>Email:</td><td><input type='text' name='email' value='"+e.getEmail()+"' /></td></tr>");
		out.println("<tr><td>Address:</td><td><input type='text' name='address' value='"+e.getAddress()+"' /></td></tr>");
		
		out.println("<tr><td>City:</td><td>");
		out.println("<select name='city' style='width:150px'>");
		out.println("<option>option</option>");
		out.println("<option>Delhi</option>");
		out.println("<option>Mumbai</option>");
		out.println("<option>Bhopal</option>");
		out.println("<option>other</option>");
		out.println("</select>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Country:</td><td>");
		out.println("<select name='country' style='width:150px'>");
		out.println("<option>option</option>");
		out.println("<option>INDIA</option>");
		out.println("<option>USA</option>");
		out.println("<option>SA</option>");
		out.println("<option>other</option>");
		out.println("</select>");
		out.println("</td></tr>");
		
		
		
		out.println("</form>");
	}



}
