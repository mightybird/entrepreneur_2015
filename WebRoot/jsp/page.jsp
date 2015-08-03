<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
	<!-- 分页 -->
<div style="width: 1880px;height: 240px;margin-left: 20px;">
	<div class="panel panel-default" >
	  	
	</div>
	<%--总分页--%>
	<div>
		<div class="panel-body" style="width: 350px;height: 50px;margin-left: 400px;float:left;margin-top:10px;">
			   <%-- 页次：${currentPage }/${pageCount }页 &nbsp; 
			   每页显示：${pageSize }条 &nbsp; 总记录数：${recordCount }条  --%>
	 	</div>
	
	<ul class="pagination">
		<%--首页 --%>
		<li><a href="javascript:gotoPageNum(1)" style="cursor: hand;">首页</a></li>
	
		<s:iterator begin="%{beginPageIndex }" end="%{endPageIndex}" var="num">
			<%--当前页 --%>
			<s:if test="#num == currentPage">
				  <li class="active"><a>${num }<span class="sr-only">(current)</span></a></li>
			</s:if>
			<%--非当前页 --%>
			<s:else>
			  		<li><a onclick="gotoPageNum(${num });" style="cursor: hand;">${num }
			  		 <span class="sr-only" >(current)</span></a></li>
			</s:else>
		</s:iterator>
		
			<%--尾页 --%>
		<li><a href="javascript:gotoPageNum(${pageCount })" style="cursor: hand;">尾页</a></li>
		<li></li>
		<li>
			
				&nbsp&nbsp&nbsp第&nbsp&nbsp<select onchange="gotoPageNum(this.value)" id="_pn" style="padding: 5px 0;margin: 2px 0 0;border:1px solid #d0d0d0;width:80px;height:32px;border-radius:3px;">
					<s:iterator begin="1" end="%{pageCount }" var="num">
						<option value="${num }">${num }</option>
					</s:iterator>
				</select>&nbsp&nbsp页&nbsp&nbsp
		</li>
		<li>
			共 &nbsp ${pageCount } &nbsp 页
		</li>
	</ul>
	</div>
		<%--分页 跳转--%>
	<%-- <div>
		转到： <select onchange="gotoPageNum(this.value)" id="_pn" style="padding: 5px 0;margin: 2px 0 0;border:1px solid #d0d0d0;width:80px;height:30px;border-radius:3px;">
			<s:iterator begin="1" end="%{pageCount }" var="num">
				<option value="${num }">${num }</option>
			</s:iterator>
		</select>
	</div> --%>
		
		
		<%--前一页 后一页 --%>
	<div>
		<ul class="pager">
			<s:if test="currentPage == 1&&pageCount!=1&&pageCount!=0">
		  		<%-- <li class="next"><a onclick="gotoPageNum(${currentPage+1 });" style="cursor: hand;">Newer &rarr;</a></li> --%>
		  		<li class="next"><a onclick="gotoPageNum(${currentPage+1 });" style="cursor: hand;"></a></li>
			</s:if>
			
			<s:elseif test="currentPage==#num">
		 		<%--  <li class="previous"><a onclick="gotoPageNum(${currentPage-1 });" style="cursor: hand;">&larr; Older</a></li> --%>
		 		 <li class="previous"><a onclick="gotoPageNum(${currentPage-1 });" style="cursor: hand;"></a></li>
			</s:elseif>
			
			<s:else>
		  		<%-- <li class="next"><a onclick="gotoPageNum(${currentPage+1 });" style="cursor: hand;">Newer &rarr;</a></li>
		  		<li class="previous"><a onclick="gotoPageNum(${currentPage-1 });"style="cursor: hand;">&larr; Older</a></li> --%>
		  		
		  		<li class="next"><a onclick="gotoPageNum(${currentPage+1 });" style="cursor: hand;"></a></li>
		  		<li class="previous"><a onclick="gotoPageNum(${currentPage-1 });" style="cursor: hand;"></a></li>
			</s:else>
		</ul>
	</div>
</div>

<script type="text/javascript">
				$("#_pn").val("${currentPage}");
</script>
<script type="text/javascript">
		function gotoPageNum(currentPage) {
			$(document.forms["page"]).append("<input type='hidden' name='currentPage' value='"+ currentPage + "'>");
			document.forms["page"].submit();
		}
</script>
</body>
</html>