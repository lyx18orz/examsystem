window.onload = function () {
    var BusinessID = getQueryString("BusinessID");
    document.getElementById('BusinessID').value = BusinessID;
    BusLoginShow();
};
function BusLoginShow() {
    var BusinessID=document.getElementById('BusinessID').value;
    var Content = document.getElementById('Content').value;
    var PageNum = document.getElementById('PageNum').value;
    var PageSize = 6;
    var PutData = "PageNum=" + PageNum + "&PageSize=" + PageSize + "&Content=" + Content+"&BusinessID="+BusinessID;
    document.getElementById('tablebody').innerHTML = "";
    $.ajax({
        type: "post",
        url: url + "/busLogin/getBusinessLoginInfoList.action",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: PutData,
        dataType: "json",
        success: function (data) {
            var str = "";
            if (data.code == 0) {
                if (data.data.BusinessLoginInfo.length == 0) {
                    str = "无员工!";
                    msgDiv.insertAdjacentHTML("beforeEnd", str);
                } else {
                    jQuery.each(data.data.BusinessLoginInfo, function (i, list) {
                        str = str + '<tr>' +
                            '<td>' +
                            '<input type="checkbox" name="checkboxBtn" value="' + list.ID + '" onclick="checkboxBtn()"/>' +
                            '</td>' +
                            '<td>' + list.Account + '</td>' +
                            '<td>' + list.Password + '</td>' +
                            '<td>' + list.NickName + '</td>' +
                            '<td><img src=" ' + list.IconUrl + ' "width="50px" height="50px"/></td>' +
                            '<td>' + list.WechatID + '</td>' +
                            '<td>' +
                            '<button class=" btn-green btn-xs" onclick="GoUpdate(' + list.ID + ')">修改 </button>' +
                            '<button class="btn-green btn-xs" onclick="GoDetails(' + list.ID + ')">详情</button>' +
                            '<button class=" btn-danger btn-xs" onclick="ShowDeleteChar(' + list.ID + ')">删除</button>' +
                            '</td>' +
                            '</tr>' +
                            '<tr class="margin">' +
                            '<td colspan="6"></td></tr>';
                    });
                    str=str+'<tr><td><button class=" btn-danger btn-xs" onclick="DelAll()" >删除所选</button></td></tr>';
                    document.getElementById('tablebody').innerHTML = str;
                }
            }
            else {
                alert("ERROR:" + data.msg);
                return false;
            }
            // document.getElementById('BusinessName').value=data.data.BusinessName
            $("#BusinessName").append( data.data.BusinessName);
            document.getElementById('TotalRows').value = data.data.TotalRows;
            document.getElementById('TotalPages').value = data.data.TotalPages;
        }
        ,
        error: function () {
            tablebody.insertAdjacentHTML("beforeEnd", "服务器没有返回数据，可能服务器忙，请重试");
        }
    });
};
//尾页
function FirstPage() {
    var PageNum = "1";
    document.getElementById('PageNum').value = PageNum;
    BusLoginShow();
}
// 上一页
function PageUp() {
    var PageNum = document.getElementById('PageNum').value;
    if (PageNum == 1) {
        alert("已经是首页!");
        return false;
    }
    PageNum--;
    document.getElementById('PageNum').value = PageNum;
    BusLoginShow();
}

//下一页
function PageDown() {
    var PageNum = document.getElementById('PageNum').value;
    var TotalRows = document.getElementById('TotalRows').value;
    if (PageNum >= TotalRows) {
        alert("已经是最后一页!");
        return false;
    }
    PageNum++;
    document.getElementById('PageNum').value = PageNum;
    BusLoginShow();
}

//尾页
function LastPage() {
    var PageNum = document.getElementById('TotalRows').value;
    document.getElementById('PageNum').value = PageNum;
    BusLoginShow();
}
// 跳转页
function GoPage() {
    var PageNum = document.getElementById('PageNum').value;
    var TotalRows = document.getElementById('TotalRows').value;
    if(PageNum>TotalRows){
        alert("一共只有"+TotalRows+"页!");
        return false;
    }
    BusLoginShow();
}

//弹出删除框
function ShowDeleteChar(BusinessLoginID) {
    var mymessage = confirm("确定要删除该？删除后不可恢复！");
    if (mymessage) {
        ConfirmDel(BusinessLoginID);

    } else{
       return null;
    }
};

//确认删除
function ConfirmDel(BusinessLoginID) {
    var PutData = "BusinessLoginID="+BusinessLoginID;
    $.ajax({
        type: "POST",
        url: url+"/busLogin/deleteaBusinessInfoLogin.action",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: PutData,
        success: function (data) {
            if (data.code == 0) {
                BusLoginShow();
            } else {
                alert(data.msg);
            }
        },
        error: function () {
            alert("服务器出错!");
        }
    });
};

function confirmAdd() {
    var BusinessID = document.getElementById('BusinessID').value;
    var BusLoginAccount = document.getElementById('BusLoginAccount').value;
    var BusLoginPassword = document.getElementById('BusLoginPassword').value;

    if (!$.trim(BusLoginAccount)) {
        alert("帐号不能为空!");
        return false;
    }
    if (!$.trim(BusLoginPassword)) {
        alert("密码不能为空!");
        return false;
    }

    var BusLogin = "BusinessID=" + BusinessID + "&BusLoginAccount=" + BusLoginAccount + "&BusLoginPassword=" + BusLoginPassword;
    $.ajax({
        //提交类型
        type: "post",
        //这里的需要Struts.xml的<action/>的name属性一致。
        url: "busLogin_Add.action",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        //提交数据给Action传入数据
        data: BusLogin,
        success: function (data) {
            if (data.code == 0) {
                closeaddChar();
                Show(1);
            } else {
                alert(data.msg);
            }
        },
        error: function () {
            alert("ERROR!");
        }
    });
};
//删除所选
function DelAll() {
    var checkboxs = $("input[name='checkboxBtn']");
    var ids = new Array();
    for (var i = 0; i < checkboxs.length; i++) {
        if (checkboxs[i].checked == true) {
            ids.push(checkboxs[i].value);
        }
    }
    ShowDeleteChar(ids);
};
