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
<title><s:property value="notice.title" /></title>
</head>
<body>
	<jsp:include page="/jsp/header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="row">
					<br />
					<br />
					<dl class="dl-horizontal">
						<dt>标题：</dt>
						<dd>
							<s:property value="notice.title" />
						</dd>
						<br />
						<dt>发送时间：</dt>
						<dd>
							<s:date name="notice.sendTime" nice="true" />
						</dd>
						<br />
						<dt>正文：</dt>
						<dd>
							<p class="lead">
								<s:property value="notice.content" />
							</p>
						</dd>
					</dl>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				<a
					href="<%=request.getContextPath()%>/user/noticeList?currentpage=1">
					<button type="button" class="btn btn-primary col-md-12">返回</button>
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