<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Insert title here</title>
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>	
<script type="text/javascript">
	function fun1(){
		$.ajax({
			url:"${pageContext.request.contextPath}/productAction_findByUid",
			type:"POST",
			success:function(data){
				alert("111");
				},
			dataType:"JSON"
		});
	}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/productAction_findByInfo">
		<div id="search">
		商品名称<input type="text" name="pname">
		所属分类<select name="kinds">
				<option value="学习资料" >学习资料</option>
				<option value="体育器材" >体育器材</option>
			</select>
			<input type="submit" value="查找">
		</div>
			<c:forEach items="${productlist}" var="product">
			<div id="productList">
				<tr>
					<td>商品图片:<img src="${product.pimg}" width="170" height="170" style="display: inline-block;"></td>
					<td>商品名称:${product.pname}</td>
					<td>商品价格:${product.price}</td>
					<td>上架日期:${product.date}</td>
					<td>商品信息:${product.info}</td>
					<td>商品数量:${product.number}</td>
					<td>浏览量:${product.counts}</td>
					<td>联系卖家:${product.uphone}</td>
					<td><a href="${pageContext.request.contextPath}/ProductCarAction_addProductToCar?pid=${product.pid}">加入购物车</a>
				</tr>
			</div>
			</c:forEach>
	</form>
	<input type="button" value="我上架的物品" onclick="fun1()"><span id="span1"></span>
	<!-- <div id="findByuid"><button>我上架的物品</button></div> -->
	<%-- <div id="findByuid"><a href="${pageContext.request.contextPath}/productAction_findByUid">我上架的物品</a></div> --%>
	<%-- <a href="${pageContext.request.contextPath}/productAction_findByUid">我上架的物品</a> --%>
</body>
</html>