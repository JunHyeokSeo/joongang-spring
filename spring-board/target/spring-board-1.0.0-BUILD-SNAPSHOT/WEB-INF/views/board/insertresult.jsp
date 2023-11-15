<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2023/11/06
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<c:if test="${result == 1}">
	<script>
        alert("글작성 성공");
        location.href = "boardlist.do";
	</script>
</c:if>
<c:if test="${result != 1}">
	<script>
        alert("글작성 실패");
        history.go(-1);
	</script>
</c:if>
</body>
</html>
