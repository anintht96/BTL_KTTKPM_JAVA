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
<title>Dang Ky</title>
</head>
<body class="bg-dark">

	<!-- Header -->
	<%@ include file="_header.jsp" %>

	<div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
      	<form method="POSt" action="register">
        	<div class="form-group">
            	<div class="form-row">
              		<div class="col-md-6">
              	 		<div class="form-label-group">
                  			<input name="nameKhachHang" type="text" id="firstName" class="form-control" placeholder="Full name" required="required" autofocus="autofocus"/>
                  			<label for="firstName">Ten</label>
                		</div>
              		</div>
	              	<div class="col-md-6">
	                	<div class="form-label-group">
	                  		<input name="diaChi" type="text" id="diaChi" class="form-control" placeholder="Dia chi" required="required"/>
	                  		<label for="diaChi">Dia chi</label>
	                	</div>
	              	</div>
          	 	 </div>
          	</div>
          	<div class="form-group">
            	<div class="form-row">
              		<div class="col-md-6">
              	 		<div class="form-label-group">
                  			<input name="sdt" type="tel" id="sdt" class="form-control" placeholder="So dien thoai" required="required" autofocus="autofocus"/>
                  			<label for="sdt">So dien thoai</label>
                		</div>
              		</div>
	              	<div class="col-md-6">
	              		 <div class="form-check-inline" style="padding-top: 10px;">
	              		 	<div class=" form-check-inline">
	                		 <label class="form-check-label" for="radio1">Gioi Tinh:
	                		 	<input type="radio" name="gioiTinh" id="radio1" value="Nam"/>Nam &nbsp;
	                		 </label>
	                		</div>
	              		 </div>
	                	 <div class="form-check-inline">
	              		 	<div class=" form-check-inline">
	                		 <label class="form-check-label" for="radio2">
	                		 	<input type="radio" name="gioiTinh" value="Nu" id="radio2"/>Nu &nbsp;
	                		 </label>
	                		</div>
	              		 </div>
	              	</div>
          	 	 </div>
          	</div>
          	<div class="form-group">
           	 <div class="form-label-group">
              	<input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required="required"/>
             	 <label for="inputEmail">Email address</label>
          	  </div>
     	   </div>
     	   <div class="form-group">
           	 <div class="form-label-group">
              	<input name="ngaySinh" type="date" id="birthday" class="form-control" placeholder="Ngay Sinh" required="required"/>
             	 <label for="birthday">Ngay Sinh</label>
          	  </div>
     	   </div>
     	   <div class="form-group">
           	 <div class="form-label-group">
              	<input name="username" type="text" id="userName" class="form-control" placeholder="User name" required="required"/>
             	 <label for="userName">User Name</label>
          	  </div>
     	   </div>
       	   <div class="form-group">
           <div class="form-row">
				<div class="col-md-6">
                	<div class="form-label-group">
                		  <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required="required"/>
                  		<label for="inputPassword">Password</label>
                	</div>
              	</div>
			<div class="col-md-6">
                <div class="form-label-group">
                  <input type="password" id="confirmPassword" class="form-control" placeholder="Confirm password" required="required">
                  <label for="confirmPassword">Confirm password</label>
                </div>
              </div>
            </div>
          </div>
          <button type="submit" class="btn btn-primary btn-block">Register</button>
          
        </form>
          
        <div class="text-center">
          <a class="d-block small mt-3" href="${pageContext.request.contextPath }/login">Login Page</a>
          <a class="d-block small" href="#">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>

<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script> --%>
<script src="${pageContext.request.contextPath }/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="${pageContext.request.contextPath }/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>
</html>