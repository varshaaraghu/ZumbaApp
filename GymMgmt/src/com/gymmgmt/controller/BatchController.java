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
import com.gymmgmt.service.BatchService;

@WebServlet("/BatchController")
public class BatchController extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
	   BatchService bs = new BatchService();
	    public BatchController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Batch> listOfBatchAndStudentInfo = bs.findAllBatch();
		HttpSession hs = request.getSession();
		hs.setAttribute("listBP", listOfBatchAndStudentInfo);
		response.sendRedirect("batchInfo.jsp");
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter pw = response.getWriter();
			int batchId = Integer.parseInt(request.getParameter("batchid"));
			String typeofbatch = request.getParameter("typeofbatch");
			String time = request.getParameter("time");
			int result = 0;
			try {
				Batch batch = new Batch(batchId, typeofbatch, time);				
				 result  = bs.storeBatch(batch);
				int totalCount = bs.getTotalCountByBatch(batchId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpSession hs = request.getSession();
			hs.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("batchResults.jsp");
			rd.include(request, response);
			
			response.setContentType("text/html");
			
		}
}
