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

    <div class="container" id="container">

        <h1 class="report-title">
            <span class="left-line"></span>



        <#list requestResource as r >
            <#if r_index==0>
                <span class="ellipsis" title="${r.testUrl}">
                ${r.testUrl}</span>
            </#if>

        </#list>


            <span class="middle-line"></span>
            H5测试报告
        </h1>

        <div class="info">
            <ul>
                <li class="h5_icon">
                    <div class="report-app-cover"></div>
                </li>
                <li class="status"><span class="name">测试状态:</span><span class="value">&nbsp;已完成</span></li>
                <li class="test-progress">
                    <span class="name">测试进度 : </span>
                    <span class="value"><span class="g">&nbsp;1</span>/<span class="r">0</span>/<span class="b">0</span></span>
                </li>
                <li class="time"><span class="name">提测时间 : </span><span
                        class="value">&nbsp;${testTimeData.gmtCreated?string("yyyy/MM/dd HH:mm:ss")}</span>
                </li>
            </ul>
        </div>

        <div id="menu-bar" data-executionid="314696">
            <div class="menus">
                <a href="#" data-spm-anchor-id="0.0.0.0"><span class="menu active"
                                                               data-tab-target="overview">测试概况</span></a>
                <a href="#" data-spm-anchor-id="0.0.0.0"><span class="menu" data-tab-target="detail">终端详情</span></a>
                <a href="#" data-spm-anchor-id="0.0.0.0"><span class="menu last-menu" data-tab-target="shoots">图像</span></a>
            </div>
        </div>

        <div id="overview" class="result-info result-active h5-overview" data-tab-content="overview"
             style="display: block;">
            <div class="overview-box _overview">
                <div class="norm1 clearfix">
                    <div class="n syn"><b>90</b><span>分</span>
                        <p>评分</p></div>
                    <div class="n warn serverResponseInterval "><b>444</b><span>ms</span>
                        <p>首资源时间 <a class="help-btn" data-toggle="tooltip"
                                    data-title="从开始加载到接收到第一个资源文件的时间。通过使用CDN、缓存可以有效降低首资源时间" data-original-title=""
                                    title=""></a></p></div>
                    <div class="n onRender"><b>${testTimeData.onReceivedTitle}</b><span>ms</span>
                        <p>白屏时间 <a class="help-btn" data-toggle="tooltip" data-title="H5应用从开始加载到绘制第一帧页面所占用的时间"
                                   data-original-title="" title=""></a></p></div>
                    <div class="n firstScreenOKInterval"><b>5.44</b><span>s</span>
                        <p>首屏时间 <a class="help-btn" data-toggle="tooltip"
                                   data-title="从开始加载到浏览器视窗被充满的时间。影响用户体验的重要指标，建议达到4s以下" data-original-title=""
                                   title=""></a></p></div>
                    <div class="n note pageFinishedInterval"><b>${testTimeData.load}</b><span>ms</span>
                        <p>资源加载时间 <a class="help-btn" data-toggle="tooltip"
                                     data-title="从开始加载到所有资源加载完成的时间。此时，图片正在绘制中，尚未显示到页面" data-original-title=""
                                     title=""></a></p></div>
                    <div class="n httpCount"><b>${requestResource?size}</b><span>个</span>
                        <p>HTTP请求数 <a class="help-btn" data-toggle="tooltip" data-title="H5应用在加载过程中，发出的HTTP请求总数"
                                      data-original-title="" title=""></a></p></div>
                    <div class="n totalUrlSize"><b>432.67</b><span>KB</span>
                        <p>网页大小 <a class="help-btn" data-toggle="tooltip"
                                   data-title="H5应用页面和所有加载资源的加和。良好的H5体验，需要网页大小降低到1M以下" data-original-title=""
                                   title=""></a></p></div>

                    <div class="n mainUrlDomNum"><b>${testTimeData.domTotal}</b><span>个</span>
                        <p>DOM节点总数 <a class="help-btn" data-toggle="tooltip" data-title="HTML文档中所包含的DOM节点总数"
                                      data-original-title="" title=""></a></p></div>

                    <div class="n redirectNum"><b>0</b><span>次</span>
                        <p>重定向次数 <a class="help-btn" data-toggle="tooltip" data-title="H5应用在加载过程中，页面发生跳转的次数"
                                    data-original-title="" title=""></a></p></div>
                    <div class="n domainNum"><b>4</b><span>个</span>
                        <p>域名数 <a class="help-btn" data-toggle="tooltip" data-title="H5应用在加载过程中，请求不同域名的总数。域名数越多，H5性能越慢"
                                  data-original-title="" title=""></a></p></div>
                    <div class="n failResourcesNum"><b>0</b><span>个</span>
                        <p>失败资源数 <a class="help-btn" data-toggle="tooltip"
                                    data-title="出现HTTP错误码4**、5**的请求数。减少失败资源数，能有效提高页面性能" data-original-title=""
                                    title=""></a></p></div>
                    <div class="n cpu"><b>2</b><span>%</span>
                        <p>CPU占用 <a class="help-btn" data-toggle="tooltip" data-title="H5应用加载过程中，占用的平均CPU资源大小"
                                    data-original-title="" title=""></a></p></div>
                    <div class="n mem"><b>36</b><span>MB</span>
                        <p>内存占用 <a class="help-btn" data-toggle="tooltip" data-title="H5应用加载过程中，占用的平均内存大小"
                                   data-original-title="" title=""></a></p></div>
                    <div class="n fps"><b>9</b><span></span>
                        <p>FPS <a class="help-btn" data-toggle="tooltip" data-title="H5应用绘制过程中的平均帧率"
                                  data-original-title="" title=""></a></p></div>
                </div>


                <code>
                ${testTimeData}
                </code>


                <div class="table-list clearfix">
                    <div class="res-domain _resDomain">
                        <div class="tabel-b">
                            <table cellspacing="0" cellpadding="0">
                                <caption>域名资源统计</caption>
                                <thead>
                                <tr>
                                    <td></td>
                                    <th>大小(KB)</th>
                                    <th>数量(个)</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th>cdn.bootcss.com</th>
                                    <td>301.4</td>
                                    <td>3</td>
                                </tr>
                                <tr>
                                    <th>hm.baidu.com</th>
                                    <td>0.08</td>
                                    <td>3</td>
                                </tr>
                                <tr>
                                    <th>jason-chen-2017.github.io</th>
                                    <td>55.04</td>
                                    <td>11</td>
                                </tr>
                                <tr>
                                    <th>code.jquery.com</th>
                                    <td>77.41</td>
                                    <td>1</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="res-type _resType">
                        <div class="tabel-b">
                            <table cellspacing="0" cellpadding="0">
                                <caption>资源类型统计</caption>
                                <thead>
                                <tr>
                                    <td></td>
                                    <th>大小(KB)</th>
                                    <th>数量(个)</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th><span class="title pic">Image</span></th>
                                    <td>0.08</td>
                                    <td>2</td>
                                </tr>
                                <tr>
                                    <th><span class="title js">JS</span></th>
                                    <td>424.31</td>
                                    <td>11</td>
                                </tr>
                                <tr>
                                    <th><span class="title css">CSS</span></th>
                                    <td>6.35</td>
                                    <td>3</td>
                                </tr>
                                <tr>
                                    <th><span class="title html">HTML</span></th>
                                    <td>1.93</td>
                                    <td>1</td>
                                </tr>
                                <tr>
                                    <th><span class="title api">JSON/XML</span></th>
                                    <td>0</td>
                                    <td>0</td>
                                </tr>
                                <tr>
                                    <th><span class="title flash">Flash</span></th>
                                    <td>0</td>
                                    <td>0</td>
                                </tr>
                                <tr>
                                    <th><span class="title other">Other</span></th>
                                    <td>0</td>
                                    <td>1</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="rule-list">
                    <div>
                        <table cellspacing="0" cellpadding="0">
                            <caption>详情列表</caption>
                            <thead>
                            <tr>
                                <th>建议</th>
                                <th>权重</th>
                                <th>问题</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th>压缩JS文件</th>
                                <td class="lv">6</td>
                                <td class="desc">发现可压缩的JS文件</td>
                                <td class="ctrl"><a href="#" data-tag-target="countJsLineCount" class="_showDatailBtn"
                                                    data-spm-anchor-id="0.0.0.0">展开详情</a></td>
                            </tr>
                            <tr data-tag="countJsLineCount" style="display: none;">
                                <td colspan="4">
                                    <div class="issue-detail _issueDetail">
                                        <div class="tips">
                                            <div class="title">优化提示</div>
                                            <pre class="content">使用类似UglifyJS、YUI Compressor、Closure等压缩工具，减小js文件大小，节约流量</pre>
                                        </div>
                                        <div class="detail">
                                            <div class="title">问题详情</div>
                                            <pre class="content"><a target="_blank"
                                                                    href="https://jason-chen-2017.github.io/Jason-Chen-2017/public/js/sidebar.js">https://jason-chen-2017.github.io/Jason-Chen-2017/public/js/sidebar.js</a><br><a
                                                    target="_blank"
                                                    href="https://jason-chen-2017.github.io/Jason-Chen-2017/public/js/header.js">https://jason-chen-2017.github.io/Jason-Chen-2017/public/js/header.js</a><br><a
                                                    target="_blank"
                                                    href="https://jason-chen-2017.github.io/Jason-Chen-2017/public/js/jason.js">https://jason-chen-2017.github.io/Jason-Chen-2017/public/js/jason.js</a><br><a
                                                    target="_blank"
                                                    href="https://jason-chen-2017.github.io/Jason-Chen-2017/public/js/sidebar.js">https://jason-chen-2017.github.io/Jason-Chen-2017/public/js/sidebar.js</a><br><a
                                                    target="_blank"
                                                    href="https://jason-chen-2017.github.io/Jason-Chen-2017/public/js/header.js">https://jason-chen-2017.github.io/Jason-Chen-2017/public/js/header.js</a><br></pre>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>减小首屏加载时间</th>
                                <td class="lv">3</td>
                                <td class="desc">首屏加载时间过长</td>
                                <td class="ctrl"><a href="#" data-tag-target="ScreenOKTime" class="_showDatailBtn"
                                                    data-spm-anchor-id="0.0.0.0">展开详情</a></td>
                            </tr>
                            <tr data-tag="ScreenOKTime" style="display: none;">
                                <td colspan="4">
                                    <div class="issue-detail _issueDetail">
                                        <div class="tips">
                                            <div class="title">优化提示</div>
                                            <pre class="content">通过按需加载、优先加载等方法，减小首屏加载时间。首屏加载时间达到4s以下为优秀，4s到8s为中等，8s以上不合格。</pre>
                                        </div>
                                        <div class="detail">
                                            <div class="title">问题详情</div>
                                            <pre class="content">首屏加载时间为 <span>5.882</span> 秒</pre>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>使用异步请求JS资源</th>
                                <td class="lv">1</td>
                                <td class="desc">发现同步引用的JS资源</td>
                                <td class="ctrl"><a href="#" data-tag-target="async" class="_showDatailBtn"
                                                    data-spm-anchor-id="0.0.0.0">展开详情</a></td>
                            </tr>
                            <tr data-tag="async" style="display: none;">
                                <td colspan="4">
                                    <div class="issue-detail _issueDetail">
                                        <div class="tips">
                                            <div class="title">优化提示</div>
                                            <pre class="content">同步请求JS阻塞页面渲染，使用defer或async属性，使异步加载</pre>
                                        </div>
                                        <div class="detail">
                                            <div class="title">问题详情</div>
                                            <pre class="content"><a target="_blank"
                                                                    href="https://jason-chen-2017.github.io/Jason-Chen-2017/">https://jason-chen-2017.github.io/Jason-Chen-2017/</a><br></pre>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>检查返回内容为空的请求</th>
                                <td class="lv">0</td>
                                <td class="desc">发现返回内容为空的请求</td>
                                <td class="ctrl"><a href="#" data-tag-target="nullContent"
                                                    class="_showDatailBtn">展开详情</a></td>
                            </tr>
                            <tr data-tag="nullContent" style="display:none;">
                                <td colspan="4">
                                    <div class="issue-detail _issueDetail">
                                        <div class="tips">
                                            <div class="title">优化提示</div>
                                            <pre class="content">检查、修复或删除返回内容为空的请求</pre>
                                        </div>
                                        <div class="detail">
                                            <div class="title">问题详情</div>
                                            <pre class="content"><a target="_blank"
                                                                    href="https://hm.baidu.com/hm.js?bb529e2f4fa35aeb3b07ca2e09b4ef7c">https://hm.baidu.com/hm.js?bb529e2f4fa35aeb3b07ca2e09b4ef7c</a><br></pre>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>针对不同屏幕的设备优化展示</th>
                                <td class="lv">0</td>
                                <td class="desc">未针对设备定制不同样式优化</td>
                                <td class="ctrl"><a href="#" data-tag-target="countcssMedia"
                                                    class="_showDatailBtn">展开详情</a></td>
                            </tr>
                            <tr data-tag="countcssMedia" style="display:none;">
                                <td colspan="4">
                                    <div class="issue-detail _issueDetail">
                                        <div class="tips">
                                            <div class="title">优化提示</div>
                                            <pre class="content">使用@media screen 优化在不同屏幕设备中的展示</pre>
                                        </div>
                                        <div class="detail">
                                            <div class="title">问题详情</div>
                                            <pre class="content"><a target="_blank"
                                                                    href="https://jason-chen-2017.github.io/Jason-Chen-2017/public/css/font.css">https://jason-chen-2017.github.io/Jason-Chen-2017/public/css/font.css</a><br><a
                                                    target="_blank"
                                                    href="https://jason-chen-2017.github.io/Jason-Chen-2017/public/css/print.css">https://jason-chen-2017.github.io/Jason-Chen-2017/public/css/print.css</a><br></pre>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <table id="requestTable" class="table table-hover table-stripped">
            <thead>
            <th>No</th>
            <th>requestUrl</th>
            <th>timestamp</th>
            <th>timeCost</th>
            <th>method</th>
            <th>headers</th>
            </thead>
            <tbody>
            <#list requestResource as r >
            <tr>
                <td>${r.index}</td>
                <td><a href="${r.requestUrl}">${r.requestUrl}</a></td>
                <td>${r.timestamp?string('##############')}</td>
                <td>${r.timeCost}</td>
                <td>${r.method}</td>
                <td limit="100">${r.headers}</td>
            </tr>
            </#list>
            </tbody>
        </table>


    </div>
</div>

</body>
<#include '../common/footer.ftl'>
</html>
