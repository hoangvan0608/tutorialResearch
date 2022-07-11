<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:if test="${not empty product}"><title>Thông tin sản phẩm</title></c:if>
    <c:if test="${ empty product}"><title>Thêm sản phẩm</title></c:if>
    <jsp:include page="../common/head.jsp"></jsp:include>
</head>

<body>
<jsp:include page="../common/nav.jsp"></jsp:include>
<div class="container">
    <c:if test="${product != null}">
        <h2 class="text-center">Cập nhật sản phẩm</h2>
    </c:if>
    <c:if test="${product== null}">
        <h2 class="text-center">Thêm sản phẩm</h2>
    </c:if>
    <jsp:include page="../common/message.jsp"></jsp:include>
    <form action="/backend/product/save" method="post" >
        <input type="hidden" name="id" value="${product.id}">
        <div class="row mb-3">
            <div class="col-md-8">
                <label for="exampleInputEmail1" class="form-label">Tên sản phẩm</label>
                <input type="text" class="form-control" id="exampleInputEmail1" name="name"
                       <c:if test="${not empty product}">value="${product.name}" </c:if> >
            </div>
            <div class="col-md-4">
                <label for="price" class="form-label">Giá</label>
                <input type="number" min="0" class="form-control" id="price" name="price"
                       <c:if test="${not empty product}">value="${product.price}" </c:if> >
            </div>

        </div>
        <div class="row mb-3">
            <div class="col-md-4">
                <label class="form-label">Danh mục</label>
                <select name="categoryId" class="form-select">
                    <c:forEach items="${categories}" var="category">
                        <option <c:if test="${product.categoryId == category.id}"> selected</c:if>
                                value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4">
                <label class="form-label">Dung lượng</label>
                <select name="memoryId" class="form-select">
                    <c:forEach items="${memories}" var="memory">
                        <option <c:if test="${product.memoryId == memory.id}"> selected</c:if>
                                value="${memory.id}">${memory.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4">
                <label class="form-label">Màu sắc</label>
                <select name="colorId" class="form-select">
                    <c:forEach items="${colors}" var="color">
                        <option <c:if test="${product.colorId == color.id}"> selected</c:if>
                                value="${color.id}">${color.name}</option>
                    </c:forEach>
                </select>
            </div>

        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Mô tả</label>
            <input type="text" class="form-control" id="exampleInputPassword1" name="description" required
                   <c:if test="${not empty product}">value="${product.description}" </c:if> >
        </div>
        <div class="row mb-3">
            <div class="col-md-6">
                <label for="fileUploadId" class="form-label">Image</label>
                <input type="text" class="form-control" id="fileUploadName" <c:if test="${not empty product}"> value="${product.image}" </c:if> name="image" hidden/>
                <input type="file" id="fileUploadId" class="form-control"/><%-- thẻ input chon ảnh--%>
                <div></div>
            </div>
            <div class="col-md-6">
                <div>
                    <img id="outputImage" width="100px" <c:if test="${not empty product}"> src="${product.image}" </c:if>/>
                </div>
            </div>

            <script>
                $('#fileUploadId').on("change", function () {
                    var file = $(this)[0].files[0];
                    var reader = new FileReader();
                    reader.onload = function () {
                        var output = document.getElementById('outputImage');
                        output.src = reader.result;
                    };
                    reader.readAsDataURL(file);
                    var data = new FormData();
                    data.append("file", file, file.name);
                    $.ajax({
                        type: "POST",
                        enctype: 'multipart/form-data',
                        url: "/upload/storage",
                        data: data,
                        // prevent jQuery from automatically transforming the data into a query string
                        processData: false,
                        contentType: false,
                        cache: false,
                        timeout: 1000000,
                        success: function (data, textStatus, jqXHR) {
                            $("#fileUploadName").val(data);
                            alert("Tải file " + data + " thành công");
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            alert("tải file thất bại")

                        }
                    });
                })
            </script>
        </div>
        <div class="d-grid gap-2 mb-3">
            <button type="submit" class="btn btn-outline-primary">
                <c:if test="${not empty product}">Cập nhật</c:if>
                <c:if test="${empty product}">Thêm mới</c:if>
            </button>
        </div>
    </form>
</div>


<jsp:include page="../common/foot.jsp"></jsp:include>
<jsp:include page="../common/js.jsp"></jsp:include>
</div>
</body>

</html>