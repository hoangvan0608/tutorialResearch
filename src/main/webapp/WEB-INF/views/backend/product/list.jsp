<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách thể loại</title>
    <jsp:include page="../common/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="../common/nav.jsp"></jsp:include>
<div class="container min-vh-100">
    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Danh sách thể loại</p>
    <jsp:include page="../common/message.jsp"></jsp:include>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID sản phẩm</th>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Thể loại</th>
            <th scope="col">Màu sắc</th>
            <th scope="col">Dung lượng</th>
            <th scope="col">Giá sản phẩm</th>
            <th scope="col">Mô tả sản phẩm</th>
            <th scope="col">Hình ảnh</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${ products != null }">
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.categoryId}</td>
                    <td>${product.colorId}</td>
                    <td>${product.memoryId}</td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                    <td><img style="max-width: 200px; height: 250px; object-fit: contain; width: 100%" src="${product.image}"> </td>
                    <td><a href="/backend/product/update/${product.id}" class="btn btn-success">Update</a> &nbsp; <a href="/backend/product/delete/${product.id}" class="btn btn-warning">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${ products == null }">
            <h1>Không có sản phẩm</h1>
        </c:if>
        </tbody>
    </table>
    <nav aria-label="...">
        <ul class="pagination">
            <li class="page-item <c:if test="${page == 1}">disabled</c:if>">
                <a class="page-link" href="/backend/product/list?page=${page - 1}&perPage=${perPage}" tabindex="-1" aria-disabled="true">Previous</a>
            </li>
            <c:forEach begin="1" end="${total}" step="1" var="num">
                <li class="page-item <c:if test="${page == num}">active</c:if> ">
                    <a class="page-link" href="/backend/product/list?page=${num}&perPage=${perPage}">${num}</a></li>
            </c:forEach>

            <li class="page-item <c:if test="${page == total}">disabled</c:if>">
                <a class="page-link" href="/backend/product/list?page=${page + 1}&perPage=${perPage}">Next</a>
            </li>
        </ul>
    </nav>
</div>
<jsp:include page="../common/foot.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>

</body>

</html>