<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách tài khoản</title>
    <jsp:include page="../common/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="../common/nav.jsp"></jsp:include>
<div class="container min-vh-100">
    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Danh sách tài khoản</p>
    <jsp:include page="../common/message.jsp"></jsp:include>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Họ và tên</th>
            <th scope="col">Email</th>
            <th scope="col">Mật khẩu</th>
            <th scope="col">Loại tài khoản</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${ users != null }">
            <c:forEach items="${users}" var="user">
                <tr>
                    <th scope="row">${user.id}</th>
                    <td>${user.fullName}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>${user.role}</td>
                    <td>
                        <a href="/backend/user/update/${user.id}" class="btn btn-success">Update</a>
                        &nbsp;
                        <a href="/backend/user/delete/${user.id}" class="btn btn-warning">Delete</a>
                        <a data-toggle="confirmation" class="btn btn-warning" data-title="Xóa tài khoản ${user.fullName}" data-popout="true"
                           href="/backend/user/delete/${user.id}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${ users == null }">
            <h1>KHông có tài khoản</h1>
        </c:if>
        </tbody>
    </table>
    <nav aria-label="...">
        <ul class="pagination">
            <li class="page-item <c:if test="${page == 1}">disabled</c:if>">
                <a class="page-link" href="/backend/user/list?page=${page - 1}&perPage=${perPage}" tabindex="-1" aria-disabled="true">Previous</a>
            </li>
            <c:forEach begin="1" end="${total}" step="1" var="num">
                <li class="page-item <c:if test="${page == num}">active</c:if> ">
                    <a class="page-link" href="/backend/user/list?page=${num}&perPage=${perPage}">${num}</a></li>
            </c:forEach>

            <li class="page-item <c:if test="${page == total}">disabled</c:if>">
                <a class="page-link" href="/backend/user/list?page=${page + 1}&perPage=${perPage}">Next</a>
            </li>
        </ul>
    </nav>
</div>
<jsp:include page="../common/foot.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>

</body>

</html>