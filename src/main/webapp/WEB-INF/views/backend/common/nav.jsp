<%@ page pageEncoding="UTF-8" %>
<header class="p-3 mb-6 border-bottom bg-light">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
<%--                <li><a href="#" class="nav-link px-2 link-secondary">Overview</a></li>--%>
<%--                <li><a href="#" class="nav-link px-2 link-dark">Inventory</a></li>--%>
                <li>
                    <div class="dropdown">
                        <button class="btn btn-light dropdown-toggle" type="button"  data-bs-toggle="dropdown" aria-expanded="false">
                            Tài khoản
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                            <li><a class="dropdown-item" href="/backend/user/list">Danh sách</a></li>
                            <li><a class="dropdown-item" href="/backend/user/create">Tạo mới</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <div class="dropdown">
                        <button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            Thể loại
                        </button>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/backend/category/list">Danh sách</a></li>
                            <li><a class="dropdown-item" href="/backend/category/create">Tạo mới</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <div class="dropdown">
                        <button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            Nhãn hiệu
                        </button>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/backend/brand/list">Danh sách</a></li>
                            <li><a class="dropdown-item" href="/backend/brand/create">Tạo mới</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <div class="dropdown">
                        <button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            Màu sắc
                        </button>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/backend/color/list">Danh sách</a></li>
                            <li><a class="dropdown-item" href="/backend/color/create">Tạo mới</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <div class="dropdown">
                        <button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            Bộ nhớ
                        </button>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/backend/memory/list">Danh sách</a></li>
                            <li><a class="dropdown-item" href="/backend/memory/create">Tạo mới</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <div class="dropdown">
                        <button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            Sản phẩm
                        </button>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/backend/product/list">Danh sách</a></li>
                            <li><a class="dropdown-item" href="/backend/product/create">Tạo mới</a></li>
                        </ul>
                    </div>
                </li>

            </ul>

            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
            </form>

            <div class="dropdown text-end">
                <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
                </a>
                <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1" style="">
                    <li><a class="dropdown-item" href="#">New project...</a></li>
                    <li><a class="dropdown-item" href="#">Settings</a></li>
                    <li><a class="dropdown-item" href="#">Profile</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="#">Sign out</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>