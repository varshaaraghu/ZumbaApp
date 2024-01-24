package com.gymmgmt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gymmgmt.bean.Batch;
import com.gymmgmt.bean.Participants;
import com.gymmgmt.service.ParticipantsService;

/**
 * Servlet implementation class viewParticipantController
 */
@WebServlet("/ViewParticipantController")
public class ViewParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewParticipantController() {
        super();
        // TODO Auto-generated constructor stub
    }
    ParticipantsService ps = new ParticipantsService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Participants> listOfParticipantsStudentInfo = ps.findAllParticipant();
		HttpSession hs = request.getSession();
		hs.setAttribute("listParticipants", listOfParticipantsStudentInfo);
		response.sendRedirect("participantsInfo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
