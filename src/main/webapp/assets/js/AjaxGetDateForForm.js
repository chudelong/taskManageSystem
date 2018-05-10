/**
 * 
 */

$(function(){
			//失去焦点时响应
			$("#studentNo").blur(function(){
				//从HTML获取数据
				var studentNo=$("#studentNo").val();
				//从隐藏域中获取路径
				var path=$("#contextPath").val()+"/checkStudentIsExist.action";
				var qrXML=$.ajax({
  				url:path,
  				type:"POST",
  				data:{"studentNo":studentNo},
  				dataType:"json"
  				});
				//从服务端获取数据后
				qrXML.done(function(data){
					var flag=true;
					var isExist=!data;
					if(isExist){
					$("#message").css("color","red");
					$("#message").html("学号已经存在");
					falg=false;
					}else if($("#studentNo").val().length==10){
					$("#message").css("color","green");
					$("#message").html("学号可以使用");
					falg=true;
					}
					//如果不满足条件,不能提交表单
					$("form").submit(function(){
						return falg;
					});
			});
			qrXML.fail(function(){
				$("#message").html("服务端错误");
			});
		});
	 });