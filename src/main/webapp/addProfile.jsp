<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%int studentId=(int)request.getAttribute("studentId"); %>

<form action="saveProfile">
<h1>Addinf Profile For Student:<%= studentId%></h1>

<input type="text" name="studentId" value="<%= studentId%>" hidden>
	Enter Profile Id: <input type="text" name="profileId"> <br>
	Enter Profile Name: <input type="text" name="profileName"><br>
	Enter Profile Url : <input type="text" name="url"><br>
						<input type="submit" >
</form>
</body>
</html>