<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>任务列表</title>

<#include '../common/header.ftl'>

</head>
<body>

<div class="container-fluid">
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
            <td>${tc.testUrl}</td>
            <td>${tc.containerType}</td>
            <td>${tc.netType}</td>
            <td>${tc.gmtCreated?string('yyyy/MM/dd HH:mm:ss')}</td>
        </tr>
        </#list>
        </tbody>
    </table>

</div>

</body>
<#include '../common/footer.ftl'>
</html>
