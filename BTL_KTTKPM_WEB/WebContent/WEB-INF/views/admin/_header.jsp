<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

	<a class="navbar-brand mr-1"
		href="${pageContext.request.contextPath }/admin">Trang Admin</a>

	<!-- <button class="btn btn-link btn-sm text-white order-1 order-sm-0"
		id="sidebarToggle" href="#collapsibleNavbar">
		<i class="fas fa-bars"></i>
	</button> -->
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> QL Sản Phẩm </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="${pageContext.request.contextPath }/admin/addsanpham">Thêm Sản Phẩm</a>
					<a class="dropdown-item" href="${pageContext.request.contextPath }/admin/loaisanpham">QL Loai SanPham</a> 
					<a class="dropdown-item" href="${pageContext.request.contextPath }/admin/nhaSanXuat">QL Nhà Sản Xuất</a>
				</div></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/admin/donHang">QL
					Đơn hàng</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/admin/thanhToan">QL Thanh Toán</a></li>
		</ul>
	</div>


	<!-- Navbar Search -->
	<form
		class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
		<div class="input-group">
			<input type="text" class="form-control" placeholder="Search for..."
				aria-label="Search" aria-describedby="basic-addon2">
			<div class="input-group-append">
				<button class="btn btn-primary" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</div>
	</form>

	<!-- Navbar -->
	<ul class="navbar-nav ml-auto ml-md-0">

		<li class="nav-item"><c:if
				test="${pageContext.request.userPrincipal.name != null }">
				<a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
			</c:if> <c:if test="${pageContext.request.userPrincipal.name == null }">
				<a class="nav-link" href="${pageContext.request.contextPath }/login">Login</a>
			</c:if></li>
	</ul>

</nav>