$(function () {
   
    $.get('presentUser','',function (json) {
    	
        var _ret = eval('('+json+')');
        alert(_ret.name);
        if(_ret.name==''){
            $('#imported-account-file').text("目前没有已导入的账户");
            $('#imported-account-file').attr('href','#');
        }else{
            $('#imported-account-file').text(_ret.name);
        }
    });
})