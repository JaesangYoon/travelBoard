<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<c:url value="/hello/result"/>" method="post">
    <label for="year"><b>연도</b></label>
    <input type="text" placeholder="연도 입력해주세요" name="year" id="year" required><br>

    <button type="submit">버튼</button>

    date = ${date}

</form>
</body>
</html>
