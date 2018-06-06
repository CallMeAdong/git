<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>	
<script type="text/javascript">

</script>
<body>
	<c:forEach items="${buyproducts}" var="buyproduct">
			<div id="productList">
				<tr>
					<td>商品图片:<img src="${buyproduct.pimg}" width="170" height="170" style="display: inline-block;"></td>
					<td>商品名称:${buyproduct.pname}</td>
					<td>商品价格:${buyproduct.price}</td>
					<td>商品信息:${buyproduct.info}</td>
					
					
					<td>联系卖家:${buyproduct.phone}</td>
					
				</tr>
			</div>
			</c:forEach>
</body>
</html>