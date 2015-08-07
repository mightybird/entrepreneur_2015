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
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="row">
					<br /> <br />
					<dl class="dl-horizontal">
						<dt>标题：</dt>
						<dd>
							<s:property value="mail.title" />
						</dd>
						<br />
						<dt>发送时间：</dt>
						<dd>
							<s:date name="mail.sendTime" nice="true" />
						</dd>
						<br />
						<dt>发送者：</dt>
						<dd>
							<a
								href='<%=request.getContextPath()%>/user/personalhome?userid=<s:property value="mail.userBySenderId.id"/>'>
								<s:property value="mail.userBySenderId.name" />
							</a>
						</dd>
						<br />
						<dt>接收者：</dt>
						<dd>
							<a
								href='<%=request.getContextPath()%>/user/personalhome?userid=<s:property value="mail.userByReceiverId.id"/>'>
								<s:property value="mail.userByReceiverId.name" />
							</a>
						</dd>
						<br />
						<div class="row">
							<div class="col-md-12">
								<dt>正文：</dt>
								<dd>
									<p class="lead">
										<s:property
											value="mail.content" />
									</p>
								</dd>
							</div>
						</div>
					</dl>
				</div>
				<br>
				<br>
				<br>
				<br> <br>
				<div class="row">
					<a id="modal-88389" href="#modal-container-88389" role="button"
						class="btn btn-success col-md-6" data-toggle="modal">
						<s:if test="#session.user.id==mail.userByReceiverId.id">
						回复
						</s:if>
						<s:else>
						再发一封
						</s:else>
					</a>
					<div class="modal fade" id="modal-container-88389" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">

									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">
										向
										<s:if test="#session.user.id==mail.userByReceiverId.id">
											<s:property value="mail.userBySenderId.name" />
										</s:if>
										<s:else>
											<s:property value="mail.userByReceiverId.name" />
										</s:else>
										发私信
									</h4>
								</div>
								<s:if test="#session.user.id==mail.userByReceiverId.id">
									<form method="post"
										action='<%=request.getContextPath()%>/user/sendMail?id=<s:property value="mail.userBySenderId.id" />'>
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
								</s:if>
								<s:else>
									<form method="post"
										action='<%=request.getContextPath()%>/user/sendMail?id=<s:property value="mail.userByReceiverId.id" />'>
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
								</s:else>
							</div>
						</div>
					</div>
					<a
						href="<%=request.getContextPath()%>/user/mailList?rcurrentpage=1&scurrentpage=1">
						<button type="button" class="btn btn-primary col-md-6">返回</button>
					</a>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	<jsp:include page="/jsp/footer.jsp"></jsp:include>
</body>
</html>