<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="loginOutLink" value="${sessionScope.id==null ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${sessionScope.id==null ? '로그인' : '로그아웃'}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <title>travelBoard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
            <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
        </a>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="<c:url value='/'/>" class="nav-link px-2 link-secondary">홈</a></li>
            <li><a href="<c:url value='/board/list'/>" class="nav-link px-2 link-dark">게시판</a></li>
            <li><a href="<c:url value='/faq'/>" class="nav-link px-2 link-dark">자주 묻는 질문</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">About</a></li>
        </ul>

        <div class="col-md-3 text-end">
<%--            <button type="button" class="btn btn-outline-primary me-2">Login</button>--%>
            <button type="button" class="btn btn-outline-primary me-2"><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></button>
            <button type="button" class="btn btn-outline-dark"><a href="<c:url value='/register/add'/>">회원가입</a></button>
        </div>
    </header>
</div>

<script>
    let msg = "${msg}"
    if(msg=="WRT_OK") alert("성공적으로 등록되었습니다.");
    if(msg=="DEL_OK") alert("성공적으로 삭제되었습니다.");
    if(msg=="DEL_ERR") alert("삭제에 실패했습니다.");
</script>
<div style="text-align:center">
    <form action="<c:url value="/board/list"/>" class="search-form" method="get">
        <select class="search-option" name="option">
            <option value="A" ${option=='A' ? "selected" : ""}>제목+내용</option>
            <option value="T" ${option=='T' ? "selected" : ""}>제목만</option>
            <option value="W" ${option=='W' ? "selected" : ""}>작성자</option>
        </select>

        <input type="text" name="keyword" class="search-input" type="text" value="${param.keyword}" placeholder="검색어를 입력해주세요">
        <input type="submit" class="search-button" value="검색">
    </form>

    <button type="button" id="writeBtn" onclick="location.href='<c:url value="/board/write"/>'">글쓰기</button>

    <table class="table table-striped table-hover" style="width: 800px; margin-left: auto; margin-right: auto;">
        <colgroup>
            <col style="width:72px; height: 57px" />
            <col style="width:447px;" />
            <col style="width:100px;" />
            <col style="width:71px;" />
            <col style="width:110px;" />
        </colgroup>
        <thead style="text-align: center;">
            <tr>
                <th scope="col">번호</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">조회수</th>
                <th scope="col">등록일</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="boardDto" items="${list}">
            <tr>
                <td>${boardDto.bno}</td>
                <td style="text-align: left;"><a href="<c:url value='/board/read?bno=${boardDto.bno}&page=${pageSize}'/>">${boardDto.title}</a></td>
                <td>${boardDto.writer}</td>
                <td>${boardDto.view_cnt}</td>
                <td>${boardDto.reg_date}</td>
            </tr>
        </c:forEach>

<%--            <th scope="row">1</th>--%>
<%--            <td>모두들 반갑습니다</td>--%>
<%--            <td class="table-center">Otto</td>--%>
<%--            <td class="table-center">2</td>--%>
<%--            <td class="table-center">2022-03-02</td>--%>
        </tbody>
    </table>

    <br>
    <div>
        <c:if test="${totalCnt!=null && totalCnt!=0}">
            <c:if test="${ph.showPrev}">
                <a class="page" href="<c:url value="/board/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>
            </c:if>
            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value="/board/list${ph.sc.getQueryString(i)}"/>">${i}</a>
            </c:forEach>
            <c:if test="${ph.showNext}">
                <a class="page" href="<c:url value="/board/list${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>
            </c:if>
        </c:if>
    </div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>