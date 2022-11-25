<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
<c:set var="to"   value="6"/> <%--변수 to의 값을 10으로 설정. EL은 lv 사용할 수 없기 때문에 저장소(default scope=page)에 key, value로 저장하는 것--%>
<c:set var="arr"  value="10,20,30,40,50,60,70,80"/> <%--배열 arr에 값을 저장--%>
<c:forEach var="i" begin="1" end="${to}">
    ${i}
</c:forEach>
<br>
<c:if test="${not empty arr}"> <%--배열이 비어있지 않다면--%>
    <c:forEach var="elem" items="${arr}" varStatus="status"><%--배열 arr의 요소를 하나씩 떠내서 elem에 넣는다. varStatus에는 count(1부터 시작), index(0부터 시작)가 들어갈 수 있다 --%>
        ${status.count}. arr[${status.index}]=${elem}<BR>
    </c:forEach>
</c:if>
<c:if test="${param.msg != null}">
    msg=${param.msg}
    msg=<c:out value="${param.msg}"/> <%--c:out은 태그를 그대로 출력한다--%>
</c:if>
<br>
<c:if test="${param.msg == null}">메시지가 없습니다.<br></c:if>
<c:set var="age" value="${param.age}"/>
<c:choose>
    <c:when test="${age >= 19}">성인입니다.</c:when>
    <c:when test="${0 <= age && age < 19}">성인이 아닙니다.</c:when>
    <c:otherwise>값이 유효하지 않습니다.</c:otherwise>
</c:choose>
<br>
<c:set var="now" value="<%=new java.util.Date() %>"/>
Server time is <fmt:formatDate value="${now}" type="both" pattern="yyyy/MM/dd HH:mm:ss"/>
</body>
</html>

