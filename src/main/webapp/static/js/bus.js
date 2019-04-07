window.onload = function () {
    BusShow();
};

function BusShow() {
    // alert(url);
    // var TotalRows = document.getElementById('TotalRows').value;
    var Content = document.getElementById('Content').value;
    var PageNum = document.getElementById('PageNum').value;
    var PageSize = 6;
    var PutData = "PageNum=" + PageNum + "&PageSize=" + PageSize + "&Content=" + Content;
    document.getElementById('tablebody').innerHTML = "";
    $.ajax({
        type: "post",
        url: url + "/bus/getBusinessInfoList.action",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: PutData,
        dataType: "json",
        success: function (data) {
            var str = "";
            if (data.code == 0) {
                if (data.data.BusinessInfo.length == 0) {
                    str = "无商家!";
                    msgDiv.innerHTML = str;
                } else {
                    jQuery.each(data.data.BusinessInfo, function (i, list) {
                        str = str + '<tr>' +
                            '<td>' +
                            '<input type="checkbox" name="checkboxBtn" value="' + list.ID + '" onclick="checkboxBtn()"/>' +
                            '</td>' +
                            '<td>' + list.BusinessName + '</td>' +
                            '<td>' + list.Phone + '</td>' +
                            '<td>' + list.CreateTime + '</td>' +
                            '<td>' +
                            '<button class=" btn-green btn-xs" onclick="ShowUpdateModal(' + list.ID + ')" >修改 </button>' +
                            '<button class="btn-green btn-xs" onclick="ShowDetailModal(' + list.ID + ')" >详情</button>' +
                            '<button class=" btn-danger btn-xs" onclick="ShowDeleteModal(' + list.ID + ')" >删除</button>' +
                            '</td>' +
                            '<td>' +
                            '<button class=" btn-yellow btn-xs" onclick="GoBusLogin(' + list.ID + ')" > 查看员工 </button>' +
                            ' <button class="btn-yellow btn-xs" onclick="GoWollarTicket(' + list.ID + ')"> 查看网乐票 </button>' +
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
                // msgDiv.insertAdjacentHTML("beforeEnd", data.msg);
                return false;
            }
            document.getElementById('TotalRows').value = data.data.TotalRows;
            document.getElementById('TotalPages').value = data.data.TotalPages;
            // document.getElementById('span').value = data.data.TotalPages;
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
    BusShow();
};

// 上一页
function PageUp() {
    var PageNum = document.getElementById('PageNum').value;
    if (PageNum == 1) {
        alert("已经是首页!");
        return false;
    }
    PageNum--;
    document.getElementById('PageNum').value = PageNum;
    BusShow();
};

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
    BusShow();
};

//尾页
function LastPage() {
    var PageNum = document.getElementById('TotalRows').value;
    document.getElementById('PageNum').value = PageNum;
    BusShow();
};

// 跳转页
function GoPage() {
    var PageNum = document.getElementById('PageNum').value;
    var TotalRows = document.getElementById('TotalRows').value;
    if (PageNum > TotalRows) {
        alert("一共只有" + TotalRows + "页!");
        return false;
    }
    BusShow();
};

function GoBusLogin(BusinessID) {
    var mothend = "/busLogin.html";
    var parameter = "BusinessID=" + BusinessID;
    Go(mothend, parameter);
};

function GoWollarTicket(BusinessID) {
    var mothend = "/wollaTicket.html";
    var parameter = "BusinessID=" + BusinessID;
    Go(mothend, parameter);
};

//弹出删除框
function ShowDeleteModal(BusinessID) {
    // alert(BusinessID)
    $("#DelId").val(BusinessID);
    $("#DeleteModal").modal();
};

//确认删除
function ConfirmDel() {
    var BusinessID = document.getElementById("DelID").value;
    var PutData = "BusinessID=" + BusinessID;
    $.ajax({
        type: "POST",
        url: url + "/bus/deleteBusinessInfo.action",
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

function AddPreview(file) {
    if (file.files && file.files[0]) {
        var reader = new FileReader();
        reader.onload = function (evt) {
            document.getElementById('AddImgID').src = evt.target.result;

            // prevDiv.innerHTML = '<img src="' + evt.target.result + '" width="100px" height="100px"/>';
        }
        reader.readAsDataURL(file.files[0]);
    } else {
        return false;
        // prevDiv.innerHTML = '<div class="img"  style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
    }
};

function BusAdd() {
    var AddBusinessName = document.getElementById("AddBusinessName").value;
    var AddPhone = document.getElementById("AddPhone").value;
    var AddFile = document.getElementById("AddFile").files[0];
    var PutData = new FormData(document.getElementById("BusAddForm"));
    if (!$.trim(AddBusinessName)) {
        alert("帐号不能为空!")
        return false;
    }
    if (!$.trim(AddPhone)) {
        alert("密码不能为空!")
        return false;
    }
    if (!$.trim(AddFile)) {
        alert("头像不能为空!")
        return false;
    }
    $.ajax({
        //提交类型
        type: "post",
        //这里的需要Struts.xml的<action/>的name属性一致。
        url: url + "/bus/saveBusinessInfo",
        contentType: false,    //不设置Content-Type请求头
        processData: false,    // 不处理发送的数据
        data: PutData,
        //返回的数据类型
        dataType: "json",
        success: function (data) {
            if (data.code == 0) {
                alert("成功!");
                window.location.href = url + "/bus.html";
            } else {
                alert(data.msg);
                return false;
            }
        }, error: function () {
            alert("服务器没有返回数据，可能服务器忙，请重试");
        }
    });
};
function ShowDetailModal(BusinessID) {
    var PutData = "BusinessID="+BusinessID;
    $.ajax({
        //提交类型
        type: "post",
        //这里的需要Struts.xml的<action/>的name属性一致。
        url: url + "/bus/getBusinessInfoDetail",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: PutData,
        //返回的数据类型
        dataType: "json",
        success: function (data) {
            if (data.code == 0) {
                document.getElementById('DetailBusinessName').value=data.data.BusinessInfo.BusinessName;
                 document.getElementById('DetailPhone').value=data.data.BusinessInfo.Phone;
                document.getElementById("DetailShowUrl").value=data.data.BusinessInfo.ShowUrl;
                document.getElementById("DetailImgID").value=data.data.BusinessInfo.LogoUrl;
                document.getElementById("DetailCreateTime").value=data.data.BusinessInfo.CreateTime;
                document.getElementById('DetailImgID').src=data.data.BusinessInfo.LogoUrl;
                $('#DetailModal').modal();
            } else {
                alert(data.msg);
                return false;
            }
        }, error: function () {
            alert("服务器没有返回数据，可能服务器忙，请重试");
        }
    });
};
function UpdatePreview(file) {
    if (file.files && file.files[0]) {
        var reader = new FileReader();
        reader.onload = function (evt) {
            document.getElementById('UpdateImgID').src = evt.target.result;

            // prevDiv.innerHTML = '<img src="' + evt.target.result + '" width="100px" height="100px"/>';
        }
        reader.readAsDataURL(file.files[0]);
    } else {
        return false;
        // prevDiv.innerHTML = '<div class="img"  style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
    }
};
function ShowUpdateModal(BusinessID) {
    var PutData = "BusinessID="+BusinessID;
    $.ajax({
        //提交类型
        type: "post",
        //这里的需要Struts.xml的<action/>的name属性一致。
        url: url + "/bus/getBusinessInfoDetail",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: PutData,
        //返回的数据类型
        dataType: "json",
        success: function (data) {
            if (data.code == 0) {
                document.getElementById('UpdateBusinessName').value=data.data.BusinessInfo.BusinessName;
                document.getElementById('UpdatePhone').value=data.data.BusinessInfo.Phone;
                document.getElementById("UpdateShowUrl").value=data.data.BusinessInfo.ShowUrl;
                document.getElementById('UpdateImgID').src=data.data.BusinessInfo.LogoUrl;
                $('#UpdateModal').modal();
            } else {
                alert(data.msg);
                return false;
            }
        }, error: function () {
            alert("服务器没有返回数据，可能服务器忙，请重试");
        }
    });
};