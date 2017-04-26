/**
 * Created by jack on 2017/4/22.
 */
$(function () {

    $('#submit').on('click', function () {
        doSaveTestCase();
    })

})

function runTestCase(url) {
    $.ajax({
        url: 'runTestCase',
        type: 'POST',
        data: {
            url: url
        },
        async: false,
        success: function (response) {
            //{exitValue: 0, tid: 1493200446692}
            console.log(response)
            if (response.exitValue == 0) {

                alert('运行成功')
                window.open("/findRequestResource?tid=" + response.tid, "_blank")
            } else {
                alert('运行错误')
            }
        }
    })
}

function doSaveTestCase() {
    $.ajax({
        url: 'saveTestCase',
        type: 'POST',
        data: $('#testCaseForm').serialize(),
        async: false,
        success: function (res) {
            if (res) {
                alert('提交成功')
                location.href = '/list'
            } else {
                alert('提交失败')
            }
        },
        error: function () {
            alert('请求错误')
        }
    })
}


