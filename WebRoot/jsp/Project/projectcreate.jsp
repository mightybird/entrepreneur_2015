<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
<link
	href="<c:url value='/datetimepicker/css/bootstrap-datetimepicker.min.css'/>"
	rel="stylesheet" media="screen">
<link href="<c:url value='/css/style.css'/>" rel="stylesheet">
<link href="<c:url  value='/tokenfield/css/tagsinput.css'/>"  rel="stylesheet" type="text/css" /> 
<script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/scripts.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/datetimepicker/js/bootstrap-datetimepicker.js'/>"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="<c:url value='/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js'/>"
	charset="UTF-8"></script>
<script src="<c:url value='/tokenfield/js/jquery.tagsinput.js'/>" type="text/javascript"></script>
<script type="text/javascript">
$(function () 
		{ $("#txtTags").TagsInput
	({ usedTags: "电信|互联网|分布式|小时代|材料|机械|手游",
		hotTags: "hotTag1|hotTag2|hotTag3|hotTag4",
		tagNum: 10, maxWords: 10 }); });  
</script>



<title></title>
</head>
<body>
	<jsp:include page="/jsp/header.jsp"></jsp:include>
	
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
		<h1>创建项目</h1>
			<form role="form"  action="createProjectSubmit" method="post" id="create_project_form" name="create_project_form">
				<div class="form-group"> 
					<label for="exampleInputEmail1">
						项目名称
					</label>
					<input type="text" name="projectname"class="form-control" id="exampleInputEmail1" required />
				</div>

				<div class="form-group">
					<label for="exampleInputEmail1">
						发起时间
					</label>
							<div class="input-group date form_date col-md-12" data-date=""
								data-date-format="yyyy-MM-dd" data-link-field="dtp_input2"
								data-link-format="yyyy-mm-dd">
								<input id="dtp" class="form-control" size="16" type="text"
									name="startTime" value="" readonly  required > <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-remove"></span></span> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-calendar"></span></span>
							</div>
							
				</div>
				
				
				<div class="form-group">
					<label for="exampleInputEmail1">
						资金类型
					</label>
					<div  >
					<select name="fundtype" id="fundtype" style="width:610px; margin-top:10px">
						<s:iterator value="#request.fundtype">
							<option>
								<s:property value="ddvalue" />
							</option>
						</s:iterator>
					</select>
					
					</div>
					
				</dir>
				
				
				
				
				<div class="form-group">
					<label style="margin-top:10px">
						资金总额(单位万元)
					</label>
					<div  >
					<select name="fundscope" id="fundscope"  style="width:610px; margin-top:10px">
						<s:iterator value="#request.fundscope">
							<option>
								<s:property value="ddvalue" />
							</option>
						</s:iterator>
					</select>
					
					</div>
				
				
				<div class="form-group">
					<label style="margin-top:10px">
						尚缺资金(单位万元)
					</label>
					<div  >
					<select name="fundlack" id="fundlack"  style="width:610px; margin-top:10px">
						<s:iterator value="#request.fundlack">
							<option>
								<s:property value="ddvalue" />
							</option>
						</s:iterator>
					</select>
					
					</div>
				</div>
				
				<div >
					<label style="margin-top:10px">联系方式</label>
					<input type="text" name="contact" class="form-control" id="exampleInputEmail1" />
				</div>
				
				<div>
					<label style="margin-top:10px">我的标签</label>
					<div>
						<input type="text" value="金融|投资|电网|第三产业" name="txtTags" id="txtTags" />
					</div>
					
				</div>
				<div>
					<label style="margin-top:10px">项目简介</label>
					<div>
					<textarea rows="5" cols="97" name="introduce" id="introduce"></textarea>
					</div>
					
				</div>
				<button type="submit" class="btn btn-default"  style="margin-top:10px">
					提   交
				</button>
			</form>
		</div>
		<div class="col-md-4">
		</div>
	</div>
</div>
	<script type="text/javascript">
		$('.form_date').datetimepicker({
			language : 'zh-CN',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0
		});
	</script>	
</body>