<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>作业提交管理系统</title>
    <!-- Core CSS - Include with every page -->
    <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet"/>
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet"/>
    <link href="assets/css/style.css" rel="stylesheet"/>
    <link href="assets/css/main-style.css" rel="stylesheet"/>
    <!--自定义css开始-->
    <link href="assets/css/selfContral.css" rel="stylesheet"/>
    <!--自定义css结束-->
    <!--表单校验插件开始-->
    <script src="assets/scripts/jquery-3.2.1.min.js"></script>
    <script src="assets/scripts/jquery.validate.min.js"></script>
    <script src="assets/scripts/jquery_cuntome_validate.js"></script>
    <script src="assets/scripts/checkForm.js"></script>
    <!--表单校验插件结束-->

    <!-- Ajax异步校验用户名是否存在开始 -->
    <script type="text/javascript" src="assets/js/AjaxGetDateForForm.js"></script>
    <!-- Ajax异步校验用户名是否存在结束-->
    <!--Ajax加载专业班级开始-->
    <script type="text/javascript" src="assets/js/AjaxGetRegisterInfo.js"></script>
    <!--Ajax加载专业班级结束-->
</head>
<body class="body-Login-back">
<!--HEADER,START-->
<div class="header">
    <span class="head_font">作业提交管理系统</span>
</div>
<!--HEADER,end-->

<div class="container">

    <div class="row">
        <div class="col-md-4 col-md-offset-4 text-center logo-margin ">
        </div>
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title" style="display:inline-block">注册</h3>
                    <!--  服务端返回的错误信息开始-->
                    <span name="Message" style="color:red;font-weight:700" id="message">${errMessage }</span>
                    <!--  服务端返回的错误信息结束-->
                </div>
                <div class="panel-body">
                    <form action="${pageContext.request.contextPath }/registerUser.action" id="stu_info_form"
                          name="reg_form" method="POST">
                        <fieldset>
                            <div class="form-group">
                                <label for="studentName" generated="true" class="error"></label>
                                <input class="form-control" placeholder="姓名" name="studentName" type="text"
                                       id="studentName">
                            </div>
                            <div class="form-group">
                                <label for="studentNo" generated="true" class="error"></label>
                                <input class="form-control" placeholder="学号" name="studentNo" type="text"
                                       id="studentNo">
                                <input type="hidden" value="${pageContext.request.contextPath}" id="contextPath">
                            </div>
                            <div class="form-group">
                                <label for="studentPassword" generated="true" class="error"></label>
                                <input class="form-control" placeholder="密码" name="studentPassword" id="studentPassword"
                                       type="password">
                            </div>
                            <div class="form-group">
                                <label for="repassword" generated="true" class="error"></label>
                                <input class="form-control" placeholder="确认密码" name="repassword" id="repassword"
                                       type="password">
                            </div>
                            <div class="form-group">
                                <label for="studentEmail" generated="true" class="error"></label>
                                <input class="form-control" placeholder="邮箱" name="studentEmail" type="email"
                                       id="studentEmail">
                            </div>

                            <div class="form-group">
                                <select class="form-control" name="college" id="college">
                                    <!-- 此处显示学院 -->
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="prono" generated="true" class="error"></label>
                                <select class="form-control" name="prono" id="prono">
                                    <!-- 此处显示专业 -->
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="classno" generated="true" class="error"></label>
                                <select class="form-control" name="sclass.classId" id="classno">
                                    <!--此处显示班级  -->
                                </select>
                            </div>
                            <input class="form-control  btn-lg btn-success " type="submit" value="注册"
                                   style="width:53%;display:inline-block; padding:7px;">
                            <input class="form-control  btn-lg btn-success" type="reset" value="重置"
                                   style="width:44%;display:inline-block;background-color:#ff8309;padding:7px;">
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
<%@include file="footer.jsp" %>
<!--FOOTER end-->

</body>

</html>
