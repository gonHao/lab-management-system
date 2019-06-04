$("#delete").click(function(){
var arr = [];
    var checkRecord =  $('#mytab').bootstrapTable('getSelections');
    if(checkRecord.length>0){
        if(confirm("你确定删除该记录吗？")==false){
            return 0;
        }
        for(var  i=0;i<checkRecord.length;i++){
                console.log(checkRecord[i].id);
                arr.push(checkRecord[i].id);
            }
            $.ajax({
                        type:'post',
                        url:'/checkInfo/deleteRec',
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
        confirm("请先选中要删除的记录！");

    }
});

    $("#commit").click(function(){
        var formDate={};
        formDate.classRoomName=$("#classroom").find("option:selected").text();
        formDate.state=$("#state").val();
        formDate.checkMan=$("#checkMan").val();
        formDate.note=$("#note").val();
        console.log(formDate);
        $.ajax({
            type:'post',
            url:'/checkInfo/addCheckInfo',
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