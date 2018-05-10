<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>作业提交管理系统</title>
    <!-- Core CSS - Include with every page -->
    <link href="/assets/plugins/bootstrap/bootstrap.css" rel="stylesheet"/>
    <link href="/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="/assets/plugins/pace/pace-theme-big-counter.css"
          rel="stylesheet"/>
    <link href="/assets/css/style.css" rel="stylesheet"/>
    <link href="/assets/css/main-style.css" rel="stylesheet"/>
    <script src="/assets/scripts/jquery-3.2.1.min.js"></script>
    <script src="/assets/js/AjaxGetCourseByCno.js"></script>
    <script>
        $(function () {
            $("*").hover(function () {
                $(this).css("text-decoration", "none");
            });
        });

    </script>
    <style>

    </style>
    <!-- Page-Level CSS -->
    <link href="/assets/plugins/dataTables/dataTables.bootstrap.css"
          rel="stylesheet"/>
    <!--自定义css开始-->
    <link href="/assets/css/selfContral.css" rel="stylesheet"/>
    <!--自定义css结束-->
</head>

<body>
<!-- 隐藏传递url -->
<input id="PageContext" type="hidden" value="${pageContext.request.contextPath}"/>

<!--  wrapper -->
<div id="wrapper">
    <!--  引入head.jsp-->
    <jsp:include page="${pageContext.request.contextPath}/head.action"></jsp:include>
    <!--  引入head.jsp-->
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
            <c:if test="${!empty AllCourse}">
                <c:forEach items="${AllCourse}" var="course" varStatus="status" end="${fn:length(AllCourse)}">
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
                                <button type="button"
                                        class="btn btn-default btn-xs dropdown-toggle"
                                        data-toggle="dropdown">
                                    查看 <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu pull-right" role="menu" id="courseList">
                                    <c:forEach items="${AllCourse }" var="course">
                                        <li value="${course.course.courseId }" ><a href="javascript:void(0);">${course.course.courseName } </a></li>
                                    </c:forEach>
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
                                    <th>是否提交</th>
                                    <th>作业名称</th>
                                    <th>提交时间</th>
                                </tr>
                                </thead>
                                <tbody id="table_content">
                                <c:forEach items="${allTaskInfos }" var="taskInfo">
                                    <tr class="odd gradeX">
                                        <td>${taskInfo.course.courseName }</td>
                                        <td>${taskInfo.type.typeName }</td>

                                        <c:if test="${!empty taskInfo.workList}">
                                            <td>是<span class="submit_is">已提交</span></td>
                                        </c:if>
                                        <c:if test="${empty taskInfo.workList}">
                                            <td>
                                                否<a href="${pageContext.request.contextPath }/student/submitTask.do?courseId=${taskInfo.course.courseId}&task_no=${taskInfo.taskId}"
                                                    class="submit_no">提交</a></td>
                                        </c:if>
                                        <td class="center">${taskInfo.taskName}</td>
                                        <td><fmt:formatDate value="${taskInfo.workList[0].workTime}"
                                                            pattern="yyyy/MM/dd  HH:mm:ss"/></td>
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

    </div>
    <!-- end page-wrapper -->

</div>
<!-- end wrapper -->

<!--FOOTER Start-->
<%@include file="footer.jsp"%>
<!--FOOTER end-->

<!-- Core Scripts - Include with every page -->
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

