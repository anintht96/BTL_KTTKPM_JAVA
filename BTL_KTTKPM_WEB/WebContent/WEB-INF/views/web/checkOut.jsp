<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/jquery-3.5.1.min.js"></script> --%>

<!-- CSS được tối ưu và biên dịch mới nhất -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
 
<!-- Thư viện jQuery (dammio.com) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
 
<!-- JavaScript biên dịch mới nhất -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<title>Check-out</title>
</head>
<body>

	<!-- Header -->
	<%@ include file="_header.jsp" %>

	<section class="jumbotron text-center">
		 <div class="container">
		     <h1 class="jumbotron-heading">Check Out</h1>
		 </div>
	</section>

	<div class="container mb-4">
		    <div class="row">
		        <div class="col-8">
		        	<form action="checkOut" method="post">
						<table class="table table-striped">
							<tr>
								<td>Shipping address:</td>
								<td><input type="text" name="diaChiGiao" class="form-control"/></td>
							</tr>
							<tr>
								<td>Total price:</td>
								<td>
									<input type="text" name="tongTien" class="form-control" readonly="readonly" value="${cart.tongTien }"/>
								</td>
							</tr>
							<tr>
								<td>Payment method</td>
								<td class="form-check-inline">
									<c:forEach items="${ds }" var="item">
										<label class="form-check-label" for="radio1">
									    	<input type="radio" class="form-check-input" id="radio1" name="idThanhToan" value="${item.idThanhToan }" checked>${item.hinhThucTT } &nbsp; &nbsp;
									    </label>
									</c:forEach>
								</td> 
							</tr>
							<tr>
								<td>
									<input type="submit" name="action" value="Save" class="btn btn-block btn-light">
									
								<td>
									<input type="submit" name="action" value="Cancel" class="btn btn-lg btn-block btn-success text-uppercase">
								</td>
							</tr>
						</table>
					</form>
		        </div>
		    </div>
	</div>	        

<!-- srcipt -->	
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script> --%>
</body>
</html>