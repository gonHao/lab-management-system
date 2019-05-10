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

