<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>转笔圈后台管理登录</title>
    <link rel="stylesheet" href="/vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="/vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div class="page-wrapper flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card p-4" id="login">
                    <div class="card-header text-center text-uppercase h4 font-weight-light">
                        登录
                    </div>

                    <div class="card-body py-5">
                        <div class="form-group">
                            <label class="form-control-label">账号</label>
                            <input type="email" class="form-control" v-model="username">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">密码</label>
                            <input type="password" class="form-control" v-model="password" @keyup.enter="login">
                        </div>

                        <div class="custom-control custom-checkbox mt-4">
                            <input type="checkbox" class="custom-control-input" id="login">
                            <label class="custom-control-label" for="login">记住我</label>
                        </div>
                    </div>

                    <div class="card-footer">
                        <div class="row">
                            <div class="col-6">
                                <button type="submit" class="btn btn-primary px-5" @click="login">登录</button>
                            </div>

                            <div class="col-6">
                                <a href="#" class="btn btn-link">忘记密码?</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/popper.js/popper.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/vendor/chart.js/chart.min.js"></script>
<script src="/js/carbon.js"></script>
<script src="/js/demo.js"></script>
<script src="/js/vue.js"></script>
<script src="/js/md5.js"></script>
<script src="/js/common.js"></script>
<script>

    var login = new Vue({
       el:"#login",
       data:{
           username:'',password:''
       }
       ,
        methods:{
           login:function () {

               if (this.username == '' || this.password == ''){
                   alert("请将信息填写完整");
               }else{
                    common.ajax.post(common.data.loginUrl,function (response) {
                        if (response.success){
                            window.location = '/main';
                        }else{
                            alert(response.msg);
                        }
                    },{username:this.username,password:hex_md5(this.password)});
               }
           }
        }
    });
</script>
</body>
</html>
