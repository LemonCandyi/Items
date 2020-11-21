

$(document).ready(function () {
    selectKC();
    selectorder();
    fukuan();
    fahuo();
    selectItemName();
    // selectNumber();
    selectNumberInit();
    commitCRK();
    CRKcheck();

});

function selectKC() {
    $("#tab1>table>tbody").empty().append("<tr><th>货物名</th><th>货物编号</th><th>库存</th></tr>");
    $('#cxkc').click(
        function () {
            $("#tab1>table>tbody").empty().append("<tr><th>货物名</th><th>货物编号</th><th>库存</th></tr>");
            $.ajax({
                type: 'POST',
                url: '/selectAll',
                datatype: "json",
                success: function (data) {
                    console.log(data);
                    $("td").css("border","solid red 1px");
                    $.each(data,function (i,item) {
                        $("#tab1>table>tbody").append("<tr><td>"+item.item_name+"</td><td>"+item.item_no+"</td><td>"+item.number+"</td></tr>");
                    })
                }
            })
        });
}

function selectorder() {
    $("#tab2>table>tbody").empty().append("<tr><th><input type='checkbox' id='allcheck' class='checkall'/></th><th>订单编号</th></th><th>货物名</th>" +
        "<th>货物编号</th><th>收件人</th><th>收件人地址</th><th>收件人手机号</th><th>是否发货</th><th>是否付款</th></tr>");
    $("#select-order").click(function () {
        $("#tab2>table>tbody").empty().append("<tr><th><input type='checkbox'  id='allcheck' class='checkall'/></th><th>订单编号</th><th>货物名</th>" +
            "<th>货物编号</th><th>收件人</th><th>收件人地址</th><th>收件人手机号</th><th>是否发货</th><th>是否付款</th></tr>");
        $.ajax({
            type: 'POST',
            url: '/selectOrder',
            datatype: "json",
            success: function (data) {
                console.log(data);
                number = data.length;
                console.log(number);
                $("td").css("border","solid red 1px");
                $.each(data,function (i,item) {
                    $("#tab2>table>tbody").append("<tr><td><input type='checkbox' name='checkbox' class='checkall' value='"+item.order_no+"'/></td>><td>"+item.order_no+"</td><td>"+item.item_name+"</td><td>"+item.item_no+"</td><td>"+item.user_name+"</td><td>"+item.addr+"</td><td>"+item.tel+"</td><td>"+item.yn_fh+"</td><td>"+item.yn_sk+"</td></tr>");
                })
            }
        })
        $("#allcheck").click(function () {
            if($("#allcheck:checked").prop("checked")){
                $(".checkall").prop("checked",true);
            }else {
                $(".checkall").prop("checked",false);
            }
        })
    });
}

function fukuan() {
    $("#yfk").click(function () {
        var chk_value =[];
        $("input[name='checkbox']:checked").each(function(){
            chk_value.push($(this).val());
        });
        console.log(chk_value);
        if(chk_value.length==0){
            alert("你还没有选择任何内容！");
        }else if(confirm('确定选中订单已付款吗？')){
            $.ajax({
                url:"/fukuan",
                type:"POST",
                datatype:"text",
                contentType:"application/json",
                data:JSON.stringify({"num":chk_value}),
                success:function (data) {
                    switch (data) {
                        case "1":alert("OJBK了");
                        case "2":alert("你一次搞的有点多，建议刷新一下");
                        case "0":alert("失败了，刷新试试")
                    }
                }
            })
        }
    })
}

function fahuo() {
    $("#yfh").click(function () {
        var chk_value_fh =[];
        $("input[name='checkbox']:checked").each(function(){
            chk_value_fh.push($(this).val());
        });
        if(chk_value.length==0){
            alert("你还没有选择任何内容！");
        }else if(confirm('确定选中订单已付款吗？')){
            $.ajax({
                url:"/fukuan",
                type:"POST",
                datatype:"text",
                contentType:"application/json",
                data:JSON.stringify({"num":chk_value_fh}),
                success:function (data) {
                    switch (data) {
                        case "1":alert("OJBK了");
                        case "2":alert("你一次搞的有点多，建议刷新一下看看是否成功");
                        case "0":alert("失败了，刷新试试")
                    }
                }
            })
        }
    })
}

function selectItemName(){
    $.ajax({
        url:"/selectItemName",
        type:"POST",
        datatype:"text",
        success:function (data) {
            $.each(data,function (i,item_name) {
                $("#item_name").append("<option>"+item_name+"</option>");
            })
            selectNumber();
            selectNumberInit();
        }
    })
}

function selectNumberInit(){
    $("#item_name").change(function () {
        selectNumber();
        $("#change-number").val("");
        $("input[name='crk']:checked").prop("checked",false);
    });
}

function selectNumber(){
        $.ajax({
            url: "/selectItemNumber",
            type: "POST",
            datatype: "text",
            data: {"name":$("#item_name option:selected").text()},
            success: function (data) {
                $("#HaveNumber").empty().append(data);
            }
        })
    }
function CRKcheck() {
    $("#change-number").blur(function () {
        if(Number($("#change-number").val()) > Number($("#HaveNumber").text())){
            $("#showTips").text("嗨呀，你有辣么多货么你就出辣么多¿¿¿").css("display","block");
            $("#showTips").fadeIn();
            $("#hidden").css("display","none");
            setTimeout(function () {
                $("#showTips").fadeOut();
            },3000);
        }else if($("#change-number").val() < 0 ){
            $("#showTips").text("别填负数啊大哥").css("display","block");
            $("#showTips").fadeIn();
            $("#commitCRK").css("display","none");
            setTimeout(function () {
                $("#showTips").fadeOut();
            },3000);
        }else{
            $("#hidden").css("display","");
        }
    })
}

function commitCRK() {
    $("div[name=commitCRK]").click(function () {
        if($("#change-number").val() == '') {
            alert("你倒是输入变动数量啊");
            return "";
        }
        if($("input[name='crk']:checked").val() == null){
            alert("选出入库啊喂！")
            return "";
        }
            $.ajax({
                url:"/inOutBound",
                type:"POST",
                datatype:"text",
                contentType:"application/json",
                data:JSON.stringify({"crk":$("input[name='crk']:checked").val(),
                    "name":$("#item_name").val(),
                    "number":$("#change-number").val()
                }),
                beforeSend:function(){
                    console.log(JSON.stringify({"crk":$("input[name='crk']:checked").val(),
                        "name":$("#item_name").val(),
                        "number":$("#change-number").val(),
                    }));
                },
                success:function (data) {
                    console.log(data);
                    switch (data) {
                        case "1":alert("OJBK，出/入库成功");
                        break;
                        case "error":alert("出问题了，，刷新试试吧")
                    }
                }
            })
    })
}

//todo 变动数量js与后端