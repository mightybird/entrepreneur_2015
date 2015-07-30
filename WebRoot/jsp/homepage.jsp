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
	<%-- <s:debug></s:debug> --%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-8">
								<div class="carousel slide" id="carousel-441031">
									<ol class="carousel-indicators">
										<li class="active" data-slide-to="0"
											data-target="#carousel-441031"></li>
										<li data-slide-to="1" data-target="#carousel-441031"></li>
										<li data-slide-to="2" data-target="#carousel-441031"></li>
									</ol>
									<div class="carousel-inner">
										<div class="item active">
											<img alt="Carousel Bootstrap First"
												src="http://lorempixel.com/output/sports-q-c-1600-500-1.jpg" />
											<div class="carousel-caption">
												<h3>知识标题1</h3>
												<p>知识内容知识内容内容内容内容内容内容内容内容</p>
											</div>
										</div>
										<div class="item">
											<img alt="Carousel Bootstrap Second"
												src="http://lorempixel.com/output/sports-q-c-1600-500-2.jpg" />
											<div class="carousel-caption">
												<h3>知识标题2</h3>
												<p>知识内容知识内容知识内容知识内容知识知识内容知识内容知识内容知识内容</p>
											</div>
										</div>
										<div class="item">
											<img alt="Carousel Bootstrap Third"
												src="http://lorempixel.com/output/sports-q-c-1600-500-3.jpg" />
											<div class="carousel-caption">
												<h3>知识标题3</h3>
												<p>知识内容知识内容知识内容知识内容知识内容知识内容知识内容</p>
											</div>
										</div>
									</div>
									<a class="left carousel-control" href="#carousel-441031"
										data-slide="prev"><span
										class="glyphicon glyphicon-chevron-left"></span></a> <a
										class="right carousel-control" href="#carousel-441031"
										data-slide="next"><span
										class="glyphicon glyphicon-chevron-right"></span></a>
								</div>
							</div>
							<div class="col-md-4">
								<div class="tabbable" id="tabs-280378">
									<ul class="nav nav-tabs">
										<li class="active"><a href="#panel-130096"
											data-toggle="tab">最新政策</a></li>
										<li><a href="#panel-440761" data-toggle="tab">法律动态</a></li>
										<li><a href="#panel-440762" data-toggle="tab">创业新闻</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane active" id="panel-130096">
											<div class="media">
												<a href="#" class="pull-left"><img
													alt="Bootstrap Media Preview"
													src="http://lorempixel.com/64/64/" class="media-object" /></a>
												<div class="media-body">
													<h4 class="media-heading">Nested media heading</h4>
													intro1
												</div>
											</div>
											<div class="media">
												<a href="#" class="pull-left"><img
													alt="Bootstrap Media Another Preview"
													src="http://lorempixel.com/64/64/" class="media-object" /></a>
												<div class="media-body">
													<h4 class="media-heading">Nested media heading</h4>
													intro2
												</div>
											</div>
											<div class="media">
												<a href="#" class="pull-left"><img
													alt="Bootstrap Media Another Preview"
													src="http://lorempixel.com/64/64/" class="media-object" /></a>
												<div class="media-body">
													<h4 class="media-heading">Nested media heading</h4>
													intro3
												</div>
											</div>
										</div>
										<div class="tab-pane" id="panel-440761">
											<ul class="list-unstyled">
												<li>
													<h5>444</h5>
												</li>
												<li>
													<h5>第三方</h5>
												</li>
												<li>
													<h5>vzasfd</h5>
												</li>
												<li>
													<h5>F444nisl东方大师法撒旦</h5>
												</li>
												<li>
													<h5>对方水电费velit</h5>
												</li>
												<li>
													<h5>成vzcvczxvz</h5>
												</li>
												<li>
													<h5>而无情人维权</h5>
												</li>
												<li>
													<h5>发多少分蛋糕和广泛地</h5>
												</li>
											</ul>
										</div>
										<div class="tab-pane" id="panel-440762">
											<ul class="list-unstyled">
												<li>
													<h5>111</h5>
												</li>
												<li>
													<h5>222t</h5>
												</li>
												<li>
													<h5>3333 massa</h5>
												</li>
												<li>
													<h5>F444nisl aliquet</h5>
												</li>
												<li>
													<h5>Nulla55555am velit</h5>
												</li>
												<li>
													<h5>F555666 fringilla vel</h5>
												</li>
												<li>
													<h5>Aene7777rat nunc</h5>
												</li>
												<li>
													<h5>Eg8888r lorem</h5>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="page-header">
							<h1>
								热门项目
								<div class="text-right">
									<small> <a href=#>所有项目</a>
									</small>
								</div>
							</h1>
						</div>
						<div class="row">
							<div class="col-md-4">
								<div class="thumbnail">
									<img alt="Bootstrap Thumbnail First"
										src="http://lorempixel.com/output/people-q-c-600-200-1.jpg" />
									<div class="caption">
										<h3>项目1</h3>
										<p>项目介绍项目介绍项目介绍项目介绍项目介绍项目介绍</p>
										<p>
											<a class="btn btn-primary" href="#">详情</a> <a class="btn"
												href="#">加入/评估/合作</a>
										</p>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="thumbnail">
									<img alt="Bootstrap Thumbnail Second"
										src="http://lorempixel.com/output/city-q-c-600-200-1.jpg" />
									<div class="caption">
										<h3>项目2</h3>
										<p>项目介绍项目介绍项目介绍项目介绍</p>
										<p>
											<a class="btn btn-primary" href="#">详情</a> <a class="btn"
												href="#">加入/评估/合作</a>
										</p>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="thumbnail">
									<img alt="Bootstrap Thumbnail Third"
										src="http://lorempixel.com/output/sports-q-c-600-200-1.jpg" />
									<div class="caption">
										<h3>项目3</h3>
										<p>项目介绍项目介绍项目介绍项目介绍项目介绍项目介绍</p>
										<p>
											<a class="btn btn-primary" href="#">详情</a> <a class="btn"
												href="#">加入/评估/合作</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="page-header">
							<h1>
								LayoutIt! <small>Interface Builder for Bootstrap</small>
							</h1>
						</div>
						<div class="row">
							<div class="col-md-3">
								<div class="thumbnail">
									<img alt="Bootstrap Thumbnail First"
										src="http://lorempixel.com/output/people-q-c-600-200-1.jpg" />
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Cras justo odio, dapibus ac facilisis in, egestas eget
											quam. Donec id elit non mi porta gravida at eget metus.
											Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
										<p>
											<a class="btn btn-primary" href="#">Action</a> <a class="btn"
												href="#">Action</a>
										</p>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="thumbnail">
									<img alt="Bootstrap Thumbnail First"
										src="http://lorempixel.com/output/people-q-c-600-200-1.jpg" />
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Cras justo odio, dapibus ac facilisis in, egestas eget
											quam. Donec id elit non mi porta gravida at eget metus.
											Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
										<p>
											<a class="btn btn-primary" href="#">Action</a> <a class="btn"
												href="#">Action</a>
										</p>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="thumbnail">
									<img alt="Bootstrap Thumbnail Second"
										src="http://lorempixel.com/output/city-q-c-600-200-1.jpg" />
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Cras justo odio, dapibus ac facilisis in, egestas eget
											quam. Donec id elit non mi porta gravida at eget metus.
											Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
										<p>
											<a class="btn btn-primary" href="#">Action</a> <a class="btn"
												href="#">Action</a>
										</p>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="thumbnail">
									<img alt="Bootstrap Thumbnail Third"
										src="http://lorempixel.com/output/sports-q-c-600-200-1.jpg" />
									<div class="caption">
										<h3>Thumbnail label</h3>
										<p>Cras justo odio, dapibus ac facilisis in, egestas eget
											quam. Donec id elit non mi porta gravida at eget metus.
											Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
										<p>
											<a class="btn btn-primary" href="#">Action</a> <a class="btn"
												href="#">Action</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
	<jsp:include page="/jsp/footer.jsp"></jsp:include>
</body>
</html>