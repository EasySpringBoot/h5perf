<!DOCTYPE html>
<html lang="zh">
<head>

    <title>H5性能测试</title>
<#include "common/header.ftl">

</head>
<body>

<div class="newContent" style="min-height : 1007px;">
    <div class="steps" id="commitStep">
        <div class="Step-div" id="newStepDiv">
            <ul>
                <li id="newStepTwo" class="oneStep Step-Current" data-for="#Step-Two-Div"
                    style="width: 383px; display: inline-block;">
                    <span class="step-num">1</span>
                    输入URL <span class="step-arrow-right"></span>
                </li>
                <li id="newStepThree" class="oneStep Step-Unreach" data-for="#Step-Three-Div"
                    style="width: 383px; display: inline-block;">
                    <span class="step-arrow-left"></span>
                    <span class="step-num">2</span>
                    选择测试终端
                    <span class="step-arrow-right"></span>
                </li>
                <li id="newStepFour" class="oneStep Step-Unreach"
                    style="margin-right: 0px; width: 383px; display: inline-block;" data-for="#Step-Four-Div">
                    <span class="step-arrow-left"></span>
                    <span class="step-num">3</span>
                    提交测试
                </li>
            </ul>
        </div>

        <div id="Step-Two-Div" class="Step-two step step-active">
            <span class="Sub-title"> <a href="/">H5测试</a></span>

            <hr class="Sub-hr">
            <div class="Main-content">
                <div class="alerts"></div>

                <form id="testCaseForm" data-parsley-validate="" novalidate="">
                    <div class="line">
                        <div class="tdTitle">容器类型：</div>
                        <div class="tdContent">
                            <div class="tdContent">
                                <div class="Radio_select_div">
                                    <label><input type="radio" name="containerType" value="ORGIN" checked=""
                                                  data-parsley-multiple="containerType"><span></span>原生H5容器</label>
                                    <label style="margin-left: 20PX;"><input type="radio" name="containerType"
                                                                             value="WECHAT"
                                                                             data-parsley-multiple="containerType"><span></span>微信H5容器</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="line">
                        <div class="tdTitle">待测URL：</div>
                        <div class="tdContent">
                            <div class="Input_url_div form-group has-feedback">
                                <input id="testUrl" name="testUrl" class="form-control" type="text"
                                       value="http://www.baidu.com"
                                       required=""
                                       data-parsley-url="" data-parsley-trigger="input" data-parsley-debounce="500">
                                <div class="help-block with-errors"></div>
                                <div class="help-block">
                                    提示：填写被测H5页面url
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="line" style="height : 35px;">
                        <!-- 弱网环境设置 -->
                        <div class="tdTitle">网络选项：</div>
                        <div class="tdContent">
                            <div class="Radio_select_div">
                                <label><input type="radio" name="netType" value="WIFI" checked=""
                                              data-parsley-multiple="netType"><span></span>WIFI</label>
                                <label><input type="radio" name="netType" value="3G"
                                              data-parsley-multiple="netType"><span></span>3G</label>
                                <label><input type="radio" name="netType" value="2G"
                                              data-parsley-multiple="netType"><span></span>2G</label>
                            </div>
                        </div>
                    </div>


                    <hr class="dashLine">
                    <div class="line" style="min-height : 82px;">
                        <div class="tdTitle">&nbsp;</div>
                        <div class="tdContent">
                            <button id="submit" class="button-blue">提交</button>
                            <span id="failButtonText" style="padding-left : 10px; color : red;"></span>
                        </div>
                    </div>


                </form>


            </div>
        </div>

    </div>
</div>
</body>
<#include 'common/footer.ftl'>
</html>
