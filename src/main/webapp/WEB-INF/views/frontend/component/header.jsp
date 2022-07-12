<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header-area">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="user-menu">
                    <ul>
                        <li><a href="#"><i class="fa fa-user"></i> My Account</a></li>
                        <li><a href="#"><i class="fa fa-heart"></i> Wishlist</a></li>
                        <li><a href="cart.html"><i class="fa fa-user"></i> My Cart</a></li>
                        <li><a href="checkout.html"><i class="fa fa-user"></i> Checkout</a></li>
                        <li><a href="#"><i class="fa fa-user"></i> Login</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-4">
                <div class="header-right">
                    <ul class="list-unstyled list-inline">
                        <li class="dropdown dropdown-small">
                            <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">
                                <spring:message code="currency"></spring:message> :</span><span class="value">
                                     <c:if test="${pageContext.response.locale == 'en'}">
                                         USD
                                     </c:if>
                                    <c:if test="${pageContext.response.locale == 'vi'}">
                                        VND
                                    </c:if>
                            </span><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">USD</a></li>
                                <li><a href="#">VND</a></li>
                            </ul>
                        </li>

                        <li class="dropdown dropdown-small">
                            <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key"> <spring:message code="language"></spring:message> :</span>
                                <span class="value">
                                    <c:if test="${pageContext.response.locale == 'en'}">
                                        <spring:message code="english"></spring:message>
                                    </c:if>
                                    <c:if test="${pageContext.response.locale == 'vi'}">
                                        <spring:message code="vietnam"></spring:message>
                                    </c:if>
                                </span><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="?lang=en">English</a></li>
                                <li><a  href="?lang=vi">Việt Nam</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End header area -->