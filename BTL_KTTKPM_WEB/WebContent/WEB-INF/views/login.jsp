<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css" type="text/css"
	rel="stylesheet"> --%>

<link href="${pageContext.request.contextPath }/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/bootstrap/css/sb-admin.css" rel="stylesheet">	
<!-- CSS được tối ưu và biên dịch mới nhất -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
 
<!-- Thư viện jQuery (dammio.com) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
 
<!-- JavaScript biên dịch mới nhất -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>


<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/jquery-3.5.1.min.js"></script> --%>
<title>Login</title>
</head>
<body class="bg-dark">

	<!-- Header -->
	<%@ include file="web/_header.jsp" %>

	<div class="container">
			<div class="card card-login mx-auto  mt-5 col-5">
		      <div class="card-header">Login</div>
		      <div class="card-body">
		        <form action="${pageContext.request.contextPath }/login" method="Post" >
		        	<input type="hidden" name="redirectId" value="${param.redirectId}" />
		          <div class="form-group">
		            <div class="form-label-group">
		              <input type="tel" id="inputEmail" name="username" class="form-control" placeholder="User Name" required="required" autofocus="autofocus">
		              <label for="inputEmail">User Name</label>
		            </div>
		          </div>
		          <div class="form-group">
		            <div class="form-label-group">
		              <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="required">
		              <label for="inputPassword">Password</label>
		            </div>
		          </div>
		          <div class="form-group">
		            <div class="checkbox">
		              <label>
		                <input type="checkbox" value="remember-me">
		                Remember Password
		              </label>
		            </div>
		          </div>
		          <p style="color: red;">${errorMessage}</p>
		          <button type="submit" class="btn btn-primary btn-block">Login</button>
		        </form>
		        <div class="text-center">
		          <a class="d-block small mt-3" href="${pageContext.request.contextPath }/register">Register an Account</a>
		          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
		        </div>
		      </div>
		    </div>
 	 </div>

<!-- srcipt -->
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script> --%>
<script src="<c:url value='${pageContext.request.contextPath }/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js'/>">"</script>

<script src="${pageContext.request.contextPath }/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>
</html>