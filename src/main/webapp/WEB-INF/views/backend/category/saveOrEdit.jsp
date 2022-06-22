<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:if test="${not empty category}"><title>Thông tin thể loại</title></c:if>
    <c:if test="${ empty category}"><title>Thêm thể loại</title></c:if>
    <jsp:include page="../common/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="../common/nav.jsp"></jsp:include>
<div class="container">
    <c:if test="${category != null}">
        <h2 class="text-center">Cập nhật thể loại</h2>
    </c:if>
    <c:if test="${category== null}">
        <h2 class="text-center">Thêm thể loại</h2>
    </c:if>
    <jsp:include page="../common/message.jsp"></jsp:include>
    <form
            <c:if test="${empty category}">action="/backend/category/save" method="post" </c:if>
            <c:if test="${not empty category}"> action="/backend/category/update/${category.id}" method="post" </c:if>>
        <input type="hidden" name="id" value="${category.id}">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Tên thể loại</label>
        <input type="text" class="form-control" id="exampleInputEmail1" name="name"
               <c:if test="${not empty category}">value="${category.name}" </c:if> >
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Mô tả</label>
        <input type="text" class="form-control" id="exampleInputPassword1" name="description" required
               <c:if test="${not empty category}">value="${category.description}" </c:if> >
    </div>
    <div class="d-grid gap-2">
        <button type="submit" class="btn btn-outline-primary">
            <c:if test="${not empty category}">Cập nhật</c:if>
            <c:if test="${empty category}">Thêm mới</c:if>
        </button>
    </div>
    </form>
</div>


<jsp:include page="../common/foot.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>
</div>
</body>

</html>