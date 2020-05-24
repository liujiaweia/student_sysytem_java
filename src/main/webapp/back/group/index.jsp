<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>小组管理</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/back/statics/js/jquery-1.8.3.min.js"></script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <h1 class="text-center">小组管理</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <table class="table table-bordered table-hover table-striped">
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>标语</th>
                    <th>所属班级</th>
                    <th>标签信息</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${requestScope.groups}" var="group">
                    <tr>
                        <td>${group.id}</td>
                        <td>${group.name}</td>
                        <td>${group.content}</td>
                        <td>${group.clazz.name}</td>
                        <td>
                            <c:forEach items="${group.tags}" var="tag">
                                ${tag} 、
                            </c:forEach>
                        </td>
                        <td>
                            <a href="" class="btn btn-info">修改</a>
                            <a href="" class="btn btn-danger">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <%--添加表单--%>
    <div class="row">
        <div class="col-sm-12">
            <form id="inputForm" class="form-inline" action="${pageContext.request.contextPath}/group/save" method="post">
                <div class="form-group">
                    <label for="name">名称:</label>
                    <input type="text" name="name" class="form-control" id="name" placeholder="请输入小组名称">
                </div>
                <div class="form-group">
                    <label for="content">标语:</label>
                    <input type="text" name="content" class="form-control" id="content" placeholder="请输入标语">
                </div>
                <div class="form-group">
                    <label for="clazzs">选择班级:</label>
                    <select name="clazzid" class="form-control" id="clazzs">

                    </select>
                </div>
                <button type="submit" class="btn btn-success">添加</button>
            </form>

        </div>
    </div>
</div>


</body>

<script>
    $(function(){

        //发送异步请求查询所有的班级信息
        $.get("${pageContext.request.contextPath}/clazz/findAllClazzJSON",function(res){
            //console.log(res);
            $.each(res,function(index,clazz){
                let option = $("<option/>").text(clazz.name).val(clazz.id);
                $("#clazzs").append(option);
            });
        });

        //简单的表单验证
        $("#inputForm").submit(function(){

            if (!$("#name").val()) {
                alert('请输入小组名称!!');
                return false;
            }

            if(!$("#content").val()){
                alert('请输入标语!!!');
                return false;
            }

            return true;
        });

    })
</script>