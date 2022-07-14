<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Màu sắc</title>
    <jsp:include page="../common/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="../common/nav.jsp"></jsp:include>
<div class="container min-vh-100">
    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Màu sắc</p>
    <jsp:include page="../common/message.jsp"></jsp:include>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID Color</th>
            <th scope="col">Color Name</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${ colors != null }">
            <c:forEach items="${colors}" var="color">
                <tr>
                    <td class="col-3">${color.id}</td>
                    <td>${color.name}</td>
                    <td class="col-3"><a href="/backend/color/update/${color.id}" class="btn btn-success">Update</a> &nbsp; <a href="/backend/color/delete/${color.id}" class="btn btn-warning">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${ colors == null }">
            <h1>Không có màu sắc</h1>
        </c:if>
        </tbody>
    </table>
</div>
<jsp:include page="../common/foot.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>

</body>

</html>