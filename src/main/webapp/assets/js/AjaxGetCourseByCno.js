//核心思想

$(function () {
    getTask();
    // limitDate();
});

// 获取课程作业
function getTask() {
    var Uarry = $("#courseList li");// 获取所有的li元素
    $("#courseList li").click(function () {// 点击事件
        // 测试直接获取值 var v=$(this).text(); alert(v);
        var count = $(this).index();// 获取li的下标
        var courseId = Uarry.eq(count).val();
        SelectCno(courseId);
    });
}

// 根据课程号获取作业
function SelectCno(courseId) {
    // 获取后台地址
    var path = $("#PageContext").val() + "/student/getAllTaskByCourseId.action";
    // 获得cno,将数据传到后台
    var jqXML = $.ajax({
        url: path,
        type: "POST",
        data: {"courseId": courseId},
        dataType: "json",
        async: true
    });
    // 回调成功函数
    jqXML.done(function (data) {
        // 判断是否提交作业,显示不同信息
        var str;
        var isSubmit;
        var path = $('#PageContext').val() + "/student/submitTask.do";
        $("#table_content").empty();
        for (i in data) {
            if (data[i].file_time == undefined) {
                data[i].file_time = "";
            }
            if (data[i].workList != null && data[i].workList != "" && data[i].workList != undefined) {
                isSubmit = "<td>是<span class='submit_is'>已提交</span></td>"
            } else {
                isSubmit = '<td>否<a href="' + path + '?courseId=' + data[i].course.courseId + '&&task.taskId=' + data[i].taskId + '" class="submit_no">提交</a></td>';
            }
            var time = "";
            if (data[i].workList.length != 0) {
                time = "<td class='center'>" + timestampToTime(data[i].workList[0].workTime)+ "</td>";
            }
            str = "<tr class='odd gradeX'  >" +
                "<td>" + data[i].course.courseName + "</td>" +
                "<td>" + data[i].type.typeName + "</td>" +
                isSubmit +
                "<td class='center'>" + data[i].taskName + "</td>" +
                time
                +"</tr>"
            $("#table_content").append(str);
        }
    });
    // 失败函数
    jqXML.fail(function () {
        alert("后台服务错误,加载Task失败");
    });
}

function timestampToTime(timestamp) {
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    Y = date.getFullYear() + '/';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '/';
    D = date.getDate() + ' ';
    h = date.getHours() + ':';
    m = date.getMinutes() + ':';
    s = date.getSeconds();
    return Y+M+D+"  "+h+""+m+""+s;
}


