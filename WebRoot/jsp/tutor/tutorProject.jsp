<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	  <s:iterator value="projects" var="c">
	  	<ul style="list-style: none;">
			<li>项目名字 ：<s:property value="#c.name"/></li>
			<li>项目发布时间：<s:property value="#c.experience"/></li>							
			<li>导师职位：<s:property value="#c.occupation"/></li>
			<li><s:property value="#c.tutorship"/></li>
			<li>导师评分：<s:property value="#c.average_score"/><li>
			<li>
				<a href="#" class="_comment" onclick="detail('<s:property value="#c.id"/>')">评论</a>	
			</li>			
		</ul>	
	  </s:iterator>
	  <div style="display: none;width: 100px;height: 100px;border: 1px solid red;" class="_text">
		  <form action="comment" id="comment" method="post">
		  	<textarea rows="20" cols="30"  name="tutorComment"></textarea>
		  	<input type="submit" value="提交">
		  </form>
	  </div>
</body>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
		$("._comment").click(function(){
			$("._text").toggle("slow");
		});
		function detail(tutorId){
			$(document.forms["comment"]).append("<input type='hidden' name='tutorId' value='"+ tutorId + "'>");
		}
	</script>
</html>