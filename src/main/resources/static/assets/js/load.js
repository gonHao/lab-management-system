
function findInfo(){

    var userInfo = {};
        userInfo.userNm=$("#userNm").val(),
        userInfo.name=$("#name").val(),
        userInfo.createDate=$("#createDate").val(),
        userInfo.note=$("#note").val()
    $.ajax({
        type:'post',
        url:"/findUsers",
        cache: false,
        data:JSON.stringify(userInfo),
        contentType: "application/json;charset=UTF-8;",
        dataType:'html',
        success:function(data){
            $("#table_refresh").html(data);
        },
        error:function(){
         alert("请求失败")
        }
   });
}

