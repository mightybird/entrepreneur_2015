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
			<div class="col-md-5">
				<div class="row">
					<div class="page-header col-md-5 col-md-offset-2">
						<h3 class="text-left">大学生创业网欢迎您</h3>
					</div>
				</div>
				<form class="form-horizontal" role="form" method="post"
					action="<c:url value='/user/login'/>">
					<div class="form-group">
						<label for="email" class="col-md-2 control-label"> 邮箱 </label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="email" name="email"
								required />
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-md-2 control-label"> 密码 </label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="password"
								name="password" required />
						</div>
					</div>
					<!-- <div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">

								<label> <input type="checkbox" /> Remember me
								</label>
							</div>
						</div>
					</div> -->
					<div class="form-group">
						<div class="col-sm-offset-2 col-md-10">
							<button type="submit" class="btn btn-default">登录</button>
						</div>
					</div>
				</form>
				<s:if test="errmsg!=null">
					<div class="row">
						<div
							class="alert alert-dismissable alert-danger col-md-offset-1">

							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">×</button>
							<h4>警告!</h4>
							<strong> <s:property value="errmsg" />
							</strong>
							<!-- <a href="#" class="alert-link">
										alert link
										</a> -->
						</div>
					</div>
				</s:if>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="/jsp/footer.jsp"></jsp:include>
</body>
</html>