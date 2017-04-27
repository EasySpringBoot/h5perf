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
        <th>执行</th>
        </thead>
        <tbody>
        <#list testCaseList as tc >
        <tr>
            <td>${tc.id}</td>
            <td><a href="${tc.testUrl}">${tc.testUrl}</a></td>
            <td>${tc.containerType}</td>
            <td>${tc.netType}</td>
            <td>${tc.gmtCreated?string('yyyy/MM/dd HH:mm:ss')}</td>
            <td>
                <button id="btn-run-${tc.id}" class="btn btn-primary" onclick=runTestCase('${tc.testUrl}',${tc.id})
                        data-loading-text="执行中">运行
                </button>
            </td>
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

        </ul>
    </div>


</div>

</body>
<#include '../common/footer.ftl'>
</html>
