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
<h1>字段查询</h1>
	<form class="form-horizontal" action="<c:url value="/select.html"/>"
		method="post">
		<div class="form-group">
			<label for="name"
				class="col-xs-2 col-sm-2 col-md-2 col-lg-1 control-label">书名</label>
			<div class="col-xs-10 col-sm-10 col-md-7 col-lg-5">
				<input name="keys" class="form-control placeholder-no-fix"
					autocomplete="off" placeholder="关键字" />
			</div>
		</div>

		

		<div class="modal-footer">
			<button type="submit" class="btn btn-primary">查询</button>
			<button type="button" class="btn btn-default"
				onclick="javascript:history.back(-1);">取消</button>
		</div>

	</form>



	<%@ include file="../shared/importJs.jsp"%>

</body>
</html>
