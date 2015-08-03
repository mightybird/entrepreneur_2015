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
<title>XXX的个人资料</title>
</head>
<body>
	<jsp:include page="/jsp/header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="jumbotron well">

					<div class="row">
						<div class="col-md-6 col-md-offset-1">
							<a href="#">
								<img class="img-responsive" alt="Responsive image"
									src="<c:url value='/images/default_head_img.jpg'/>" />
							</a>
						</div>
						<div class="col-md-5">
							<div class="text-right">
								<a href="#" class="btn btn-success">加好友</a>
								<a href="#" class="btn btn-default">发私信</a>
							</div>
						</div>
					</div>
					<br>
					<div class="row">
						<dl class="dl-horizontal">
							<dt>姓名</dt>
							<dd>XXXXXXX</dd>
							<br />
							<dt>类型</dt>
							<dd>Vestibulum id ligula porta felis euismod semper eget
								lacinia odio sem nec elit.</dd>
							<dd>Donec id elit non mi porta gravida at eget metus.</dd>
							<br />
							<dt>性别</dt>
							<dd>Etiam porta sem malesuada magna mollis euismod.</dd>
							<br />
							<dt>电子邮箱</dt>
							<dd>Fusce dapibus, tellus ac cursusa justo sit amet risus.</dd>
							<br />
							<dt>联系方式</dt>
							<dd>Fusce dapibus, tellus ac cursumassa justo sit amet risus.</dd>
							<br />
							<dt>地址</dt>
							<dd>Fusce dapibus, tellus ac cum massa justo sit amet risus.</dd>
							<br />
							<dt>个人简介</dt>
							<dd>Fusce dapibus, tellus ac cursus coa justo sit amet risus.</dd>
							<br />
							<dt>注册时间</dt>
							<dd>Fusce dapibus, tellus ac cutum massa justo sit amet risus.</dd>
							<br />
							<dt>被访问次数</dt>
							<dd>Fusce dapibus, tellus ac cursm massa justo sit amet risus.</dd>
							<br />
						</dl>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	<jsp:include page="/jsp/footer.jsp"></jsp:include>
</body>
</html>