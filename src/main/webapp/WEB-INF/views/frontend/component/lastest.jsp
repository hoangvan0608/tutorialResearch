<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="latest-product">
    <h2 class="section-title">Latest Products</h2>
    <div class="product-carousel">
        <c:forEach items="products" var="p">
            <div class="single-product">
                <div class="product-f-image">
                    <img src="img/product-1.jpg" alt="">
                    <div class="product-hover">
                        <a href="#" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Add to cart</a>
                        <a href="single-product.html" class="view-details-link"><i class="fa fa-link"></i>
                            See details</a>
                    </div>
                </div>

                <h2><a href="single-product.html">${p.name}</a></h2>

                <div class="product-carousel-price">
                    <ins>$ 700.00</ins>
                    <del>$ ${p.price}</del>
                </div>
            </div>
        </c:forEach>

<%--        <div class="single-product">--%>
<%--            <div class="product-f-image">--%>
<%--                <img src="img/product-2.jpg" alt="">--%>
<%--                <div class="product-hover">--%>
<%--                    <a href="#" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Add to cart</a>--%>
<%--                    <a href="single-product.html" class="view-details-link"><i class="fa fa-link"></i>--%>
<%--                        See details</a>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <h2>Nokia Lumia 1320</h2>--%>
<%--            <div class="product-carousel-price">--%>
<%--                <ins>$899.00</ins>--%>
<%--                <del>$999.00</del>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="single-product">--%>
<%--            <div class="product-f-image">--%>
<%--                <img src="img/product-3.jpg" alt="">--%>
<%--                <div class="product-hover">--%>
<%--                    <a href="#" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Add to cart</a>--%>
<%--                    <a href="single-product.html" class="view-details-link"><i class="fa fa-link"></i>--%>
<%--                        See details</a>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <h2>LG Leon 2015</h2>--%>

<%--            <div class="product-carousel-price">--%>
<%--                <ins>$400.00</ins>--%>
<%--                <del>$425.00</del>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="single-product">--%>
<%--            <div class="product-f-image">--%>
<%--                <img src="img/product-4.jpg" alt="">--%>
<%--                <div class="product-hover">--%>
<%--                    <a href="#" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Add to cart</a>--%>
<%--                    <a href="single-product.html" class="view-details-link"><i class="fa fa-link"></i>--%>
<%--                        See details</a>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <h2><a href="single-product.html">Sony microsoft</a></h2>--%>

<%--            <div class="product-carousel-price">--%>
<%--                <ins>$200.00</ins>--%>
<%--                <del>$225.00</del>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="single-product">--%>
<%--            <div class="product-f-image">--%>
<%--                <img src="img/product-5.jpg" alt="">--%>
<%--                <div class="product-hover">--%>
<%--                    <a href="#" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Add to cart</a>--%>
<%--                    <a href="single-product.html" class="view-details-link"><i class="fa fa-link"></i>--%>
<%--                        See details</a>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <h2>iPhone 6</h2>--%>

<%--            <div class="product-carousel-price">--%>
<%--                <ins>$1200.00</ins>--%>
<%--                <del>$1355.00</del>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="single-product">--%>
<%--            <div class="product-f-image">--%>
<%--                <img src="img/product-6.jpg" alt="">--%>
<%--                <div class="product-hover">--%>
<%--                    <a href="#" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Add to cart</a>--%>
<%--                    <a href="single-product.html" class="view-details-link"><i class="fa fa-link"></i>--%>
<%--                        See details</a>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <h2><a href="single-product.html">Samsung gallaxy note 4</a></h2>--%>

<%--            <div class="product-carousel-price">--%>
<%--                <ins>$400.00</ins>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div>
</div>