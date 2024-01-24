package com.gymmgmt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gymmgmt.service.ParticipantsService;

/**
 * Servlet implementation class DeleteParticipantController
 */
@WebServlet("/DeleteParticipantController")
public class DeleteParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteParticipantController() {
        super();
        // TODO Auto-generated constructor stub
    }
    ParticipantsService ps = new ParticipantsService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		int id =Integer.parseInt(request.getParameter("id"));
		String result = ps.deleteById(id);
		pw.println("<script type=\"text/javascript\">");
		if(result.equalsIgnoreCase("deleted"))
			pw.println("alert('Successfully deleted.');");
		else
			pw.println("alert('Failed to delete.');");
		pw.println("</script>");
		response.sendRedirect("ViewParticipantController");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
