$(window).scroll(function () {
    var scrollTop = $(this).scrollTop();
    var scrollHeight = $(document).height();
    var windowHeight = $(this).height();
    if (scrollTop + windowHeight == scrollHeight) {

        friend.pageTuring();
    }
});

var friend = new Vue({
    el:"#friend",
    data:{
        page:0,
        length:10,
        friendList:[],
        kw:''
    }
    ,
    created:function () {
        this.getFriendList();
    }
    ,
    watch:{
        kw:function () {

            if (this.kw === ''){
                this.userList = [];
                this.page =0;
                this.getStateList();
            }else{
                this.userList = [];
                this.page =0;
                this.searchFriendList();
            }
        }
    }
    ,
    methods:{
        getFriendList:function () {
            var that = this;
            common.ajax.get(common.data.getFriendListUrl,function (response) {
                if (response.success){
                    var list = response.data;
                    if (list != null){
                        if (list.length == 0){
                            alert("无数据");
                        }

                        that.friendList = that.friendList.concat(list);
                    }

                }else{
                    alert(response.msg);
                }
            },{page:this.page,length:this.length});
        }
        ,
        searchFriendList:function () {
            var that = this;
            common.ajax.get(common.data.getFriendListUrl,function (response) {
                if (response.success){
                    var list = response.data;
                    if (list != null){
                        if (list.length == 0){
                            alert("无数据");
                        }

                        that.friendList = that.friendList.concat(list);
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
                this.searchFriendList();
            }else{
                this.getFriendList();
            }

        }

    }
});