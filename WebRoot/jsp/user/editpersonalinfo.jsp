<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
<link
	href="<c:url value='/datetimepicker/css/bootstrap-datetimepicker.min.css'/>"
	rel="stylesheet" media="screen">
<link href="<c:url value='/css/style.css'/>" rel="stylesheet">
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
<title><s:property value="#session.user.name" />修改个人信息</title>
</head>
<body>
	<jsp:include page="/jsp/header.jsp"></jsp:include>
	<s:debug></s:debug>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-6">
						<%-- <s:if test="errmsg!=null">
							<div class="row">
								<div
									class="alert alert-dismissable alert-danger col-md-5 col-md-offset-2">

									<button type="button" class="close" data-dismiss="alert"
										aria-hidden="true">×</button>
									<h4>警告!</h4>
									<strong> <s:property value="errmsg" />
									</strong>
									<!-- <a href="#" class="alert-link">
										alert link
										</a> -->
								</div>
							</div>
						</s:if> --%>
						<div class="row">
							<div class="page-header col-md-5 col-md-offset-2">
								<h3 class="text-left">基本信息</h3>
							</div>
						</div>
						<form class="form-horizontal" method="post"
							action="<c:url value='/user/editPersonalInfo'/>">
							<%-- <input type="hidden" name="userid" value="<s:property value='#userid'/>" /> --%>
							<div class="form-group">
								<label for="name" class="col-md-2 control-label"> 名字 </label>
								<div class="col-md-5">
									<input type="text" class="form-control" id="name" name="name"
										value="<s:property value='user.name'/>" />
								</div>
							</div>
							<!-- <div class="form-group">
								<label for="email" class="col-md-2 control-label"> 邮箱 </label>
								<div class="col-md-5">
									<input type="email" class="form-control" id="email"
										name="email" required placeholder="必填" />
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-md-2 control-label">
									输入密码 </label>
								<div class="col-md-5">
									<input type="password" class="form-control" id="password"
										name="password" required placeholder="必填" />
								</div>
							</div>
							<div class="form-group">
								<label for="passwordconfirm" class="col-md-2 control-label">
									确认密码 </label>
								<div class="col-md-5">
									<input type="password" class="form-control"
										id="passwordconfirm" name="passwordconfirm" required
										placeholder="必填" />
								</div>
							</div> -->
							<div class="form-group">
								<label for="contact" class="col-md-2 control-label">
									联系电话 </label>
								<div class="col-md-5">
									<input type="text" class="form-control" id="contact"
										name="contact" value="<s:property value='user.contact'/>" />
								</div>
							</div>
							<div class="form-group">
								<label for="address" class="col-md-2 control-label">
									联系地址 </label>
								<div class="col-md-5">
									<textarea rows=5 " class="form-control" id="address"
										name="address"><s:property value='user.address' /></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="introduce" class="col-md-2 control-label">
									个人简介 </label>
								<div class="col-md-5">
									<textarea rows="5" class="form-control" id="introduce"
										name="introduce"><s:property value='user.introduce' /></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="gender" class="col-md-2 control-label"> 性别 </label>
								<div id="gender" class="col-md-5">
									<s:if test='user.gender=="男"'>
										<label class="radio-inline"> <input type="radio"
											name="gender" value="男" checked> 男
										</label>
										<label class="radio-inline"> <input type="radio"
											name="gender" value="女"> 女
										</label>
									</s:if>
									<s:elseif test='user.gender=="女"'>
										<label class="radio-inline"> <input type="radio"
											name="gender" value="男"> 男
										</label>
										<label class="radio-inline"> <input type="radio"
											name="gender" value="女" checked> 女
										</label>
									</s:elseif>
									<s:else>
										<label class="radio-inline"> <input type="radio"
											name="gender" value="男"> 男
										</label>
										<label class="radio-inline"> <input type="radio"
											name="gender" value="女"> 女
										</label>
									</s:else>
								</div>
							</div>
							<div class="form-group">
								<label for="dtp" class="col-md-2 control-label">生日</label>
								<div class="input-group date form_date col-md-4" data-date=""
									data-date-format="yyyy-MM-dd" data-link-field="dtp_input2"
									data-link-format="yyyy-mm-dd">
									<input id="dtp" class="form-control" size="16" type="text"
										name="birth" value="<s:property value='birth'/>" readonly>
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-remove"></span></span> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-calendar"></span></span>
								</div>
								<!-- <input type="hidden" id="dtp_input2" value="" /> -->
							</div>
							<!-- <div class="form-group">
								<label for="exampleInputFile"> File input </label> <input
									type="file" id="exampleInputFile" />
								<p class="help-block">Example block-level help text here.</p>
							</div> -->
							<!-- <div class="checkbox">
								<label> <input type="checkbox" /> Check me out
								</label>
							</div> -->
							<s:if test='#session.role.name=="entrepreneur"'>
								<!-- <input type="hidden" name="role" value="entrepreneur" /> -->
								<div class="row">
									<div class="page-header col-md-5 col-md-offset-2">
										<h3 class="text-left">创业者信息</h3>
									</div>
								</div>
								<div class="form-group">
									<label for="degree" class="col-md-2 control-label"> 学历
									</label>
									<div class="col-md-5">
										<select class="form-control" name="degree" id="degree"><option
												value="Elementary"
												<s:if test='user.entrepreneur.degree=="Elementary"'>selected</s:if>>小学</option>
											<option value="JuniorHigh"
												<s:if test='user.entrepreneur.degree=="JuniorHigh"'>selected</s:if>>初中</option>
											<option value="SeniorHigh"
												<s:if test='user.entrepreneur.degree=="SeniorHigh"'>selected</s:if>>高中</option>
											<option value="Bachelor"
												<s:if test='user.entrepreneur.degree=="Bachelor"'>selected</s:if>>本科</option>
											<option value="Master"
												<s:if test='user.entrepreneur.degree=="Master"'>selected</s:if>>硕士</option>
											<option value="Doctor"
												<s:if test='user.entrepreneur.degree=="Doctor"'>selected</s:if>>博士</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="major" class="col-md-2 control-label"> 专业 </label>
									<div class="col-md-5">
										<input type="text" class="form-control" id="major"
											name="major"
											value="<s:property value='user.entrepreneur.major'/>" />
									</div>
								</div>
								<div class="form-group">
									<label for="experience" class="col-md-2 control-label">
										职业经历 </label>
									<div class="col-md-5">
										<textarea rows="5" class="form-control" id="experience"
											name="experience"><s:property
												value='user.entrepreneur.experience' /></textarea>
									</div>
								</div>
							</s:if>

							<s:if test='#session.role.name=="tutor"'>
								<!-- <input type="hidden" name="role" value="tutor" /> -->
								<div class="row">
									<div class="page-header col-md-5 col-md-offset-2">
										<h3 class="text-left">导师信息</h3>
									</div>
								</div>
								<div class="form-group">
									<label for="ttype" class="col-md-2 control-label"> 导师类型
									</label>
									<div class="col-md-5">
										<select class="form-control" name="ttype" id="ttype">
											<s:iterator value="tutortype" var="it">
												<option value="<s:property value='#it.ddvalue'/>"
													<s:if test="user.tutor.type==#it.ddvalue">selected</s:if>>
													<s:property value='#it.ddvalue' />
												</option>
											</s:iterator>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="major" class="col-md-2 control-label">当前职业</label>
									<div class="col-md-5">
										<input type="text" class="form-control" id="occupation"
											name="occupation"
											value="<s:property value='user.tutor.occupation'/>" />
									</div>
								</div>
								<div class="form-group">
									<label for="major" class="col-md-2 control-label">指导领域</label>
									<div class="col-md-5">
										<input type="text" class="form-control" id="tutorship"
											name="tutorship"
											value="<s:property value='user.tutor.tutorship'/>" />
									</div>
								</div>
								<div class="form-group">
									<label for="experience" class="col-md-2 control-label">
										职业经历 </label>
									<div class="col-md-5">
										<textarea rows="5" class="form-control" id="experience"
											name="experience"><s:property
												value='user.tutor.experience' /></textarea>
									</div>
								</div>
							</s:if>

							<s:if test='#session.role.name=="institution"'>
								<input type="hidden" name="role" value="institution" />
								<div class="row">
									<div class="page-header col-md-5 col-md-offset-2">
										<h3 class="text-left">机构信息</h3>
									</div>
								</div>
								<div class="form-group">
									<label for="instype" class="col-md-2 control-label">
										机构类型 </label>
									<div class="col-md-5">
										<select class="form-control" name="instype" id="instype">
											<s:iterator value="institutiontype" var="it">
												<option value="<s:property value='#it.ddvalue'/>"
													<s:if test="user.institution.type==#it.ddvalue">selected</s:if>>
													<s:property value='#it.ddvalue' />
												</option>
											</s:iterator>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="principal" class="col-md-2 control-label">责任人/法人</label>
									<div class="col-md-5">
										<input type="text" class="form-control" id="principal"
											name="principal"
											value="<s:property value='user.institution.principal'/>" />
									</div>
								</div>
								<div class="form-group">
									<label for="scale" class="col-md-2 control-label">机构规模</label>
									<div class="col-md-5">
										<textarea rows="5" class="form-control" id="scale"
											name="scale"><s:property
												value='user.institution.scale' /></textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="service" class="col-md-2 control-label">
										业务范围 </label>
									<div class="col-md-5">
										<textarea rows="5" class="form-control" id="service"
											name="service"><s:property
												value='user.institution.service' /></textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="fosterIndustry" class="col-md-2 control-label">
										所属行业 </label>
									<div class="col-md-5">
										<select class="form-control" name="fosterIndustry"
											id="fosterIndustry">
											<s:iterator value="industrylist" var="it">
												<option value="<s:property value='#it.name'/>"
													<s:if test="user.institution.fosterIndustry==#it.name">selected</s:if>>
													<s:property value='#it.name' />
												</option>
											</s:iterator>
										</select>
									</div>
								</div>
							</s:if>

							<div class="col-md-2"></div>
							<div class="col-md-5">
								<button type="submit" class="btn btn-default">提交</button>
							</div>
						</form>
					</div>
					<div class="col-md-2"></div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/jsp/footer.jsp"></jsp:include>
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
</html>