//用Ajax局部刷新验证码
$(function(){
	$("#checkImg").click(function(){
		var path="/common/createIdentifyCode.action?"+ new Date().getTime();
		$('#checkImg').attr("src", path);
	});
});
