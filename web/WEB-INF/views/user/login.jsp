<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<h1>로그인</h1>
<div>${requestScope.msg}</div>
<form action="/user/login" method="post" id="login-frm">
    <div><label>id : <input type="text" name="uid" value="${requestScope.tryLogin.uid}" required></label></div>
    <div><label>pw : <input type="password" name="upw" ></label></div>
    <div>
        <input type="submit" value="LOGIN">
    </div>
</form>
<div><a href="/user/join"><input type="button" value="JOIN"></a></div>
<!--
    로그인 처리
    세션에 UserEntity 객체 주소값 저장 하는데,
    키값은 Const.LOGIN_USER 를 사용.
    객체에 isuer, uid, nm, frofileimg 값만 저장.
    로그인 성공시 /board/list 주소값 이동
    로그인 실패시 login.jsp 에서 메세지 출력!
    (아이디 없음, 비밀번호 확인, 알 수 없는 에러)
-->