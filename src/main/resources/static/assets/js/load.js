/*
该方法实现用ajax局部刷新div
    obj为传入数据对象
    url为请求路径
    refresh为需要刷新div的id
*/
function findInfo(obj,url,refresh){
    $.ajax({
        type:'post',
        url:url,
        cache: false,
        data:JSON.stringify(obj),
        contentType: "application/json;charset=UTF-8;",
        dataType:'html',
        success:function(data){
            $("#"+refresh+"").html(data);
        },
        error:function(){
         alert("请求失败");
        }
   });
}
 function savePic(url){
        var formData = new FormData($( "#upExcel" )[0]);
        //alert(ajaxUrl);
        //$('#uploadPic').serialize() 无法序列化二进制文件，这里采用formData上传
        //需要浏览器支持：Chrome 7+、Firefox 4+、IE 10+、Opera 12+、Safari 5+。
        $.ajax({
            type: "POST",
            dataType: "text",
            url: url,
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
            alert(data);
            },
            error: function(data) {
                alert("error:"+data.responseText);

             }
        });
        return false;
    }


