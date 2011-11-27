<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="greeting">
		<p>
			Hello <s:property value="#session.username" />! Welcome to the E-Shop!
		</p>
	</div>
	<div id="products">
		<s:iterator value="products">
			<div class="product">
				<span class="product_id"><s:property value="id" /></span>
				<span class="product_name"><s:property value="name" /></span>
				
				<s:url var="productDetails" action="productDetails">
					<s:param name="productId">
						<s:property value="id" />
					</s:param>
				</s:url>
				<s:a href="%{productDetails}">details</s:a>
				<s:if test="#session.isAdmin eq true">
					<s:url var="editProduct" action="insertOrUpdateProduct">
						<s:param name="productId">
							<s:property value="id" />
						</s:param>
					</s:url>
					<s:a href="%{editProduct}">edit</s:a>
				</s:if>
			</div>
		</s:iterator>
	</div>	
</body>
</html>