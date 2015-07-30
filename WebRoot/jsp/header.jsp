<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/css/style.css'/>" rel="stylesheet">
<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/js/scripts.js'/>"></script> -->
<title></title>
</head>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">大学生创业网</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">首页</a></li>
					<li><a href="#">项目</a></li>
					<li><a href="<%=request.getContextPath()%>/Tutor-list">导师</a></li>
					<li><a href="#">机构</a></li>
					<li><a href="#">供需</a></li>
					<li><a href="#">关于我们</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">知识<strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a href="#">政策知识</a></li>
							<li><a href="#">创业知识</a></li>
							<li><a href="#">法律知识</a></li>
							<!-- <li class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li class="divider"></li>
							<li><a href="#">One more separated link</a></li> -->
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" />
					</div>
					<div class="form-group">
						<select class="form-control"><option value="project">项目</option>
							<option value="tutor">导师</option>
							<option value="entrepreneur">创业者</option>
							<option value="knowledge">知识</option></select>
					</div>
					<button type="submit" class="btn btn-default">搜索</button>
				</form>
				<s:if test="#session.user==null">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="<c:url value='/user/applylogin'/>">登录</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">注册<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a
									href="<c:url value='/user/applyregister?role=entrepreneur'/>">我是创业者</a></li>
								<li><a
									href="<c:url value='/user/applyregister?role=tutor'/>">我是创业导师</a></li>
								<li><a
									href="<c:url value='/user/applyregister?role=institution'/>">我是创业机构</a></li>
								<!-- <li class="divider">
								</li>
								<li>
									<a href="#">Separated link</a>
								</li> -->
							</ul></li>
					</ul>
				</s:if>
				<s:else>
					<ul class="nav navbar-nav navbar-right">
						
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><s:property value="#session.user.name" /><strong
								class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value='#'/>">个人主页</a></li>
								<li><a href="<c:url value='#'/>">好友</a></li>

								<li class="divider"></li>
								<li><a href="<c:url value='/user/logout'/>">退出</a></li>
							</ul>
						<li><a href="<c:url value='#'/>">私信<span
								class="badge pull-right">16</span></a></li>
						<li><a href="<c:url value='#'/>">消息<span
								class="badge pull-right">30</span></a></li>
					</ul>
				</s:else>
			</div>
			</nav>
		</div>
	</div>
</div>
</body>
</html>