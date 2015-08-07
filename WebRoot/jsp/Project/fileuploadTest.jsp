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
<script type="text/javascript">
function uploadDoc(projectId) { 	
		 $(document).ready( 
                 function() {  
                     var options = {  
                         url : '${newurl}modifyProjectDoc?pathType=project_accessory_path&projectId='+projectId,  
                         type : "POST",  
                         dataType :'text/xml',  
                         success : function(msg) {
                             if (msg.indexOf("#") > 0) {  
                                 var data = msg.split("#");  
                                 if(data[0]=='项目资料改成功!')
                                 {
                                 	 alert("修改成功！");
                                 	location.reload();
                                 }
                                 location.reload();
                             } else {  
                                 $("#tipDivDoc").html(msg);  
                             }  
                         }  
                     };  
                     $("#doc_form").ajaxSubmit(options);  
                     return false;  
                 });  
	
   
} 

</script>


<title></title>
</head>
<body>
	<jsp:include page="/jsp/header.jsp"></jsp:include>
	
	
	
	<div  id="modifyImage">
		上传资料(会覆盖掉之前的旧资料):
		<form id="doc_form" method="post" enctype="multipart/form-data">  
		                        浏览文档：
                  <input id="fileuploadDoc" name="upload" type="file"  required/>  
                  <span id="tipDivDoc"></span> 
                  <input type="button" value="上传" class="submit_btn" 
                  onclick="uploadDoc('<s:property value="#request.project.id"/>')"/> 
               
    	</form> 
	</div> 
	<s:debug></s:debug>
</body>