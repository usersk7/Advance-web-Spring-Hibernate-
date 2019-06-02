<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link
	href="${pageContext.request.contextPath}/WEB-INF/styles/mystyle.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/webjars/css/bootstrap.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
.errors {
	color: red;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	
	<div class="container"><h1>Add a Student</h1>
		<c:url var="addAction" value="/addStudent"></c:url>
		<div class="form-group">
		<form:form action="${addAction}" modelAttribute="student">
			<table class="table">
				<c:if test="${!empty student.studentId}">
					<tr>
						<td><form:label path="studentId">
								<spring:message text="Student ID" />
							</form:label></td>
						<td><form:input path="studentId" readonly="true" size="8"
								disabled="true" /> <form:hidden path="studentId" /></td>
					</tr>
				</c:if>
				<tr>
					<td><form:label path="name">
							<spring:message text="Student Name" />
						</form:label></td>
					<td><form:input path="name" /> 
					<form:errors path="name"
							cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="country">
							<spring:message text="Country Name" />
						</form:label></td>
					<td><form:input path="country" /> <form:errors path="country"
							cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td colspan="2"><c:if test="${!empty student.name}">
							<input class="btn btn-warning" type="submit"
								value="<spring:message 
					text="Edit Student"/>" />
						</c:if> <c:if test="${empty student.name}">
							<input type="submit" class="btn btn-primary"
								value="<spring:message 
					text="Add Student"/>" />
						</c:if></td>
				</tr>
			</table>
			<img src="${pageContext.request.contextPath}/webjars/images/spring-logo.png" class="img-circle" height=100px width=100px alt="Spring Terre">
		</form:form>
		</div>
<div class="con"></div>
		<c:if test="${!empty studentList}">
		<h3>List of Students</h3>
			<table class="table">
				<tr>
					<th width="80">Student ID</th>
					<th width="120">Student Name</th>
					<th width="120">Student Country</th>
					<th width="60">Edit &nbsp;&nbsp;&nbsp;Delete</th>
				</tr>
				<c:forEach items="${studentList}" var="student">
					<tr>
						<td>${student.studentId}</td>
						<td>${student.name}</td>
						<td>${student.country}</td>
						<td><button class="btn btn-warning">
								<a href="${pageContext.request.contextPath}/editStudent/${student.studentId}" style="color:black">Edit</a>
							</button>&nbsp;<button class="btn btn-danger">
								<a href="
			<c:url value='/removeStudent/${student.studentId}' />" style="color:black">Delete</a>
							</button></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>