<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Edit Product.
	<s:form>
		<s:text name="label.name" />
		<s:textfield name="product.name" />
		<s:text name="label.cost" />
		<s:textfield name="product.cost" />
		<s:text name="label.category" />
		<s:select name="product.category.id" listKey="id" listValue="name" list="categories" />
	</s:form>
</body>
</html>