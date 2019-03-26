
var dashboard = new Vue({
   el:"#dashboard",
   data:{
       totalUser:0,
       todayUser:0
   },
    created:function () {

       this.updateDashboard();
    }
   ,
    methods:{
       updateDashboard:function () {
           var that = this;
           common.ajax.get(common.data.getDashboardUrl,function (resposne) {
               if (resposne.success){
                   that.totalUser = resposne.data.totalUser;
                   that.todayUser = resposne.data.todayUser ;
               }else{
                   alert(resposne.msg);
               }
           })
       }
    }
});