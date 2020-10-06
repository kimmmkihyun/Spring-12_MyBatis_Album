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
<!-- insert.ab 요청  -->    
WEB-INF\album\AlbumInsertForm.jsp <br>

<h1>앨범 추가</h1>
<form:form commandName="albumBean" action="insert.ab" method="post">
	<p>
		<label>노래제목</label>
		<input type="text" name="title" value="${albumBean.title }">
		<form:errors cssClass="err" path="title"></form:errors>
	</p>

	<p>
		<label>가수명</label>
		<input type="text" name="singer" value="${albumBean.singer }">
		<form:errors cssClass="err" path="singer"></form:errors>
	</p>
	
	<p>
		<label>가격</label>
		<input type="text" name="price" value="${albumBean.price }">
		<form:errors cssClass="err" path="price"></form:errors>
	</p>
	
	<p>
		<label>발매일</label>
		<input type="text" name="day" value="${albumBean.day }">
	</p>
	
	<p>
		<input type="submit" value="추가하기">
	</p>
</form:form>


