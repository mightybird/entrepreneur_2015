<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<s:url value="/" var="newurl"></s:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/css/style.css'/>" rel="stylesheet">
<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/js/scripts.js'/>"></script>
<script>
	function verifyForm(nameStr) {
		var fileType = (nameStr.substring(nameStr.lastIndexOf(".") + 1,
				nameStr.length)).toLowerCase();
		var suppotFile = new Array();
		suppotFile[0] = "bmp";
		suppotFile[1] = "jpg";
		suppotFile[2] = "gif";
		suppotFile[3] = "png";
		for (var i = 0; i < suppotFile.length; i++) {
			if (suppotFile[i] == fileType) {
				return true;
			} else {
				continue;
			}
		}
		alert("不支持文件类型" + fileType + ",只支持bmp,jpg,gif,png类型");
		return false;
	}
	function uploadImage(projectId) {
		var projectId = $("#projectId").val();

		//alert("11");
		if (document.getElementById("fileuploadImage").value == '') {
			alert("你没有打开文件！");
			return;
		} else if (verifyForm(document.getElementById("fileuploadImage").value)) {
			alert("11");
			$(document)
					.ready(
							function() {
								var options = {
									"projectId" : $("#projectId").val(),
									"uploadFileName" : $("#fileuploadImage")
											.val()
								};
								$
										.ajax({
											url : '/entrepreneur_2015/project/modifyProjectImage',
											data : options,
											type : "POST",
											dataType : 'text/xml',
											success : function(msg) {
												if (msg.indexOf("#") > 0) {
													var data = msg.split("#");
													$("#tipDiv").html(data[0]);
													$("#showImage")
															.html(
																	"<img width='150px' height='150px' src='/entrepreneur_2015/project/showImage?imageUrl="
																			+ data[1]
																			+ "'/>");
												} else {
													$("#tipDiv").html(msg);
												}
											}

										});
								/*  $("#form2").ajaxSubmit(options);  
								 return false;   */
							});
		}
	}
</script>


<title></title>
</head>
<body>
	<jsp:include page="/jsp/header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div id=maincontent>
					<h1>项目信息</h1>
					<div style="float: left; margin-top: 10px">
						<img width="150px" height="150px"
							src="<%=request.getContextPath()%>/images/<s:property value="#session.project_image" />" />
					</div>
					<div style="height: 150px">
						<div>

							<input type="button" value="解散项目" class="dismissBt"
								style="background-color: red; margin-left: 150px"
								onclick="dismissProject('<s:property value="#request.projectid"/>')" />
						</div>
						<div id="modifyImage">
							修改项目图标:
							<form
								action="modifyProjectImage?projectId=<s:property value='#request.project.id'/>"
								method="post" enctype="multipart/form-data">  
			                        浏览图片：
	                    		<input name="upload" type="file" required />
								<input type="hidden" value="${project.id }" />
								<input type="submit" value="上传" class="submit_btn" />
							</form>
						</div>
					</div>


					<div>
						<h3 style="color: green">项目标签：</h3>
					</div>
					<div style="margin-top: 10px">
						<s:if test="#request.labels.size==0">
			暂无标签~
			</s:if>
						<!--   <s:iterator value="#request.project.projectLabels.label" status="status">
				<input type="button" class="labelBt" value="<s:property value="name"/>"></input>
			</s:iterator>-->
						<s:iterator value="#request.labels">
							<input type="button" class="labelBt" value="<s:property />"></input>
						</s:iterator>
					</div>

					<div>
						<h3 style="color: green">项目名称：</h3>
					</div>
					<div id="inputCantainer">
						<s:property value="#request.project.name" />
					</div>
					<div>
						<h3 style="color: green">项目人数：</h3>
					</div>
					<div id="inputCantainer">
						1
						<!--   <s:property value="#request.project.memberNumber"/> -->
						人
					</div>

					<div>
						<h3 style="color: green">发起时间：</h3>
					</div>
					<div id="inputCantainer">
						<s:date name="#request.project.startTime" format="yyyy-MM-dd" />
					</div>

					<div>
						<h3 style="color: green">资金类型：</h3>
					</div>
					<div id="inputCantainer">
						<s:property value="#request.project.fundType" />
					</div>

					<div>
						<h3 style="color: green">资金总额：</h3>
					</div>
					<div id="inputCantainer">
						<s:property value="#request.project.fundAmountLower" />
						万元-
						<s:property value="#request.project.fundAmountUpper" />
						万元
					</div>
					<div>
						<h3 style="color: green">尚缺资金：</h3>
					</div>
					<div id="inputCantainer">
						<s:property value="#request.project.fundLackLower" />
						万元-
						<s:property value="#request.project.fundLackUpper" />
						万元
					</div>

					<div>
						<h3 style="color: green">联系方式：</h3>
					</div>
					<div id="inputCantainer">
						<s:property value="#request.project.contact" />
					</div>

					<div>
						<h3 style="color: green">所属行业：</h3>
					</div>
					<div id="inputCantainer">
						<s:property value="#request.project.industry.name" />
					</div>
					<div>
						<h3 style="color: green">项目简介：</h3>
					</div>
					<div id="inputCantainer">
						<s:property value="#request.project.introduce" />
					</div>
					<div id="inputCantainer">
						<h3 style="color: green">项目附件：</h3>
					</div>

					<div id=download>
						<s:if test="#request.projectAccessoryName!='NULL'">
							<s:if test="#request.projectAccessoryName.contains(\".zip\")">
								<img src="${newurl}assets/image/zip.png" class="image_frame" />
							</s:if>
							<s:if test="#request.projectAccessoryName.contains(\".rar\")">
								<img src="${newurl}assets/image/rar.png" class="image_frame" />
							</s:if>
							<br></br>
							<a href="javascript:void(0);"
								onclick="download('${newurl}<s:property value="#request.projectAccessoryPath"/>')">
								下载文档<s:property value="#request.projectAccessoryName" />...
							</a>
						</s:if>
						<s:else>
							<div id="title">暂无资料~</div>
						</s:else>
						<div>
							<form action="UploadAccessary" method="post"
								enctype="multipart/form-data">
								选择文件：<input type="file" name="upload" required /> 
								       <input type="submit" value="上传" />
							</form>

						</div>


					</div>


					<div class="col-md-3"></div>
				</div>




			</div>

		</div>
	</div>
	<s:debug></s:debug>

</body>