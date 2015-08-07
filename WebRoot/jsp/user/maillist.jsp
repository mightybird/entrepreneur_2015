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
<title><s:property value="#session.user.name" />的私信</title>
</head>
<body>
	<jsp:include page="/jsp/header.jsp"></jsp:include>
	<%-- <s:debug></s:debug> --%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="page-header">
					<h3>
						<s:property value="#session.user.name" />
						的私信
					</h3>
				</div>
				<div class="panel-group" id="accordion" role="tablist"
					aria-multiselectable="true">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion"
									href="#collapseOne" aria-expanded="true"
									aria-controls="collapseOne">
									<div class="text-left">收件箱</div>
									<div class="text-right">
										<small> 第&nbsp; <s:property
												value="receivedMail.currentPage" /> &nbsp;页&nbsp;共&nbsp; <s:property
												value="receivedMail.pageCount" /> &nbsp;页&nbsp;
										</small>
									</div>
								</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in"
							role="tabpanel" aria-labelledby="headingOne">

							<table class="table table-hover">
								<thead>
									<tr>
										<th class="col-md-2">发送时间</th>
										<th class="col-md-2">发件人</th>
										<th class="col-md-3">标题</th>
										<th class="col-md-5">正文</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="receivedMail.entityList" var="rmail">
										<s:if test='#rmail.status=="unread"'>
											<tr class="info">
												<td><s:date name="#rmail.sendTime" nice="true" /></td>
												<td><a
														href='<%=request.getContextPath()%>/user/personalhome?userid=<s:property value="#rmail.userBySenderId.id" />'>
														<s:property value="#rmail.userBySenderId.name" />
													</a></td>
												<td><a
														href='<%=request.getContextPath()%>/user/mail?mailid=<s:property value="#rmail.id" />'>
														<s:property value="#rmail.title" />
													</a></td>
												<td><s:property value="#rmail.content" /></td>
											</tr>
										</s:if>
										<s:else>
											<tr>
												<td><s:date name="#rmail.sendTime" nice="true" /></td>
												<td><a
														href='<%=request.getContextPath()%>/user/personalhome?userid=<s:property value="#rmail.userBySenderId.id" />'>
														<s:property value="#rmail.userBySenderId.name" />
													</a></td>
												<td><a
														href='<%=request.getContextPath()%>/user/mail?mailid=<s:property value="#rmail.id" />'>
														<s:property value="#rmail.title" />
													</a></td>
												<td><s:property value="#rmail.content" /></td>
											</tr>
										</s:else>
									</s:iterator>
								</tbody>
							</table>
							<div class="panel-footer">
								<ul class="pagination pagination-sm">
									<s:if test="receivedMail.currentPage==1">
										<li class="disabled"><a>首页</a></li>
									</s:if>
									<s:else>
										<li><a
												href='<%=request.getContextPath()%>/user/mailList?rcurrentpage=1&scurrentpage=<s:property value="sentMail.currentPage"/>'>
												首页 </a></li>
									</s:else>
									<s:iterator value="receivedMail.pagination" var="p">
										<s:if test="receivedMail.currentPage==#p">
											<li class="active"><a>
													<s:property value="#p" />
												</a></li>
										</s:if>
										<s:else>
											<li><a
													href='<%=request.getContextPath()%>/user/mailList?rcurrentpage=<s:property value="#p"/>&scurrentpage=<s:property value="sentMail.currentPage"/>'>
													<s:property value="#p" />
												</a></li>
										</s:else>
									</s:iterator>
									<s:if test="receivedMail.currentPage==receivedMail.pageCount">
										<li class="disabled"><a>末页</a></li>
									</s:if>
									<s:else>
										<li><a
												href='<%=request.getContextPath()%>/user/mailList?rcurrentpage=<s:property value="receivedMail.pageCount"/>&scurrentpage=<s:property value="sentMail.currentPage"/>'>
												末页 </a></li>
									</s:else>
								</ul>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingTwo">
							<h4 class="panel-title">
								<a class="collapsed" role="button" data-toggle="collapse"
									data-parent="#accordion" href="#collapseTwo"
									aria-expanded="true" aria-controls="collapseTwo">
									<div class="text-left">发件箱</div>
									<div class="text-right">
										<small> 第&nbsp; <s:property
												value="sentMail.currentPage" /> &nbsp;页&nbsp;共&nbsp; <s:property
												value="sentMail.pageCount" /> &nbsp;页&nbsp;
										</small>
									</div>
								</a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse in"
							role="tabpanel" aria-labelledby="headingTwo">

							<table class="table table-hover">
								<thead>
									<tr>
										<th class="col-md-2">发送时间</th>
										<th class="col-md-2">收件人</th>
										<th class="col-md-3">标题</th>
										<th class="col-md-5">正文</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="sentMail.entityList" var="smail">
										<tr>
											<td><s:date name="#smail.sendTime" nice="true" /></td>
											<td><a
													href='<%=request.getContextPath()%>/user/personalhome?userid=<s:property value="#smail.userByReceiverId.id" />'>
													<s:property value="#smail.userByReceiverId.name" />
												</a></td>
											<td><a
													href='<%=request.getContextPath()%>/user/mail?mailid=<s:property value="#smail.id" />'>
													<s:property value="#smail.title" />
												</a></td>
											<td><s:property value="#smail.content" /></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
							<div class="panel-footer">
								<ul class="pagination pagination-sm">
									<s:if test="sentMail.currentPage==1">
										<li class="disabled"><a>首页</a></li>
									</s:if>
									<s:else>
										<li><a
												href='<%=request.getContextPath()%>/user/mailList?rcurrentpage=<s:property value="receivedMail.currentPage"/>&scurrentpage=1'>
												首页 </a></li>
									</s:else>
									<s:iterator value="sentMail.pagination" var="p">
										<s:if test="sentMail.currentPage==#p">
											<li class="active"><a>
													<s:property value="#p" />
												</a></li>
										</s:if>
										<s:else>
											<li><a
													href='<%=request.getContextPath()%>/user/mailList?rcurrentpage=<s:property value="receivedMail.currentPage"/>&scurrentpage=<s:property value="#p"/>'>
													<s:property value="#p" />
												</a></li>
										</s:else>
									</s:iterator>
									<s:if test="sentMail.currentPage==sentMail.pageCount">
										<li class="disabled"><a>末页</a></li>
									</s:if>
									<s:else>
										<li><a
												href='<%=request.getContextPath()%>/user/mailList?rcurrentpage=<s:property value="receivedMail.currentPage"/>&scurrentpage=<s:property value="sentMail.pageCount"/>'>
												末页 </a></li>
									</s:else>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
	<jsp:include page="/jsp/footer.jsp"></jsp:include>
</body>
</html>