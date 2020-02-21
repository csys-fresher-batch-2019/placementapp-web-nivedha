<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.trainingproject.dao.impl.InterviewScheduleDAOImpl" %>
        <%@ page import="com.trainingproject.model.InterviewSchedule" %>
            <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Interview Schedule</title>
</head>
<style>
body {
  background-image: url('assets/images/bg22.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: cover;
}
</style>
<body>
<h1 style="color:white; font-size:25px; font-family:courier; text-align:centre;">INTERVIEW SCHEDULES</h1>
<%
InterviewScheduleDAOImpl impl=new InterviewScheduleDAOImpl();
List<InterviewSchedule> list=(List <InterviewSchedule>)request.getAttribute("interview_schedule");
%>
<table border="1">
<thead>
<tr>
<th><h1 style="color:blue; font-size:25px; font-family:courier; text-align:centre;">Interview_Id</h1></th>
<th><h1 style="color:blue; font-size:25px; font-family:courier; text-align:centre;">Client_Id</h1></th>
<th><h1 style="color:blue; font-size:25px; font-family:courier; text-align:centre;">Job_Title</h1></th>
<th><h1 style="color:blue; font-size:25px; font-family:courier; text-align:centre;">Job_Requirement</h1></th>
<th><h1 style="color:blue; font-size:25px; font-family:courier; text-align:centre;">Interview_Date</h1></th>
<th><h1 style="color:blue; font-size:25px; font-family:courier; text-align:centre;">Interview_Time</h1></th>
</tr>
</thead>

<% for(InterviewSchedule i:list)
{%>
<tr>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getInterviewId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getClientId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getJobTitle()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getJobRequirement()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getInterviewDate()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getInterviewTime()%></h1></td>
<td><a href="AttendInterviewServ" button type="submit"><h1 style="color:red; font-size:20px; font-family:courier; text-align:centre;">ATTEND</a></td>

</tr>
<%HttpSession ses=request.getSession();
ses.setAttribute("Client_id",i.getClientId());%>
<%} %>

</table>
</body>
</html>