<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../shared/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	//设置左侧浏览状态
	session.setAttribute("nav", "user");
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>书城</title>
<base href="<%=basePath%>" />

<%@ include file="../shared/importCss.jsp"%>
<link href="<c:url value='/css/pages/index.css'/>" rel="stylesheet"
	type="text/css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<h1>增加一个新的书本信息</h1>
	<form class="form-horizontal" action="<c:url value="/add.html"/>"
		method="post">
		<div class="form-group">
			<label for="name"
				class="col-xs-2 col-sm-2 col-md-2 col-lg-1 control-label">书名</label>
			<div class="col-xs-10 col-sm-10 col-md-7 col-lg-5">
				<input name="name" class="form-control placeholder-no-fix"
					autocomplete="off" placeholder="书名" />
			</div>
		</div>

		<div class="form-group">
			<label for="name"
				class="col-xs-2 col-sm-2 col-md-2 col-lg-1 control-label">作者</label>
			<div class="col-xs-10 col-sm-10 col-md-7 col-lg-5">
				<input name="author" class="form-control placeholder-no-fix"
					autocomplete="off" placeholder="作者" />
			</div>
		</div>
		<div class="form-group">
			<label for="name"
				class="col-xs-2 col-sm-2 col-md-2 col-lg-1 control-label">书本信息</label>
			<div class="col-xs-10 col-sm-10 col-md-7 col-lg-5">
				<input name="binfo" class="form-control placeholder-no-fix"
					autocomplete="off" placeholder="书本信息" />
			</div>
		</div>
		<div class="form-group">
			<label for="name"
				class="col-xs-2 col-sm-2 col-md-2 col-lg-1 control-label">作者信息</label>
			<div class="col-xs-10 col-sm-10 col-md-7 col-lg-5">
				<input name="auinfo" class="form-control placeholder-no-fix"
					autocomplete="off" placeholder="作者信息" />
			</div>
		</div>
		<div class="form-group">
			<label for="name"
				class="col-xs-2 col-sm-2 col-md-2 col-lg-1 control-label">收藏</label>
			<div class="col-xs-10 col-sm-10 col-md-7 col-lg-5">
				<input name="collects" class="form-control placeholder-no-fix"
					autocomplete="off" placeholder="收藏" />
			</div>
		</div>
		<div class="form-group">
			<label for="name"
				class="col-xs-2 col-sm-2 col-md-2 col-lg-1 control-label">打赏</label>
			<div class="col-xs-10 col-sm-10 col-md-7 col-lg-5">
				<input name="rewards" class="form-control placeholder-no-fix"
					autocomplete="off" placeholder="打赏" />
			</div>
		</div>
		<div class="form-group">
			<label for="name"
				class="col-xs-2 col-sm-2 col-md-2 col-lg-1 control-label">已出版</label>
			<div class="col-xs-10 col-sm-10 col-md-7 col-lg-5">
				<input name="publish" class="form-control placeholder-no-fix"
					autocomplete="off" placeholder="已出版" />
			</div>
		</div>
		<div class="form-group">
			<label for="name"
				class="col-xs-2 col-sm-2 col-md-2 col-lg-1 control-label">字数</label>
			<div class="col-xs-10 col-sm-10 col-md-7 col-lg-5">
				<input name="words" class="form-control placeholder-no-fix"
					autocomplete="off" placeholder="字数" />
			</div>
		</div>

		<div class="modal-footer">
			<button type="submit" class="btn btn-primary">添加</button>
			<button type="button" class="btn btn-default"
				onclick="javascript:history.back(-1);">取消</button>
		</div>

	</form>



	<%@ include file="../shared/importJs.jsp"%>

</body>
</html>
