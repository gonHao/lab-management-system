$("#delete").click(function (){
    $.ajax({
        type:'get',
        url:'/tTable/deleteClass',
        data:{id:classInfo.id},
        contentType: "application/json;charset=UTF-8;",
        dataType:'text',
        success:function(data){
           alert(data);
           onChange();
        },
        error:function(){
            alert("发生未知错误");
        }
    });
});
$("#addClassB").click(function (){
    console.log("新增刷新模态框");
     $("#weekDiv").show();
     $("#commit").show();
     $("#delete").hide();
     $("#classroom").val("");
     $("#classNm").val("");
     $("#beginWeek").val("");
     $("#endWeek").val("");
     $("#day").val("");
     $("#beginTime").val("");
     $("#endTime").val("");
     $("#profClass").val("");
     $("#teacher").val("");
});


$("#commit").click(function (){
    var addClassInfo={};
        addClassInfo.classroomNo=$("#classroom").val(),
        addClassInfo.classNm=$("#classNm").val(),
        addClassInfo.beginWeek=$("#beginWeek").val(),
        addClassInfo.endWeek=$("#endWeek").val(),
        addClassInfo.day=$("#day").val(),
        addClassInfo.beginTime=$("#beginTime").val(),
        addClassInfo.endTime=$("#endTime").val(),
        addClassInfo.profClass=$("#profClass").val();
        addClassInfo.teacher=$("#teacher").val();
    console.log(addClassInfo);
    $.ajax({
        type:'post',
        url:'/tTable/addClass',
        data:JSON.stringify(addClassInfo),
        contentType: "application/json;charset=UTF-8;",
        dataType:'text',
        success:function(data){
           alert(data);
           onChange();
        },
        error:function(){
            alert("发生未知错误");
        }
    });
});