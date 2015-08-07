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
<title>项目信息</title>
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
									src="<c:url value='/images/head_image_default.png'/>" />
							</a>
						</div>
						<div class="col-md-5">
							<div class="text-right">
							<c:choose>
								<%-- <c:when test="${role_id == 1 }">
								<a href="#" class="btn btn-success" onclick="func1('${role_id}','${user.id}','${project.id}')">查看我的项目</a>	
								</c:when> --%>
								<c:when test="${role_id == 2 }">
								<a href="#" class="btn btn-success" onclick="func2('${user.role.id}','${user.id}','${tutor}')">申请评估</a>	
								</c:when>
								<c:when test="${role_id == 3 }">
								<a href="#" class="btn btn-success" onclick="func3('${user.role.id}','${user.id}','${tutor}')">申请合作</a>	
								</c:when>							
							</c:choose>
							
							
							<%-- <s:if test="#request.role_id =='1'">
								<a href="#" class="btn btn-success" onclick="func('${user.role.id}','${user.id}','${tutor}')">申请合作</a>	
							</s:if>
							<s:if test="#request.role_id=='2'">
								<a href="#" class="btn btn-success" onclick="func('${user.role.id}','${user.id}','${tutor}')">申请评估</a>	
							</s:if>
							<s:if test="#request.role_id=='3'"> 
								<a href="#" class="btn btn-success" onclick="func('${user.role.id}','${user.id}','${tutor}')">申请评估</a>	
							</s:if> --%>					
							</div>
							<div style="margin:-30px 10px 20px 120px;width: 94px;height: 32px;border: 2px solid #ccc;overflow: hidden;border-radius:4px;">
								<select style="width: 110px;height: 32px;border: 1px solid #ccc;overflow: hidden;border-radius:4px;font-family:'微软雅黑'；font-size:15px;" id="projectId" >
									<s:iterator value="projects" var="c" >
										<option value="<s:property value="#c.project.id"/>"><s:property value="#c.project.name"/></option>
									</s:iterator>
								</select>							
							</div>
						</div>
					</div>
					<br>
					<div class="row" style="width: 600px;height: 500px;">
						<dl class="dl-horizontal">
							<s:iterator value="project" var="c">
							<ul style="list-style: none;font-size: 25px">
								<li>项目名称 ：<s:property value="#c.name"/></li>
								<li>项目标签：
								<s:if test="#request.labels.size()==0">
								暂无标签
								</s:if>
								<s:iterator value="#request.labels">
									<input type="button" class="labelBt" value="<s:property value="name"/>"></input>
								</s:iterator>
								</li>
								<li>开始时间：<s:property value="#c.startTime"/></li>							
								<li>资金类型：<s:property value="#c.fundType"/></li>								
								<li>资金范围：<s:property value="#request.project.fundLackLower" />
						                    万元-<s:property value="#request.project.fundLackUpper" />万元</li>
								<li>尚缺资金：<s:property value="#request.project.fundAmountLower" />
						                    万元-<s:property value="#request.project.fundAmountUpper" />万元</li>							
								<li>联系方式：
								<s:if test="#c.contact.length()==0">
								无
								</s:if>
								<s:property value="#c.contact"/>
								</li>	
								<li>项目简介：
								<s:if test="#c.introduce.length()==0">
								无
								</s:if>								
								<s:property value="#c.introduce"/>
								</li>		
								<li>下载附件： <a href="">下载</a> </li>			
							</ul>	
							</s:iterator>
						</dl>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
			<%-- <form action="<%=request.getContextPath()%>/project/showProjectInfoPage?projectid=
			<s:property value="project.id"/>" method="post" id="showProjectInfoPage"></form> --%>
			<form action="EstimateProject" method="post" id="EstimateProject"></form>
			<form action="CooperateWithProject" method="post" id="coperate"></form>
		</div>
	</div>
	<jsp:include page="/jsp/footer.jsp"></jsp:include>
	
	<script type="text/javascript">
	function func1(roleid,userid,projectid){
		alert(projectid);
		if(projectid==null){
			alert("查看失败,请先登录");
		}else{			
			document.forms["showProjectInfoPage"].submit();
			
		}
	}
	
	</script>
	<script type="text/javascript"> 
		function func2(roleId,userId,tutorId){
			if(roleId==1){
				var projectId=$("#projectId").val();
				if(projectId==null){
					alert("申请失败,请先登录");
				}else{
					alert("申请成功");
					$(document.forms["apply"]).append("<input type='hidden' name='userId' value='"+ userId + "'>,<input type='hidden' name='tutorId' value='"+ tutorId + "'>,<input type='hidden' name='projectId' value='"+ projectId + "'>");
					document.forms["apply"].submit();
				}
			}else{
				alert("申请失败");
			}
		}
	</script>
	<script type="text/javascript"> 
		function func3(roleId,userId,tutorId){
			if(roleId==1){
				var projectId=$("#projectId").val();
				if(projectId==null){
					alert("申请失败,请先登录");
				}else{
					alert("申请成功");
					$(document.forms["apply"]).append("<input type='hidden' name='userId' value='"+ userId + "'>,<input type='hidden' name='tutorId' value='"+ tutorId + "'>,<input type='hidden' name='projectId' value='"+ projectId + "'>");
					document.forms["apply"].submit();
				}
			}else{
				alert("申请失败");
			}
		}
	</script>
	
	<s:debug></s:debug>
</body>