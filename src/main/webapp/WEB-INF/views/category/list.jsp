<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách tài khoản</title>
    <jsp:include page="../../common/web/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="../../common/nav.jsp"></jsp:include>
<div class="container min-vh-100">
    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Danh sách thể loại</p>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã thể loại</th>
            <th scope="col">Tên thể loại</th>
            <th scope="col">Mô tả</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${ users != null }">
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td>${category.description}</td>
                    <td><a href="/category/${category.id}" class="btn btn-success">Update</a> &nbsp; <a class="btn btn-warning">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${ categories == null }">
            <h1>Không có thể loại</h1>
        </c:if>
        </tbody>
    </table>
</div>

<!-- MDB -->
<jsp:include page="../../common/footer.jsp"></jsp:include>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.js"></script>
</body>

</html>