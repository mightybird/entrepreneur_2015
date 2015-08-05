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
<title><s:property value="user.name" />的个人主页</title>
</head>
<body>
	<jsp:include page="/jsp/header.jsp"></jsp:include>
	<%-- <s:debug></s:debug> --%>
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
										<s:property value="user.name" />
									</h3>
								</div>
								<div class="row">
									<a href="#">
										<img class="img-responsive" alt="Responsive image"
											src='<%=request.getContextPath()%>/images/<s:property value="user.headImage" />' />
									</a>
								</div>
								<div class="row">
									<dl>
										<dt>性别</dt>
										<dd>
											<s:property value="user.gender" />
										</dd>
										<dt>生日</dt>
										<dd>
											<s:property value="user.birth" />
										</dd>
										<dt>联系电话</dt>
										<dd>
											<s:property value="user.contact" />
										</dd>
										<dt>电子邮箱</dt>
										<dd>
											<s:property value="user.email" />
										</dd>
										<dt>个人简介</dt>
										<dd>
											<s:property value="user.introduce" />
										</dd>
										<dt>地址</dt>
										<dd>
											<s:property value="user.address" />
										</dd>
										<dt>注册时间</dt>
										<dd>
											<s:property value="user.registerTime" />
										</dd>
										<dt>被访问次数</dt>
										<dd>
											<s:property value="user.visitedCount" />
										</dd>
									</dl>
								</div>
								<div class="row">
									<s:if test="#session.user.id==user.id">
										<a class="btn btn-warning col-md-5"
											href="<c:url value='/user/applyEditPersonalInfo'/>">修改资料</a>
										<a class="btn btn-danger col-md-5 col-md-offset-2"
											href="<c:url value='/user/applyChangePassword'/>">更改密码</a>
									</s:if>
									<s:else>
										<a class="btn btn-warning col-md-5" href="<c:url value='#'/>">发送私信</a>
										<s:if test="notafriend">
											<a class="btn btn-danger col-md-5 col-md-offset-2"
												href="<c:url value='#'/>"> 加为好友 </a>
										</s:if>
										<s:else>
											<a class="btn btn-danger col-md-5 col-md-offset-2"
												href="<c:url value='#'/>"> 删除好友 </a>
										</s:else>
									</s:else>
								</div>
							</div>
							<div class="jumbotron well">
								<div class="page-header">
									<h4>
										<s:property value="user.name" />
										的好友
										<div class="text-right">
											<a href="#" class="btn btn-default">查看全部</a>
										</div>
									</h4>
								</div>
								<s:iterator value="friendlist" var="friend">
									<div class="media">
										<a href="#" class="pull-left">
											<img alt="Bootstrap Media Preview"
												src="<c:url value='/images/default_head_img.jpg'/>"
												class="media-object">
										</a>
										<div class="media-body">
											<h4 class="media-heading">
												<s:property value="#friend.name" />
											</h4>
										</div>
									</div>
								</s:iterator>
							</div>
						</div>
						<div class="col-md-9">
							<s:if test="crole.name=='entrepreneur'">
								<div class="jumbotron well">
									<div class="row">
										<div class="page-header">
											<h3>
												<s:property value="user.name" />
												发布的项目
												<div class="text-right">
													<a href="/entrepreneur_2015/project/ShowProjectCreatePage"
														class="btn btn-success"> 发布新项目 </a>
													<a href="#" class="btn btn-default">查看全部</a>
												</div>
											</h3>
										</div>
									</div>
									<div class="row">
										<s:iterator value="projectlist" var="project">
											<div class="col-md-4">
												<div class="thumbnail">
													<img alt="Bootstrap Thumbnail First"
														src="<c:url value='/images/project_image.jpg'/>" />
													<div class="caption">
														<h3>
															<s:property value="#project.name" />
														</h3>
														<p>
															<small> <s:property value="#project.introduce" />
															</small>
														</p>
														<p>
															<a class="btn btn-default" href="#"> 详情 </a>
														</p>
													</div>
												</div>
											</div>
										</s:iterator>
									</div>
								</div>
							</s:if>
							<s:if test="crole.name=='tutor'">
								<div class="jumbotron well">
									<div class="row">
										<div class="page-header">
											<h3>
												<s:property value="user.name" />
												未评估的项目
												<div class="text-right">
													<a href="#" class="btn btn-default">查看全部</a>
												</div>
											</h3>
										</div>
									</div>
									<div class="row">
										<s:iterator value="projectlist" var="project">
											<div class="col-md-4">
												<div class="thumbnail">
													<img alt="Bootstrap Thumbnail First"
														src="<c:url value='/images/project_image.jpg'/>" />
													<div class="caption">
														<h3>
															<s:property value="#project.name" />
														</h3>
														<p>
															<small> <s:property value="#project.introduce" />
															</small>
														</p>
														<p>
															<a class="btn btn-default" href="#"> 详情 </a>
														</p>
													</div>
												</div>
											</div>
										</s:iterator>
									</div>
								</div>
								<div class="jumbotron well">
									<div class="row">
										<div class="page-header">
											<h3>
												<s:property value="user.name" />
												已评估的项目
												<div class="text-right">
													<a href="#" class="btn btn-default">查看全部</a>
												</div>
											</h3>
										</div>
									</div>
									<div class="row">
										<s:iterator value="projectlist" var="project">
											<div class="col-md-4">
												<div class="thumbnail">
													<img alt="Bootstrap Thumbnail First"
														src="<c:url value='/images/project_image.jpg'/>" />
													<div class="caption">
														<h3>
															<s:property value="#project.name" />
														</h3>
														<p>
															<small> <s:property value="#project.introduce" />
															</small>
														</p>
														<p>
															<a class="btn btn-default" href="#"> 详情 </a>
														</p>
													</div>
												</div>
											</div>
										</s:iterator>
									</div>
								</div>
							</s:if>
							<s:if test="crole.name=='institution'">
								<div class="jumbotron well">
									<div class="row">
										<div class="page-header">
											<h3>
												<s:property value="user.name" />
												合作的项目
												<div class="text-right">
													<a href="#" class="btn btn-default">查看全部</a>
												</div>
											</h3>
										</div>
									</div>
									<div class="row">
										<s:iterator value="projectlist" var="project">
											<div class="col-md-4">
												<div class="thumbnail">
													<img alt="Bootstrap Thumbnail First"
														src="<c:url value='/images/project_image.jpg'/>" />
													<div class="caption">
														<h3>
															<s:property value="#project.name" />
														</h3>
														<p>
															<small> <s:property value="#project.introduce" />
															</small>
														</p>
														<p>
															<a class="btn btn-default" href="#"> 详情 </a>
														</p>
													</div>
												</div>
											</div>
										</s:iterator>
									</div>
								</div>
								<div class="jumbotron well">
									<div class="row">
										<div class="page-header">
											<h3>
												<s:property value="user.name" />
												申请合作的项目
												<div class="text-right">
													<a href="#" class="btn btn-default">查看全部</a>
												</div>
											</h3>
										</div>
									</div>
									<div class="row">
										<s:iterator value="projectlist" var="project">
											<div class="col-md-4">
												<div class="thumbnail">
													<img alt="Bootstrap Thumbnail First"
														src="<c:url value='/images/project_image.jpg'/>" />
													<div class="caption">
														<h3>
															<s:property value="#project.name" />
														</h3>
														<p>
															<small> <s:property value="#project.introduce" />
															</small>
														</p>
														<p>
															<a class="btn btn-default" href="#"> 详情 </a>
														</p>
													</div>
												</div>
											</div>
										</s:iterator>
									</div>
								</div>
							</s:if>

							<div class="jumbotron well">
								<div class="row">
									<div class="page-header">
										<h3>
											<s:property value="user.name" />
											发布的供需
										</h3>
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
											<s:iterator value="supplylist" var="supply">
												<tr>
													<td><s:property value="#supply.title" /></td>
													<td><s:property value="#supply.type" /></td>
													<td><s:property value="#supply.industry.name" /></td>
													<td><s:property value="#supply.area" /></td>
													<td><s:property value="#supply.publishTime" /></td>
													<td>
														<div class="text-right">
															<a class="btn btn-default" href="#"> 详情 </a>
														</div>
													</td>
												</tr>
											</s:iterator>
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
											<s:iterator value="needlist" var="need">
												<tr>
													<td><s:property value="#need.title" /></td>
													<td><s:property value="#need.type" /></td>
													<td><s:property value="#need.industry.name" /></td>
													<td><s:property value="#need.area" /></td>
													<td><s:property value="#need.publishTime" /></td>
													<td>
														<div class="text-right">
															<a class="btn btn-default" href="#"> 详情 </a>
														</div>
													</td>
												</tr>
											</s:iterator>
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