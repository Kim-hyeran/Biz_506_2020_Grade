<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Grade Management</title>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		document.querySelector("#grade-list").addEventListener("click", function() {
			document.location.href="${rootPath}/"
		})
		document.querySelector("#grade-input").addEventListener("click", function() {
			document.location.href="${rootPath}/input"
		})
	})
</script>
</head>
<body>
	<header></header>
	<nav>
		<ul>
			<li id="grade-list">성적보기</li>
			<li id="grade-input">입력하기</li>
		</ul>
	</nav>
	<section>
		<c:choose>
			<c:when test = "${BODY == 'GRADE_INPUT'}">
				<%@ include file = "/WEB-INF/views/input.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file = "/WEB-INF/views/list.jsp"%>
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>