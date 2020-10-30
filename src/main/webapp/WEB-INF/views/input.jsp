<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script>
	document.addEventListener("DOMContentLoaded", function() {
		document.querySelector("#list").addEventListener("click", function() {
			document.location.href="${rootPath}/"
		})
	})
</script>
<h3>성적 입력</h3>
<form method="POST">
	<div>
		<label>학번</label>
		<input id="number" name="g_number" value="${G_VO.g_number}">
	</div>
	<div>
		<label>이름</label>
		<input id="name" name="g_name" value="${G_VO.g_name}">
	</div>
	<div>
		<label>국어</label>
		<input id="kor" name="g_kor" value="${G_VO.g_kor}">
	</div>
	<div>
		<label>영어</label>
		<input id="eng" name="g_eng" value="${G_VO.g_eng}">
	</div>
	<div>
		<label>수학</label>
		<input id="math" name="g_math" value="${G_VO.g_math}">
	</div>
	<div id="btn-box">
		<button id="list" type="button">취소</button>
		<button id="save" type="submit">저장</button>
	</div>
</form>