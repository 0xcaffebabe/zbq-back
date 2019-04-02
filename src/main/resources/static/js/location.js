$(window).scroll(function () {
    var scrollTop = $(this).scrollTop();
    var scrollHeight = $(document).height();
    var windowHeight = $(this).height();
    if (scrollTop + windowHeight == scrollHeight) {

        friend.pageTuring();
    }
});

var friend = new Vue({
    el:"#location",
    data:{
        page:0,
        length:10,
        locationList:[],
        kw:'',
        info:''
    }
    ,
    created:function () {
        this.getLocationList();
    }
    ,
    watch:{
        kw:function () {

            if (this.kw === ''){
                this.stateList = [];
                this.page =0;
                this.getLocationList();
            }else{
                this.stateList = [];
                this.page =0;
                this.searchLocationList();
            }
        }
    }
    ,
    methods:{
        getLocationList:function () {
            var that = this;
            common.ajax.get(common.data.getLocationListUrl,function (response) {
                if (response.success){
                    var list = response.data;
                    if (list != null){
                        if (list.length == 0){
                            alert("无数据");
                        }

                        that.locationList = that.locationList.concat(list);
                    }

                }else{
                    alert(response.msg);
                }
            },{page:this.page,length:this.length});
        }
        ,
        searchLocationList:function () {
            var that = this;
            common.ajax.get(common.data.getLocationListUrl,function (response) {
                if (response.success){
                    var list = response.data;
                    if (list != null){
                        if (list.length == 0){
                            alert("无数据");
                        }

                        that.locationList = that.locationList.concat(list);
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
                this.searchLocationList();
            }else{
                this.getLocationList();
            }

        }


    }
});