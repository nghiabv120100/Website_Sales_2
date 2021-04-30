<%--
  Created by IntelliJ IDEA.
  User: hungd
  Date: 4/21/2021
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:url value="/api-admin-product" var="APIurl"></c:url>
<c:url value="/views/admin/static" var="url"></c:url>
<c:url value="/admin-warehouse_receipt-list" var="PCurl"></c:url>
<script src="./Validation.js"></script>
<!DOCTYPE html>
<html>
<head>
    <script src="<c:url value="/ckeditor/ckeditor.js" />"></script>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Thêm phiếu nhập hàng</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="${url}/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="${url}/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLES-->
    <link href="${url}/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans'
          rel='stylesheet' type='text/css' />
</head>
<body>
<div id="wrapper">
    <jsp:include page="/views/admin/view/nav-bar.jsp"></jsp:include>
    <!-- /. NAV TOP  -->
    <jsp:include page="/views/admin/view/slide-bar.jsp"></jsp:include>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h2>Thêm phiếu nhập hàng</h2>
                </div>
            </div>
            <!-- /. ROW  -->
            <hr />
            <div class="row">
                <div class="col-md-12">
                    <!-- Form Elements -->
                    <div class="panel panel-default">
                        <div class="panel-heading"></div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <h3>Nhập thông tin phiếu nhập hàng</h3>
                                    <form role="form" action="api-admin-product" method="post" enctype="multipart/form-data">

                                        <div class="form-group" style="display:inline;">
                                            <div class="col-md-6">
                                                <label>Tên nhà cung cấp</label>
                                                <div class="checkbox">
                                                    <select name="supplierId" id="supplierId">
                                                        <c:forEach items="${lstSupplier}" var="c">
                                                            <option value='${c.id}'>${c.nameSupplier}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <label >Mô tả đơn hàng </label>
                                                <br>
                                                <textarea rows="4" cols="50" name="editer" id="editer" ></textarea>
                                            </div>
                                        </div>

                                        <div class="table-responsive" style="width: max-content; margin-top: 20px">
                                            <table class="table table-striped table-bordered table-hover" id="data-table">
                                                <thead>
                                                <tr>
                                                    <th>Mã sản phẩm </th>
                                                    <th>Tên sản phẩm</th>
                                                    <th>Số lượng</th>
                                                    <th>Giá sản phẩm (vnđ)</th>
                                                    <th>Tổng đơn hàng (vnđ)</th>
                                                    <th></th>
                                                </tr>
                                                </thead>
                                                <tbody>
<%--                                                <c:forEach items="${hangnhaps}" var="hangnhap">--%>
<%--                                                    <tr>--%>
<%--                                                        <td>2</td>--%>
<%--                                                        <td>${hangnhap.getMaMatHang()}</td>--%>
<%--                                                        <td>${hangnhap.getTenMatHang()}</td>--%>
<%--                                                        <td>${hangnhap.getSoluong()}</td>--%>
<%--                                                        <td>${hangnhap.getGiaTri()}</td>--%>
<%--                                                        <td><button type="button" class="btn btn-primary float-right" onclick="DeleteRow()">Xóa</button></td>--%>
<%--                                                    </tr>--%>
<%--                                                </c:forEach>--%>
                                                <tr>
                                                    <td><input type="text" class="form-control" id="idsanpham" readonly></td>
                                                    <td><input type="text" class="form-control" id="tensanpham"></td>
                                                    <td><input type="text" class="form-control" id="soluong"></td>
                                                    <td><input type="text" class="form-control" id="giasanpham"></td>
                                                    <td><input type="text" class="form-control" id="tongdonhang" readonly></td>
                                                    <td>
                                                        <button id="addRow" type="button" style="border-radius: 5px; border: none; background-color: white; color: black" class="btn btn-primary float-right" onclick="AddRow()">Thêm</button>
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>

                                        <button type="button" id="btnAdd" class="btn btn-default">Thêm</button>
                                        <button type="reset" class="btn btn-primary" onclick="window.location.href ='${PCurl}?type=add'">Reset</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End Form Elements -->
                </div>
            </div>
        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="${url}/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="${url}/js/bootstrap.min.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="${url}/js/jquery.metisMenu.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="${url}/js/custom.js"></script>
<script type="text/javascript" language="javascript">
    CKEDITOR.replace('ckeditor', {width: '700px',height: '300px'});
</script>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
    $('#addRow').click(function (e){
        var tensanpham = document.getElementById("tensanpham").value;
        var soluong = document.getElementById("soluong").value;
        var giasanpham = document.getElementById("giasanpham").value;
        var maphieu = null;
        var myVar = JSON.stringify({nameProduct: tensanpham, price: giasanpham, total: soluong, goodsReceivedEntity: maphieu});
        $.ajax({
            url: 'addImportGoods',
            type: 'POST',
            enctype: 'multipart/form-data',
            processData:false,
            contentType: 'application/json',
            data: myVar,
            dataType: 'json',
            success: function (result){
                var table = document.getElementById("data-table");
                var index = table.rows.length - 1;

                row = table.insertRow(index);
                cell1 = row.insertCell(0);
                cell2 = row.insertCell(1);
                cell3 = row.insertCell(2);
                cell4 = row.insertCell(3);
                cell5 = row.insertCell(4);
                cell6 = row.insertCell(5);

                cell1.innerHTML = result.id;
                cell2.innerHTML = tensanpham;
                cell3.innerHTML = soluong;
                cell4.innerHTML = giasanpham;
                cell5.innerHTML = giasanpham * soluong ;
                cell6.innerHTML = '<button type="button" class="btn btn-primary float-right" onclick="DeleteRow()">Xóa</button>';
                document.getElementById("idsanpham").value = "";
                document.getElementById("tensanpham").value = "";
                document.getElementById("giasanpham").value = "";
                document.getElementById("soluong").value = "";
            },
            errMode: function (error){
                console.log("Error");
            }
        });
    });
    function DeleteRow(x) {
        // var td = event.target.parentNode;
        // var tr = td.parentNode; // the row to be removed
        // var id = tr.querySelector('#idsanpham');
        // var myVar = JSON.stringify({id: id});
        // $.ajax({
        //     url: 'addImportGoods',
        //     type: 'DELETE',
        //     contentType: 'application/json',
        //     data: 'para' + myVar,
        //     contentType: 'application/json',
        //     dataType: 'json',
        //     success: function (result){
        //         var td = event.target.parentNode;
        //         var tr = td.parentNode; // the row to be removed
        //         var test = tr.firstChild;
        //         tr.parentNode.removeChild(tr);
        //         alert(result);
        //     },
        //     errMode: function (error){
        //         alert(error);
        //     }
        // });

    }
</script>
</body>
</html>




