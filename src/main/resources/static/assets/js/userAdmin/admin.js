 $(function(){
    $("#find").click(function(){
    var createDate  = $("#createDate").val();
                  var userInfo = {};
                  userInfo.userNm=$("#userNm").val();
                  userInfo.name=$("#name").val();
                  userInfo.createDate=createDate.substring(0,4)+createDate.substring(5,7)+createDate.substring(8,10);
                  userInfo.note=$("#note").val();
                  findInfo(userInfo,"/findUsers","table_refresh");
     });

    $("#commit").click(function(){
        var formDate={};
        formDate.userNm=$("#addUserNm").val();
        formDate.name=$("#addName").val();
        formDate.note=$("#addNote").val();
        console.log( $("#admin").val());
        var userModule = new Array();
        for(i=0;i<8;i++){
            if($("#checkbox"+i+"").prop("checked")){
                userModule[i]=$("#checkbox"+i+"").val();
            }
        }
        formDate.userModule=userModule;
        console.log(formDate);
        $.ajax({
            type:'post',
            url:'/addUser',
            data:JSON.stringify(formDate),
            contentType: "application/json;charset=UTF-8;",
            dataType:'text',
            success:function(data){
                alert(data);
            },
            error:function(){
                alert("请求失败");
            }
        });

    });
});
