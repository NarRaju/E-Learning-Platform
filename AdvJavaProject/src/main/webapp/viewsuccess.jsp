<%@page import="java.util.List"%>
<%@page import="com.adv.user.UserData"%>
<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
table {
	margin: auto;
	text-align: center;
}

.container {
	width: 100%;
	background: linear-gradient(to top, rgba(0, 0, 0, 0.5) 50%,
		rgba(0, 0, 0, 0.5) 50%), url(websiteimage.jpg) 50%;
	background-position: center;
	background-size: cover;
	height: 109vh;
	color: white;
	text-align: center;
	margin-top: 20px;
}
</style>
</head>
<body>


	
		<h1>List of Users</h1>
		<a href="index.html" style="color: white;" class="style">HOME</a> 
					<a href="index.html" style="color: white;">ABOUT</a>
					<a href="registration.html" style="color: white;">REGISTRATION FORM</a>
					<a href="login.html" style="color: white;">APPLICATION LOGIN</a>
					<a href="resetlogin.html" style="color: white;">PASSWORD RESET</a>
					<a href="viewsuccess.jsp " style="color: white;">Services</a>
					 <input type="number" name="search"	placeholder="Searching ByName">
					 <a href="#"><button class="btn">SEARCH</button> </a> 
								<p></p>
								<p></p>
								<br>
								<p></p>
								<p></p>
								<br>
		<table border="1">
			<tr>
				<th>User Name</th>
				<th>Email</th>
				<th>Country</th>
				<th>Qualification</th>
				<th>Technologies</th>
				<th>Gender</th>
				<th>Address</th>
				<th>comments</th>
				<th>Action</th>
			</tr>

		
<%
List<UserData>users=(List<UserData>)request.getAttribute("users");
%>

			<c:forEach items="${users}" var="user">
				<tr>

					<td>${user.username}</td>
					<td>${user.email}</td>
					<td>${user.country}</td>
					<td>${user.qualification}</td>
					<td>${user.gender}</td>
					<td>${user.technologies}</td>
					<td>${user.address}</td>
					<td>${user.comments}</td>
					<td><a href="#"><button>Edit</button> </a> <a
						href="DeleteServlet?user=${ user.username}&linkname='delete'"><button>Delete</button>
					</a></td>

				</tr>
			</c:forEach>
		</table>
		<h1>
			<a href="index.html"><button>Home</button></a>
		</h1>
</body>
</html>