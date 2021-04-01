<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/views/web/static" var="url"> </c:url>
<c:url value="/views/web" var="Pathurl"> </c:url>
<c:url value="/trang-chu" var="HomeUrl"> </c:url>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>index</title>
    <link href="${url}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${url}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${url}/css/main.css" rel="stylesheet">
    <link rel="stylesheet" href="${url}/css/menu.css">
</head>
<body>
<header id="header"><!--header-->
    <div class="header-middle"><!--header-middle-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="logo pull-left">
                        <a href="index.jsp"><img src="${url}/images/logo1.png" alt="" /></a>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="shop-menu pull-right">
                        <ul class=" nav nav-pills nav-stacked ">
                            <li><a href="${pageContext.request.contextPath}/account-manager"><i class="fa fa-book" aria-hidden="true"></i>Tài khoản</a></li>
                            <li><a href="${pageContext.request.contextPath}/client-cart-list"><i class="fa fa-shopping-cart"></i> Giỏ hàng</a></li>
                            <c:if test="${not empty loginName}">
                                <li><a href="#"><i class="fa fa-user"></i>Chào <c:out value="${loginName}"></c:out></a></li>
                                <li><a href="${pageContext.request.contextPath }/dang-nhap?action=logout">Đăng xuất</a></li>
                            </c:if>
                            <c:if test="${empty loginName}">
                                <li><a href="${Pathurl}/login.jsp"><i class="fa fa-lock"></i>Đăng nhập / Đăng kí </a></li>
                            </c:if>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/header-middle-->
</header><!--/header-->

<nav>
    <ul>
        <li><a href="${HomeUrl}?action=home">Trang chủ</a></li>
      <%--      <li><a href="${pageContext.request.contextPath }/client-product-list?type=list&page=1">Trang chủ</a>--%>
        <li><a href="${pageContext.request.contextPath }/client-product-list?type=list&page=1">Danh mục sản phẩm</a>
            <ul>
                <li><a href="${pageContext.request.contextPath }/client-product-list?type=category&cate_id=1&page=1">Laptop</a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=1&page=1">Laptop Acer</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=2&page=1">Laptop Asus</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=3&page=1">Laptop Dell</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=4&page=1">Laptop Lenovo</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=5&page=1">Laptop HP</a></li>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath }/client-product-list?type=category&cate_id=2&page=1">Màn Hình</a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=6&page=1">Màn Hình Samsung </a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=7&page=1">Màn Hình ASUS</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=8&page=1">Màn Hình Acer</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=9&page=1">Màn Hình Gigabyte</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=10&page=1">Màn Hình MSI</a></li>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath }/client-product-list?type=category&cate_id=3&page=1">Chuột chơi game</a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=11&page=1">Logitech</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=12&page=1">Kingston HyperX</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=13&page=1">Razer</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=14&page=1">Asus</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=15&page=1">MSI</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=16&page=1">Hãng Khác</a></li>


                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath }/client-product-list?type=category&cate_id=4&page=1">Bàn phím</a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=17&page=1">Logitech</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=18&page=1">Kingston HyperX</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=19&page=1">Razer</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=20&page=1">Asus</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=21&page=1">MSI</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=22&page=1">Hãng Khác</a></li>

                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath }/client-product-list?type=category&cate_id=5&page=1">Tai nghe</a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=23&page=1">Logitech</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=24&page=1">Kingston HyperX</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=25&page=1">Razer</a></li>
                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=26&page=1">Asus</a></li>
<%--                        <li><a href="${pageContext.request.contextPath}/client-product-list?type=detail_category&detail_cate_id=27&page=1">Corsier</a></li>&ndash;%&gt;--%>
<%--                        <li><a href="${pageContext.request.contextPath }/client-product-list?type=detail_category&detail_cate_id=28&page=1">Hãng Khác</a></li>--%>
                    </ul>
                </li>
            </ul>
        </li>
        <li><a href="${Pathurl}/salespolicy.jsp">Chính sách bán hàng</a></li>
        <li><a href="${Pathurl}/map.jsp">Liên hệ</a></li>
        <div class="search-container">
            <form action="${pageContext.request.contextPath }/client-product-list">
                <input name="keyword" type="text" placeholder="Tìm kiếm.." >
                <input name="type" type="hidden" value="searchByName">
                <input name="page" type="hidden" value="1">
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
        </div>
    </ul>

</nav>
</body>
</html>
