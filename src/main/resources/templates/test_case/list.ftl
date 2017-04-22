<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>任务列表</title>

<#include '../common/header.ftl'>

</head>
<body>
<div class="container-fluid">
<#include '../common/nav.ftl'>
    <table class="table table-hover">
        <thead>
        <th>Id</th>
        <th>testUrl</th>
        <th>containerType</th>
        <th>netType</th>
        <th>gmtCreated</th>
        </thead>
        <tbody>
        <#list testCaseList as tc >
        <tr>
            <td>${tc.id}</td>
            <td><a href="${tc.testUrl}">${tc.testUrl}</a></td>
            <td>${tc.containerType}</td>
            <td>${tc.netType}</td>
            <td>${tc.gmtCreated?string('yyyy/MM/dd HH:mm:ss')}</td>
        </tr>
        </#list>
        </tbody>
    </table>

    <div class="center">
        <ul class="pagination">
            <li><a href="/listTestCase?pageNo=${prePage}&pageSize=10">&laquo;</a></li>
        <#list 1..totalPage as index>
            <#if index=pageNo>
                <li class="active"><a href="/listTestCase?pageNo=${index}&pageSize=10">${index}</a></li>
            <#else>
                <li><a href="/listTestCase?pageNo=${index}&pageSize=10">${index}</a></li>
            </#if>
        </#list>
            <li><a href="/listTestCase?pageNo=${nextPage}&pageSize=10">&raquo;</a></li>

        <#--<li class="active"><a href="#">1</a></li>-->
        <#--<li><a href="#">2</a></li>-->
        <#--<li><a href="#">3</a></li>-->
        <#--<li><a href="#">4</a></li>-->
        <#--<li><a href="#">5</a></li>-->
        </ul>
    </div>


</div>

</body>
<#include '../common/footer.ftl'>
</html>
