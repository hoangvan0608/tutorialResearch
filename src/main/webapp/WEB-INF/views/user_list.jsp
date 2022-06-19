<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Danh sách tài khoản</title>
            <jsp:include page="../common/web/head.jsp"></jsp:include>
        </head>

        <body>
            <div class="container">
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
                                    <td><a class="btn btn-success">Update</a> &nbsp; <a class="btn btn-warning">Delete</a> </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${ users == null }">
                            <h1>KHông có tài khoản</h1>
                        </c:if>
                    </tbody>
                </table>
            </div>

            <!-- MDB -->
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.js"></script>
        </body>

        </html>