<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>教师端管理系统</title>
    <!-- Core CSS - Include with every page -->
    <link href="/assets/plugins/bootstrap/bootstrap.css" rel="stylesheet"/>
    <link href="/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="/assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet"/>
    <link href="/assets/css/style.css" rel="stylesheet"/>
    <link href="/assets/css/main-style1.css" rel="stylesheet"/>
    <!-- Page-Level CSS -->
    <link href="/assets/plugins/morris/morris-0.4.3.min.css" rel="stylesheet"/>
    <!--自定义css开始/-->
    <link href="/assets/css/selfContral1.css" rel="stylesheet"/>
    <!--自定义css结束-->
</head>
<body>
<!--  wrapper -->
<div id="wrapper">
    <!-- navbar top -->
    <jsp:include page="/teacher/head.do"/>
    <!-- end navbar side -->
    <div id="page-wrapper">
        <!--  page-wrapper -->

        <div class="row">
            <!-- Page Header -->
            <div class="col-lg-12">
                <h1 class="page-header">控制中心</h1>
            </div>
            <!--End Page Header -->
        </div>

        <div class="row">
            <!-- Welcome -->
            <div class="col-lg-12">
                <div class="alert alert-info">
                    <i class="fa fa-folder-open"></i><b>&nbsp;你好 ! </b>欢迎回来 <b>${teacherName} </b>
                    <i class="fa  fa-pencil"></i><b>&nbsp;</b>
                </div>
            </div>
            <!--end  Welcome -->
        </div>


        <div class="row">
            <div class="col-lg-12">


                <!--Simple table example -->
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <i class="fa fa-bar-chart-o fa-fw"></i>个人资料
                        <div class="pull-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default btn-xs dropdown-toggle"
                                        data-toggle="dropdown">
                                    修改
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu pull-right" role="menu">
                                    <li><a href="#">修改个人资料<a>
                                    </li>

                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover table-striped" style="font-size:2em">
                                        <thead>
                                        <tr>

                                            <th colspan="4" style="text-align:center; color:#1786ec;font-size:1.5em">
                                                ${teacherInfo.teacherName}
                                            </th>

                                        </tr>
                                        <tr>

                                            <th>学校</th>
                                            <th>专业</th>
                                            <th>学院</th>
                                            <th>性别</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <th>${teacherInfo.profession.college.school.schoolName}</th>
                                            <th>${teacherInfo.profession.professionName}</th>
                                            <th>${teacherInfo.profession.college.collegeName}</th>
                                            <th>${teacherInfo.teacherSex==20?"男":"女"}</th>
                                        </tr>


                                        </tbody>
                                    </table>
                                </div>

                            </div>

                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!--End simple table example -->


                <!--Area chart example -->
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <i class="fa fa-bell fa-fw"></i>通知面板
                    </div>

                    <div class="panel-body">
                        <div class="list-group">

                            <a href="#" class="list-group-item">
                                <i class="fa fa-envelope fa-fw"></i>tom提交了作业
                                <span class="pull-right text-muted small"><em>27 分钟之前</em>
                                    </span>
                            </a>
                            <a href="#" class="list-group-item">
                                <i class="fa fa-tasks fa-fw"></i>新作业
                                <span class="pull-right text-muted small"><em>43 分钟之前</em>
                                    </span>
                            </a>
                            <a href="#" class="list-group-item">
                                <i class="fa fa-upload fa-fw"></i>登录
                                <span class="pull-right text-muted small"><em>11:32 AM</em>
                                    </span>
                            </a>


                        </div>
                        <!-- /.list-group -->
                        <a href="#" class="btn btn-default btn-block">View All Alerts</a>
                    </div>

                </div>
                <!--End area chart example -->
            </div>

           <%-- <div class="col-lg-4">
                <div class="panel panel-primary text-center no-boder">
                    <div class="panel-body yellow">
                        <i class="fa fa-bar-chart-o fa-3x"></i>
                        <h3>2 </h3>
                    </div>
                    <div class="panel-footer">
                            <span class="panel-eyecandy-title">待提交作业数
                            </span>
                    </div>
                </div>
                <div class="panel panel-primary text-center no-boder">
                    <div class="panel-body blue">
                        <i class="fa fa-pencil-square-o fa-3x"></i>
                        <h3>8 </h3>
                    </div>
                    <div class="panel-footer">
                            <span class="panel-eyecandy-title">已提交作业数
                            </span>
                    </div>
                </div>
                <div class="panel panel-primary text-center no-boder">
                    <div class="panel-body green">
                        <i class="fa fa fa-floppy-o fa-3x"></i>
                        <h3>90</h3>
                    </div>
                    <div class="panel-footer">
                            <span class="panel-eyecandy-title">进度
                            </span>
                    </div>
                </div>
                <div class="panel panel-primary text-center no-boder">
                    <div class="panel-body red">
                        <i class="fa fa-thumbs-up fa-3x"></i>
                        <h3>2,700 </h3>
                    </div>
                    <div class="panel-footer">
                            <span class="panel-eyecandy-title">你获得的赞
                            </span>
                    </div>
                </div>

            </div>--%>

        </div>


    </div>
    <!-- end page-wrapper -->

</div>
<!-- end wrapper -->

<!--FOOTER Start-->
<%@include file="../footer.jsp"%>
<!--FOOTER end-->

<!-- Core Scripts - Include with every page -->
<script src="/assets/plugins/jquery-1.10.2.js"></script>
<script src="/assets/plugins/bootstrap/bootstrap.min.js"></script>
<script src="/assets/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="/assets/plugins/pace/pace.js"></script>
<script src="/assets/scripts/siminta.js"></script>
<!-- Page-Level Plugin Scripts-->
<script src="/assets/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="/assets/plugins/morris/morris.js"></script>
<script src="/assets/scripts/dashboard-demo.js"></script>

</body>

</html>
