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
	<div id="navigation">
		<s:url var="listProducts" action="listProducts" />
		<s:a href="%{listProducts}">back to product listing</s:a>
	</div>
	<div id="productForm">
		
			<s:text name="label.name" /><span class="product_name"><s:property value="product.name" /></span>
			<s:text name="label.cost" /><span class="product_cost"><s:property value="product.cost" /></span>
			<s:text name="label.category" /><span class="product_category"><s:property value="product.category.name" /></span>
	
	</div>
</body>
</html>