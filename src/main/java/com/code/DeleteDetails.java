package com.code;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DeleteDetails
 */
@WebServlet("/DeleteDetails")
public class DeleteDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		com.coder.dao.DeleteDetails.delete(id);	//calling delete method from DeleteDetails class of com.coder.dao package
		response.sendRedirect("ShowDetails");
	}



}
