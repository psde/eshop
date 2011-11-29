<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="product==null || product.id == null">
	<s:set name="title" value="%{'Add new product'}"/>
</s:if>
<s:else>
	<s:set name="title" value="%{'Update product'}"/>
</s:else>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="#title"/></title>
</head>
<body>
	<div>
		<p>
			<s:url var="listProducts" action="listProducts" />
			<s:a href="%{listProducts}">back to product listing</s:a>
		</p>
	</div>
	<h2>Edit Product</h2>
	<s:form action="insertOrUpdateProduct!save.action" method="post">
		<s:text name="label.name" />
		<s:textfield name="product.name" value="%{product.name}" />
		<s:text name="label.cost" />
		<s:textfield name="product.cost" value="%{product.cost}" />
		<s:text name="label.category" />
		<s:select name="product.category.id" listKey="id" listValue="name" list="categories" />
		<s:hidden name="product.id" value="%{product.id}"/>
		<s:submit />
	</s:form>
</body>
</html>