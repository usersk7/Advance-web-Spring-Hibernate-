<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Customer Page</title>	
	<link
	href="${pageContext.request.contextPath}/WEB-INF/webjars/css/bootstrap.css"
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
	<style>
.errors {
	color: red;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
<div class="container">
<h1>
	Add a Customer
</h1>
<c:url var="addAction" value="/customer/add" ></c:url>
<form:form action="${addAction}" 
	modelAttribute="customer">
<table border="1">
	<c:if test="${!empty customer.name}">
	<tr>
		<td>
			<form:label path="customerId">
				<spring:message text="Customer ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="customerId" readonly="true" 
			size="8"  disabled="true" />
			<form:hidden path="customerId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Customer Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
			<form:errors path="name" cssClass="errors"></form:errors>
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="Email"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
			<form:errors path="email" cssClass="errors"></form:errors>
		</td>
	</tr>
	<!-- name VARCHAR2(30),
  email VARCHAR2(70),
  age NUMBER,
  gender VARCHAR2(6),
  birthday DATE, 
  phone VARCHAR2(13)); -->
  <tr>
		<td>
			<form:label path="age">
				<spring:message text="Age"/>
			</form:label>
		</td>
		<td>
			<form:input path="age" />
			<form:errors path="age" cssClass="errors"></form:errors>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="gender">
				<spring:message text="Gender"/>
			</form:label>
		</td>
		<td>
		<form:radiobutton path="gender" value="MALE"/>MALE 
		<form:radiobutton path="gender" value="FEMALE"/>FEMALE 
			<form:errors path="gender" cssClass="errors"></form:errors>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="birthday">
				<spring:message text="Birthday(MM/dd/yyyy)"/>
			</form:label>
		</td>
		<td>
			<form:input path="birthday" />
			<form:errors path="birthday" cssClass="errors"></form:errors>
		</td>
	</tr>
		<tr>
		<td>
			<form:label path="phone">
				<spring:message text="Phone(eg:9879879876)"/>
			</form:label>
		</td>
		<td>
			<form:input path="phone" />
			<form:errors path="phone" cssClass="errors"></form:errors>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty customer.name}">
				<input type="submit" class="btn btn-success"
					value="<spring:message 
					text="Edit Customer"/>" />
			</c:if>
			<c:if test="${empty customer.name}">
				<input type="submit" class="btn btn-success"
					value="<spring:message 
					text="Add Customer"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
	<!-- 
	customer_Id NUMBER PRIMARY KEY,
  name VARCHAR2(30),
  email VARCHAR2(70),
  age NUMBER,
  gender VARCHAR2(6),
  birthday DATE, 
  phone VARCHAR2(13) -->
<h3>Customers List</h3>
<c:if test="${!empty listCustomers}">
	<table class="table">
	<tr>
		<th width="80">Customer ID</th>
		<th width="120">Customer Name</th>
		<th width="150">Email</th>
		<th width="20">Age</th>
		<th width="30">Gender</th>
		<th width="60">BirthDate</th>
		<th width="100">Phone</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listCustomers}" 
	var="customer">
		<tr>
			<td>${customer.customerId}</td>
			<td>${customer.name}</td>
			<td>${customer.email}</td>
			<td>${customer.age}</td>
			<td>${customer.gender}</td>
			<td>${customer.birthday}</td>
			<td>${customer.phone}</td>
			<td><button  class="btn btn-warning"><a href="
<c:url value='/editCustomer/${customer.customerId}' />" >
Edit</a></button></td>
			<td><button  class="btn btn-danger"><a href="
<c:url value='/removeCustomer/${customer.customerId}' />" >
Delete</a></button>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</div>
</body>
</html>
