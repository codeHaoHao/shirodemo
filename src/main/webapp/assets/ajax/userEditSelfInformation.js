$(function() {
	$("#userEditSelfInformation_Button").click(function() {
		var data={
				"name":$("input[name='name']")[0].value,
				"age":$("input[name='age']")[0].value,
				"gender":$("input[name='docVlGender']:checked")[0].value,
				"individualResume":$("textarea[name='individualResume']")[0].value
		};
		$.ajaxFileUpload({
			type:"post",
			url:"doUserEditSelfInformation.action",
			secureuri:false,//是否需要安全协议，一般设置为false
			data:data,//传递的参数
			fileElementId:"xdaTanFileImg",//文件上传域的ID
			dataType:"JSON",//返回值类型
			success:function(data){
					if(data!=null){
						if(data==1){
							confirm("修改成功");
						}
					}else{
						alert("修改失败")
					}
				},
				error:function(){
					alert("error");
				}
		})
	})
})