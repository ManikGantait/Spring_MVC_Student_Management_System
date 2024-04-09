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
<%SocialProfile profile=(SocialProfile)request.getAttribute("profileData");
int studentId=(int)request.getAttribute("studentId");
%>

<form action="saveUpdateProfile">

<input type="text" name="studentId" value="<%=studentId%>" hidden>
	Enter Profile Id: <input type="text" name="profileId" value="<%= profile.getProfileId()%>" readonly="readonly"> <br>
	Enter Profile Name: <input type="text" name="profileName" value="<%=profile.getProfileName()%>"><br>
	Enter Profile Url : <input type="text" name="url" value="<%= profile.getUrl()%>"><br>
						<input type="submit" >
</form>

</body>
</html>