$(function(){
	$("#transpondMoment").click(function() {
		if(confirm("确定要转发该文章吗？")){
			var data = {
					id:$("input[name='momentsIdInput']").val()
			}
			$.ajax({
				type:"post",
				dataType:"json",
				url:"transpondMoment.action",
				data:data,
				async:true,
				success:function(data){
						if(data=="1"){
							confirm("转发成功");
						}
					},
				error:function(){
						confirm("您还没有登录，请先登录");
					}
				
			})
		}
	})
})