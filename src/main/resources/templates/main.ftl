<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
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
            <div class="container-fluid">
                <div class="row" id="dashboard">
                    <div class="col-md-3">
                        <div class="card p-4">
                            <div class="card-body d-flex justify-content-between align-items-center">
                                <div>
                                    <span class="h4 d-block font-weight-normal mb-2">{{totalUser}}</span>
                                    <span class="font-weight-light">用户</span>
                                </div>

                                <div class="h2 text-muted">
                                    <i class="fa fa-users"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="card p-4">
                            <div class="card-body d-flex justify-content-between align-items-center">
                                <div>
                                    <span class="h4 d-block font-weight-normal mb-2">{{todayUser}}</span>
                                    <span class="font-weight-light">今日活跃用户</span>
                                </div>

                                <div class="h2 text-muted">
                                    <i class="fa fa-user"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="card p-4">
                            <div class="card-body d-flex justify-content-between align-items-center">
                                <div>
                                    <span class="h4 d-block font-weight-normal mb-2">900</span>
                                    <span class="font-weight-light">待处理事件</span>
                                </div>

                                <div class="h2 text-muted">
                                    <i class="fa fa-calendar"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="card p-4">
                            <div class="card-body d-flex justify-content-between align-items-center">
                                <div>
                                    <span class="h4 d-block font-weight-normal mb-2">560ms</span>
                                    <span class="font-weight-light">今日响应时</span>
                                </div>

                                <div class="h2 text-muted">
                                    <i class="fa fa-clock"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row ">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                最近12小时流量
                            </div>

                            <div class="card-body p-0">
                                <div class="p-4">
                                    <canvas id="line-chart" width="100%" height="20"></canvas>
                                </div>

                                <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                    <div class="text-center">
                                        <div class="text-muted small">总流量</div>
                                        <div>12,457 (40%)</div>
                                    </div>

                                    <div class="text-center">
                                        <div class="text-muted small">被禁用户</div>
                                        <div>95,333 (5%)</div>
                                    </div>

                                    <div class="text-center">
                                        <div class="text-muted small">页面访问</div>
                                        <div>957,565 (50%)</div>
                                    </div>

                                    <div class="text-center">
                                        <div class="text-muted small">平均耗时</div>
                                        <div>560 ms</div>
                                    </div>
                                </div>
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
<script src="/js/common.js"></script>
<script src="/js/main.js"></script>
</body>
</html>
