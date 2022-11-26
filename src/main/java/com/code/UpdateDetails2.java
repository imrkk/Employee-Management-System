package com.code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coder.beans.AddEmpDetails;
import com.coder.dao.SaveDetails;
import com.coder.dao.UpdateDetails;

/**
 * Servlet implementation class UpdateDetails2
 */
@WebServlet("/UpdateDetails2")
public class UpdateDetails2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		
		AddEmpDetails e = new AddEmpDetails();    
		e.setId(id);
		e.setName(name);
		e.setName(password);
		e.setName(email);
		e.setName(address);
		e.setName(city);
		e.setName(country);
		
		
		int status = UpdateDetails.update(e);   //calling update method from updatedetails class
		if(status > 0) {					
			response.sendRedirect("ShowDetails");
		}else {
			out.println("<p1>Sorry! unable to update record</p>");
		}
		
		out.close();
		
	}

}
