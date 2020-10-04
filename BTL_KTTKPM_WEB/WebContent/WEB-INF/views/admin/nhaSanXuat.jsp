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

<title>Loai san pham</title>
<title>Admin</title>
</head>
<body>

	<!--Header-->
	<%@ include file="_header.jsp" %>
	
	
	<div class="row">
		<div class="col-sm" align="center">
			<h1>Them Nha San Xuat</h1>
		</div>
	</div>
	<div class="container mt-4">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-7">
				<form action="${pageContext.request.contextPath }/admin/addNhaSX" method="Post">
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Ten</label>
						<div class="col-sm-10">
							<input name="ten" class="form-control"
								placeholder="Ten nha san xuat" />
						</div>
					</div> 
					<button type="submit" name="action" value="add" class="btn btn-primary">Them</button>
				</form>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>

	<div class="row mt-4">
		<div class="col-sm" align="center">
			<h1>Danh Sach Nha San Xuat</h1>
		</div>
	</div>
	<div class="row mt-2">
		<div class="col-sm-2"></div>
		<div class="col-sm-7">
			<form action="" method="POST">
				<table class="table table-striped table-dark">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Ten</th>
							<td scope="col">Edit</td>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ds }" var="item">
							<tr>
								<td>${item.idNhaSanXuat }</td>
								<td>${item.tenNhaSanXuat }</td>
								<td>
									<button type="button" class="btn btn-primary passingID"
										data-toggle="modal" data-target="#myModal"
										data-id="${item.idNhaSanXuat }">Edit</button>
								</td>
								<td>
									<button class="btn btn-primary passingIDDelete"
										type="button" data-toggle="modal" data-target="#myModalDelete"
										data-idDelete="${item.idNhaSanXuat }">Delete</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
		<div class="col-sm-3"></div>
	</div>
	
	<!-- The Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-lg modal-dialog-centered">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Edit Nha San Xuat</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="${pageContext.request.contextPath }/admin/updateNhaSX" method="POST">


						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-2 col-form-label">ID
							</label>
							<div class="col-sm-5">
								<input name="idNhaSanXuat" id="idkl" value=""
									placeholder="Ten nha san xuat" class="form-control"
									readonly="readonly" />
							</div>
						</div>

						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-2 col-form-label">Ten
							</label>
							<div class="col-sm-5">
								<input class="form-control" name="tenUpdate"
									placeholder="Ten nha san xuat"/>
							</div>
						</div>
						<button type="submit" name="action" value="update" class="btn btn-primary">Update</button>
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

	<!-- The Modal -->
	<div class="modal fade" id="myModalDelete" role="dialog">
		<div class="modal-dialog modal-lg modal-dialog-centered">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Canh bao xoa !</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="${pageContext.request.contextPath }/admin/deleteNhaSX" method="POST">


						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-2 col-form-label">ID
							</label>
							<div class="col-sm-5">
								<input name="idNhaSanXuat" id="idklDelete" value=""
									placeholder="Ten loai San Pham" class="form-control"
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
		$(".passingIDDelete").click(function() {
			var idsDelete = $(this).attr('data-idDelete');
			$("#idklDelete").val(idsDelete);
			$('#myModalDelete').modal('show');
		});
	</script>

<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script> --%>
</body>
</html>