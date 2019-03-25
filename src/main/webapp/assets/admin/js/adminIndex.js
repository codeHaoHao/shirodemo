$(function() {
	var vm = new Vue({
	el:"#loadAdminManagerUser",
	data:{
		isdisable:false,
		page:3,
		totalpage:6,
		groupList:[-2,-1,0,1,2],
		dataList:[]
	},
	filters:{
		formatDate:function(value){
			let date = new Date(value);
	        let y = date.getFullYear();
	        let MM = date.getMonth() + 1;
	        MM = MM < 10 ? ('0' + MM) : MM;
	        let d = date.getDate();
	        d = d < 10 ? ('0' + d) : d;
	        let h = date.getHours();
	        h = h < 10 ? ('0' + h) : h;
	        let m = date.getMinutes();
	        m = m < 10 ? ('0' + m) : m;
	        let s = date.getSeconds();
	        s = s < 10 ? ('0' + s) : s;
	        return y + '-' + MM + '-' + d + ' ' + h + ':' + m + ':' + s;
		}
	},
	mounted:function(){
		this.$nextTick(function() {
			this.createView();
			
		})
	},
	methods:{
		createView:function(){
			this.$http.post("adminCountOfUsers.action").then((res)=>{
				
				
				this.page =1;
				this.totalpage=Math.ceil(res.body/15);
			});
			this.$http.post("loadAdminManagerUsersData.action").then((res)=> {
				
				res.body.forEach((item,index)=>{
					this.dataList.push(item);
				})
				
				if(this.dataList.length>=15)this.isdisable=true;
			})
		},
		pageable:function(p){
			this.$http.post("adminManagerUsersPageable.action",{page:p,size:15},{emulateJSON: true}).then((res)=>{
				this.page=p;
				this.dataList=[];
				res.body.forEach((item,index)=>{
					this.dataList.push(item);
				})
			})
		},
		edit:function(index){
			$("input[name='id']").val(this.dataList[index].id);
			$("input[name='username']").val(this.dataList[index].username);
			$("input[name='name']").val(this.dataList[index].name);
			$("input[name='age']").val(this.dataList[index].age);
			$("input[name='gender']").val(this.dataList[index].gender);
			var _this = this;
			 $("#dialog-edit").dialog({
				 title:"编辑",
				 autoOpen: false,
			      height: 300,
			      width: 350,
			      modal: true,
			      buttons:{
			    	  "保存":function(){
			    		  var data = {
			    				  id:$("input[name='id']").val(),
			    				  username:$("input[name='username']").val(),
			    				  name:$("input[name='name']").val(),
			    				  age:$("input[name='age']").val(),
			    				  gender:$("input[name='docVlGender']:checked").val()
			    		  };
			    		  _this.$http.post("editUserInformation.action",data,{emulateJSON: true}).then(function(res){
			    			  if(res.body!=null){
			    				  _this.dataList[index].gender=res.body.gender;
			    				  _this.dataList[index].age=res.body.age;
			    				  _this.dataList[index].name=res.body.name;
									confirm("修改成功")
			    			  }
								
							})
			    	  },
			    	  "取消":function(){
			    		  $("#dialog-edit").dialog("close")
			    	  }
			      }
			      
			 });
			 $("#dialog-edit").dialog("open")
		},
		
		editPassword:function(index){
			var _this = this;
			$("#dialog-editPassword").dialog({
				 title:"修改密码",
				 autoOpen: false,
			      height: 300,
			      width: 350,
			      modal: true,
			      buttons:{
			    	  "保存":function(){
			    		  var newPassword = $("input[name='newPassword']").val();
			    		  _this.$http.post("editUserNewPassword.action",{id:_this.dataList[index].id,newPassword:newPassword,salt:_this.dataList[index].salt},{emulateJSON: true}).then(function(res){
			    			 
			    			  if(res.bodyText!="0"){
			    				  _this.dataList[index].password=res.bodyText;
									confirm("密码修改成功")
			    			  }
								
							})
			    	  },
			    	  "取消":function(){
			    		  $("#dialog-editPassword").dialog("close")
			    	  }
			      }
			      
			 });
			 $("#dialog-editPassword").dialog("open")
		},
		deleteButton:function(index){
			if(confirm("该功能只是让用户锁定，即用户不能登录，确定要锁定该用户吗？")){
				this.$http.post("deleteUser.action",{id:this.dataList[index].id},{emulateJSON: true}).then((res)=>{
	
					if(res.body=="1"){
						this.dataList[index].locked="1";
						confirm("锁定成功，该用户已经无法登陆")
					}
				})
			}
			
		},
		search:function(){
			var data={
					username:$("input[name='search']").val()
			};
			this.$http.post("searchByUsername.action",data,{emulateJSON: true}).then((res)=>{
				if(res.body!=null){
					this.dataList=[];
					res.body.forEach((item,index)=>{
						this.dataList.push(item);
					})
					
				}
				
			})
		}
		
	},
})
})
