<%@page import="com.spring.mvc.entity.Student"%>
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
	Student student = (Student) request.getAttribute("student");
	%>
	
	<form action="saveUpdateStudent">
Enter Student Id: <input type="text" name="studentId" value="<%= student.getStudentId()%>"> <br><br>
Enter Student Name: <input type="text" name="studentName" value="<%= student.getStudentName()%>"> <br><br>
Enter Student Email: <input type="text" name="studentEmail" value="<%= student.getStudentEmail()%>"><br><br>
Enter Student Marks: <input type="text" name="studentMarks" value="<%= student.getStudentMarks()%>"><br><br>
<input type="submit" value="Update" > 
	

</body>
</html>