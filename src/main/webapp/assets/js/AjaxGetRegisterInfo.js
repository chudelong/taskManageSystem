$(function () {
    //加载学院
    loadCollege();
    //加载专业
    loadProno();
    //loadProfession();
    //加载班级
    loadClass();
});


//焦点触发事件
function loadProno() {
    loadProfessionByCollegeId($('#college option:first').val());
    $("#college").change(function () {
        $("#prono").empty();
        $("#classno").empty();
        var collegetId = $(this).val();
        loadProfessionByCollegeId(collegetId);
        loadClassByProfessionId($('#prono option:first').val())
    });
}

function loadClass() {
    loadClassByProfessionId($('#prono option:first').val())
    $("#prono").change(function () {
        $("#classno").empty();
        loadClassByProfessionId($(this).val());
    });
}


//加载学院
function loadCollege() {
    var path = $("#contextPath").val() + "/loadCollege.action";
    var jqXHR = $.ajax({
        url: path,
        method: "POST",
        dataType: "json",
        async: false
    });
    //成功回调函数
    jqXHR.done(function (data) {
        for (i in data) {
            $("#college").append("<option value='" + data[i].collegeId + "'>" + data[i].collegeName + "</option>");
        }
    });
}

//显示专业
function loadProfessionByCollegeId(collegeId) {
    var path = $("#contextPath").val() + "/loadProfessionByCollege.action";
    var jqXMl = $.ajax({
        url: path,
        type: "POST",
        data: {"collegeId": collegeId},
        dataType: "json",
        async: false
    });
    //回掉方法
    jqXMl.done(function (data) {
        for (var i in data) {
            $("#prono").append("<option value='" + data[i].professionId + "'>" + data[i].professionName + "</option>");
        }
    });
}

//显示班级方法
function loadClassByProfessionId(professionId) {
    var path = $("#contextPath").val() + "/loadClassByCollege.action";
    //根据prono查询
    var qrXML = $.ajax({
        url: path,
        type: "POST",
        data: {"professionId": professionId},
        dataType: "json",
        async: false
    });
    //显示class
    qrXML.done(function (data) {
        for (i in data) {
            $("#classno").append("<option value='" + data[i].classId + "'>" + data[i].className + "</option>")
        }
    });
}