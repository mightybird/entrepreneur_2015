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
	<s:debug></s:debug>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-3">
							<div class="jumbotron well">
								<div class="row">
									<h3>
										<s:property value="#session.user.name" />
									</h3>
								</div>
								<div class="row">
									<a href="#">
										<img class="img-responsive" alt="Responsive image"
											src="<c:url value='/images/default_head_img.jpg'/>" />
									</a>
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
								<div class="row">
									<a class="btn btn-info col-md-4 " href="#">改资料</a>
									<a class="btn btn-danger col-md-4 col-md-offset-2" href="#">改密码</a>
								</div>
							</div>
							<div class="jumbotron well">
								<div class="page-header">
									<h4>
										我的好友
										<div class="text-right">
											<a href="#" class="btn btn-default">查看全部</a>
										</div>
									</h4>
								</div>
								<a href="#">
									<img src="<c:url value='/images/default_head_img.jpg'/>"
										class="img-rounded" />
								</a>
								<h5>name</h5>
							</div>
						</div>
						<div class="col-md-9">
							<div class="jumbotron well">
								<div class="row">
									<div class="page-header">
										<h3>
											我的项目
											<div class="text-right">
												<a href="#" class="btn btn-success">发布项目</a>
												<a href="#" class="btn btn-default">查看全部</a>
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
													<a class="btn btn-default" href="#">详情</a>
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
													<a class="btn btn-default" href="#">详情</a>
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
													<a class="btn btn-default" href="#">详情</a>
												</p>
											</div>
										</div>
									</div>

								</div>
							</div>
							<div class="jumbotron well">
								<div class="row">
									<div class="page-header">
										<h3>我的供需</h3>
									</div>
								</div>
								<div class="row">
									<div class="panel panel-default">

										<div class="panel-heading">
											<h4>供应</h4>
											<div class="text-right">
												<a href="#" class="btn btn-success">发布供应</a>
												<a href="#" class="btn btn-default">查看全部</a>
											</div>
										</div>



										<table class="table">
											<tr>
												<th>标题</th>
												<th>类型</th>
												<th>行业</th>
												<th>地区</th>
												<th>发布时间</th>
											</tr>
											<tr>
												<td>1</td>
												<td>2</td>
												<td>3</td>
												<td>4</td>
												<td>5</td>
												<td><div class="text-right">
														<a class="btn btn-default" href="#">详情</a>
													</div></td>
											</tr>
										</table>
									</div>
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4>需求</h4>
											<div class="text-right">
												<a href="#" class="btn btn-success">发布需求</a>
												<a href="#" class="btn btn-default">查看全部</a>
											</div>
										</div>

										<table class="table">
											<tr>
												<th>标题</th>
												<th>类型</th>
												<th>行业</th>
												<th>地区</th>
												<th>发布时间</th>
											</tr>
											<tr>
												<td>1</td>
												<td>2</td>
												<td>3</td>
												<td>4</td>
												<td>5</td>
												<td><div class="text-right">
														<a class="btn btn-default" href="#">详情</a>
													</div></td>
											</tr>
										</table>
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