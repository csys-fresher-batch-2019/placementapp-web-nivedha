package com.training;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainingproject.DbException;
import com.trainingproject.dao.impl.GradeDAOImpl;
import com.trainingproject.dao.impl.InterviewPerformanceDAOImpl;
import com.trainingproject.model.InterviewPerformance;

@WebServlet("/UpdateInterviewStatusServ")

public class UpdateInterviewStatusServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		InterviewPerformanceDAOImpl impl=new InterviewPerformanceDAOImpl();
		InterviewPerformance p=new InterviewPerformance();
		int interviewId=Integer.parseInt(request.getParameter("interviewid"));
		int marks=Integer.parseInt(request.getParameter("marks"));
		
        try {
			impl.updateInterviewMarks(marks,interviewId);
		} catch (DbException e) {
			e.printStackTrace();
		}
        GradeDAOImpl grade=new GradeDAOImpl();
        grade.updateStatus();
        response.sendRedirect("AllInterviewStatusServ");
       

	
	}

}
