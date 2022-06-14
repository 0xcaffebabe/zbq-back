$(window).scroll(function () {
    var scrollTop = $(this).scrollTop();
    var scrollHeight = $(document).height();
    var windowHeight = $(this).height();
    if (scrollTop + windowHeight == scrollHeight) {

        friend.pageTuring();
    }
});

var friend = new Vue({
    el:"#state",
    data:{
        page:0,
        length:10,
        stateList:[],
        kw:'',
        info:''
    }
    ,
    created:function () {
        this.getStateList();
    }
    ,
    watch:{
        kw:function () {

            if (this.kw === ''){
                this.stateList = [];
                this.page =0;
                this.getStateList();
            }else{
                this.stateList = [];
                this.page =0;
                this.searchStateList();
            }
        }
    }
    ,
    methods:{
        getStateList:function () {
            var that = this;
            common.ajax.get(common.data.getStateListUrl,function (response) {
                if (response.success){
                    var list = response.data;
                    if (list != null){
                        if (list.length == 0){
                            alert("无数据");
                        }

                        that.stateList = that.stateList.concat(list);
                    }

                }else{
                    alert(response.msg);
                }
            },{page:this.page,length:this.length});
        }
        ,
        searchStateList:function () {
            var that = this;
            common.ajax.get(common.data.getStateListUrl,function (response) {
                if (response.success){
                    var list = response.data;
                    if (list != null){
                        if (list.length == 0){
                            alert("无数据");
                        }

                        that.stateList = that.stateList.concat(list);
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
                this.searchStateList();
            }else{
                this.getStateList();
            }

        }
        ,
        showInfo:function (content) {
            this.info = content;
            $("#infoModal").modal("show");
        }

    }
});