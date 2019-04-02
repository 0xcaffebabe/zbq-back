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
            <div class="container-fluid" id="user">

                <div class="modal fade" id="editInfoModal" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">用户信息 - {{editUser.username}}</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>

                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-md-2">
                                        <img :src="editUser.profile" alt="" class="" width="64"
                                             style="border-radius: 50px;">

                                    </div>
                                    <div class="col-md-10">
                                        <div class="form-group">
                                            <label for="normal-input" class="form-control-label">账号</label>
                                            <input class="form-control" v-model="editUser.username">
                                        </div>

                                        <div class="form-group">
                                            <label for="normal-input" class="form-control-label" >密码</label>
                                            <input id="normal-input" class="form-control" v-model="editUser.password"
                                                   disabled/ >
                                            <button class="btn btn-sm btn-danger" @click="resetPassword" style="float:right">重置密码</button>
                                        </div>

                                        <div class="form-group">
                                            <label for="normal-input" class="form-control-label">昵称</label>
                                            <input class="form-control" value="root">
                                        </div>

                                        <div class="form-group">
                                            <label for="normal-input" class="form-control-label">生日</label>
                                            <input id="normal-input" type="date" class="form-control"
                                                   v-model="editUser.birthday">
                                        </div>

                                        <div class="form-group">
                                            <label for="normal-input" class="form-control-label">笔龄</label>
                                            <input class="form-control" v-model="editUser.penYear">
                                        </div>

                                        <div class="form-group">
                                            <label for="normal-input" class="form-control-label">性别</label>
                                            <select name="" id="" class="form-control" v-model="editUser.gender">
                                                <option value="0">未知</option>
                                                <option value="1">男</option>
                                                <option value="-1">女</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="normal-input" class="form-control-label">个签</label>
                                            <textarea name="" id="" cols="30" rows="3" class="form-control"
                                                      v-model="editUser.description"></textarea>
                                        </div>
                                    </div>

                                </div>


                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-link" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary" @click="updateUserInfo(editUser.userId)">更新</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal fade" id="permissionModal" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">权限管理 - root</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>

                            <div class="modal-body">

                                <table class="table table-hover">

                                    <thead>
                                        <tr>
                                            <td>权限</td>
                                            <td>状态</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="(value,key) in editUserPermission">
                                            <td>{{key}}</td>
                                            <td>
                                                <div class="toggle-switch" data-ts-color="primary">
                                                    <input :id="key" type="checkbox" hidden="hidden" v-model="editUserPermission[key]">
                                                    <label :for="key" class="ts-helper"></label>
                                                </div>
                                            </td>
                                        </tr>

                                    </tbody>
                                </table>







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
                        <td>用户名</td>
                        <td>最后登录</td>
                        <td>操作</td>
                    </tr>

                    </thead>

                    <tr v-for="(user,index) in userList">
                        <td>{{user.userId}}</td>
                        <td>{{user.username}}</td>
                        <td>{{user.lastLogin}}</td>
                        <td>
                            <button class="btn btn-sm btn-success" @click="editInfo(user.userId)">信息编辑</button>
                            <button class="btn btn-sm btn-primary" @click="editPermission(user.userId)">权限管理</button>
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
<script src="/js/user.js"></script>

</body>
</html>
