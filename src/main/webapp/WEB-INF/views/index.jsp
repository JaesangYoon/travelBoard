<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="loginOutLink" value="${sessionScope.id==null ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${sessionScope.id==null ? '로그인' : '로그아웃'}"/>
<!DOCTYPE html>
<html lang="en">
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

<div class="body1">

	<h3><a href="<c:url value='/board/recent'/>">최근 게시물</a></h3>
	<h3><a href="<c:url value='/flight/top10'/>">인기 항공편 Top 10</a></h3>

</div>

<div style="text-align:center">
	<h1>This is HOME</h1>
	<h1>This is HOME</h1>
	<h1>This is HOME</h1>
</div>

<!-- 지도를 표시할 div 입니다 -->
<div id="map" style="width:50%;height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4eef7eba99ac3f096f917ea27da4d10b"></script>
<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div
			mapOption = {
				center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				level: 3 // 지도의 확대 레벨
			};

	// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption);
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>