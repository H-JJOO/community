<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
    <c:if test="${sessionScope.loginUser != null}">
        <a href="/board/write?icategory=${requestScope.icategory}">글쓰기</a>
    </c:if>
    <h1>보드 리스트</h1>
    <c:choose>
        <c:when test="${fn:length(requestScope.list) == 0}">
            글이 없습니다.
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>no</th>
                    <th>title</th>
                    <th>hits</th>
                    <th>writer</th>
                    <th>reg date</th>
                </tr>
                <c:forEach items="${requestScope.list}" var="item">
                    <tr>
                        <td>${item.iboard}</td>
                        <td>${item.title}</td>
                        <td>${item.hits}</td>
                        <td>${item.iuser}</td>
                        <td>${item.rdt}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</div>
