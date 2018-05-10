<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>作业提交管理系统</title>
    <!-- Core CSS - Include with every page -->
    <link href="/assets/plugins/bootstrap/bootstrap.css" rel="stylesheet"/>
    <link href="/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="/assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet"/>
    <link href="/assets/css/style.css" rel="stylesheet"/>
    <link href="/assets/css/main-style.css" rel="stylesheet"/>
    <!--自定义css开始-->
    <link href="/assets/css/selfContral.css" rel="stylesheet"/>
    <!--自定义css结束-->
    <!--表单校验插件开始-->
    <script src="/assets/scripts/jquery-3.2.1.min.js"></script>
    <script src="/assets/scripts/jquery.validate.min.js"></script>
    <script src="/assets/scripts/jquery_cuntome_validate.js"></script>
    <script src="/assets/scripts/checkForm.js"></script>
    <script src="/assets/js/AJaxCheckLogin.js"></script>
    <!--表单校验插件结束-->
</head>

<body class="body-Login-back " style="border:0px solid red;margin:0">
<!--HEADER,START-->
<div class="header" style="margin-top:3%">
    <span class="head_font">作业提交管理系统</span>
</div>
<!--HEADER,end-->


<div class="container" style="border:0px solid blue">

    <div class="row" style="border:0px solid black">
        <div class="col-md-4 col-md-offset-4 text-center logo-margin ">
            <!-- <img src="assets/img/logo.png" alt=""/> -->
        </div>
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">请登录</h3>
                </div>
                <div class="panel-body">
                    <form name="login_form" id="stu_info_form" action="${pageContext.request.contextPath }/checkLogin.action"
                          method="POST">
                        <fieldset>
                            <div class="form-group">
                                学号:<label for="studentNo" generated="true" class="error"></label><label
                                    style="color:red">${loginStatue}</label>
                                <input class="form-control" type="text" name="studentNo" placeholder="输入10位学号"
                                       id="studentNo" value="${studentNo }">
                                <input type="hidden" value="${pageContext.request.contextPath}" id="ContextPath">
                            </div>
                            <div class="form-group">
                                密码:<label for="studentPassword" generated="true" class="error"></label>
                                <input class="form-control" type="password" name="studentPassword" placeholder="请输入密码"
                                       id="studentPassword">
                            </div>
                            <div class="form-group" style="width:100%; padding:0 ">
                                验证码:<label for="checkCode" generated="true" class="error"></label><label id="errMessage"
                                                                                                         style="color:red;"></label>
                                <br><input class="form-control" placeholder="验证码" name="checkCode" id="checkCode"
                                           type="text" style="width:46%;display:inline-block">
                                <img class="check_img form-control" height="100%" width="100%"
                                     src="${pageContext.request.contextPath }/common/createIdentifyCode.action"
                                     id="checkImg" style="cursor:pointer">
                            </div>

                            <div class="checkbox">
                                <label style="display:inline-block">
                                    <input name="aotoLogin" type="checkbox" name="autoLogin" value="autoLogin">自动登录
                                </label>
                                <div style="display:inline-block; margin-left:15%">&spades;没有账号,<a href="${pageContext.request.contextPath}/register.action">注册</a>一个
                                </div>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <input class="form-control  btn-lg btn-success " type="submit" value="登录"
                                   style="padding:0;">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Core Scripts - Include with every page -->
<script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
<script src="assets/plugins/metisMenu/jquery.metisMenu.js"></script>
<!--FOOTER Start-->
<%@include file="footer.jsp"%>
<!--FOOTER end-->

</body>

</html>
