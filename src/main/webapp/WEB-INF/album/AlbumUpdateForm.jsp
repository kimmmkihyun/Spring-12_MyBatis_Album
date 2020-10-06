<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">
	.err{
	font-size: 9pt;
	color: red;
	font-weight: bold;
	}
</style>

WEB-INF\album\AlbumUpdateForm.jsp(${ pageNumber }  /  ${ pageSize }) <br>

<h1>앨범 수정</h1>
<form:form commandName="album" action="update.ab" method="post">
<input type="hidden" name=pageNumber value="${pageNumber }">
<input type="hidden" name=pageSize value="${pageSize }">
<input type="hidden" name="num" value="${album.num }">
	<p>
		<label>노래제목</label>
		<input type="text" name="title" value="${album.title }">
		<form:errors cssClass="err" path="title"></form:errors>
	</p>

	<p>
		<label>가수명</label>
		<input type="text" name="singer" value="${album.singer }">
		<form:errors cssClass="err" path="singer"></form:errors>
	</p>
	
	<p>
		<label>가격</label>
		<input type="text" name="price" value="${album.price }">
		<form:errors cssClass="err" path="price"></form:errors>
	</p>
	
	<p>
		<label>발매일</label>
		<input type="text" name="day" value="${album.day }">
	</p>
	
	<p>
		<input type="submit" value="수정하기">
	</p>
</form:form>


