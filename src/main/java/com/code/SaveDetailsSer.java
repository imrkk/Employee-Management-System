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


@WebServlet("/SaveDetailsSer")
public class SaveDetailsSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		
		AddEmpDetails e = new AddEmpDetails();    //calling "AddEmpDetails" class for getter and setter
		e.setName(name);
		e.setName(password);
		e.setName(email);
		e.setName(address);
		e.setName(city);
		e.setName(country);
		
		int status = SaveDetails.save(e);   // calling "SaveDetails" class where we have made "save" method 
		if(status > 0) {					//where "e" which is object here will save in that
			out.println("<p1>Record saved successfully!</p>");
		}else {
			out.println("<p1>Sorry! unable to save record</p>");
		}
		
		out.close();
		
	}

}
