<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
	
	<div class="container-fluid" style="width: 1880px;height:580px;border-radius:5px;">
	<div class="row" style="border: 1px solid #d0d0d0;width: 1870px;height:580px;border-radius:5px;">
		<div class="col-md-1">
		</div>
		<!-- 侧边栏信息 -->
		<div class="col-md-2">
		</div>
		<!-- 中间部分 -->
		<div class="col-md-8">
			<div class="row" >
				<div class="col-md-3">			
				</div>
				<div class="col-md-5" style="width: 800px;height:580px;margin-left: -265px;float:left;" id="c_div">
				<ul class="list-unstyled" >						
						<li style="padding-top: 20px;width: 800px;height:580px;font-family: '微软雅黑';font-size: 20px">
							<s:iterator value="project1s" var="c">
								<s:div style="border: 1px solid #d0d0d0;width: 700px;height:180px;float:left;">
									<s:div style="width: 100px;height:140px;float:left;">
										<img alt="picture" src="<%=request.getContextPath()%>/images/project_list_default.jpg" style="width:100%;height:100%"  >
									</s:div>
									<s:div style="width: 560px;height:180px;float:left;padding-left:30px;padding-top:3px;">
										<ul style="list-style: none;">
											<li>项目名称 ：<s:property value="#c.name"/></li>	
											<li>创建者：<s:property value=""/></li>				
											<li>创建时间：<s:property value="#c.startTime"/></li>
											<li>项目简介：<s:property value="#c.introduce"/></li>											
											<a href="#"  style="text-decoration: none;padding-left: 325px;" onclick="detail('<s:property value="#c.id"/>')" >详情</a>
											<li>		
										</ul>									
									</s:div>																
								</s:div>								
							</s:iterator>										
							<s:debug></s:debug>
						</li>
					</ul>
					<form action="ShowProjectList" id="page" method="post"></form>
					<form action="ShowProjectDetail" id="detail" method="post"></form>
				</div>
				<div class="col-md-3">
				
				</div>
			</div>
		</div>
		<!-- 推荐信息 -->
		<div class="col-md-1">
		</div>
	</div>
</div>
<div>
	<jsp:include page="/jsp/page.jsp"></jsp:include>
</div>
<script type="text/javascript">
		function detail(projectId){
			$(document.forms["detail"]).append("<input type='hidden' name='projectId' value='"+ projectId + "'>");
			document.forms["detail"].submit();		
		}
</script>


</body>