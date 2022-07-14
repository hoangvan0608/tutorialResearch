<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bộ nhớ</title>
    <jsp:include page="../common/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="../common/nav.jsp"></jsp:include>
<div class="container min-vh-100">
    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Bộ nhớ</p>
    <jsp:include page="../common/message.jsp"></jsp:include>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Bộ nhớ</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${ memories != null }">
            <c:forEach items="${memories}" var="memory">
                <tr>
                    <td class="col-3">${memory.id}</td>
                    <td>${memory.name}</td>
                    <td class="col-3"><a href="/backend/memory/update/${memory.id}" class="btn btn-success">Update</a> &nbsp; <a href="/backend/memory/delete/${memory.id}" class="btn btn-warning">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${ memories == null }">
            <h1>Không có dữ liệu</h1>
        </c:if>
        </tbody>
    </table>
</div>
<jsp:include page="../common/foot.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>

</body>

</html>