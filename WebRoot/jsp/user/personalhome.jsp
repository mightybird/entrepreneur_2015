<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/css/style.css'/>" rel="stylesheet">
<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/js/scripts.js'/>"></script>
<title></title>
</head>
<body>
	<jsp:include page="/jsp/header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-3">
							<div class="jumbotron well">
								<div class="row">
									<h5>
										<s:property value="#session.user.name" />
									</h5>
								</div>
								<div class="row">
									<img alt="Bootstrap Image Preview"
										src="<c:url value='/images/default_head_img.jpg'/>"
										class="img-rounded" />
								</div>
								<div class="row">
									<dl>
										<dt>contact</dt>
										<dd>XXXXX</dd>
										<dt>email</dt>
										<dd>X@X.com</dd>
										<dt>introduce</dt>
										<dd>XXXXXXXXXXXXXXXXX</dd>
										<dt>address</dt>
										<address>
											<strong>Twitter, Inc.</strong><br /> 795 Folsom Ave, Suite
											600<br /> San Francisco, CA 94107<br /> <abbr title="Phone">P:</abbr>
											(123) 456-7890
										</address>
									</dl>
								</div>
								<div class="row"></div>
							</div>
						</div>
						<div class="col-md-9">
							<div class="jumbotron well">
								<div class="row">
									<div class="page-header">
										<h3>
											我的项目
											<div class="text-right">
												<small><a href="#">查看全部</a></small>
											</div>
										</h3>
									</div>
								</div>
								<div class="row">
									<div class="col-md-4">
										<div class="thumbnail">
											<img alt="Bootstrap Thumbnail First"
												src="<c:url value='/images/project_image.jpg'/>" />
											<div class="caption">
												<h3>Project name</h3>
												<dl>
													<dt>contact</dt>
													<dd>XXXXX</dd>
													<dt>email</dt>
													<dd>X@X.com</dd>
													<dt>introduce</dt>
													<dd>XXXXXXXXXXXXXXXXX</dd>

												</dl>
												<p>
													<a class="btn btn-primary" href="#">详情</a>
												</p>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="thumbnail">
											<img alt="Bootstrap Thumbnail First"
												src="<c:url value='/images/project_image.jpg'/>" />
											<div class="caption">
												<h3>Project name</h3>
												<p>
													<small> projectin, troduceproject, introduceproj,
														ectintroduce, projectintroduce </small>
												</p>
												<p>
													<a class="btn btn-primary" href="#">详情</a>
												</p>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="thumbnail">
											<img alt="Bootstrap Thumbnail First"
												src="<c:url value='/images/project_image.jpg'/>" />
											<div class="caption">
												<h3>Project name</h3>
												<p>
													<small> projectin, troduceproject, introduceproj,
														ectintroduce, projectintroduce projectin, troduceproject,
														introduceproj, ectintroduce, projectintroduce </small>
												</p>
												<p>
													<a class="btn btn-primary" href="#">详情</a>
												</p>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
	<jsp:include page="/jsp/footer.jsp"></jsp:include>
</body>