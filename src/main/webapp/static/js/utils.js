var storage = window.sessionStorage;

function getRootPath_web() {
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return (localhostPaht + projectName);
}

var url = getRootPath_web();

// 获取URL里的参数
function getQueryString(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
};

function Go(method, parameter) {
    // alert(method);
    window.location.href = url + method + "?" + parameter;//重定向转跳页面
};

function ExitLogin() {
    window.location.href = url + "/login/exit.action";
};

function checkboxBtn() {
    var checkboxAll = document.getElementById('checkboxAll');
    var all = $("input[name='checkboxBtn']").length;//所有条目的个数
    var select = $("input[name='checkboxBtn']:checked").length;//获取所有被选择条目的个数
    if (all == select) {//全都选中了
        checkboxAll.checked = true;//勾选全选复选框,这里不支持
    } else if (select == 0) {//谁都没有选中
        checkboxAll.checked = false;//取消全选,这里不支持
    } else {
        checkboxAll.checked = false;//取消全选,这里不支持
    }
};

function checkbox() {
    var checkboxAll = document.getElementById('checkboxAll');
    var checkboxs = $("input[name='checkboxBtn']");
    var ids = new Array();
    for (var i = 0; i < checkboxs.length; i++) {
        checkboxs[i].checked = checkboxAll.checked;
    }
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
    $("#DelId").val(ids);
    $("#DeleteModal").modal();
};
