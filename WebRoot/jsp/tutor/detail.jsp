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
<title>导师的个人资料</title>
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
								<a href="#" class="btn btn-success" onclick="func('${user.role.id}','${user.id}','${tutor}')">申请评估</a>
							</div>
							<div style="margin:-30px 10px 20px 120px;width: 94px;height: 32px;border: 2px solid #ccc;overflow: hidden;border-radius:4px;">
								<select style="width: 110px;height: 32px;border: 1px solid #ccc;overflow: hidden;border-radius:4px;font-family:'微软雅黑'；font-size:15px;" id="projectId" >
									<s:iterator value="projects" var="c" >
										<option value="<s:property value="#c.project.id"/>"><s:property value="#c.project.name"/></option>
									</s:iterator>
								</select>
								<s:debug></s:debug>
							</div>
						</div>
					</div>
					<br>
					<div class="row" style="width: 600px;height: 500px;">
						<dl class="dl-horizontal">
							<s:iterator value="tutors" var="c">
							<ul style="list-style: none;font-size: 25px">
								<li>导师姓名 ：<s:property value="#c.name"/></li>
								<li>导师类型：<s:property value="#c.tutor.type"/></li>
								<li>联系方式：<s:property value="#c.contact"/></li>							
								<li>出生日期：<s:property value="#c.birth"/></li>								
								<li>简介：<s:property value="#c.introduce"/></li>
								<li>邮箱：<s:property value="#c.email"/>	</li>							
								<li>地址：<s:property value="#c.email"/></li>			
							</ul>	
							</s:iterator>
						</dl>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
			<form action="apply" method="post" id="apply"></form>
		</div>
	</div>
	<jsp:include page="/jsp/footer.jsp"></jsp:include>
	
	<script type="text/javascript">
		
	
	</script>
	<script type="text/javascript">
		function func(roleId,userId,tutorId){
			if(roleId==1){
				var projectId=$("#projectId").val();
				if(projectId==null){
					alert("申请失败")
				}else{
					alert("申请成功");
					$(document.forms["apply"]).append("<input type='hidden' name='userId' value='"+ userId + "'>,<input type='hidden' name='tutorId' value='"+ tutorId + "'>,<input type='hidden' name='projectId' value='"+ projectId + "'>");
					document.forms["apply"].submit();
				}
				
			}else{
				alert("申请失败")
			}
		}
	</script>
</body>
</html>