var vm = new Vue({
	el:"#loadUserHistory",
	data:{
		isdisable:false,
		page:0,
		totalpage:8,
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
			this.$http.post("userHistoryCountOfRows.action").then((res)=>{
				
				console.log("totalpage："+Math.ceil(res.body/8))
				this.page =1;
				this.totalpage=Math.ceil(res.body/8);
			});
			this.$http.post("loadUserHistoryData.action").then((res)=> {
				console.log(res.body)
				res.body.forEach((item,index)=>{
					this.momentsList.push(item);
				})
				
				if(this.momentsList.length>=8)this.isdisable=true;
			})
		},
		pageable:function(p){
			this.$http.post("historyPageable.action",{page:p,size:8},{emulateJSON: true}).then((res)=>{
				this.page=p;
				this.momentsList=[];
				res.body.forEach((item,index)=>{
					this.momentsList.push(item);
				})
			})
		}
		
	},
})