package com.training;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trainingproject.dao.impl.InterviewPerformanceDAOImpl;

//@WebServlet("/AttendInterviewServ")

public class AttendInterviewServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AttendInterviewServlet");
		InterviewPerformanceDAOImpl impl = new InterviewPerformanceDAOImpl();
		HttpSession sess = request.getSession();
		int clientId = Integer.parseInt(request.getParameter("Client_id"));
		String userIdStr = (String) sess.getAttribute("userid");
		int userId = Integer.parseInt(userIdStr);
		System.out.println(userIdStr);
		try {
			impl.addPerformanceDetails(clientId, userId);
			response.sendRedirect("ViewInterviewStatusServ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
