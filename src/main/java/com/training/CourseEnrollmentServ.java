package com.training;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trainingproject.DbException;
import com.trainingproject.dao.impl.UserCourseDAOImpl;
import com.trainingproject.model.UserCourse;

@WebServlet("/CourseEnrollmentServ")

public class CourseEnrollmentServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession ses=request.getSession(false);
		UserCourseDAOImpl impl1=new UserCourseDAOImpl();
		UserCourse course=(UserCourse) ses.getAttribute("userCourse");
		try {
			impl1.addCourseDurationDate(course);
			response.sendRedirect("UserCourseServ");
		} catch (DbException e) {
			e.printStackTrace();
		}
		System.out.println("Enrolled Successfully");
		
		}

	

}
