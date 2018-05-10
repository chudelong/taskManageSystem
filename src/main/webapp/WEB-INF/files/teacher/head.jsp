<%--
  Created by IntelliJ IDEA.
  User: tangy
  Date: 2018/4/21
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- navbar top -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation" id="navbar">
    <!-- navbar-header -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.jsp">
            <!-- <img  style="width:25% ;height:250%;"src="assets/img/logo.png" alt="" /> -->
            <span class="head_font" style="font-family: “Arial”,”Microsoft YaHei”,”黑体”,”宋体”,sans-serif;">作业管理<font
                    style="color:rgb(237, 253, 46);">教师端</font></span>
        </a>
    </div>
    <!-- end navbar-header -->
    <!-- navbar-top-links -->
    <ul class="nav navbar-top-links navbar-right">
        <!-- main dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <span class="top-label label label-danger">3</span><i class="fa fa-envelope fa-3x"></i>
            </a>
            <!-- dropdown-messages -->
            <ul class="dropdown-menu dropdown-messages">
                <li>
                    <a href="#">
                        <div>
                            <strong><span class=" label label-danger">教师名字</span></strong>
                            <span class="pull-right text-muted">
                                        <em>昨天</em>
                                    </span>
                        </div>
                        <div>数据结构老师发布了新的通知</div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <strong><span class=" label label-info">${teacher.teacherName}</span></strong>
                            <span class="pull-right text-muted">
                                        <em>昨天</em>
                                    </span>
                        </div>
                        <div>完成了作业...</div>
                    </a>
                </li>

                <li class="divider"></li>
                <li>
                    <a class="text-center" href="#">
                        <strong>读取所有消息</strong>
                        <i class="fa fa-angle-right"></i>
                    </a>
                </li>
            </ul>
            <!-- end dropdown-messages -->
        </li>

        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <span class="top-label label label-success">4</span> <i class="fa fa-tasks fa-3x"></i>
            </a>
            <!-- dropdown tasks -->
            <ul class="dropdown-menu dropdown-tasks">
                <li>
                    <a href="#">
                        <div>
                            <p>
                                <strong>任务 1</strong>
                                <span class="pull-right text-muted">完成40% Complete</span>
                            </p>
                            <div class="progress progress-striped active">
                                <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40"
                                     aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                    <span class="sr-only">完成40%</span>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>

                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <p>
                                <strong>任务 4</strong>
                                <span class="pull-right text-muted">完成80% </span>
                            </p>
                            <div class="progress progress-striped active">
                                <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80"
                                     aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                    <span class="sr-only">80%完成</span>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a class="text-center" href="#">
                        <strong>查看所有任务</strong>
                        <i class="fa fa-angle-right"></i>
                    </a>
                </li>
            </ul>
            <!-- end dropdown-tasks -->
        </li>

        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <span class="top-label label label-warning">5</span> <i class="fa fa-bell fa-3x"></i>
            </a>
            <!-- dropdown alerts-->
            <ul class="dropdown-menu dropdown-alerts">
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-comment fa-fw"></i>新通知
                            <span class="pull-right text-muted small">4 分钟之前</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-twitter fa-fw"></i>3 同学
                            <span class="pull-right text-muted small">12 分钟之前</span>
                        </div>
                    </a>
                </li>

                <li class="divider"></li>
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-upload fa-fw"></i>设备重启
                            <span class="pull-right text-muted small">4 分钟之前</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a class="text-center" href="#">
                        <strong>查看所有</strong>
                        <i class="fa fa-angle-right"></i>
                    </a>
                </li>
            </ul>
            <!-- end dropdown-alerts -->
        </li>

        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-3x"></i>
            </a>
            <!-- dropdown user-->
            <ul class="dropdown-menu dropdown-user">
                <li><a href="#"><i class="fa fa-user fa-fw"></i>用户中心</a>
                </li>
                <li><a href="#"><i class="fa fa-gear fa-fw"></i>设置</a>
                </li>
                <li class="divider"></li>
                <li><a href="/teacher/logOut.action"><i class="fa fa-sign-out fa-fw"></i>退出登录</a>
                </li>
            </ul>
            <!-- end dropdown-user -->
        </li>
        <!-- end main dropdown -->
    </ul>
    <!-- end navbar-top-links -->

</nav>
<!-- end navbar top -->

<!-- navbar side -->
<nav class="navbar-default navbar-static-side" role="navigation">
    <!-- sidebar-collapse -->
    <div class="sidebar-collapse">
        <!-- side-menu -->
        <ul class="nav" id="side-menu">
            <li>
                <!-- user image section-->
                <div class="user-section">
                    <div class="user-section-inner">
                        <img src="${teacher.teacherImg}" alt="">
                    </div>
                    <div class="user-info">
                        <div><strong>${teacher.teacherName}</strong></div>
                        <div class="user-text-online">
                            <span class="user-circle-online btn btn-success btn-circle ">
                                <c:if test="${! empty teacher}">
                            </span>&nbsp;在线
                            </c:if>
                            <c:if test="${ empty teacher}">
                                </span>&nbsp;离线
                            </c:if>
                        </div>
                    </div>
                </div>
                <!--end user image section-->
            </li>
            <li class="sidebar-search">
                <!-- search section-->
                <div class="input-group custom-search-form">
                    <input type="text" class="form-control" placeholder="查找...">
                    <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                </div>
                <!--end search section-->
            </li>
            <li class="selected">
                <a href="/teacher/index.action"><i class="fa fa-dashboard fa-fw"></i>控制中心</a>
            </li>

            <li>
                <a href="/teacher/manageCenter.action"><i class="fa fa-table fa-fw"></i>管理中心</a>
            </li>
            <li>
                <a href="/teacher/assignTask.do"><i class="fa fa-edit fa-fw"></i>发布作业</a>
            </li>

            <%--<li>
                <a href="#"><i class="fa fa-files-o fa-fw"></i>测试页面<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="blank.html">空白页</a>
                    </li>
                    <li>
                        <a href="login.jsp">登录页面</a>
                    </li>
                </ul>
                <!-- second-level-items -->
            </li>--%>
        </ul>
        <!-- end side-menu -->
    </div>
    <!-- end sidebar-collapse -->
</nav>