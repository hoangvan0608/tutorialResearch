<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8" %>
<div class="latest-product">
    <h2 class="section-title">Latest Products</h2>
    <div class="product-carousel">
        <c:forEach items="${products}" var="p">
            <div class="single-product">
                <div class="product-f-image">
                    <img style="width: 200px; height: 300px; object-fit: contain;" src="${p.image}" alt="lỗi">
                    <div class="product-hover">
                        <a href="#" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Add to cart</a>
                        <a href="/backend/product/detail/${p.id}" class="view-details-link"><i class="fa fa-link"></i>
                            See details</a>
                    </div>
                </div>

                <h2><a href="single-product.html">${p.name}</a></h2>

                <div class="product-carousel-price">
                    <ins id="price">${p.price} VNĐ</ins>
                    <br>
                    <del id="price-under">${p.price * 0.13} VNĐ</del>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
