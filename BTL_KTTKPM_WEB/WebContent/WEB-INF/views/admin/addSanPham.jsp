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
<title>Admin</title>
</head>
<body>

	`<!--Header-->
	<%@ include file="_header.jsp" %>

	<div class="row">
		<div class="col-sm" align="center">
			<h1>Them San Pham</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-7">
			<form action="${pageContext.request.contextPath }/admin/addsanpham" method="POSt" enctype="multipart/form-data">
				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">ID</label>
					<div class="col-sm-10">
						<input name="idSanPham" class="form-control" placeholder="Id san pham"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Ten </label>
					<div class="col-sm-10">
						<input name="tenSanPham" class="form-control" placeholder="Ten San Pham"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Mo Ta </label>
					<div class="col-sm-10">
						<input name="moTa" class="form-control" placeholder="Mo ta"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">So luong </label>
					<div class="col-sm-10">
						<input name="soLuong" class="form-control" placeholder="So luong san pham"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">DOn gia </label>
					<div class="col-sm-10">
						<input name="donGia" class="form-control" placeholder="Don gia"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Ngay San xuat </label>
					<div class="col-sm-10">
						<input name="ngaySanXuat" class="form-control" placeholder="Id san pham" type="Date"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Han Su Dung </label>
					<div class="col-sm-10">
						<input name="hanSuDung" class="form-control" placeholder="Han su Dung" type="Date"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Loai San pham </label>
					<div class="col-sm-10">
							<select name="idLoaiSanPham" class="custom-select mr-sm-2">
								<c:forEach items="${dsLoaiSP }" var="item">
									<option value="${item.idLoaiSanPham }" label="${item.tenLoaiSanPham }"></option>
								</c:forEach>
							</select>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Nha San Xuat </label>
					<div class="col-sm-10">
						<select name="idNhaSanXuat" class="custom-select mr-sm-2">
								<c:forEach items="${dsNhaSX }" var="item">
									<option value="${item.idNhaSanXuat }" label="${item.tenNhaSanXuat }"></option>
								</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">File Image </label>
					<div class="col-sm-10">
						<input name="fileData" type="file"/>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Them</button>
			</form>
		</div>
		<div class="col-sm-3"></div>
	</div>
	
<!-- srcipt -->	
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script> --%>
</body>
</html>