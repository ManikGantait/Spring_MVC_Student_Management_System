<%@page import="com.spring.mvc.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.spring.mvc.entity.SocialProfile"%>
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
	int studentId = (int) request.getAttribute("studentId");
	List<SocialProfile> profiles=(List<SocialProfile>)request.getAttribute("socialList");
	%>
	
	
	<h1><a href="addProfile?studentId=<%= studentId%>">Add Profiles</a></h1>
	
	
	<table>
	<thead>
		<tr>
		<th>Profile Id</th>
		<th>Profile name</th>
		<th>Profile Url</th>
		<th>Update</th>
		<th>Delete</th>
		</tr>
	</thead>
	<tbody>
	<%for(SocialProfile profile :profiles){ %>
		<tr>
			<td><%=profile.getProfileId() %></td>
			<td><%=profile.getProfileName() %></td>
			<td><a href="<%=profile.getUrl() %>">link</a></td>
			<td><a href="updateProfile?profileId=<%=profile.getProfileId()%>&studentId=<%= studentId%>">Update</a></td>
			<td><a href="deleteProfile?profileId=<%=profile.getProfileId()%>&studentId=<%= studentId%>">Delete</a></td>			
		</tr>
		
		<%} %>
	</tbody>
</table>
<h3><a href="fetchStudent">Go Back To Display All Student </a></h3>
</body>
</html>