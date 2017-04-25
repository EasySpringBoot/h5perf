<!DOCTYPE html>
<html lang="zh">
<head>

    <title>H5性能测试</title>
<#include "common/header.ftl">

</head>
<body>
<div class="container-fluid">
<#include 'common/nav.ftl'>

    <form action="/login" method="post" class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-1"> 用户名: </label>
            <div class="col-sm-3">
                <input type="text" name="username" class="form-control" value="root"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1"> 密 码: </label>
            <div class="col-sm-3">
                <input type="password" name="password" class="form-control" value="123456"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-3">
                <input type="submit" value="登录"/>
            </div>
        </div>

    </form>

    <form action="/logout" method="post" class="form-horizontal">
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-3">
                <input type="submit" value="退出"/>
            </div>
        </div>
    </form>
</div>
</body>
<#include 'common/footer.ftl'>
</html>
