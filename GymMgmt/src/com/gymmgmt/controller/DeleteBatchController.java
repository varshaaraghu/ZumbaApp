package com.gymmgmt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gymmgmt.service.BatchService;

/**
 * Servlet implementation class DeleteBatchController
 */
@WebServlet("/DeleteBatchController")
public class DeleteBatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BatchService bs = new BatchService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBatchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		int id =Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String result = bs.deleteById(id);
		pw.println("<script type=\"text/javascript\">");
		if(result.equalsIgnoreCase("deleted"))
			pw.println("alert('Successfully deleted.');");
		else
			pw.println("alert('Failed to delete.');");
		pw.println("</script>");
		response.sendRedirect("BatchController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
