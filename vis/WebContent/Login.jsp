<%@taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
<title>E-Shop Login</title>
<s:head />
</head>
<body>
	<s:form action="Login">
		<s:textfield name="username" label="Username" />
		<s:password name="password" label="Password" />
		<s:submit name="submit" value="Login!" />
	</s:form>
</body>
</html>