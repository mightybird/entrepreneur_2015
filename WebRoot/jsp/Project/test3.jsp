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
	<a href="../homepage.jsp">test2</a>
		<div>
			<label style="margin-top:10px">上传附件</label>
			<div>
				 <form action="/entrepreneur_2015/utils/Upload" method="post" enctype="multipart/form-data">
					 <input type="file" name="upload" required/>
					 <input type="submit" value="上传" />
				 </form>	
			</div>		
		</div>
		
		
		<s:a  action="../../project/ShowProjectCreatePage">快速发布2</s:a>
		
		
		
		<form action="/entrepreneur_2015/project/ShowProjectCreatePage">
			<input  type="submit" value="快速发布3" />
		</form>
		
		<s:a  action="<c:url value='/utils/upload'/>">快速发布1</s:a>
		
		<form action="upload" method="post" enctype="multipart/form-data">
		选择文件：<input type="file" name="upload" / >
		       <input   type="submit" value="上传"/>
		
		</form>	
		
		
		
		
		
		
		
		
		
		
		
		
</body>