<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<html>
<head>
<meta charset=UTF-8">
<title>관리자 메인</title>
<link rel="stylesheet" type="text/css" href="./css/admin.css" />
<script src="./js/jquery.js"></script>
</head>
<body>
 <div id="adminmain_wrap">
   <!-- 상단 메뉴 -->
   <div id="adminmain_header">
     <div id="adminheader_left">
      <div id="admin_home">
       <a href="admin_main.do" onfocus="this.blur()">홈</a>       
      </div>            
            
      <h3 class="adminheader_title">관리자 모드 메뉴입니다.</h3>
      <ul>
       <li>
       <a href="/spring3/adminGongji_List.do" onfocus="this.blur()">공지사항</a>
       </li>
       <li>
       <a href="/spring3/admin_board_list.do" onfocus="this.blur()">게시판</a>
       </li>
       <li>
       <a href="/spring3/admin_bbs_list.do" onfocus="this.blur()">자료실</a>
       </li>
       <li>
        <a href="/spring3/admin_member_list.do" onfocus="this.blur()">회원관리</a>
       </li>
      </ul>     
     </div>
     
     <div id="adminheader_right">
     <c:if test="${!empty admin_id}">  
      <form method="post" action="admin_logout.do">
      <ul>
        <li><b>${admin_name}</b>&nbsp;님 로그인을 환영합니다.</li>
        <li><input type="submit" value="로그아웃" class="input_button" /></li>
       </ul> 
       </form> 
     </c:if>
     <c:if test="${empty admin_id}">  
       <script>
        alert("다시 로그인 해주세요!");
        location.href="admin_index.do";
       </script>       
     </c:if>  
     </div>
   </div>
 