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
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-6">
						<s:if test="errmsg!=null">
							<div class="row">
								<div
									class="alert alert-dismissable alert-danger col-md-5 col-md-offset-2">

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
						<div class="row">
							<div class="page-header col-md-5 col-md-offset-2">
								<h3 class="text-left">
									<s:property value="#session.user.name" />
									更改密码
								</h3>
							</div>
						</div>
						<form class="form-horizontal" method="post"
							action="<c:url value='/user/changePassword'/>">
							<div class="form-group">
								<label for="originalPassword" class="col-md-2 control-label">
									确认原密码 </label>
								<div class="col-md-5">
									<input type="password" class="form-control"
										id="originalPassword" name="originalPassword" required
										placeholder="必填" />
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-md-2 control-label">
									输入新密码 </label>
								<div class="col-md-5">
									<input type="password" class="form-control" id="password"
										name="password" required placeholder="必填" />
								</div>
							</div>
							<div class="form-group">
								<label for="passwordconfirm" class="col-md-2 control-label">
									确认新密码 </label>
								<div class="col-md-5">
									<input type="password" class="form-control"
										id="passwordconfirm" name="passwordconfirm" required
										placeholder="必填" />
								</div>
							</div>
							<div class="col-md-2"></div>
							<div class="col-md-5">
								<button type="submit" class="btn btn-default">提交</button>
							</div>
						</form>
					</div>
					<div class="col-md-2"></div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/jsp/footer.jsp"></jsp:include>
</body>
</html>