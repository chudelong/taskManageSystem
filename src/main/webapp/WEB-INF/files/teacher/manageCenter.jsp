<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>作业提交管理系统</title>
    <!-- Core CSS - Include with every page -->
    <link href="/assets/plugins/bootstrap/bootstrap.css" rel="stylesheet"/>
    <link href="/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet"/>
    <link href="/assets/css/style.css" rel="stylesheet"/>
    <link href="/assets/css/main-style1.css" rel="stylesheet"/>
    <script src="/assets/scripts/jquery-3.2.1.min.js"></script>
    <script>
        $(function () {
            $("*").hover(function () {
                $(this).css("text-decoration", "none");
            });
        });
    </script>
    <style>
        div.panel-body:hover {
            text-decoration: none;
        }
    </style>
    <!-- Page-Level CSS -->
    <link href="/assets/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet"/>
    <!--自定义css开始-->
    <link href="/assets/css/selfContral1.css" rel="stylesheet"/>
    <!--自定义css结束-->
</head>

<body>
<!--  wrapper -->
<div id="wrapper">
    <jsp:include page="/teacher/head.do"/>
    <!--  page-wrapper -->
    <div id="page-wrapper">


        <div class="row">
            <!--  page header -->
            <div class="col-lg-12">
                <h1 class="page-header">课程中心</h1>
            </div>
            <!-- end  page header -->
        </div>


        <div class="row">
            <c:if test="${!empty courseAndCountList}">
                <c:forEach items="${courseAndCountList}" var="course" varStatus="status">
                    <div class="col-lg-4">
                            <%--循环各种颜色--%>
                        <div class="panel panel-primary text-center no-boder">
                            <c:if test="${(status.index+4)%4==0}">
                                <div class="panel-body blue">
                                    <i class="fa fa-pencil-square-o fa-3x"></i>
                                    <h3>${course.count}</h3>
                                </div>
                            </c:if>
                            <c:if test="${(status.index+4)%4==1}">
                                <div class="panel-body red">
                                    <i class="fa fa-pencil-square-o fa-3x"></i>
                                    <h3>${course.count}</h3>
                                </div>
                            </c:if>
                            <c:if test="${(status.index+4)%4==2}">
                                <div class="panel-body yellow">
                                    <i class="fa fa-pencil-square-o fa-3x"></i>
                                    <h3>${course.count}</h3>
                                </div>
                            </c:if>
                            <c:if test="${(status.index+4)%4==3}">
                                <div class="panel-body green">
                                    <i class="fa fa-pencil-square-o fa-3x"></i>
                                    <h3>${course.count}</h3>
                                </div>
                            </c:if>
                            <div class="panel-footer">
                                <span class="panel-eyecandy-title">${course.course.courseName} </span>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>


        <div class="row">
            <div class="col-lg-12">
                <!-- Advanced 课程中心 -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        所有作业
                        <div class="pull-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default btn-xs dropdown-toggle"
                                        data-toggle="dropdown">
                                    查看
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu pull-right" role="menu">
                                    <li><a href="#">数据结构<a>
                                    </li>
                                    <li><a href="#">Java程序设计<a>
                                    </li>
                                </ul>

                            </div>
                        </div>
                    </div>

                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered " id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>课程名称</th>
                                    <th>作业类型</th>
                                    <th>学生姓名</th>
                                    <th>作业名称</th>
                                    <th>提交时间</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${submitListInfo}" var="info">
                                    <tr class="odd gradeX">
                                        <td>${info.courseName}</td>
                                        <td>${info.typeName}</td>
                                        <td>${info.studentName}</td>
                                        <td class="center">${info.taskName}</td>
                                        <td class="center"><fmt:formatDate value="${info.workTime}" pattern="yyyy-MM-dd"/> </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
                <!--End Advanced 课程中心 -->
            </div>
        </div>

        <div class="row">
            <div class="col-lg-6">
                <!--    Context Classes  -->
                <div class="panel panel-default">

                    <div class="panel-heading">
                        专业进度
                        <div class="pull-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default btn-xs dropdown-toggle"
                                        data-toggle="dropdown">
                                    查看
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu pull-right" role="menu">
                                    <li><a href="#">数据结构<a>
                                    </li>
                                    <li><a href="#">Java程序设计<a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>


                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>姓名</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="success">
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr class="info">
                                    <td>2</td>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr class="warning">
                                    <td>3</td>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!--  end  Context Classes  -->
            </div>

            <div class="col-lg-6">
                <!--    Hover Rows  -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        班级进度
                        <div class="pull-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default btn-xs dropdown-toggle"
                                        data-toggle="dropdown">
                                    查看
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu pull-right" role="menu">
                                    <li><a href="#">数据结构<a>
                                    </li>
                                    <li><a href="#">Java程序设计<a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- End  Hover Rows  -->
            </div>
        </div>
    </div>
    <!-- end page-wrapper -->

</div>
<!-- end wrapper -->

<!--FOOTER Start-->
<%@include file="../footer.jsp" %>
<!--FOOTER end-->

<!-- Core Scripts - Include with every page -->
<script src="/assets/plugins/jquery-1.10.2.js"></script>
<script src="/assets/plugins/bootstrap/bootstrap.min.js"></script>
<script src="/assets/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="/assets/plugins/pace/pace.js"></script>
<script src="/assets/scripts/siminta.js"></script>
<!-- Page-Level Plugin Scripts-->
<script src="/assets/plugins/dataTables/jquery.dataTables.js"></script>
<script src="/assets/plugins/dataTables/dataTables.bootstrap.js"></script>
<script>
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
    });
</script>

</body>

</html>
