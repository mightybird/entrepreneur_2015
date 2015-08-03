<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
	<link href="<c:url value='/css/style.css'/>" rel="stylesheet">
	<script src="<c:url value='/js/jquery.min.js'/>"></script>
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/js/scripts.js'/>"></script>
	<title>大学生创业平台</title>
</head>
<body>
	<!-- 页面导航栏 -->
	<jsp:include page="/jsp/header.jsp"></jsp:include>
	<!-- 中间部分 -->
	<div class="container-fluid" style="width: 1880px;height:580px;border-radius:5px;">
	<div class="row" style="border: 1px solid #d0d0d0;width: 1870px;height:580px;border-radius:5px;">
		<div class="col-md-1" >
		</div>
		<!-- 侧面导师导航栏 -->
		<div class="col-md-2" style="border:1px solid #d0d0d0;width: 200px;height:580px;background: #d9fff7">
			<h3 class="text-center" style="padding-top: 3px">
				<a href="<%=request.getContextPath()%>/Tutor-list" style="font-family: '微软雅黑';font-size: 28px;text-decoration: none;">全部导师信息</a>
			</h3>
			<h3 class="text-center">
				<a href="<%=request.getContextPath()%>/Manage-manage" style="font-family: '微软雅黑';font-size: 24px;text-decoration: none;">经营管理导师</a>
			</h3>
			<h3 class="text-center">
				<a href="<%=request.getContextPath()%>/Finace-finace" style="font-family: '微软雅黑';font-size: 24px;text-decoration: none;">财务导师</a>
			</h3>
			<h3 class="text-center">
				<a href="<%=request.getContextPath()%>/Technique-technique" style="font-family: '微软雅黑';font-size: 24px;text-decoration: none;">技术指导导师</a>
			</h3>
			<h3 class="text-center">
				<a href="<%=request.getContextPath()%>/Market-market" style="font-family: '微软雅黑';font-size: 24px;text-decoration: none;">市场环境导师</a>
			</h3>
		</div>
		<!-- 中间导师详细信息 -->
		<div class="col-md-8" style="width: 1350px;height:580px;float:left;">
			<div class="row" >
				<div class="col-md-4">
				</div>
				<div class="col-md-5" style="width: 800px;height:580px;margin-left: -265px;float:left;">
					<ul class="list-unstyled" >						
						<li style="padding-top: 20px;width: 800px;height:580px;font-family: '微软雅黑';font-size: 20px">
							<s:iterator value="technique1s" var="c">
								<s:div style="border: 1px solid #d0d0d0;width: 700px;height:180px;float:left;">
									<s:div style="width: 100px;height:140px;float:left;">
										<img alt="picture" src="images/4.jpg" style="width:100%;height:100%"  >
									</s:div>
									<s:div style="width: 550px;height:180px;float:left;padding-left:30px;padding-top:3px;">
										<s:property value="#c.id"/><br>
										<s:property value="#c.type"/><br>
										<s:property value="#c.experience"/><br>							
										<s:property value="#c.occupation"/><br>
										<s:property value="#c.tutorship"/><br>
										<s:property value="#c.average_score"/><br>
									</s:div>																	
								</s:div>								
							</s:iterator>
							<s:debug></s:debug>
						</li>
					</ul>
					<form action="Technique-technique" id="page" method="post">
					</form>
				</div>
				
				<!-- 推荐区 -->
				<div class="col-md-3" style="width: 320px;height: 580px;border:1px solid #d0d0d0;">
				</div>
			</div>
		</div>
		<div class="col-md-1">
		</div>
	</div>
</div>
<div>
	<jsp:include page="/jsp/page.jsp"></jsp:include>
</div>
</body>
</html>