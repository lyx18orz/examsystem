window.onload = function () {
    var BusinessID = getQueryString("BusinessID");
    document.getElementById('BusinessID').value = BusinessID;
    BusDetail();
};
function BusDetail() {
    var BusinessID = document.getElementById('BusinessID').value;
    var PutData="BusinessID="+BusinessID;
    $.ajax({
        //提交类型
        type: "post",
        //这里的需要Struts.xml的<action/>的name属性一致。
        url: url+"/bus/getBusinessInfoDetail",
        contentType: false,    //不设置Content-Type请求头
        processData: false,    // 不处理发送的数据
        data: PutData,
        //返回的数据类型
        dataType: "json",
        success: function (data) {
            if (data.code == 0) {
                document.getElementById('BusinessName').valu=data.data.BusinessInfo.BusinessName;
                document.getElementById('Phone').valu=data.data.BusinessInfo.Phone;
                document.getElementById('ShowUrl').valu=data.data.BusinessInfo.ShowUrl;
                document.getElementById('imgID').src=data.data.BusinessInfo.LogoUrl;
            } else {
                alert(data.msg);
                return false;
            }
        }, error: function () {
            alert("服务器没有返回数据，可能服务器忙，请重试");
        }
    });
};