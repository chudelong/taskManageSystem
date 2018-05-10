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
    <link href="/assets/css/main-style1.css" rel="stylesheet"/>
    <%--加载课程--%>
    <script src="/assets/scripts/jquery-3.2.1.min.js"></script>
    <script src="/assets/js/AjaxGetTeacherCourse.js"></script>
    <!--时间插件-->
    <script src="/assets/laydate/laydate.js"></script>
    <script>
        lay('#version').html('-v' + laydate.v);

        //执行一个laydate实例
        laydate.render({
            elem: '#deadLine' //指定元素
        });
    </script>

    <!--自定义css开始-->
    <link href="/assets/css/selfContral1.css" rel="stylesheet"/>
    <!--自定义css结束-->
</head>

<body>
<!--  wrapper -->
<div id="wrapper">
    <!-- navbar top -->
    <jsp:include page="/teacher/head.do"/>
    <!-- end navbar side -->
    <!--  page-wrapper -->
    <div id="page-wrapper">
        <div class="row">
            <!-- page header -->
            <div class="col-lg-12">
                <h1 class="page-header">发布作业</h1>
            </div>
            <!--end page header -->
        </div>
        <div class="row">
            <div class="col-lg-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        作业发布
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <form action="${pageContext.request.contextPath}/teacher/assignTask.action" method="post"
                                  id="submit">
                                <input type="hidden" value="${pageContext.request.contextPath}" id="PageContext">
                                <div class="col-lg-12">
                                    <h1>请选择发布信息</h1>

                                    <div class="form-group">
                                        <label>课程</label>
                                        <select class="form-control" id="course" name="course.courseId">
                                            <%--此处显示课程--%>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>作业类型</label>
                                        <select class="form-control" id="taskType" name="type.typeId">
                                            <%--此处显示作业类型--%>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label>截至时间</label>
                                        <input type="text" name="deadLine" id="deadLine">
                                    </div>
                                    <div class="form-group">
                                        <label>作业名称</label>
                                        <input type="text" name="taskName" id="taskName">
                                    </div>

                                    <div class="form-group">
                                        <label>备注信息</label>
                                        <textarea class="form-control" rows="3" name="taskDesc"></textarea>
                                    </div>

                                </div>
                                <div class="col-lg-6">
                                    <input type="submit" class="btn btn-primary  " value="提交作业"></button>

                                    <button type="reset" class="btn btn-success">重新填写</button>
                                </div>
                            </form>
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
    <%@include file="../footer.jsp" %>
    <!--FOOTER end-->

    <!-- Core Scripts - Include with every page -->
    <script src="/assets/plugins/bootstrap/bootstrap.min.js"></script>
    <script src="/assets/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="/assets/plugins/pace/pace.js"></script>
    <script src="/assets/scripts/siminta.js"></script>
    <script src="/assets/scripts/index.js"></script>


</body>

</html>
