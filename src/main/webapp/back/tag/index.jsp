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
    <title>标签管理</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/back/statics/js/jquery-1.8.3.min.js"></script>

</head>
<body>

<%--标签管理--%>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <h1 class="text-center">标签管理</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>标签类型</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${requestScope.tags}" var="tag">
                    <tr>
                        <td>${tag.id}</td>
                        <td>${tag.name}</td>
                        <td>${tag.type}</td>
                        <td><fmt:formatDate value="${tag.createtime}"/></td>
                        <td>
                            <a href="" class="btn btn-info">修改</a>
                            <a href="" class="btn btn-danger">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>


    <div class="row">
        <div class="col-sm-12">
            <form action="${pageContext.request.contextPath}/tag/save" method="post" id="inputForm" class="form-inline">
                <div class="form-group">
                    <label for="name">标签名称:</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="输入标签名称...">
                </div>
                <div class="form-group">
                    <label for="type">标签类型:</label>
                    <select name="type" id="type" style="width: 200px;" class="form-control">
                        <option value="班级">班级标签</option>
                        <option value="学生">学生标签</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-success">添加标签</button>
            </form>
        </div>
    </div>

</div>

</body>

<script>
    $(function(){

        $("#inputForm").submit(function(){
            if(!$("#name").val()){alert('请输入标签名称');return false;}
            return true;
        });

    });
</script>