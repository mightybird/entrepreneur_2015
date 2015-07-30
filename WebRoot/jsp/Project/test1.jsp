<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/css/style.css'/>" rel="stylesheet">
<link href="<c:url  value='/tokenfield/css/tagsinput.css'/>"  rel="stylesheet" type="text/css" /> 
<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/js/scripts.js'/>"></script>
<script src="<c:url value='/tokenfield/js/jquery.tagsinput.js'/>" type="text/javascript"></script>
<!--  <script src="<c:url value='/tokenfield/js/jquery-1.9.1.js'/>" type="text/javascript"></script>-->

<script type="text/javascript">
$(function () 
		{ $("#txtTags").TagsInput
	({ usedTags: "css|js|jquery|html|C#|.net|web",
		hotTags: "hotTag1|hotTag2|hotTag3|hotTag4",
		tagNum: 10, maxWords: 10 }); });  
		</script>
<title></title>
</head>
<body>
	<jsp:include page="/jsp/header.jsp"></jsp:include>
<div>
<input type="text" value="逗号|分号|空格|Tab|回车键" name="txtTags" id="txtTags" />
</div>
	
</body>