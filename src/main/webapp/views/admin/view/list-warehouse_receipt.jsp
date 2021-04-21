<%--
  Created by IntelliJ IDEA.
  User: hungd
  Date: 4/21/2021
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:url var="APIurl" value="/api-admin-product"/>
<c:url value="/views/admin/static" var="url"></c:url>
<c:url value="/admin-product-list" var="PCurl"></c:url>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Product Management</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="${url}/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="${url}/css/font-awesome.css" rel="stylesheet" />
    <!-- MORRIS CHART STYLES-->
    <!-- CUSTOM STYLES-->
    <link href="${url}/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans'
          rel='stylesheet' type='text/css' />
    <!-- TABLE STYLES-->
    <link href="${url}/js/dataTables/dataTables.bootstrap.css"
          rel="stylesheet" />
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
                    <h2>Danh sách phiếu nhập hàng</h2>
                </div>
            </div>
            <!-- /. ROW  -->
            <hr />
            <div class="row">
                <div class="col-md-12">
                    <div>
                        <button class="btn btn-danger square-btn-adjust" style="margin-bottom: 5px"><a href='<c:url value="/admin-warehouse_receipt-list?type=add"/>' style="color: white">Thêm phiếu nhập hàng</a></button>
                    </div>

                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading"></div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover"
                                       id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>ID </th>
                                        <th>Nhà cung cấp</th>
                                        <th>Người tạo đơn</th>
                                        <th>Ngày nhập</th>
                                        <th>Mô tả</th>
                                        <th>Giá trị đơn hàng</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${lstGoodsReceived}" var="received">
                                        <tr class="odd gradex">
                                            <td>${received.getId()}</td>
                                            <td>${received.getSupplierEntity().getNameSupplier()}</td>
                                            <td>${received.getUserEntity().getFullname()}</td>
                                            <td>${received.getDate_Goods_Received()}</td>
                                            <td>${received.getNote()}</td>
                                            <td>0đ</td>
                                            <td>
                                                <button style="width: 70px;">
                                                    <a href="<c:url value="/admin-product-list?type=edit&id=${pro.id }"/>"
                                                       class="center">Xem/Sửa</a>
                                                </button>
                                                <button id="btnDelete" type ="button" onclick = "deleteProduct(${pro.id})"
                                                        class="center">Xóa
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${url}/js/jquery-1.10.2.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/js/jquery.metisMenu.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="${url}/js/dataTables/jquery.dataTables.js"></script>
<script src="${url}/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    $(document).ready(function() {
        $('#dataTables-example').dataTable();
    });
</script>
<!-- CUSTOM SCRIPTS -->
<script src="${url}/js/custom.js"></script>
</body>
</html>