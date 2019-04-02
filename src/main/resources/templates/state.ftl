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
            <div class="container-fluid" id="state">

                <div class="modal fade" id="infoModal" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">动态详情 </h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>

                            <div class="modal-body">

                                {{info}}
                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-link" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fa fa-search"></i></span>
                    </div>
                    <input type="text" class="form-control" placeholder="" v-model="kw">
                </div>


                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <td>ID</td>
                        <td>是否可见</td>
                        <td>创建时间</td>
                        <td>用户</td>
                        <td>操作</td>
                    </tr>

                    </thead>

                    <tr v-for="state in stateList">
                        <td>{{state.stateId}}</td>
                        <td>{{state.visible}}</td>
                        <td>{{state.createTime}}</td>
                        <td>{{state.user}}</td>
                        <td>
                            <button class="btn btn-sm btn-danger" @click="showInfo(state.content)">详细内容</button>
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
<script src="/js/state.js"></script>

</body>
</html>
