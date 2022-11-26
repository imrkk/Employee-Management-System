package com.code;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coder.beans.AddEmpDetails;
import com.coder.dao.SelectDetails;


@WebServlet("/ShowDetails")
public class ShowDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<a href='index.html'>Add New Employee</a>");
		out.println("<h1>Employees List</h1>");
		
		List<AddEmpDetails> list = SelectDetails.getAllEmployees();  // calling  "SelectDetails" class in which we have made getAllEmployees() method
		
		
		out.println("<table border='1' id='customers' ");
		out.println("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Address</th><th>City</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		for(AddEmpDetails e: list) {
			out.println("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+
		    e.getEmail()+"</td><td>"+e.getAddress()+"</td><td>"+e.getCity()+"</td><td>"+e.getCountry()+"</td><td><a href='UpdateDetailsSer?id="+e.getId()+"'>edit</a></td><td><a href='DeleteDetails?id="+e.getId()+"'>delete</a></td></tr>");
		}
		out.println("<table>");
		
		out.close();
	}

}
