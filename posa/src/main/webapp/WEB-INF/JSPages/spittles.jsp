<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spittles</title>
</head>
<body>

	<c:forEach var="spittle" items="${spittleList}" >
		<li id="spittle_<c:out value ="spittle.id"/>">
			<div class="spittleMessage">
				<c:out value="${spittle.message}" />
			</div>
			<div>
				<span class="spittleTime"> <c:out value="${spittle.time}" /></span>
			</div>
		</li>
	</c:forEach>

</body>
</html>