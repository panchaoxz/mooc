<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session ="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spittr</title>
</head>
<body>
<h1>Welcome to Spittr</h1>

<a href="<c:url value="/spittles?max=238900&count=70" />">Spittles</a>
<a href ="<c:url value="/spitter/register" />">Register</a>
<a href ="<c:url value="/spittles/25" />">Spittle</a>
</body>
</html>