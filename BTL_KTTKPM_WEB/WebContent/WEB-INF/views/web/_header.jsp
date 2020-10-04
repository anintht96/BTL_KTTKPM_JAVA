<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="${pageContext.request.contextPath }/">Shopping</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="${pageContext.request.contextPath }/trang-chu">Trang chủ
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath }/shoppingCart">Cart</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Dịch Vụ</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Thông tin</a>
          </li>
          
          <li class="nav-item">
          	<c:if test="${pageContext.request.userPrincipal.name != null }">
          		<a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
          	</c:if>
          	<c:if test="${pageContext.request.userPrincipal.name == null }">
          		<a class="nav-link" href="${pageContext.request.contextPath }/login">Login</a>
          	</c:if>
          </li>
        </ul>
      </div>
    </div>
  </nav>