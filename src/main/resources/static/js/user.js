$(window).scroll(function () {
    var scrollTop = $(this).scrollTop();
    var scrollHeight = $(document).height();
    var windowHeight = $(this).height();
    if (scrollTop + windowHeight == scrollHeight) {

        user.pageTuring();
    }
});

var user = new Vue({
   el:"#user",
   data:{
       page:0,
       length:10,
       userList:[],
       kw:'',
       editUser:{},
       editUserPermission:{}
   }
   ,
    created:function () {
        moment.locale("zh-cn");

        this.getUserList();
    }
    ,
    watch:{
       kw:function () {

           if (this.kw === ''){
               this.userList = [];
               this.page =0;
               this.getUserList();
           }else{
               this.userList = [];
               this.page =0;
               this.searchUserList();
           }
       }
    }
   ,
    methods:{
       getUserList:function () {
           var that = this;
           common.ajax.get(common.data.getUserListUrl,function (response) {
               if (response.success){
                   var list = response.data;
                   if (list != null){
                       if (list.length == 0){
                           alert("无数据");
                       }
                       for (var i =0;i<list.length;i++){
                           if (list[i].lastLogin != null){
                               list[i].lastLogin = moment(list[i].lastLogin).fromNow();
                           }

                       }
                       that.userList = that.userList.concat(list);
                   }

               }else{
                   alert(response.msg);
               }
           },{page:this.page,length:this.length});
       }
       ,
        searchUserList:function () {
            var that = this;
            common.ajax.get(common.data.getUserListUrl,function (response) {
                if (response.success){
                    var list = response.data;
                    if (list != null){
                        if (list.length == 0){
                            alert("无数据");
                        }
                        for (var i =0;i<list.length;i++){
                            if (list[i].lastLogin != null){
                                list[i].lastLogin = moment(list[i].lastLogin).fromNow();
                            }

                        }
                        that.userList = that.userList.concat(list);
                    }
                }else{
                    alert(response.msg);
                }
            },{page:this.page,length:this.length,kw:this.kw});
        }
       ,
        pageTuring:function () {

           this.page++;
           if (this.kw != ''){
               this.searchUserList();
           }else{
               this.getUserList();
           }

        }
        ,
        editInfo:function (id) {
            $("#editInfoModal").modal("show");
            var that = this;
            common.ajax.get(common.data.getUserInfoByIdUrl+id,function (response) {
                if (response.success){
                    that.editUser = response.data;
                    that.editUser.userId = id;
                }else{
                    alert("获取用户信息失败");
                }
            })

        }
        ,
        editPermission:function (id) {

           $("#permissionModal").modal("show");
           var that = this;
           common.ajax.get(common.data.getUserPermissionByIdUrl+id,function (response) {
               if (response.success){
                   that.editUserPermission = response.data;
               }else{
                   alert(response.msg);

               }
           })
        }
        ,
        updateUserInfo:function (id) {

           common.ajax.post(common.data.updateUserInfoUrl+id,function (response) {
               if (response.success){
                   alert(response.data);
               }else{
                   alert(response.msg);
               }
           },this.editUser);
        }
        ,
        resetPassword:function () {
           var r = prompt("输入该用户的新密码:");
           if (r){
               this.editUser.password = hex_md5(r).toUpperCase();
           }else{

           }
        }
    }
});