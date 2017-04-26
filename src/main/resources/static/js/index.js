/**
 * Created by jack on 2017/4/22.
 */
$(function () {
    $("[limit]").limit();

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
                window.open("listTestResult", "_blank")
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


/**
 * limit
 */
function trim(s) {
    return trimRight(trimLeft(s));
}
function trimLeft(s) {
    if (s == null) {
        return "";
    }
    var whitespace = new String(" \t\n\r");
    var str = new String(s);
    if (whitespace.indexOf(str.charAt(0)) != -1) {
        var j = 0, i = str.length;
        while (j < i && whitespace.indexOf(str.charAt(j)) != -1) {
            j++;
        }
        str = str.substring(j, i);
    }
    return str;
}
function trimRight(s) {
    if (s == null) return "";
    var whitespace = new String(" \t\n\r");
    var str = new String(s);
    if (whitespace.indexOf(str.charAt(str.length - 1)) != -1) {
        var i = str.length - 1;
        while (i >= 0 && whitespace.indexOf(str.charAt(i)) != -1) {
            i--;
        }
        str = str.substring(0, i + 1);
    }
    return str;
}

function getLimit(limilt) {
    var text = $(limilt).text();
    var objString = trim(text);
    var objLength = objString.length;
    var num = $(limilt).attr("limit");
    if (objLength > num) {
        $(limilt).attr("title", objString);
        $(limilt).text(objString.substring(0, num) + "...");
    }
}
jQuery.fn.limit = function () {
    var self = $("[limit]");
    self.each(function () {
        getLimit(this);
    })
}

