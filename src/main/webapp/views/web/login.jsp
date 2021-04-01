<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/views/web" var="login"></c:url>
<c:url value="/trang-chu" var="HomeUrl"> </c:url>
<html>
<head>
    <title>Title</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <style>
        h5 {
            padding: 10px 0px;
        }
    </style>
</head>
<body style="background-color: rgba(0,0,0,0.003)">
<div class="container" >
    <div class="row" style=" min-height: 100vh;">
        <div class="col-12">
            <div class="row">
                <div class="col-12 text-center" style="padding-top: 20px;">
                    <a href="${HomeUrl}?action=home" class="mt2" style=" color:#696763;"><i class="fas fa-home fa-4x"></i></a>
                </div>
            </div>
            <div class="row" style="margin-top: 100px;">
                <div class="col-1"></div>
                <div class="col-4">
                    <h4>Đăng nhập</h4>
                    <div class="login-form">
                        <form action="${pageContext.request.contextPath }/dang-nhap" method="post">
                            <div class="form-group">
                                <h5>Tên đăng nhập</h5>
                                <input name="username" type="text" class="form-control" placeholder="Tên đăng nhập">
                            </div>
                            <div class="form-group">
                                <h5>Mật khẩu</h5>
                                <input name="password" type="password" class="form-control" placeholder="Mật khẩu">
                            </div>
                            <label>${msg}</label><br>
                            <button type="submit" class="btn btn-success btn-primary" style="margin-top: 10px; color: white; background-color: #696763; border: none;">Đăng nhập</button>

                            <input type="hidden" name="action" value="login">

                        </form>
                        <form action="${pageContext.request.contextPath }/dang-ky?type=register" method="get ">
                            <button type="submit" class="btn btn-link">Đăng kí</button>
                            <input type="hidden" name="action" value="register">
                            <%--                <button type="button" class="btn btn-link" style="padding-left: 180px">Quên mật khẩu?</button>--%>
                        </form>
                    </div>
                </div>
                <div class="col-1" ></div>
                <div class="col-1" style="border-left: solid 1px #333 "></div>
                <div class="col-5" >
                    <div class="col-8">
                        <h4>Quên mật khẩu</h4>
                        <form action="${pageContext.request.contextPath }/trang-chu" method="post">
                            <div class="form-group">
                                <h5>Tên tài khoản</h5>
                                <input name="userName" type="text" class="form-control" placeholder="Nhập tên tài khoản">
                                <h5>Nhập email</h5>
                                <input name="emailReset" type="text" class="form-control" placeholder="Nhập email">
                            </div>
                            <label>${msg}</label><br>
                            <button type="submit" class="btn btn-success btn-primary " style="margin-top: 10px; color: white; background-color: #696763; border: none;" >Gửi </button>
                            <input type="hidden" name="action" value="login">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
</body>
</html>
