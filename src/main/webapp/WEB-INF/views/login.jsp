<%@ page pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Login</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" />
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" rel="stylesheet" />
            <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" rel="script" />
            <link href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" rel="stylesheet" />
            <style>
                @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap');
                * {
                    margin: 0;
                    padding: 0;
                    box-sizing: border-box;
                    font-family: 'Poppins', sans-serif
                }
                
                body {
                    background: #ecf0f3
                }
                
                .wrapper {
                    max-width: 350px;
                    min-height: 500px;
                    margin: 80px auto;
                    padding: 40px 30px 30px;
                    background-color: #ecf0f3;
                    border-radius: 15px;
                    box-shadow: 13px 13px 20px #cbced1, -13px -13px 20px #fff
                }
                
                .logo {
                    width: 80px;
                    margin: auto
                }
                
                .logo img {
                    width: 100%;
                    height: 80px;
                    object-fit: cover;
                    border-radius: 50%;
                    box-shadow: 0px 0px 3px #5f5f5f, 0px 0px 0px 5px #ecf0f3, 8px 8px 15px #a7aaa7, -8px -8px 15px #fff
                }
                
                .wrapper .name {
                    font-weight: 600;
                    font-size: 1.4rem;
                    letter-spacing: 1.3px;
                    padding-left: 10px;
                    color: #555
                }
                
                .wrapper .form-field input {
                    width: 100%;
                    display: block;
                    border: none;
                    outline: none;
                    background: 0 0;
                    font-size: 1.2rem;
                    color: #666;
                    padding: 10px 15px 10px 10px
                }
                
                .wrapper .form-field {
                    padding-left: 10px;
                    margin-bottom: 20px;
                    border-radius: 20px;
                    box-shadow: inset 8px 8px 8px #cbced1, inset -8px -8px 8px #fff
                }
                
                .wrapper .form-field .fas {
                    color: #555
                }
                
                .wrapper .btn {
                    box-shadow: none;
                    width: 100%;
                    height: 40px;
                    background-color: #03a9f4;
                    color: #fff;
                    border-radius: 25px;
                    box-shadow: 3px 3px 3px #b1b1b1, -3px -3px 3px #fff;
                    letter-spacing: 1.3px
                }
            </style>
        </head>

        <body>
            <div class="wrapper">
                <div class="logo">
                    <img src="https://www.freepnglogos.com/uploads/twitter-logo-png/twitter-bird-symbols-png-logo-0.png" alt="">
                </div>
                <div class="text-center mt-4 name">
                    Twitter
                </div>
                <form class="p-3 mt-3" action="/doLogin" method="post">
                    <div class="form-field d-flex align-items-center">
                        <span class="far fa-user"></span>
                        <input type="text" name="email" id="userName" placeholder="Username">
                    </div>
                    <div class="form-field d-flex align-items-center">
                        <span class="fas fa-key"></span>
                        <input type="password" name="password" id="pwd" placeholder="Password">
                    </div>
                    <button class="btn mt-3">Login</button>
                </form>
                <div class="text-center fs-6">
                    <a href="#">Forget password?</a> or <a href="#">Sign up</a>
                </div>
                <jsp:include page="../common/message.jsp"></jsp:include>

            </div>
        </body>

        </html>

<%--<c:if test="${not empty message}">--%>
<%--    <script>--%>
<%--        alert(${message})--%>
<%--    </script>--%>
<%--</c:if>--%>