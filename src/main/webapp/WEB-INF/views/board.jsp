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
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<div class="head">
    <a href="<c:url value='/board/list'/>">게시판</a>
    <a href="<c:url value='/faq'/>">자주 묻는 질문</a>
    <a href="<c:url value='/'/>">다시, 출발</a>
    <a href="<c:url value='${loginOutLink}'/>">${loginOut}</a>   <%--로그인 상태일 때와 로그아웃 상태일 때 다르게 표시되도록--%>
    <a href="<c:url value='/register/add'/>">회원가입</a>
</div>
<div style="text-align:center">
    <h2>게시물 ${mode=="new" ? "글쓰기" : "읽기"}</h2>
    <form action="" id="form">
        <input type="hidden" name="bno" value="${boardDto.bno}" readonly="readonly">
        <input type="text" name="title" value="${boardDto.title}" ${mode=="new" ? '' : 'readonly="readonly"'}>
        <textarea name="content" id="" cols="30" rows="10" ${mode=="new" ? '' : 'readonly="readonly"'}>${boardDto.content}</textarea>
        <button type="button" id="writeBtn" class="btn">등록</button>
        <button type="button" id="modifyBtn" class="btn">수정</button>
        <button type="button" id="removeBtn" class="btn">삭제</button>
        <button type="button" id="listBtn" class="btn">목록</button>
    </form>
</div>
<script>
    let msg="${msg}";
    if(msg=="WRT_ERR") alert("게시물 등록에 실패했습니다. 다시 시도해주세요.")
</script>
<script>
    $(document).ready(function(){ // main()과 같다. 브라우저가 html 문서를 다 읽고 DOM을 구성하면 document.ready 이벤트 발생
        $('#listBtn').on("click", function(){
            location.href = "<c:url value='/board/list'/>?page=${page}&pageSize=${pageSize}";
        })

        $('#modifyBtn').on("click", function(){
            // 1. 읽기 상태이면 수정 상태로 변경
            let form = $("#form");
            let isReadOnly = $("input[name=title]", "#form").attr('readonly');

            if (isReadOnly == "readonly") {
                $("input[name=title]").attr('readonly', false); // title
                $("textarea").attr('readonly', false); // content
                $("#modifyBtn").html("등록"); // 내용 바꾸기
                $("h2").html("게시물 수정");
                return;
            }

            // 2. 수정 상태이면, 수정된 내용을 서버로 전송

            form.attr("action", "<c:url value='/board/modify'/>");
            form.attr("method", "post");
            form.submit();
        })

        $('#writeBtn').on("click", function(){
            let form = $('#form');
            form.attr("action", "<c:url value='/board/write'/>");
            form.attr("method", "post");
            form.submit();
        })
        $('#removeBtn').on("click", function(){
            if(!confirm("정말로 삭제하시겠습니까?")) return;
            let form = $('#form');
            form.attr("action", "<c:url value='/board/remove'/>?page=${page}&pageSize=${pageSize}");
            form.attr("method", "post");
            form.submit();
        })
    })
</script>
</body>
</html>