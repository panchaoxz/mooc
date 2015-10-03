<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spittle</title>
</head>
<body>

	<div class="spittleMessage">
		<c:out value="${spittle.message}" />
	</div>
	<div>
		<span class="spittleTime"> <c:out value="${spittle.time}" /></span>
	</div>
</body>
</html>