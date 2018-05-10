<%@page import="java.net.URLDecoder" %>
<%@page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <!-- 文件上传开始 -->

    <!--自定义css开始-->
    <link href="/assets/css/selfContral.css" rel="stylesheet"/>
    <!--自定义css结束-->

    <!--提交作业开始  -->
    <script src="/assets/scripts/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/assets/js/AjaxGetCourse.js"></script>
    <!-- 文件上传开始 -->
    <link rel="stylesheet" href="/assets/css/file_style.css">
    <script src="/assets/scripts/file.js"></script>
    <!--提交作业结束  -->


</head>

<body>

<input type="hidden" value="${param.courseId}" id="courseId">
<input type="hidden" value="${param.task_no}" id="task_no">


<!--  wrapper -->
<div id="wrapper">
    <!--  引入head.jsp-->
    <jsp:include page="${pageContext.request.contextPath}/head.action"/>
    <!--  引入head.jsp-->
    <!--  page-wrapper -->
    <div id="page-wrapper">
        <div class="row">
            <!-- page header -->
            <div class="col-lg-12">
                <h1 class="page-header">作业提交</h1>
            </div>
            <!--end page header -->
        </div>
        <div class="row">
            <div class="col-lg-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        作业提交
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <form action="${pageContext.request.contextPath }/student/submitTask.action" method="post"
                                  id="submit" enctype="multipart/form-data">
                                <input type="hidden" value="${pageContext.request.contextPath }" id="ContextPath">

                                <div class="col-lg-6">
                                    <h1>请选择提交信息</h1>

                                    <div class="form-group">
                                        <label>课程</label>
                                        <select class="form-control" id="course" name="course">
                                            <!-- 此处显示课程 -->
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>作业类型</label>
                                        <select class="form-control" id="task" name="task.taskId">
                                            <!-- 此处显示作业 -->
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label>备注信息</label>

                                        <textarea class="form-control" rows="3" style="resize:none"
                                                  name="otherMessage"></textarea>
                                    </div>

                                </div>

                                <div class="col-lg-6">
                                    <h1>在这里上传文件</h1>
                                    <div class="form-group">

                                        <div class="file-uploader">
                                            <div class="file-uploader__message-area">
                                                <p>选择要上传的文件</p>
                                            </div>
                                            <div class="file-chooser">
                                                <input class="file-chooser__input" type="file" name="uploadFile"
                                                       id="uploadFile">
                                            </div>
                                            <button class="file-uploader__submit-button" type="button" id="file_choose">
                                                选择文件
                                            </button>
                                        </div>
                                    </div>
                                    <input type="submit" class="btn btn-primary  " value="提交作业">
                                    <button type="reset" class="btn btn-success">重新填写</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Form Elements -->
        </div>
    </div>
</div>
<!-- end page-wrapper -->

</div>
<!-- end wrapper -->

<!--FOOTER Start-->
<%@include file="footer.jsp"%>
<!--FOOTER end-->

<!-- Core Scripts - Include with every page -->
<script src="/assets/scripts/jquery-3.2.1.min.js"></script>
<script src="/assets/plugins/bootstrap/bootstrap.min.js"></script>
<script src="/assets/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="/assets/plugins/pace/pace.js"></script>
<script src="/assets/scripts/siminta.js"></script>
<script src="/assets/scripts/index.js"></script>


</body>

</html>
