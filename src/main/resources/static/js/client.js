$(document).ready(function () {
    check();
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
        let name=$("#item option:selected").text();
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
        let temp = "item:"+$("[name=\"item\"]").val()+",name:"+$("[name=\"name\"]").val()+",tel:"+$("[name=\"tel\"]").val()+",addr:"+$("[name=\"addr\"]").val();
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

function check() {
    $("input").blur(function () {
        if(checkone($("[name=name]"),"请填写收件人姓名")){
            return null;
        }
        if(checkone($("[name=tel]"),"请填写手机号")){
            return null;
        }
        if(checkone($("[name=addr]"),"请填写收件地址")){
            return null;
        }
        $("#submit").css("display","block");
    });
}

function checkone(obj,msg) {
    let temp = obj.val();
    if(temp == ""){
        alert(msg);
        return true;
    }else {
        return false;
    }
}
function isEmpty(obj) {
    let temp = obj.val();
    return temp.length > 0 ? true : false;
}
