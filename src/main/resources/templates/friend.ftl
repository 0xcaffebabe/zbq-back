<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Carbon - Admin Template</title>
    <link rel="stylesheet" href="/vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="/vendor/font-awesome/css/fontawesome-all.min.css">

    <link rel="stylesheet" href="/css/styles.css">
</head>
<body class="sidebar-fixed header-fixed">


<div class="page-wrapper">
    <#include "header.ftl"/>

    <div class="main-container">
       <#include "side.ftl"/>

        <div class="content">
            <div class="container-fluid" id="friend">



                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fa fa-search"></i></span>
                    </div>
                    <input type="text" class="form-control" placeholder="" v-model="kw">
                </div>


                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <td>用户</td>
                        <td>用户</td>
                        <td>关系确立时间</td>
                        <td>操作</td>
                    </tr>

                    </thead>

                    <tr v-for="friend in friendList">
                        <td>{{friend.userId}}</td>
                        <td>{{friend.friendId}}</td>
                        <td>{{friend.createTime}}</td>
                        <td>
                            <button class="btn btn-sm btn-danger" @click="">删除</button>
                        </td>
                    </tr>

                </table>
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
<script src="/js/common.js"></script>
<script src="http://momentjs.cn/downloads/moment-with-locales.min.js"></script>
<script src="/js/md5.js"></script>
<script src="/js/friend.js"></script>

</body>
</html>
