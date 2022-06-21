<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../common/taglib.jsp" %>
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

    <jsp:include page="../../common/web/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="../../common/nav.jsp"></jsp:include>
<div class="container min-vh-100">
    <c:if test="${not empty user}">
        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Chi tiết tài khoản</p>
    </c:if>
    <c:if test="${empty user}">
        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Tạo tài khoản</p>
    </c:if>

    <form:form method="post" action="/user/save">
        <jsp:include page="../../common/message.jsp"></jsp:include>
        <!-- 2 column grid layout with text inputs for the first and last names -->
        <div class="row mb-4">
            <div class="col">
                <div class="form-outline">
                    <input type="text" id="form3Example1" class="form-control" value="${user.fullName}"/>
                    <label class="form-label" for="form3Example1">Họ và tên</label>
                </div>
            </div>
        </div>

        <!-- Email input -->
        <div class="form-outline mb-4">
            <input type="email" id="form3Example3" class="form-control" value="${user.email}"/>
            <label class="form-label" for="form3Example3">Email</label>
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
            <input type="text" id="form3Example4" class="form-control" value="${user.password}"/>
            <label class="form-label" for="form3Example4">Password</label>
        </div>

        <%--        <div class="form-outline mb-4">--%>
        <%--        <div class="row">--%>
        <%--            <div class="col-3"><label class="form-control">Loại tài khoản</label></div>--%>
        <%--            <div class="col-9"><select class="form-control">--%>
        <%--                <option value="1">One</option>--%>
        <%--                <option value="2">Two</option>--%>
        <%--                <option value="3">Three</option>--%>
        <%--            </select></div>--%>
        <%--        </div>--%>
        <select class="form-select mb-4">
            <option selected>Loại tài khoản</option>
            <option <c:if test="${user.role == 'USER'}"> SELECTED</c:if> value="USER">USER</option>
            <option <c:if test="${user.role == 'ADMIN'}"> SELECTED</c:if> value="ADMIN">ADMIN</option>
        </select>

        <%--        </div>--%>

        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4">
            <c:if test="${not empty user}">
                Cập nhật
            </c:if>
            <c:if test="${empty user}">
                Thêm mới
            </c:if>
        </button>

        <!-- Register buttons -->
        <%--        <div class="text-center">--%>
        <%--            <p>or sign up with:</p>--%>
        <%--            <button type="button" class="btn btn-primary btn-floating mx-1">--%>
        <%--                <i class="fab fa-facebook-f"></i>--%>
        <%--            </button>--%>

        <%--            <button type="button" class="btn btn-primary btn-floating mx-1">--%>
        <%--                <i class="fab fa-google"></i>--%>
        <%--            </button>--%>

        <%--            <button type="button" class="btn btn-primary btn-floating mx-1">--%>
        <%--                <i class="fab fa-twitter"></i>--%>
        <%--            </button>--%>

        <%--            <button type="button" class="btn btn-primary btn-floating mx-1">--%>
        <%--                <i class="fab fa-github"></i>--%>
        <%--            </button>--%>
        <%--        </div>--%>
    </form:form>
    <!-- MDB -->
    <jsp:include page="../../common/footer.jsp"></jsp:include>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.js"></script>
</div>
</body>

</html>