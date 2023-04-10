<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách nhân viên</title>
<!-- Google Font: Source Sans Pro -->
 <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="plugins/jqvmap/jqvmap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css">
  
  
  <link rel="stylesheet" href="css/style.min.css">
  
  
  
  
  <link rel="stylesheet" href="css/employee.css">
  <link rel="stylesheet" href="css/detail-test.css">
  <link rel="stylesheet" href="css/fix-test.css">
  <link rel="stylesheet" href="<c:url value='/templates/css/alertify.min.css'/>" />
  
  
  
</head>
<body>
	
	<div class="content-wrapper">
	
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<a href="/admin/management/staff/list"><h1>Danh Sách Nhân Viên</h1></a>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="/admin/home">Trang Chủ</a></li>
							<li class="breadcrumb-item active">Danh sách nhân viên</li>
						</ol>
					</div>

				</div>
			</div>
		</section>


		<section class="content">
			<form action="<c:url value='/admin/management/staff/list'/>" id="formSubmit" method="get">
				<div class="container-fluid">
					<div class="row" style="justify-content: center;"></div>
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">Tìm Kiếm</h3>

								<div class="card-tools">
									<div class="input-group input-group-sm" style="width: 150px;">
										<input type="text" name="search" id="search"
											value="${paging.search}" class="form-control float-right"
											placeholder="Search">
										<div class="input-group-append">
											<button type="submit" class="btn btn-default">
												<i class="fas fa-search"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
							<!-- /.card-header -->
							<div class="card-body">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>ID</th>
											<th>HỌ TÊN</th>
											<th>GIỚI TÍNH</th>
											<th>SĐT</th>
											<th>EMAIL</th>
											<th>CHỨC VỤ</th>
											<th><a type="button"
												class="btn btn  btn-success float-right"
												style="color: white" data-toggle="modal"
												data-target="#modal-add"> Thêm Mới </a></th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="staff" items="${listStaff}">
											<tr>
												<td>${staff.getId()}</td>
												<td>${staff.getName()}</td>
												<td>${staff.getGender()}</td>
												<td>${staff.getPhoneNumber()}</td>
												<td>${staff.account.getEmail()}</td>
												<td>${staff.account.role.getName()}</td>
												<td><a class="btn btn-primary" data-toggle="modal"
													data-target="#modal-${staff.getId()}"> <i class="fas fa-info-circle"></i>
												</a> <a
													href="/admin/management/staff/edit?id=${staff.getAccount().getEmail()}"
													class="btn btn-info"> <i class="fas fa-edit"></i></a> <a
													class="btn btn-danger" data-toggle="modal"
													data-target="#modal-default"> <i class="fas fa-trash"></i></a>
											</tr>
											
											
								<div class="modal fade" id="modal-default">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h4 class="modal-title">Thông báo</h4>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true"></span>
												</button>
											</div>
											<div class="modal-body">
												<p>Bạn có đồng ý xoá nhân viên không?</p>
											</div>
											<div class="modal-footer justify-content-between">
												<a
													href="/admin/management/staff/remove?id=${staff.getAccount().getEmail()}"
													type="button" class="btn btn-primary">Đống ý</a>
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Đóng</button>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal-dialog -->
								</div>
											<div class="modal fade" id="modal-${staff.getId()}">
												<div class="modal-dialog modal-lg">
													<div class="modal-content ">
														<div class="  modal-header ">
															<h4 class="modal-title ">Thông Tin Nhân Viên</h4>
															<button type="button" class="close" data-dismiss="modal"
																aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">
															<div class="card card-primary card-outline">
																<div class="card-body box-profile">

																	<div class="container">
																		<div class="row">
																			<div class="col col-sm-5" style="margin-top: 40px;">


																				<div class="text-center">
																					<img class="profile-user-img img-fluid img-circle"
																						src="<c:url value='/templates/admin/img/${staff.getImage()}'/>"
																						alt="User profile picture"> <br> <br>
																					<div class="alert alert-success" role="alert">
																						Hoạt Động</div>
																				</div>

																			</div>
																			<div class="col col-sm-7">
																				<ul class="list-group list-group-unbordered ">
																					<li class="list-group-item"><b>Mã nhân
																							viên </b> <a class="float-right text-primary">${staff.getId()}</a>
																					</li>
																					<li class="list-group-item"><b>Họ và Tên</b> <a
																						class="float-right text-primary">${staff.getSurname()}
																							${staff.getName()}</a></li>
																					<li class="list-group-item"><b>Giới tính</b> <a
																						class="float-right text-primary">${staff.getGender()}</a>
																					</li>
																					<li class="list-group-item"><b>Ngày sinh</b> <a
																						class="float-right text-primary">${staff.dateOfBirth}</a>
																					</li>
																					<li class="list-group-item"><b>Địa chỉ</b> <a
																						class="float-right text-primary">${staff.getAddress()}</a>
																					</li>
																					<li class="list-group-item"><b>Email</b> <a
																						class="float-right text-primary">${staff.account.getEmail()}</a>
																					</li>
																					<li class="list-group-item"><b>Phone</b> <a
																						class="float-right text-primary">${staff.getPhoneNumber()}</a>
																					</li>
																					<li class="list-group-item"><b>Chức vụ</b> <a
																						class="float-right text-primary">${staff.account.role.getName()}</a>
																					</li>
																				</ul>
																			</div>

																		</div>
																	</div>


																</div>
																<!-- /.card-body -->
															</div>
														</div>
														<!-- <div class="modal-footer ">
															<button type="button" class="btn btn-default"
																data-dismiss="modal">Đóng</button>
														</div> -->

													</div>
													<!-- /.modal-content -->
												</div>
												<!-- /.modal-dialog -->
											</div>

											<!--  000000000000000000000000000 -->
											<div class="modal fade" id="modal-add" tabindex="-1"
												role="dialog" aria-hidden="true">
												<div class="modal-dialog modal-lg modal-dialog-centered">
													<div class="modal-content">
														<div class="modal-header">
															<h4 class="modal-title" id="myCenterModalLabel">Thêm
																Mới Nhân Viên</h4>
															<button type="button" class="btn btn-default"
																data-dismiss="modal">Đóng</button>
														</div>
														<div class="modal-body">
															<div class="row">
																<div class="col-12">
																	<div class="bg-primary-dark block block-h-auto">
																		<div class="row edit-product-row">
																			<form class="contener1-fix" method="POST"
																				action="/managenment/admin/staff/add.htm"
																				modelAttribute="taikhoan">
																				<div class="col-md-6">
																					<div class="form-group">
																						<label for="email">Email Tài Khoản</label> <input
																							type="email" name="email" class="form-control"
																							required>
																					</div>
																					<div class="form-group">
																						<label for="tenNV">Tên Nhân Viên</label> <input
																							type="text" name="tenNV" class="form-control"
																							required>
																					</div>
																					<div class="form-group">
																						<label for="cmnd">CMND</label> <input type="text"
																							name="cmnd" class="form-control" required>
																					</div>
																					<div class="form-group">
																						<label for="soDT">SĐT</label> <input type="text"
																							name="soDT" class="form-control" required>
																					</div>
																					<div class="form-group">
																						<label for="diaChi">Địa Chỉ</label> <input
																							type="text" name="diaChi" class="form-control"
																							required>
																					</div>
																				</div>
																				<div class="col-md-6">
																					<div class="form-group">
																						<label for="ngaySinh">Ngày Sinh</label> <input
																							type="date" name="ngaySinh" class="form-control"
																							required>
																					</div>
																					<div class="form-group">
																						<label for="gioiTinh">Giới Tính</label> <select
																							name="gioiTinh" class="form-control">
																							<option value="false">Nữ</option>
																							<option value="true">Nam</option>
																						</select>
																					</div>
																					<div class="form-group">
																						<label for="trangThai">Trạng Thái</label>
																						<div class="btn-group" role="group"
																							aria-label="Trạng Thái">
																							<a href="#" class="btn btn-outline-primary">Hoạt
																								Động</a>
																						</div>
																					</div>
																					<div class="form-group">
																						<label for="anh">Ảnh</label>
																						<div class="custom-file">
																							<input type="file" name="anh"
																								class="custom-file-input"> <label
																								class="custom-file-label" for="anh">Chọn
																								ảnh</label>


																						</div>
																					</div>
																					<div class="form-group text-center">
																						<button type="button"
																							class="btn btn-primary btn-lg btn-block">Thêm
																							Mới</button>
																					</div>
																				</div>
																			</form>

																		</div>
																	</div>
																</div>

															</div>
														</div>
													</div>
												</div>
											</div>
										
										
										</c:forEach>
									
									</tbody>
								</table>


							</div>

						</div>
						<!-- /.card-body -->
							<div class="card-footer clearfix">
								<ul id="pagination-demo" class="pagination-lg"></ul>
								<input type="hidden" value="1" id="page" name="page" /> <input
									type="hidden" value="1" id="limit" name="limit" />
							</div>
						</div>
						<!-- /.card -->
					</div>
				
			</form>

		</section>

	
	
	</div>

	<script>
		var totalPages = $
		{
			paging.totalPage
		};
		var currentPage = $
		{
			paging.page
		};
		$('#pagination-demo').twbsPagination({
			totalPages : totalPages,
			visiblePages : 10,
			startPage : currentPage,
			onPageClick : function(event, page) {
				if (currentPage != page) {
					$('#limit').val(1);
					$('#page').val(page);
					$('#formSubmit').submit();
				}
			}
		});
	</script>


	<script
		src="<c:url value='/templates/admin/plugins/jquery/jquery.min.js'/>"></script>
	<!-- Bootstrap 4 -->
	<script
		src="<c:url value='/templates/admin/plugins/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<!-- SweetAlert2 -->
	<script
		src="<c:url value='/templates/admin/plugins/sweetalert2/sweetalert2.min.js'/>"></script>
	<!-- Toastr -->
	<script
		src="<c:url value='/templates/admin/plugins/toastr/toastr.min.js'/>"></script>
	<!-- AdminLTE App -->
	<script src="<c:url value='/templates/admin/dist/js/adminlte.min.js'/>"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<c:url value='/templates/admin/dist/js/demo.js'/>"></script>
	<!-- Page specific script -->
</body>
</html>