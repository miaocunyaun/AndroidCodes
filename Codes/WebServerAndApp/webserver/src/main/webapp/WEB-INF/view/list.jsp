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



<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>





	<div>

		<div class="DocumentPageRightArea">
			<button type="button" class="btn btn-default btn-md"
				onclick="location='<c:url value="/addbook.html"/>'">增加</button>
			<button type="button" class="btn btn-default btn-md"
				onclick="location='<c:url value="/selectbook.html"/>'">查询</button>
			





			<c:choose>

				<c:when test="${booklist!=null and fn:length(booklist)>0}">


					<div class="container-fluid">

						<div class="row">
							<div class="col-xs-1 col-md-1">
								<strong>序号</strong>
							</div>
							<div class="col-xs-1 col-md-1">
								<strong>书名</strong>
							</div>

							<div class="col-xs-1 col-md-1">
								<strong>作者姓名</strong>
							</div>
							<div class="col-xs-1 col-md-1">
								<strong>书本信息</strong>
							</div>
							<div class="col-xs-1 col-md-1">
								<strong>作者信息</strong>
							</div>
							<div class="col-xs-1 col-md-1">
								<strong>收藏</strong>
							</div>

							<div class="col-xs-1 col-md-1">
								<strong>打赏</strong>
							</div>
							<div class="col-xs-1 col-md-1">
								<strong>已出版</strong>
							</div>
							<div class="col-xs-1 col-md-1">
								<strong>字数</strong>
							</div>
							<div class="col-xs-1 col-md-1">
								<strong>跟新日期</strong>
							</div>
							<div class="col-xs-1 col-md-1">
								<strong>操作</strong>
							</div>
						</div>


						<c:set var="index" value="1"></c:set>
						<c:forEach var="data" items="${booklist}">
							<div class="row show-grid">
								<div class="col-xs-1 col-md-1">${index}</div>
								<div class="col-xs-1 col-md-1">${data.name}</div>
								<div class="col-xs-1 col-md-1">${data.author}</div>
								<div class="col-xs-1 col-md-1">${data.binfo}</div>
								<div class="col-xs-1 col-md-1">${data.auinfo}</div>
								<div class="col-xs-1 col-md-1">${data.collects}</div>
								<div class="col-xs-1 col-md-1">${data.rewards}</div>
								<div class="col-xs-1 col-md-1">${data.publish}</div>
								<div class="col-xs-1 col-md-1">${data.words}</div>
								<div class="col-xs-1 col-md-1">

									<fmt:formatDate value="${data.update}"
										pattern="yyyy-MM-dd HH:mm:ss" />
								</div>
								<div class="col-xs-1 col-md-1">


									<button type="button" class="btn btn-default btn-xs"
										onclick="location='<c:url value="/delete/${data.id }.html"/>'">删除</button>
										
										
										
									<button type="button" class="btn btn-default btn-xs"
										onclick="location='<c:url value="/updatebookinfo/${data.id }.html"/>'">修改</button>

								</div>
							</div>
							<c:set var="index" value="${index + 1}"></c:set>
						</c:forEach>




					</div>
				</c:when>
				<c:otherwise>
					<div class="alert alert-warning alert-dismissible fade in"
						role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>查无此书！</strong>
						<p class="text-info">查无此书！</p>
					</div>
				</c:otherwise>
			</c:choose>

		</div>
	</div>

	<%@ include file="../shared/importJs.jsp"%>

	<script>
		function onDelete(t_user_id, t_user_name) {

			var url = "location='<c:url value="/user/delete-"/>" + t_user_id
					+ ".html'";

			$('#deleteModal').find('.modal-body #deleteinfo').text(t_user_name);
			$('#deleteModal').find('.modal-footer #deletebtn').attr("onclick",
					url);

			$('#deleteModal').modal('show');

		}
	</script>
</body>
</html>
