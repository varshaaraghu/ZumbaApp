package com.gymmgmt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gymmgmt.bean.Batch;
import com.gymmgmt.bean.Participants;
import com.gymmgmt.service.BatchService;
import com.gymmgmt.service.ParticipantsService;

/**
 * Servlet implementation class EditParticipantController
 */
@WebServlet("/EditParticipantController")
public class EditParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ParticipantsService ps = new ParticipantsService();
	   BatchService bs = new BatchService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditParticipantController() {
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
		Participants participant = ps.findParticipantById(id);
		String time= bs.findBatchTime(participant.getBatchid());
		List<Batch> listOfBatch = bs.findAllBatch();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("pid",participant.getParticipantId());
		hs.setAttribute("pname",participant.getParticipantName());
		hs.setAttribute("age",participant.getParticipantAge());
		hs.setAttribute("phonenumber",participant.getPhoneNumber());
		hs.setAttribute("batchid",participant.getBatchid());
		hs.setAttribute("time",time);
		hs.setAttribute("listOfBatch", listOfBatch);

//		pw.println("<script type=\"text/javascript\">");
//		pw.println("alert('Successfully deleted');");
//		pw.println("</script>");
		
		RequestDispatcher rd = request.getRequestDispatcher("editParticipantInfo.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			HttpSession hs = request.getSession();
			String pname = request.getParameter("pname");
			int age =Integer.parseInt(request.getParameter("age"));
			String phonenumber = request.getParameter("phonenumber");
			int batchid = Integer.parseInt(request.getParameter("batchid"));
			Participants pp = new Participants();
			pp.setParticipantName(pname);
			pp.setParticipantAge(age);
			pp.setPhoneNumber(phonenumber);
			pp.setBatchid(batchid);
			int result = ps.updateParticipantDetails(pp,(int)hs.getAttribute("pid"));			
			hs.setAttribute("result", result);
			System.out.println(result);
			RequestDispatcher rd = request.getRequestDispatcher("participantsResults.jsp");
			rd.include(request, response);
		
		
		response.setContentType("text/html");
	}

}
