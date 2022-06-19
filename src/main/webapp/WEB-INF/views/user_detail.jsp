<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8"%>
 <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Thông tin tài khoản</title>
            <jsp:include page="../common/web/head.jsp"></jsp:include>
        </head>

        <body>
        <div class="container mt-3">
            <form>
                <!-- 2 column grid layout with text inputs for the first and last names -->
                <div class="row mb-4">
                    <div class="col">
                        <div class="form-outline">
                            <input type="text" id="form6Example1" class="form-control" value="${user.fullName}" />
                            <label class="form-label" for="form6Example1">Họ và tên</label>
                        </div>
                    </div>
                </div>

                <!-- Text input -->
                <div class="form-outline mb-4">
                    <input type="text" id="form6Example3" class="form-control" value="${user.email}" />
                    <label class="form-label" for="form6Example3">Email</label>
                </div>

                <!-- Text input -->
                <div class="form-outline mb-4">
                    <input type="text" id="form6Example4" class="form-control" value="${user.password}" />
                    <label class="form-label" for="form6Example4">Mật khẩu</label>
                </div>

                <!-- Email input -->
                <div class="form-outline mb-4">
                    <label class="form-label">Loại tài khoản</label>
                    <select class="form-select-button">
                        <option <c:if test="${user.role == 'USER'}"> selected</c:if> >USER</option>
                        <option <c:if test="${user.role == 'ADMIN'}"> selected</c:if> >ADMIN</option>

                    </select>
                </div>

<%--                <!-- Number input -->--%>
<%--                <div class="form-outline mb-4">--%>
<%--                    <input type="number" id="form6Example6" class="form-control" />--%>
<%--                    <label class="form-label" for="form6Example6">Phone</label>--%>
<%--                </div>--%>

<%--                <!-- Message input -->--%>
<%--                <div class="form-outline mb-4">--%>
<%--                    <textarea class="form-control" id="form6Example7" rows="4"></textarea>--%>
<%--                    <label class="form-label" for="form6Example7">Additional information</label>--%>
<%--                </div>--%>

<%--                <!-- Checkbox -->--%>
<%--                <div class="form-check d-flex justify-content-center mb-4">--%>
<%--                    <input class="form-check-input me-2" type="checkbox" value="" id="form6Example8" checked />--%>
<%--                    <label class="form-check-label" for="form6Example8"> Create an account? </label>--%>
<%--                </div>--%>

<%--                <!-- Submit button -->--%>
<%--                <button type="submit" class="btn btn-primary btn-block mb-4">Place order</button>--%>
            </form>
            <!-- MDB -->
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.js"></script>
        </div>
        </body>

        </html>