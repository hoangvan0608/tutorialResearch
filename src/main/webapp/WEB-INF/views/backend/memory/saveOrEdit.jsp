<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bộ nhớ</title>
    <jsp:include page="../common/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="../common/nav.jsp"></jsp:include>
<div class="container">
    <c:if test="${memory != null}">
        <h2 class="text-center">Cập nhật thông tin</h2>
    </c:if>
    <c:if test="${memory== null}">
        <h2 class="text-center">Thêm thông tin</h2>
    </c:if>
    <jsp:include page="../common/message.jsp"></jsp:include>
    <form action="/backend/memory/save" method="post">
        <input type="hidden" name="id" value="${memory.id}">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Bộ nhớ</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="name"
                   <c:if test="${not empty memory}">value="${memory.name}" </c:if> >
        </div>
        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-outline-primary">
                <c:if test="${not empty memory}">Cập nhật</c:if>
                <c:if test="${empty memory}">Thêm mới</c:if>
            </button>
        </div>
    </form>
</div>


<jsp:include page="../common/foot.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>
</div>
</body>

</html>