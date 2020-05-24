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
    <title>学生管理</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/back/statics/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="container-fluid">


    <%--标题--%>
    <div class="row">
        <div class="col-sm-12">
            <h1 class="text-center">学生信息录入</h1>
        </div>
    </div>

    <%--创建表单--%>
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/student/save" method="post">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-10">
                        <input type="text" name="name" class="form-control" id="name" placeholder="请输入学生姓名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="bir" class="col-sm-2 control-label">生日</label>
                    <div class="col-sm-10">
                        <input type="text" name="bir" class="form-control" id="bir" placeholder="请输入生日">
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label">电话</label>
                    <div class="col-sm-10">
                        <input type="text" name="phone" class="form-control" id="phone" placeholder="请输入手机号码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="qq" class="col-sm-2 control-label">QQ</label>
                    <div class="col-sm-10">
                        <input type="text" name="qq" class="form-control" id="qq" placeholder="请输入QQ号码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="mark" class="col-sm-2 control-label">备注</label>
                    <div class="col-sm-10">
                        <input type="text" name="mark" class="form-control" id="mark" placeholder="请输入学生备注信息">
                    </div>
                </div>


                <div class="form-group">
                    <label for="city" class="col-sm-2 control-label">就业城市</label>
                    <div class="col-sm-10">
                        <select name="cityid" id="city" class="form-control">

                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="clazz" class="col-sm-2 control-label">班级信息</label>
                    <div class="col-sm-10">
                        <select name="clazzid" id="clazz" class="form-control">

                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="group" class="col-sm-2 control-label">小组信息</label>
                    <div class="col-sm-10">
                        <select name="groupid" id="group" class="form-control">

                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">选择标签信息:</label>
                    <div class="col-sm-10">
                        <div class="checkbox" id="cks">

                        </div>
                    </div>
                </div>
                <div class="form-group" style="margin-top: 20px;">
                    <div class="col-sm-12 col-sm-offset-1">
                        <button type="submit" style="width: 45%" class="btn btn-info">提交</button>
                        <a href="${pageContext.request.contextPath}/student/findAll" style="width: 45%"
                           class="btn btn-danger">返回列表</a>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>


</body>

<script>
    $(function () {
        //1.发送ajax请求查询所有城市信息
        $.get("${pageContext.request.contextPath}/city/findAllJSON",function(res){
            console.log(res);
            //遍历城市信息
            $.each(res,function(index,city){
               let option = $("<option/>").text(city.name).val(city.id);
               $("#city").append(option);
            });
        });

        //2.发送ajax请求查询所有班级信息
        $.get("${pageContext.request.contextPath}/clazz/findAllClazzJSON",function(clazzs){
            $.each(clazzs,function(index,clazz){
                let option = $("<option/>").text(clazz.name).val(clazz.id);
                $("#clazz").append(option);
            });

            //触发一次班级change事件
            $("#clazz").change();
        });

        //3.监听班级的下拉列表中onchange事件根据选择班级获取对应的小组信息
        $("#clazz").change(function(){
            //清空上一次小组信息
            $("#group").empty();
            $.get("${pageContext.request.contextPath}/group/findByClazzId",{id:$(this).val()},function(res){
                $.each(res,function(index,group){
                   let option  = $("<option/>").text(group.name).val(group.id);
                   $("#group").append(option);
                });
            });
        });

        //4.发送ajax请求查询标签信息(学生类型的标签)
        $.get("${pageContext.request.contextPath}/tag/findByType",{type:"学生"},function(tags){
            console.log(tags);
            $.each(tags,function(index,tag){
               let label = $("<label/>");
               let cks = $("<input/>").attr({type:"checkbox",name:"tagIds"}).val(tag.id);
               label.append(cks).append(tag.name +"&nbsp;&nbsp;");
               $("#cks").append(label);
           });
        });

    })
</script>