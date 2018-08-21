<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>Insert title here</title>
</head>
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>	
<script type="text/javascript">

</script>
<style>
	#search{
		background-attachment: fixed;
		overflow-y:scroll;
		text-align: center;
		margin:0 auto;
		width: 750px;
	}
	#myproduct{
	margin-top:-23px;
	float:right;
	}
	#productList{
		width: 674px;
		float:left;
		margin-top: 20px;
		text-align: center;
	}
</style>
<body>
	<form action="${pageContext.request.contextPath}/productAction_findByInfo">
		<div id="bodyhead">
			<div id="search">
			商品名称<input type="text" name="pname">
			所属分类<select name="kinds">
					<option value="学习资料" >学习资料</option>
					<option value="体育器材" >体育器材</option>
				</select>
				<input type="submit" value="查找">
			</div>
			<div id="myproduct">
				<a href="${pageContext.request.contextPath}/productAction_findByUid">我上架的物品</a>
			</div>
		</div>	
			<c:forEach items="${pageBean.productList}" var="product">
			<div id="productList">
				<tr>
					<td><img src="${product.pimg}" width="170" height="170" style="display: inline-block;margin: 0 auto;"></td></br>
					<td>商品名称:${product.pname}</td>
					<td>商品价格:${product.price}</td>
					<td>上架日期:${product.date}</td></br>
					<td>商品信息:${product.info}</td>
					<td>商品数量:${product.number}</td>
					<td>浏览量:${product.counts}</td>
					<td>联系卖家:${product.uphone}</td>
					<td><a href="${pageContext.request.contextPath}/ProductCarAction_addProductToCar?pid=${product.pid}">加入购物车</a>
				</tr>
			</div>
			</c:forEach>
	
	
	<div style="width: 380px; margin: 0 auto; margin-top: 260px;">
		<ul class="pagination" style="text-align: center; margin-top: 10px;">
			<!-- 上一页 -->
			<!-- 判断当前页是否是第一页 -->
			<c:if test="${pageBean.currentPage==1 }">
				<li class="disabled">
					<a href="javascript:void(0);" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
			</c:if>
			<c:if test="${pageBean.currentPage!=1 }">
				<li>
					<a href="${pageContext.request.contextPath }/productAction_selectProductByLimit?currentPage=${pageBean.currentPage-1}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
			</c:if>	
	<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
				<!-- 判断当前页 -->
				<c:if test="${pageBean.currentPage==page }">
					<li class="active"><a href="javascript:void(0);">${page}</a></li>
				</c:if>
				<c:if test="${pageBean.currentPage!=page }">
					<li><a href="${pageContext.request.contextPath }/productAction_selectProductByLimit?currentPage=${page}">${page}</a></li>
				</c:if>
			
			</c:forEach>
			
			<!-- 判断当前页是否是最后一页 -->
			<c:if test="${pageBean.currentPage==pageBean.totalPage }">
				<li class="disabled">
					<a href="javascript:void(0);" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</c:if>
			<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
				<li>
					<a href="${pageContext.request.contextPath }/productAction_selectProductByLimit?currentPage=${pageBean.currentPage+1}" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</c:if>
		
		</ul>
	</div>
	</form>
	
	<%-- <a href="${pageContext.request.contextPath}/productAction_findByUid">我上架的物品</a> --%>
</body>
</html>