$("#delete").click(function(){
var arr = [];
    var userObj =  $('#mytab').bootstrapTable('getSelections');
    if(userObj.length>0){
        confirm("你确定删除该用户吗？");
        for(var  i=0;i<userObj.length;i++){
                arr.push(userObj[i].userNm);
            }
            $.ajax({
                        type:'post',
                        url:'/user/deleteUsers',
                        traditional: true,
                        data:JSON.stringify(arr),
                        contentType: "application/json;charset=UTF-8;",
                        dataType:'text',
                        success:function(data){
                            alert(data);
                        },
                        error:function(){
                            alert("请求失败");
                        }
                    });
    }else{
        confirm("请先选中要删除的用户！");

    }
    console.log(userObj);
});
$("#update").click(function(){
    $("#addUserNm").attr("disabled","disabled");
    $("#updateInfo").show();
    $("#commit").hide();
    if($('#mytab').bootstrapTable('getSelections').length==1){
         var updateUser =  $('#mytab').bootstrapTable('getSelections')[0];
         console.log(updateUser);
         $("#addUserNm").val(updateUser.userNm);
         $("#addName").val(updateUser.name);
         $("#addUserType").val(updateUser.userType);
         $("#addState").val(updateUser.state);
         $("#addNote").val(updateUser.note);
         for(i=0;i<8;i++){
                 $("#checkbox"+i+"").prop("checked",false);
             }``
         for(var i=0;i<updateUser.userModule.length;i++){
            for(var j=0;j<8;j++){
                var str  = "ROLE_"+$("#checkbox"+j+"").val();

                if(updateUser.userModule[i] == str){
                    $("#checkbox"+j+"").prop("checked",true);
                    console.log("true");
                    console.log("userM:" +updateUser.userModule[i]);
                    console.log("str:" +str);
                }
            }
         }

    }else{
        confirm("请先选中一位要修改信息的用户！");
    }

$("#updateInfo").click(function(){
            var formDate={};
            formDate.userNm=$("#addUserNm").val();
            formDate.name=$("#addName").val();
            formDate.userType=$("#addUserType").val();
            formDate.state=$("#addState").val();
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
                url:'/user/updateUser',
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
$("#mod").click(function(){
    $("#addUserNm").removeAttr("disabled");
    $("#updateInfo").hide();
    $("#commit").show();
    $("#addUserNm").val("");
    $("#addName").val("");
    $("#addUserType").val("");
    $("#addState").val("");
    $("#addNote").val("");
    for(i=0;i<8;i++){
        $("#checkbox"+i+"").prop("checked",false);
    }
});

    $("#commit").click(function(){
        var formDate={};
        formDate.userNm=$("#addUserNm").val();
        formDate.name=$("#addName").val();
        formDate.userType=$("#addUserType").val();
        formDate.state=$("#addState").val();
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
            url:'/user/addUser',
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
