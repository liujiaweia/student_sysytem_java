<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/back/statics/js/jquery-1.8.3.min.js"></script>
</head>
<body>


<div class="container-fluid">

    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <h1 class="text-center">城市管理</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <table class="table table-striped table-bordered table-hover" >
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>录入时间</th>
                    <th>当前城市就业人数</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${requestScope.citys}" var="city">
                    <tr>
                        <td>${city.id}</td>
                        <td>${city.name}</td>
                        <td><fmt:formatDate value="${city.createtime}" pattern="yyyy年MM月dd日" /></td>
                        <td>${city.numbers}</td>
                        <td>
                            <a href="" class="btn btn-info btn-sm">修改</a>
                            <a href="" class="btn btn-danger btn-sm">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>

    <%--添加城市--%>
    <div class="row">
        <div class="col-sm-12">
            <form class="form-inline" id="inputForm" action="${pageContext.request.contextPath}/city/save" method="post">
                <div class="form-group">
                    <label for="name">城市名称:</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="输入城市名称">
                </div>
                <button type="submit" class="btn btn-success">添加城市信息</button>
            </form>
        </div>
    </div>

</div>
</body>
<script>
    $(function(){

        //提交事件
        $("#inputForm").submit(function () {
            if (!$("#name").val()) {
                alert('城市名称不能为空!!!');
                return false;
            }
        });
    })

</script>