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

<title>Shopping-Cart</title>
</head>
<body>

	<!-- Header -->
	<%@ include file="_header.jsp" %>
	
	<section class="jumbotron text-center">
		    <div class="container">
		        <h1 class="jumbotron-heading">SHOPPING CART</h1>
		     </div>
		</section>
		
		<div class="container mb-4">
		    <div class="row">
		        <div class="col-12">
		            <div class="table-responsive">
		                <table class="table table-striped">
		                    <thead>
		                        <tr>
		                            <th scope="col"> </th>
		                            <th scope="col">San Pham</th>
		                            <th scope="col">Don gia</th>
		                            <th scope="col" class="text-center">So luong</th>
		                            <th scope="col" class="text-right">Thanh Tien</th>
		                            <th> </th>
		                            <th> </th>
		                        </tr>
		                    </thead>
		                    <tbody>
		                    	<tr>
									<c:if test="${cart.lineItemCount==0 }">
										<td colspan="8">Gio hang hien dang trong.</td>
									</c:if>
								</tr>
								<c:forEach items="${cart.listAllCartItem }" var="cartItem" varStatus="counter">
									<form name="item" method="post" action="cart/udCart" >
										<tr>
											<td>
												<img class="card-img-top" src="${pageContext.request.contextPath }/sanPhamImage?idSanPham=${cartItem.partNumber}" alt="Card image cap" style="height: 50px;width: 50px">
												<input type="hidden" name="partNumber" value="${cartItem.partNumber }"/>
											</td>
											<td><c:out value="${cartItem.thongTin }"></c:out></td>
											<td><c:out value="${cartItem.donGia }"></c:out>
											<td>
												<input name="soLuong" type="number" min="1" size="2" value="${cartItem.soLuong }" class="form-control"/>
											</td>
											<td class="text-right"><input type="hidden" name="itemIndex" value="<c:out value="${counter.count }"></c:out>"> 
												<c:out value="${cartItem.thanhTien } VND"></c:out>
											</td>
											<td class="text-right"><input type="submit" name="action" value="updateCart" class="btn btn-info"></td>
											<td class="text-right"><input type="submit" name="action" value="removeCart" class="btn btn-danger"></td>
										</tr>
									</form>
								</c:forEach>
		                        <tr>
		                            <td></td>
		                            <td></td>
		                            <td></td>
		                            <td></td>
		                            <td></td>
		                            <td><strong>Total</strong></td>
		                            <td class="text-right"><strong><c:out value="${cart.tongTien }"></c:out> VND</strong></td>
		                        </tr>
		                    </tbody>
		                </table>
		            </div>
		        </div>
		        <div class="col mb-2">
		            <div class="row">
		                <div class="col-sm-12  col-md-6">
		                   	<a href="${pageContext.request.contextPath }/trang-chu"><button class="btn btn-block btn-light">Continue Shopping</button></a>
		                </div>
		                <div class="col-sm-12 col-md-6 text-right">
		                	<a href="${pageContext.request.contextPath }/checkOut"><button class="btn btn-lg btn-block btn-success text-uppercase">Checkout</button></a>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
	
<!-- srcipt -->	
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script> --%>
</body>
</html>