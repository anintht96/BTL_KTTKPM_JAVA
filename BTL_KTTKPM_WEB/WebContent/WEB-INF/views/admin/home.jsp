<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<!-- Header -->
	<%@ include file="_header.jsp" %>

	<div class="row mt-4">
		<div class="col-sm" align="center">
			<h1>Danh Sach San Pham</h1>
		</div>
	</div>

	<form method="Get">
		<table class="table table-dark table-striped">
			<tr>
				<th>ID</th>
				<th>Ten san Pham</th>
				<th>Mo Ta</th>
				<th>So Luong</th>
				<th>Don gia</th>
				<th>Ngay san xuat</th>
				<th>Han su dung</th>
				<th>Nha san Xuat</th>
				<th>Loai San Pham</th>
				<th>Image</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${ds }" var="item">
				<tr>
					<td>${item.idSanPham }</td>
					<td>${item.tenSanPham }</td>
					<td>${item.moTa }</td>
					<td>${item.soLuong }</td>
					<td>${item.donGia }</td>
					<td>${item.ngaySanXuat }</td>
					<td>${item.hanSuDung }</td>
					<td>${item.nhaSanXuat.tenNhaSanXuat }</td>
					<td>${item.loaiSanPham.tenLoaiSanPham }</td>
					<td><img alt=""
						src="${pageContext.request.contextPath }/sanPhamImage?idSanPham=${item.idSanPham}"
						width="135px" height="120px"></td>
					<td>
						<%-- <button type="button" class="btn btn-primary passingID" data-toggle="modal" data-target="#myModal" data-id="${item.idSanPham }">Edit</button> --%>
						<a href="${pageContext.request.contextPath }/admin/updateSP?idSanPham=${item.idSanPham }&action=update"><button
								type="button" class="btn btn-primary">Edit</button> </a>
					</td>
					<td>
						<button type="button" class="btn btn-primary passingID"
							data-toggle="modal" data-target="#myModal"
							data-id="${item.idSanPham }">Delete</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>

	<!-- The Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-lg modal-dialog-centered">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Canh bao xoa !</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="${pageContext.request.contextPath }/admin/deleteSP" method="get">

						<div class="form-group row">
							<label class="col-sm-2 col-form-label">ID
							</label>
							<div class="col-sm-5">
								<input name="idSanPham" id="idkl"
									value="" placeholder="id san pham" class="form-control"
									readonly="readonly" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-10 col-form-label">Ban co chac chan
								muon xoa. </label>
						</div>
						<button type="submit" name="action" value="delete" class="btn btn-primary">Delete</button>
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>

				</div>

			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(".passingID").click(function() {
			var ids = $(this).attr('data-id');
			$("#idkl").val(ids);
			$('#myModal').modal('show');
		});
	</script>

<!-- srcipt -->	
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script> --%>
</body>
</html>