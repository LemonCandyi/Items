$(document).ready(function () {
    $("#itm").empty();
    $.ajax({
        url: "/selectItemName",
        type: "POST",
        datatype: "json",
        success: function (data) {
            $.each(data,function (i,item) {
                $("#item").append("<option id='item'>"+item+"</option>");
            })
        }
    }
    )

    $("#item").blur(function () {
        var name=$("#item option:selected").text();
        $.ajax({
            url: "/selectItemNumber",
            type: "POST",
            datatype: "text",
            data: {"name":name},
            beforeSend:function(){
              console.log(name);
            },
            success: function (data) {
                $("#number").empty().append(data);
            }
        })
    })

    $("#submit").click(function () {
        var temp = "item:"+$("[name=\"item\"]").val()+",name:"+$("[name=\"name\"]").val()+",tel:"+$("[name=\"tel\"]").val()+",addr:"+$("[name=\"addr\"]").val();
        console.log(temp)
        // temp = "{"+temp+"}";
        // console.log(temp);
        $.ajax({
            url:"/commitForm",
            type:"POST",
            datatype:"text",
            data:{data:temp},
            beforeSend:function () {
                console.log(temp)
            },
            success:function (data) {
                if(data=="1"){
                    alert("提交成功，请找尹咪付钱");
                }else{
                    alert("提交失败，请重试");
                }
            }
        })
    })
})