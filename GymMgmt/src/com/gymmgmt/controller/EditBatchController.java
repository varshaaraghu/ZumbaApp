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

/**
 * Servlet implementation class EditBatchController
 */
@WebServlet("/EditBatchController")
public class EditBatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BatchService bs = new BatchService();
       
    /**
     * @ see HttpServlet#HttpServlet()
     */
    public EditBatchController() {
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
		
		
		HttpSession hs = request.getSession();
	
		hs.setAttribute("batchid",id);
		

//		pw.println("<script type=\"text/javascript\">");
//		pw.println("alert('Successfully deleted');");
//		pw.println("</script>");
		
		RequestDispatcher rd = request.getRequestDispatcher("editBatchInfo.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs = request.getSession();
		int batchId = Integer.parseInt(request.getParameter("batchid"));
		String typeofbatch = request.getParameter("typeofbatch");
		String time = request.getParameter("time");
		Batch pp = new Batch();
		pp.setBatchType(typeofbatch);
		pp.setTime(time);
		pp.setBatchid(batchId);
		int result = bs.updateBatchDetails(pp);			
		hs.setAttribute("result", result);
		System.out.println(result);
		RequestDispatcher rd = request.getRequestDispatcher("batchResults.jsp");
		rd.include(request, response);
	
	
	response.setContentType("text/html");
	}

}
