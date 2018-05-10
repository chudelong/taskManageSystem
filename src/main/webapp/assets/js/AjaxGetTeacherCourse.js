$(function () {
    loadAllCourse();
    loadTypeByCourseId();
});

//加载该教师的全部课程
function loadAllCourse() {
    var path = $("#PageContext").val() + "/teacher/loadAllCourse.action";
    var jqXHR = $.ajax({
        url: path,
        method: "POST",
        dataType: "json"
    });
    //成功回掉函数
    jqXHR.done(function (data) {
        for (i in data) {
            $("#course").append("<option value='" + data[i].courseId + "'>" + data[i].courseName + "</option>");
        }
    });
    //失败
    jqXHR.fail(function () {
        alert("服务端出错");
    });
}

//根据课程加载类型
function loadTypeByCourseId() {
    var path = $("#PageContext").val() + "/teacher/loadAllCourseByCourseId.action";
    var jqXHR = $.ajax({
        url: path,
        method: "POST",
        dataType: "json",
    });
    jqXHR.done(function (data) {
        for (i in data) {
            $("#taskType").append("<option value='" + data[i].typeId + "'>" + data[i].typeName + "</option>");
        }
    });
    jqXHR.fail(function () {
        alert("服务端出错");
    });
}


