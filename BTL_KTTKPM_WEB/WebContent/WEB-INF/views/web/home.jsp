<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%-- <link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script> --%>

	
<!-- CSS được tối ưu và biên dịch mới nhất -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
 
<!-- Thư viện jQuery (dammio.com) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
 
<!-- JavaScript biên dịch mới nhất -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<title>Trang-chu</title>
</head>
<body>

	<!-- Header -->
	<%@ include file="_header.jsp" %>
	
	<div class="container">

		<!-- Heading Row -->
		<div class="row align-items-center my-5">
			<div class="col-lg-7">
				<img class="img-fluid rounded mb-4 mb-lg-0"
					src="https://lh3.googleusercontent.com/proxy/nMmcj_4Hdxtp-9h866SR09f_UW2MOMtWWP4AzKiSW0lZHOvHqeBebqBr8FfpvG07NsyvmV5r1DIY009vQYFt53PPoa6oPRKztpk0_TyihOAQ980HwH_0HQcCrYuOwu-4HTskYov2kOnV6brOCeK-WqR-nVuhIonZ35shd4xdif_wGcZtxw" alt="">
			</div>
			<!-- /.col-lg-8 -->
			<div class="col-lg-5">
				<h1 class="font-weight-light">Trang web bán hàng online</h1>
				<p></p>
				
			</div>
			<!-- /.col-md-4 -->
		</div>
		<!-- /.row -->
	<img alt="" src="">
		<!-- Call to Action Well -->
		<div class="card text-white bg-secondary my-5 py-4 text-center">
			<div class="card-body">
				<p class="text-white m-0"><img alt="" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRcVnwB9Ol9bS7qx-aLoCp0Zt20ogcDnAwjVA&usqp=CAU"> </p>
			</div>
		</div>

		<!-- Content Row -->
		<div class="row">
			<c:forEach items="${ds }" var="item">
				<form action="addToCart" method="Post">
					<div class="col-md-4 mb-5">
						<div class="card h-100 text-center" style="width: 300px">
							<div class="card-header">
								<h2 class="card-title"><input type="hidden" name="thongTin" value="${item.tenSanPham }"/>${item.tenSanPham }</h2>
							</div>
							<div class="card-body">
								<img class="card-img-top" src="${pageContext.request.contextPath }/sanPhamImage?idSanPham=${item.idSanPham}" alt="Card image cap" style="height: 220px">
								<p class="card-text text-center" style="padding-top: 5px">
									  	<input type="hidden" name="donGia" value="${item.donGia }"/>
									    <span class="input-group-text">Don Gia : ${item.donGia } VND</span>
								</p>
								<div class="input-group" style="margin-bottom: 5px">
								  <div class="input-group-prepend">
								    <span class="input-group-text">So luong</span>
								  </div>
								  <input type="number" name="soLuong" value="1" size="2" min="0" max="${item.soLuong }" class="form-control" aria-label="Amount"/>
								</div>
								<input type="hidden" name="partNumber" value="${item.idSanPham }"/>
								<div class="alert alert-dark" style="margin: 0px">
								    <strong><a href="">Chi tiet san pham</a></strong>
								  </div>
							</div>
							<div class="card-footer">
								<input type="submit" value="Add To Cart" class="btn btn-primary btn-sm">
							</div>
						</div>
					</div>
				</form>
			</c:forEach>
		</div>
	</div>		
	

</body>
</html>