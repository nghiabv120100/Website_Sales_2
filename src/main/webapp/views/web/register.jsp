<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:url value="/api-admin-user" var ="APIurl"></c:url>
<c:url value="/validationlogin" var="url"> </c:url>
<!DOCTYPE html>
<html>
<head>
    <title>Registation Form * Form Tutorial</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2 class="text-center">Đăng ký tài khoản</h2>
        </div>

        <form class="panel-body" id="register-form">
            <div class="form-group">
                <label for="fullname">Full Name:</label>
                <input required="true" type="text" class="form-control" id="fullname"
                       value="${user.fullname}" placeholder = "Nhập full name" />
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="username">User Name:</label>
                <input required="true" type="text" class="form-control" id="username"
                       value="${user.username}" placeholder = "Nhập User" />
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input required="true" type="email" class="form-control" id="email" placeholder="Nhập email"
                value="${user.email}">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="phone">Phone number:</label>
                <input required="true" type="phone" class="form-control" id="phone" placeholder="Nhập số điện thoại"
                       value="${user.phonenumber}">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input required="true" type="password" class="form-control" id="pwd" placeholder="Nhập mật khẩu"
                       value="${user.passWord}">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="confirmation_pwd">Confirmation Password:</label>
                <input required="true" type="password" class="form-control" placeholder="Xác nhận mật khẩu" id="confirmation_pwd">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" class="form-control" id="address" placeholder="Nhập địa chỉ"
                       value="${user.address}">
                <span class="form-message"></span>
            </div>
            <button type="button" class="btn btn-success" id="btnRegister">Register</button>
            <button class="btn btn-success" onclick="document.location='${pageContext.request.contextPath}/trang-chu?action=home'">Cancel</button>
        </form>
    </div>
</div>
<script>
    $('#btnRegister').click(function (e){
        e.preventDefault();
        var fullname=$('#fullname').val();
        var username= $('#username').val();
        var email= $('#email').val();
        var phone= $('#phone').val();
        var pwd= $('#pwd').val();
        var address= $('#address').val();
        var data={
            "fullname":fullname,
            "username":username,
            "email":email,
            "phone_number":phone,
            "passWord":pwd,
            "address":address,
            "role": "0"
        }
        registerAccount(data)
    });
    function registerAccount(data){
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            enctype: 'multipart/form-data',
            processData:false,
            contentType: 'application/json',
            data:JSON.stringify(data),
            dataType: 'json',

            success: function (result){
                console.log("Success");
                window.location.href = "${url}?type=logout";
            },
            error: function (error){
                console.log("Error");

                window.location.href = "${url}?type=register";

            }

        })
    }
</script>

<script src='${pageContext.request.contextPath }/Validation.js'></script>
<script>
    Validator({
        form: '#register-form',
        formGroupSelector: '.form-group',
        errorSelector : '.form-message',
        rules: [
            Validator.isRequired('#fullname'),
            Validator.isRequired('#username'),
            Validator.minLength('#username','6'),
            Validator.isRequired('#email'),
            Validator.isEmail('#email'),
            Validator.isRequired('#phone'),
            Validator.minLength('#pwd', '6'),
            Validator.minLength('#confirmation_pwd','6'),
            Validator.isRequired('#pwd'),
            Validator.isRequired('#comfirmation_pwd'),
            Validator.isConfirmed('#confirmation_pwd',function () {
                return document.querySelector('#register-form #pwd').value;
            }),
            Validator.isRequired('#address')
        ]
    });

</script>
</body>
</html>
