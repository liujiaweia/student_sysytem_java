<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户登录</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/back/statics/js/jquery-1.8.3.min.js"></script>

</head>
<body>


<div class="container-fluid">


    <%--用户注册--%>
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <h1 class="text-center">用户登录</h1>
        </div>
    </div>

    <%--完成表单--%>
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">

            <form id="inputForm">
                <div class="form-group">
                    <label for="name">用户名:</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="请输入用户名...">
                </div>
                <div class="form-group">
                    <label for="password">密码:</label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码...">
                </div>
                <div class="form-group">
                    <label for="code">验证码:</label>
                    <div>
                        <input type="text" name="code" class="form-control" style="height:48px;width: 52%;float: left;"
                               id="code" placeholder="请输入验证码....">
                        <img src="${pageContext.request.contextPath}/user/getImage" id="image"
                             style="height:48px;float: right;" alt="">
                    </div>
                </div>
                <div class="clearfix"></div>
                <button type="button" class="btn btn-danger" id="logBtn"
                        style="margin-top:20px;width: 43%;margin-left: 13px;">登录
                </button>
                <a class="btn btn-info" href="${pageContext.request.contextPath}/back/register.jsp" style="margin-top:20px;width: 43%;margin-left: 30px;">注册账号</a>
            </form>

        </div>
    </div>

</div>

</body>
</html>

<script>
    $(function () {

        //绑定登录按钮的单击事件
        $("#logBtn").click(function () {
            $.post("${pageContext.request.contextPath}/user/login", $("#inputForm").serialize(), function (res) {
                if(res.status){
                    alert(res.msg+",点击确定进入主页");
                    location.href='${pageContext.request.contextPath}/back/index.jsp';
                }else{
                    alert(res.msg);
                }
            })
        });
        //更换验证码
        $("#image").click(function () {
            $(this).attr("src", "${pageContext.request.contextPath}/user/getImage?id=" + Math.random());
        })


    })
</script>