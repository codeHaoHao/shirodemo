var vm = new Vue({
	el:"#loadUserMomentsData",
	data:{
		isdisable:false,
		page:3,
		totalpage:6,
		groupList:[-2,-1,0,1,2],
		momentsList:[]
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
			this.$http.post("countOfRows.action").then((res)=>{
				
				console.log("totalpage："+Math.ceil(res.body/6))
				this.page =1;
				this.totalpage=Math.ceil(res.body/6);
			});
			this.$http.post("loadUserMomentsData.action").then((res)=> {
				res.body.forEach((item,index)=>{
					this.momentsList.push(item);
				})
				if(this.momentsList.length>=6)this.isdisable=true;
			})
		},
		deleteMoments:function(index,id){
			this.$http.post("deleteMomentsById.action",{id:id},{emulateJSON: true}).then((res)=>{
				if(res.body==1){
					if(confirm("确定要删除吗?")){
						this.momentsList.splice(index,1);
						this.momentsList=[];
						this.createView();
					}
				}
				else confirm("删除数据出错")
			})
		},
		pageable:function(p){
			this.$http.post("pageable.action",{page:p,size:6},{emulateJSON: true}).then((res)=>{
				this.page=p;
				this.momentsList=[];
				res.body.forEach((item,index)=>{
					this.momentsList.push(item);
				})
			})
		}
		
	},
})