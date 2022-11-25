<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <title>travelBoard</title>
    <style>
        /*input:not(div) {*/
        /*    display: grid;*/
        /*    grid-template-columns: auto;*/
        /*    justify-items: center;*/
        /*}*/

    </style>
</head>
<body>
<div class="head">
    <a href="<c:url value='/board/list'/>">게시판</a>
    <a href="<c:url value='/faq'/>">자주 묻는 질문</a>
    <a href="<c:url value='/'/>">다시, 출발</a>
    <a href="<c:url value='/login/login'/>">로그인</a>
    <a href="<c:url value='/register/add'/>">회원가입</a>
</div>
<form action="<c:url value="/register/save"/>" method="post">
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

        <label for="id"><b>아이디</b></label>
        <input type="text" placeholder="아이디를 입력해주세요" name="id" id="id" required><br>

        <label for="pwd"><b>비밀번호</b></label>
        <input type="password" placeholder="비밀번호를 입력해주세요" name="pwd" id="pwd" required><br>

        <label for="psw-repeat"><b>비밀번호 확인</b></label>
        <input type="password" placeholder="비밀번호를 다시 입력해주세요" name="psw-repeat" id="psw-repeat" required><br>

        <label for="email"><b>이메일</b></label>
        <input type="text" placeholder="이메일을 입력해주세요" name="email" id="email" required><br>

        <label for="name"><b>이름</b></label>
        <input type="text" placeholder="이름을 입력해주세요" name="name" id="name"><br>

        <b>성별</b>
        <label for="male"/>
        <input type="radio" id = "male" name="gender" value="male" >남성
        <label for="female"/>
        <input type="radio" id = "female" name="gender" value="female">여성<br>

        <label for="birth"><b>생일</b></label>
        <input type="text" placeholder="1980/01/01" name="birth" id="birth"><br>

        <hr>
        <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

        <button type="submit" class="registerbtn">회원가입</button>
    </div>

    <div>
        <p>이미 계정이 있으십니까? <a href="#">회원가입</a>.</p>
    </div>
</form>

</body>
</html>