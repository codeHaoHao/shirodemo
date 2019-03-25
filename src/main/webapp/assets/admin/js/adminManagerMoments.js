var vm = new Vue({
	el:"#loadData",
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
			this.$http.post("adminCountOfMoments.action").then((res)=>{
				
				
				this.page =1;
				this.totalpage=Math.ceil(res.body/15);
			});
			this.$http.post("loadAdminManagerMomentsData.action").then((res)=> {
				
				res.body.forEach((item,index)=>{
					this.dataList.push(item);
				})
				
				if(this.dataList.length>=15)this.isdisable=true;
			})
		},
		pageable:function(p){
			this.$http.post("adminManagerMomentsPageable.action",{page:p,size:15},{emulateJSON: true}).then((res)=>{
				this.page=p;
				this.dataList=[];
				res.body.forEach((item,index)=>{
					this.dataList.push(item);
				})
			})
		},
		deleteMoments:function(index){
			if(confirm("确定要删除该文章吗？")){
				var data={
						id:this.dataList[index].id
				};
				this.$http.post("adminDeleteMoments.action",data,{emulateJSON: true}).then((res)=>{
					if(res.bodyText=="1"){
						this.dataList[index].isdelete="1";
						confirm("删除成功");
					}
				})
			}
			
		},
		cancelDeleteMoments:function(index){
			if(confirm("确定要取消删除该文章吗？")){
				var data={
						id:this.dataList[index].id
				};
				this.$http.post("adminCancelDeleteMoments.action",data,{emulateJSON: true}).then((res)=>{
					if(res.bodyText=="1"){
						this.dataList[index].isdelete="0";
						confirm("文章已取消删除");
					}
				})
			}
			
		},
		search:function(){
			var data={
					title:$("input[name='search']").val()
			};
			this.$http.post("searchByTitle.action",data,{emulateJSON: true}).then((res)=>{
				if(res.body!=null){
					this.dataList=[];
					this.totalpage=0;
					res.body.forEach((item,index)=>{
						this.dataList.push(item);
					})
					
				}
				
			})
		}
		
	},
})