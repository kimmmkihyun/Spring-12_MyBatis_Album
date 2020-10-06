<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
webapp\Album_Start.jsp

<%
	String viewPage = request.getContextPath() + "/list.ab";
	System.out.println("viewPage : " + viewPage); // viewPage : /ex/list.ab
	// http://localhost:8080/ex/list.ab
	
	response.sendRedirect(viewPage);
	
%>
