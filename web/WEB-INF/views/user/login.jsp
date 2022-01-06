<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<h1>로그인</h1>
<form action="/user/login" method="post" id="login-frm">
    <div><label>id : <input type="text" name="uid" required></label></div>
    <div><label>pw : <input type="password" name="upw" required></label></div>
    <div>
        <input type="submit" value="LOGIN">
        <a href="/user/join"><input type="button" value="JOIN"></a>
    </div>
</form>