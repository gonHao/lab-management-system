$("#delete").click(function(){
var arr = [];
    var classProObj =  $('#mytab').bootstrapTable('getSelections');
    if(classProObj.length>0){
        confirm("你确定删除该用户吗？");
        for(var  i=0;i<classProObj.length;i++){
                arr.push(classProObj[i].courseNo);
            }
            $.ajax({
                        type:'post',
                        url:'/class/deleteClassPro',
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
    console.log(classProObj);
});
$("#update").click(function(){
    $("#updateInfo").show();
    $("#course_no").attr("disabled","disabled");
    $("#commit").hide();
    if($('#mytab').bootstrapTable('getSelections').length==1){
         var updateClassPro =  $('#mytab').bootstrapTable('getSelections')[0];
         console.log(updateClassPro);
         $("#course_no").val(updateClassPro.courseNo);
         $("#course_type").val(updateClassPro.courseType);
         $("#course_name").val(updateClassPro.courseName);
         $("#course_class").val(updateClassPro.courseClass);
         $("#number").val(updateClassPro.studentNum);

    }else{
        confirm("请先选中一位要修改信息的用户！");
    }

$("#updateInfo").click(function(){
            var formDate={};
            formDate.courseNo=$("#course_no").val();
            formDate.courseType=$("#course_type").val();
            formDate.courseName=$("#course_name").val();
            formDate.courseClass=$("#course_class").val();
            formDate.studentNum=$("#number").val();
            console.log(formDate);
            $.ajax({
                type:'post',
                url:'/class/updateClassPro',
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
    $("#course_no").removeAttr("disabled");
    $("#updateInfo").hide();
    $("#commit").show();
    $("#course_no").val("");
    $("#course_type").val("");
    $("#course_name").val("");
    $("#course_class").val("");
    $("#number").val("");
});

    $("#commit").click(function(){
        var formDate={};
        formDate.courseNo=$("#course_no").val();
        formDate.courseType=$("#course_type").val();
        formDate.courseName=$("#course_name").val();
        formDate.courseClass=$("#course_class").val();
        formDate.studentNum=$("#number").val();
        console.log(formDate);
        $.ajax({
            type:'post',
            url:'/class/addClassPro',
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
