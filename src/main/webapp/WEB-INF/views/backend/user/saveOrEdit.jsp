<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../../common/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap-confirmation2/dist/bootstrap-confirmation.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js" ></script>
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
    <form id="myForm" method="post" action="/backend/user/save">
        <jsp:include page="../common/message.jsp"></jsp:include>
        <div class="row mb-4">
            <div class="col">
                <div class="form-outline">
                    <label class="form-label" for="form3Example1">Họ và tên</label>
                    <input type="text" id="form3Example1" name="fullName" class="form-control" value="${user.fullName}" required/>
                    <input name="id" value="${user.id}" hidden>
                </div>
            </div>
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="form3Example3">Email</label>
            <input type="email" id="form3Example3" name="email" class="form-control" <c:if test="${not empty user}">disabled</c:if> value="${user.email}" required/>
        </div>
        <div class="form-outline mb-4 <c:if test="${not empty user.id }"> d-none </c:if> ">
            <label class="form-label" for="form3Example4">Password</label>
            <input type="password" id="form3Example4" name="password" class="form-control" <c:if test="${not empty user.id }"> value="${user.password}"</c:if> required/>
        </div>
        <div class="row mb-4">
            <div class="col-6">
                <label class="form-label" for="form3Example4">Loại tài khoản</label>
                <select name="role" class="form-select" required>
                    <option selected>------------------------</option>
                    <option <c:if test="${user.role == 'USER'}"> selected</c:if> value="USER">USER</option>
                    <option <c:if test="${user.role == 'ADMIN'}"> selected</c:if> value="ADMIN">ADMIN</option>
                </select>
            </div>
            <div class="col-6">
                <label class="form-label" for="form3Example4">Trạng thái</label>
                <select name="active" class="form-select" required>
                    <option>------------------------</option>
                    <option <c:if test="${user.active == '1'}"> selected</c:if> value="1">KÍCH HOẠT</option>
                    <option <c:if test="${user.active == '0'}"> selected</c:if> value="0">DỪNG KÍCH HOẠT</option>
                </select>
            </div>
        </div>

        <div class="mb-4">
            <label class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" name="address" <c:if test="${not empty user.id }"> value="${user.address}" </c:if> required/>
        </div>
        <div class="mb-4">
            <label class="form-label">Số điện thoại</label>
            <input type="text" class="form-control"  name="phone" <c:if test="${not empty user.id }"> value="${user.phone}" </c:if> required/>
        </div>
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

<script type="text/javascript">
    // add row
    $("#addRow").click(function () {
        var html = '';
        html += '<div id="inputFormRow">';
        html += '<div class="input-group mb-3">';
        html += '<input type="text" name="phones[]" class="form-control m-input" placeholder="Số điện thoại" autocomplete="off">';
        html += '<div class="input-group-append">';
        html += '<button id="removeRow" type="button" class="btn btn-danger">Xóa</button>';
        html += '</div>';
        html += '</div>';

        $('#newRow').append(html);
    });

    // remove row
    $(document).on('click', '#removeRow', function () {
        $(this).closest('#inputFormRow').remove();
    });
</script>