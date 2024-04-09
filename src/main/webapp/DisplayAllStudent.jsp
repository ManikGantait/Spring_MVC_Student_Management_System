<%@page import="com.spring.mvc.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Student> students = (List) request.getAttribute("studentList");
	%>
	<table border="">
		<thead>
			<tr>
			<th>Student Id</th>
			<th>Student Name</th>
			<th>Student Email</th>
			<th>Student Marks</th>
			<th>Social Profile</th>
			<th>Update</th>
			<th>Delete</th>
			</tr>
		</thead>
		<tbody>
		<%for(Student student:students){ %>
		<tr>
		<td><%=student.getStudentId() %></td>
		<td><%=student.getStudentName() %></td>
		<td><%= student.getStudentEmail()%></td>
		<td><%=student.getStudentMarks() %></td>
		<td><a href="viewProfile?studentId=<%=student.getStudentId() %>">View</a></td>
		<td><a href="update?studentId=<%=student.getStudentId()%>">Update</a></td>
		<td><a href="delete?studentId=<%=student.getStudentId()%>">delete</a></td>
		</tr>
		</tbody>
<%} %>
	</table>

<h2><a href="home.jsp">Go Back To Home</a></h2>
</body>
</html>