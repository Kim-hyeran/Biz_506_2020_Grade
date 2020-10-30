<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<h3>성적 리스트</h3>
<table>
	<thead>
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			<th colspan="2">기타</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty GRADE_LIST}">
				<tr>
					<td colspan="8">데이터가 존재하지 않습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${GRADE_LIST}" var="G_VO">
			        <tr>
			            <td>${G_VO.g_number}</td>
			            <td>${G_VO.g_name}</td>
			            <td>${G_VO.g_kor}</td>
			            <td>${G_VO.g_eng}</td>
			            <td>${G_VO.g_math}</td>
			            <td>${G_VO.g_sum}</td>
			            <td>${G_VO.g_avg}</td>
			            <td><a href="${rootPath}/update?id=${G_VO.g_number}">수정</a></td>
			            <td><a href="${rootPath}/delete?id=${G_VO.g_number}">삭제</a></td>
			        </tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>