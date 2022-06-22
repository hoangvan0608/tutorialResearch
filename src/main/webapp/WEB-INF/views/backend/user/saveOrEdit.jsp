<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../../common/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:if test="${not empty user}">
        <title>Thông tin tài khoản</title>
    </c:if>
    <c:if test="${empty user}">
        <title>Tạo mới tài khoản</title>
    </c:if>
    <jsp:include page="../common/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="../common/nav.jsp"></jsp:include>
<div class="container min-vh-100">
    <c:if test="${not empty user}">
        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Chi tiết tài khoản</p>
    </c:if>
    <c:if test="${empty user}">
        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Tạo tài khoản</p>
    </c:if>
    <form id="myForm" method="post" action="/user/save">
        <jsp:include page="../common/message.jsp"></jsp:include>
        <div class="row mb-4">
            <div class="col">
                <div class="form-outline">
                    <label class="form-label" for="form3Example1">Họ và tên</label>
                    <input type="text" id="form3Example1" name="fullName" class="form-control" value="${user.fullName}"/>
                </div>
            </div>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form3Example3">Email</label>
            <input type="email" id="form3Example3" name="email" class="form-control" value="${user.email}"/>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form3Example4">Password</label>
            <input type="password" id="form3Example4" name="password" class="form-control" value="${user.password}"/>
        </div>
        <select class="form-select mb-4">
            <option selected>Loại tài khoản</option>
            <option <c:if test="${user.role == 'USER'}"> SELECTED</c:if> value="USER">USER</option>
            <option <c:if test="${user.role == 'ADMIN'}"> SELECTED</c:if> value="ADMIN">ADMIN</option>
        </select>
        <button type="submit" class="btn btn-primary btn-block mb-4">
            <c:if test="${not empty user}">
                Cập nhật
            </c:if>
            <c:if test="${empty user}">
                Thêm mới
            </c:if>
        </button>
    </form>
    <jsp:include page="../common/foot.jsp"></jsp:include>
    <jsp:include page="../common/js.jsp"></jsp:include>
</div>
</body>
<script>
    // Validate by jquery
    $(document).ready(function() {
        $("#myForm").validate({
            rules: {
                fullName: "required",
                email: {
                    required: true,
                    email: true
                },
                password: "required"
            },
            messages: {
                fullName: "Please specify your name",
                email: {
                    required: "We need your email address to contact you",
                    email: "Your email address must be in the format of name@domain.com"
                }
            }
        });
    });
</script>
</html>