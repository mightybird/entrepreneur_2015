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
											<s:date format="yyyy年MM月dd日" name="user.birth" />
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
											<s:date name="user.registerTime" nice="true" />
										</dd>
										<dt>被访问次数</dt>
										<dd>
											<s:property value="user.visitedCount" />
										</dd>
									</dl>
								</div>
								<div class="row">
									<s:if test="#session.user.id==user.id">
										<a class="btn btn-primary col-md-5"
											href="<c:url value='/user/applyEditPersonalInfo'/>">修改资料</a>
										<a class="btn btn-warning col-md-5 col-md-offset-2"
											href="<c:url value='/user/applyChangePassword'/>">更改密码</a>
									</s:if>
									<s:else>
										<%-- <a class="btn btn-success col-md-5" href="<c:url value='#'/>">发送私信</a> --%>
										<a id="modal-88388" href="#modal-container-88388"
											role="button" class="btn btn-success col-md-5"
											data-toggle="modal">发送私信</a>

										<div class="modal fade" id="modal-container-88388"
											role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">

														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">×</button>
														<h4 class="modal-title" id="myModalLabel">
															向
															<s:property value="user.name" />
															发私信
														</h4>
													</div>
													<form method="post"
														action='<%=request.getContextPath()%>/user/sendMail?id=<s:property value="user.id" />'>
														<div class="modal-body">
															<div class="form-group">
																<label for="title" class="col-md-2 control-label">
																	标题 </label>
																<input type="text" class="form-control" id="title"
																	name="title" required />
															</div>
															<div class="form-group">
																<label for="content" class="col-md-2 control-label">
																	正文 </label>
																<textarea rows="8" class="form-control" id="content"
																	name="content" required></textarea>
															</div>
														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-default"
																data-dismiss="modal">取消</button>
															<%-- <a class="btn btn-success"
															href='<%=request.getContextPath()%>/user/deleteFriend?id=<s:property value="user.id" />'>
															发送 </a> --%>
															<button type="submit" class="btn btn-success">发送</button>
														</div>
													</form>
												</div>
											</div>
										</div>
										<s:if test='friendstatus=="stranger"'>
											<a class="btn btn-danger col-md-5 col-md-offset-2"
												href='<%=request.getContextPath()%>/user/applyFriend?id=<s:property value="user.id" />'>
												加为好友 </a>
										</s:if>
										<s:elseif test='friendstatus=="applyee"'>
											<button type="button"
												class="btn btn-default col-md-5 col-md-offset-2"
												disabled="disabled">已申请</button>
										</s:elseif>
										<s:elseif test='friendstatus=="applyer"'>
											<a class="btn btn-success col-md-5 col-md-offset-2"
												href='<%=request.getContextPath()%>/user/acceptFriend?id=<s:property value="user.id" />'>
												同意申请 </a>
										</s:elseif>
										<s:else>
											<a id="modal-88386" href="#modal-container-88386"
												role="button"
												class="btn btn-danger col-md-5 col-md-offset-2"
												data-toggle="modal">删除好友</a>

											<div class="modal fade" id="modal-container-88386"
												role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">

															<button type="button" class="close" data-dismiss="modal"
																aria-hidden="true">×</button>
															<h4 class="modal-title" id="myModalLabel">确认删除好友</h4>
														</div>
														<div class="modal-body">
															真的要删除好友
															<s:property value="user.name" />
															吗？
														</div>
														<div class="modal-footer">

															<button type="button" class="btn btn-default"
																data-dismiss="modal">放弃</button>
															<a class="btn btn-danger"
																href='<%=request.getContextPath()%>/user/deleteFriend?id=<s:property value="user.id" />'>
																友尽！ </a>
														</div>
													</div>
												</div>
											</div>
											<%-- <a class="btn btn-danger col-md-5 col-md-offset-2"
												href="<c:url value='#'/>"> 删除好友 </a> --%>
										</s:else>
									</s:else>
								</div>
							</div>
							<s:if test="#session.user.id==user.id">
								<div class="jumbotron well">
									<div class="page-header">
										<h4>
											好友申请
											<!-- <div class="text-right">
												<a href="#" class="btn btn-default">查看全部</a>
												</div> -->
										</h4>
									</div>
									<s:iterator value="applyingFriendlist" var="friend">
										<div class="media">
											<a
												href='<%=request.getContextPath()%>/user/personalhome?userid=<s:property value="#friend.id" />'
												class="pull-left">
												<img alt="Bootstrap Media Preview"
													src='<%=request.getContextPath()%>/images/<s:property value="#friend.headImage" />'
													class="media-object">
											</a>
											<div class="media-body">
												<h5 class="media-heading">
													<s:property value="#friend.name" />
												</h5>
												<div class="text-right">
													<a
														href='<%=request.getContextPath()%>/user/acceptFriend?id=<s:property value="#friend.id" />'
														class="btn btn-success btn-sm"> 同意申请 </a>
												</div>
											</div>
										</div>
									</s:iterator>
								</div>
							</s:if>
							<div class="jumbotron well">
								<div class="page-header">
									<h4>
										<s:property value="user.name" />
										的好友
										<!-- <div class="text-right">
											<a href="#" class="btn btn-default">查看全部</a>
										</div> -->
									</h4>
								</div>
								<s:iterator value="friendlist" var="friend">
									<div class="media">
										<a
											href='<%=request.getContextPath()%>/user/personalhome?userid=<s:property value="#friend.id" />'
											class="pull-left">
											<img alt="Bootstrap Media Preview"
												src='<%=request.getContextPath()%>/images/<s:property value="#friend.headImage" />'
												class="media-object">
										</a>
										<div class="media-body">
											<h5 class="media-heading">
												<s:property value="#friend.name" />
											</h5>
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
												<s:if test="#session.user.id==user.id">
													<div class="text-right">
														<a href="/entrepreneur_2015/project/ShowProjectCreatePage"
															class="btn btn-success"> 发布新项目 </a>
														<!-- <a href="#" class="btn btn-default">查看全部</a> -->
													</div>
												</s:if>
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
															<a class="btn btn-default"
																href='<%=request.getContextPath()%>/project/showProjectInfoPage?projectid=<s:property value="#project.id"/>'>
																详情 </a>
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
												<!-- <div class="text-right">
													<a href="#" class="btn btn-default">查看全部</a>
												</div> -->
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
															<a class="btn btn-default"
																href='<%=request.getContextPath()%>/project/showProjectInfoPage?projectid=<s:property value="#project.id"/>'>
																详情 </a>
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
												<!-- <div class="text-right">
													<a href="#" class="btn btn-default">查看全部</a>
												</div> -->
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
															<a class="btn btn-default"
																href='<%=request.getContextPath()%>/project/showProjectInfoPage?projectid=<s:property value="#project.id"/>'>
																详情 </a>
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
												<!-- <div class="text-right">
													<a href="#" class="btn btn-default">查看全部</a>
												</div> -->
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
															<a class="btn btn-default"
																href='<%=request.getContextPath()%>/project/showProjectInfoPage?projectid=<s:property value="#project.id"/>'>
																详情 </a>
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
												<!-- <div class="text-right">
													<a href="#" class="btn btn-default">查看全部</a>
												</div> -->
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
															<a class="btn btn-default"
																href='<%=request.getContextPath()%>/project/showProjectInfoPage?projectid=<s:property value="#project.id"/>'>
																详情 </a>
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
											<s:if test="#session.user.id==user.id">
												<div class="text-right">
													<a href="#" class="btn btn-success">发布供应</a>
													<!-- <a href="#" class="btn btn-default">查看全部</a> -->
												</div>
											</s:if>
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
													<td><s:date name="#supply.publishTime" nice="true" /></td>
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
											<s:if test="#session.user.id==user.id">
												<div class="text-right">
													<a href="#" class="btn btn-success">发布需求</a>
													<!-- <a href="#" class="btn btn-default">查看全部</a> -->
												</div>
											</s:if>
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
													<td><s:date name="#need.publishTime" nice="true" /></td>
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