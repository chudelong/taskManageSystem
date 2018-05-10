//显示所有课程
$(function () {
    // 加载课程
    findCourse();
    // 当课程改变时
    changCno();
    //判断是否为空
    isNull();
    check();
});

function changCno() {
    $("#course").change(function () {
        $("#task").empty();
        // 获取课程号
        var courseId = $("#course").val();
        findTaskByCno(courseId);
        // 清除上一次的选择
    });
}

function findCourse() {

    var path = $("#ContextPath").val() + "/student/getAllCourse.action";
    // 页面加载时候,显示所有
    var qrXML = $.ajax({
        url: path,
        type: "post",
        dataType: "json",
        async: false

    });
    qrXML.done(function (data) {

        for (i in data) {
            $("#course").append("<option value='" + data[i].courseId + "'>" + data[i].courseName + "</option>");
        }
        // 调用页面传值加载课程
        loadCourse();
    });
    qrXML.fail(function () {
        alert("加载课程失败");
    });

}

// 根据课程编号显示作业
function findTaskByCno(courseId) {
    var path = $("#ContextPath").val() + "/student/getTaskByCourseId.action";
    // 将数据传到后台,并返回作业类型
    var jqXML = $.ajax({
        url: path,
        type: "POST",
        data: {"courseId": courseId},
        dataType: "json"
    });

    // 成功回调函数
    jqXML.done(function (data) {
        for (i in data) {
            $("#task").append("<option value='" + data[i].taskId + "'>" + data[i].taskName + "</option>")
        }
        //$('#task').prop('selectedIndex', 0);
        // 调用页面传值的方法
        // 判断如果是页面传值过来的cno则执行方法,否则不执行
        if (courseId == $("#courseId").val()) {

            loadTask(courseId);
        }
        // // 判断时间是否到期,到期不能提交
        // if (data[i].deadLine != undefined) {
        //     var oldTime = new Date(data[i].deadLine);
        //     // alert(oldTime);
        //     var currentTime = new Date();
        //     // alert(currentTime);
        //     if (oldTime < currentTime) {
        //         $("form").submit(function (e) {
        //             e.preventDefault();
        //             var str = "该作业提交最晚时间为\n" + timestampToTime(data[i].deadLine);
        //             alert("超过时间,不能提交\n" + str);
        //             window.location.reload;
        //         });
        //     }
        // }
    });

    // 失败函数
    jqXML.fail(function () {
        alert("加载作业失败");
    });
}

// 加载课程函数
function loadCourse() {
    // 当页面传递过来的不为空时
    var course_no = $("#courseId").val();
    // alert(course_no);
    if (course_no != "" && course_no != "undefined") {
        $("#course ").val(course_no);
        findTaskByCno(course_no);
    } else {
        $("#course").find("option").eq(0).prop("selected", true);
        c = $("#course").val();
        // 调用showClass()
        findTaskByCno(c);
    }
}

function loadTask() {
    var task = $("#task_no").val();
    if (task != "" && task != "undefined") {
        $("#task ").val(task);
    }
}


// 判断是否到期函数
function check() {
    $("form").submit(function (e) {
        var taskId = $("#task").val();
        var jqXHR = $.ajax({
            url: "/student/checkDeadLine.action",
            method: "post",
            async: false,
            data: {"taskId": taskId}
        });
        jqXHR.done(function (data) {
            var oldTime = new Date(data);
            var currentTime = new Date();
            if (oldTime < currentTime) {
                e.preventDefault();
                var str = "该作业提交最晚时间为\n" + timestampToTime(oldTime);
                alert("超过时间,不能提交\n" + str);
                window.location.href='/student/submitTask.do';
            }
        });
        jqXHR.fail(function () {
            alert("请求deadLine失败");
        });
    });

}

// 判断作业是否为空
function isNull() {
    $("form").submit(function (e) {
        //判断文件为空
        var file = $("#uploadFile");
        if ($.trim(file.val()) == '') {
            var cof = confirm("您当前没有选择文件,确定提交吗?");
            if (cof == false) {
                e.preventDefault();
                window.location.href = window.location.href;
                window.location.reload;
            }
        }
        var lenTask = $("#task").find("option").length;
        var lenCourse = $("#course").find("option").length;
        if (lenTask == 0 || lenCourse == 0) {
            e.preventDefault();
            alert("当前课程无作业或未选中课程");
            window.location.href = window.location.href;
            window.location.reload;
        }
    });
}

function timestampToTime(timestamp) {
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    Y = date.getFullYear() + '/';
    M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '/';
    D = date.getDate() + ' ';
    h = date.getHours() + ':';
    m = date.getMinutes() + ':';
    s = date.getSeconds();
    return Y + M + D;
}

// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function (fmt) { // author: meizz
    var o = {
        "M+": this.getMonth() + 1,                 // 月份
        "d+": this.getDate(),                    // 日
        "h+": this.getHours(),                   // 小时
        "m+": this.getMinutes(),                 // 分
        "s+": this.getSeconds(),                 // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
        "S": this.getMilliseconds()             // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}  


