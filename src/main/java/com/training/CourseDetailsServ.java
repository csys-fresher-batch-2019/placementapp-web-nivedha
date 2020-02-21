package com.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainingproject.dao.impl.CourseDAOImpl;
import com.trainingproject.logger.Logger;
import com.trainingproject.model.Course;

@WebServlet("/CourseDetailsServ")

public class CourseDetailsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private static final Logger log=Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Course> list=new ArrayList<Course>();
		 PrintWriter out=response.getWriter();
		String courseName = request.getParameter("courseName");
		CourseDAOImpl obj=new CourseDAOImpl();
		try {
			list= obj.allCourseDetails(courseName);
			log.getInput(list);
			out.println(list);
			request.setAttribute("COURSE_LIST", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("CourseDetails.jsp");
		dispatcher.forward(request, response);
		
	
	
	}

	

}
