<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:if test="${not empty category}" ><title>Thông tin thể loại</title></c:if>4
    <c:if test="${ empty category}" ><title>Thêm thể loại</title></c:if>
    <jsp:include page="../../common/web/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="../../common/nav.jsp"></jsp:include>
<div class="container min-vh-100">
    <c:if test="${not empty category}" >
        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Chi tiết thể loại</p>
    </c:if>
    <c:if test="${empty category}" >
        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Thêm thể loại</p>
    </c:if>
    <form
            <c:if test="${category == null}" >action="/category/save" method="post" </c:if>
            <c:if test="${category != null}" >action="/category/update/${category.id}" method="post" </c:if>
    >
        <!-- 2 column grid layout with text inputs for the first and last names -->
        <jsp:include page="../../common/message.jsp"></jsp:include>
        <div class="row mb-4">
            <div class="col">
                <div class="form-outline">
                    <input type="text" id="form3Example1" class="form-control" name="name" value="${category.name}"/>
                    <label class="form-label" for="form3Example1">Tên thể loại</label>
                </div>
            </div>
        </div>

        <!-- Email input -->
        <div class="form-outline mb-4">
            <input type="text" id="form3Example3" class="form-control" name="description"
                   value="${category.description}"/>
            <label class="form-label" for="form3Example3">Mô tả</label>
        </div>
        <button type="submit" class="btn btn-primary btn-block mb-4">
            <c:if test="${not empty category}" >CẬP NHẬT</c:if>
            <c:if test="${empty category}" >THÊM MỚI</c:if>
        </button>
    </form>
    <!-- MDB -->
    <jsp:include page="../../common/footer.jsp"></jsp:include>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.js"></script>
</div>
</body>

</html>