<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//删除登录标识
	session.removeAttribute("empLoginName");


%>
<script type="text/javascript">
	window.top.location.href = 'login.html';
</script>"C:/Users/DLETC/Desktop/笔记总集/11.9/hr/WebContent/logout.jsp"