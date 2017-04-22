/**
 * Created by jack on 2017/4/22.
 */
$(function(){

    $('#submit').on('click',function(){
        doSaveTestCase();
    })


})

function doSaveTestCase() {
    $.ajax({
        url:'saveTestCase',
        type: 'POST',
        data: $('#testCaseForm').serialize(),
        async: false,
        success: function(res){
            if(res){
                alert('提交成功')
                location.href='/list'
            }else{
                alert('提交失败')
            }
        },
        error: function(){
            alert('请求错误')
        }
    })
}


