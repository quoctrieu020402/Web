<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<div class="col l-2">
		<%@ include file="/common/user/nav.jsp"%>
	</div>
	<div class="col l-10">
		<div class="row">
			<div class="col l-12">
				<div class="tool">
					<div class="row">
						<div class="col l-2">
							<div class="dropdown">
								<button class="dropbtn">Sắp xếp giá</button>
								<div class="dropdown-content">
									<a href="#">Tăng dần</a> <a href="#">Giảm dần</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col l-12 mt-20">
				<div class="listProdcuct">
					<div class="row">
						<div class="col l-3">
							<c:forEach var="product" items="${listOfProduct}">
								<div class="product">
									<img class="product__img"
										src="https://cdn.tgdd.vn/Products/Images/42/22701/dien-thoai-di-dong-Nokia-1280-dienmay.com-l.jpg"
										alt="">
									<h1 class="roduct__bracnh">${product.branch}</h1>
									<h2 class="roduct__name">${product.name}</h2>
									<div class="product__price">
										<strong>100₫</strong>
									</div>
									<div class="product__size">
										<strong>${product.size}</strong>
									</div>
									<div class="product__color">
										<strong>${product.color}</strong>
									</div>
									<div class="product__tooltip">
										<button class="product__tooltip--btn">
											<span class="product__tooltip--text">Thêm vào giỏ</span> +
										</button>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>