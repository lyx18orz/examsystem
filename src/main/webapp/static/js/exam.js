window.onload = function () {
    Show();
};


function Start() {
    document.getElementById("formStart").style.display = "none";
    document.getElementById("DivTable").style.display = "block";
}
function Show() {
    document.getElementById('tablebody').innerHTML = "";
    $.ajax({
        type: "get",
        url: url + "/clientTopic/getTopicInfoList",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json",
        success: function (data) {
            var str = "";
            var but = "";
            if (data.code == 0) {
                if (data.data.TopicInfo.length == 0) {
                    str = "无商家!";
                    msgDiv.innerHTML = str;
                } else {
                    jQuery.each(data.data.TopicInfo, function (i, list) {
                        if (i == 0) {
                            str = str + '<div id="Div' + (i + 1) + '" style="display: block"><from ><table border="4" >';
                        } else {
                            str = str + '<div id="Div' + (i + 1) + '" style="display: none"><from><table border="4" >';
                        }
                        str = str + '<tr><td colspan="2" align="left">' + (i + 1) + '.' + list.Title + '(' + list.Type + ')</td></tr>' +
                            '<tr><td>选项:</td><td></td></tr>';
                        if (list.Type == '单选题') {
                            if (list.OptionA != "") {
                                str = str + '<tr><td><input type="radio" onclick="Radio(' + list.ID + ')" name="radio' + list.ID + '" value="A"></td><td>A.' + list.OptionA + '</td></tr>';
                            }
                            if (list.OptionB != "") {
                                str = str + '<tr><td><input type="radio" onclick="Radio(' + list.ID + ')"name="radio' + list.ID + '" value="B"></td><td>B.' + list.OptionB + '</td></tr>';
                            }
                            if (list.OptionC != "") {
                                str = str + '<tr><td><input type="radio"onclick="Radio(' + list.ID + ')" name="radio' + list.ID + '" value="C"></td><td>C.' + list.OptionC + '</td></tr>';
                            }
                            if (list.OptionD != "") {
                                str = str + '<tr><td><input type="radio" onclick="Radio(' + list.ID + ')" name="radio' + list.ID + '" value="D"></td><td>D.' + list.OptionD + '</td></tr>';
                            }
                        }
                        if (list.Type == '多选题') {
                            if (list.OptionA != "") {
                                str = str + '<tr><td><input type="checkbox" onclick="Checkbox(' + list.ID + ')"name="checkbox' + list.ID + '" value="A"></td><td>A.' + list.OptionA + '</td></tr>';
                            }
                            if (list.OptionB != "") {
                                str = str + '<tr><td><input type="checkbox" onclick="Checkbox(' + list.ID + ')"name="checkbox' + list.ID + '" value="B"></td><td>B.' + list.OptionB + '</td></tr>';
                            }
                            if (list.OptionC != "") {
                                str = str + '<tr><td><input type="checkbox" onclick="Checkbox(' + list.ID + ')"name="checkbox' + list.ID + '" value="C"></td><td>C.' + list.OptionC + '</td></tr>';
                            }
                            if (list.OptionD != "") {
                                str = str + '<tr><td><input type="checkbox" onclick="Checkbox(' + list.ID + ')"name="checkbox' + list.ID + '" value="D"></td><td>D.' + list.OptionD + '</td></tr>';
                            }
                            if (list.OptionE != "") {
                                str = str + '<tr><td><input type="checkbox" onclick="Checkbox(' + list.ID + ')"name="checkbox' + list.ID + '" value="E"></td><td>E.' + list.OptionE + '</td></tr>';
                            }
                            if (list.OptionF != "") {
                                str = str + '<tr><td><input type="checkbox" onclick="Checkbox(' + list.ID + ')"name="checkbox' + list.ID + '" value="F"></td><td>F.' + list.OptionF + '</td></tr>';
                            }
                        }
                        if (list.Type == '判断题') {
                            if (list.OptionA != "") {
                                str = str + '<tr><td><input type="radio" onclick="Judge(' + list.ID + ')"name="judge' + list.ID + '" value="A"></td><td>' + list.OptionA + '</td></tr>';
                            }
                            if (list.OptionB != "") {
                                str = str + '<tr><td><input type="radio" onclick="Judge(' + list.ID + ')"name="judge' + list.ID + '" value="B"></td><td>' + list.OptionB + '</td></tr>';
                            }
                        }
                        str = str + '</table></form></div>';
                        but = but + '<button  id="But' + list.ID + '" onclick="GoTopic(' + (i + 1) + ')" >' + (i + 1) + '</button>';
                    });
                    // alert(str)
                    $('#tablebody').html(str);
                    $('#But').html(but);
                    // document.getElementById('tablebody');
                }
            }
            else {
                alert("ERROR:" + data.msg);
                // msgDiv.insertAdjacentHTML("beforeEnd", data.msg);
                return false;
            }
        }
        ,
        error: function () {
            tablebody.insertAdjacentHTML("beforeEnd", "服务器没有返回数据，可能服务器忙，请重试");
        }
    });
};


// 上一页
function Up() {
    var ModalID = document.getElementById('ModalID').value;
    if (ModalID == 1) {
        alert("已经是第一题!");
        return false;
    }
    document.getElementById("Div" + ModalID).style.display = "none";
    ModalID--;
    document.getElementById('ModalID').value = ModalID;
    document.getElementById("Div" + ModalID).style.display = "block";
};

//下一页
function Down() {
    var ModalID = document.getElementById('ModalID').value;
    if (ModalID >= 100) {
        alert("已经是最后一题!");
        return false;
    }
    document.getElementById("Div" + ModalID).style.display = "none";
    ModalID++;
    document.getElementById('ModalID').value = ModalID;
    document.getElementById("Div" + ModalID).style.display = "block";
};

// 跳转页
function GoTopic(i) {
    var ModalID = document.getElementById('ModalID').value;
    document.getElementById("Div" + ModalID).style.display = "none";
    document.getElementById('ModalID').value = i;
    document.getElementById("Div" + i).style.display = "block";
};

function Radio(i) {
    // alert(i);
    var val = $('input:radio[name="radio' + i + '"]:checked').val();
    // alert(val);
    if (val == null) {
        document.getElementById("But" + i).style.background = "";
        return false;
    }
    else {
        document.getElementById("But" + i).style.background = "red";
    }
};

function Checkbox(i) {
    // alert(i);
    var val = $('input:checkbox[name="checkbox' + i + '"]:checked').val();
    // alert(val);
    if (val == null) {
        document.getElementById("But" + i).style.background = "";
        return false;
    }
    else {
        document.getElementById("But" + i).style.background = "red";
    }
};

function Judge(i) {
    // alert(i);
    var val = $('input:radio[name="judge' + i + '"]:checked').val();
    // alert(val);
    if (val == null) {
        document.getElementById("But" + i).style.background = "";
        return false;
    }
    else {
        document.getElementById("But" + i).style.background = "red";
    }
};


// function Submit() {
//     document.getElementById('tablebody').innerHTML = "";
//     $.ajax({
//         type: "get",
//         url: url + "/clientTopic/getTopicInfoList",
//         contentType: "application/x-www-form-urlencoded; charset=utf-8",
//         dataType: "json",
//         success: function (data) {
//             var str = "";
//             var but = "";
//             if (data.code == 0) {
//                 if (data.data.TopicInfo.length == 0) {
//                     str = "无商家!";
//                     msgDiv.innerHTML = str;
//                 } else {
//                     jQuery.each(data.data.TopicInfo, function (i, list) {
//                         if (i == 0) {
//                             str = str + '<div id="Div' + (i + 1) + '" style="display: block"><from><table border="4">';
//                         } else {
//                             str = str + '<div id="Div' + (i + 1) + '" style="display: none"><from><table border="4">';
//                         }
//                         str = str + '<tr><td colspan="2" align="left">' + (i + 1) + '.' + list.Title + '(' + list.Type + ')</td></tr>' +
//                             '<tr><td>选项:</td><td></td></tr>';
//                         if (list.Type == '单选题') {
//                             if (list.OptionA != "") {
//                                 str = str + '<tr><td><input type="radio" onclick="Radio(' + list.ID + ')" name="radio' + list.ID + '" value="A"></td><td>A.' + list.OptionA + '</td></tr>';
//                             }
//                             if (list.OptionB != "") {
//                                 str = str + '<tr><td><input type="radio" onclick="Radio(' + list.ID + ')"name="radio' + list.ID + '" value="B"></td><td>B.' + list.OptionB + '</td></tr>';
//                             }
//                             if (list.OptionC != "") {
//                                 str = str + '<tr><td><input type="radio"onclick="Radio(' + list.ID + ')" name="radio' + list.ID + '" value="C"></td><td>C.' + list.OptionC + '</td></tr>';
//                             }
//                             if (list.OptionD != "") {
//                                 str = str + '<tr><td><input type="radio" onclick="Radio(' + list.ID + ')" name="radio' + list.ID + '" value="D"></td><td>D.' + list.OptionD + '</td></tr>';
//                             }
//                         }
//                         if (list.Type == '多选题') {
//                             if (list.OptionA != "") {
//                                 str = str + '<tr><td><input type="checkbox" onclick="Checkbox(' + list.ID + ')"name="checkbox' + list.ID + '" value="A"></td><td>A.' + list.OptionA + '</td></tr>';
//                             }
//                             if (list.OptionB != "") {
//                                 str = str + '<tr><td><input type="checkbox" onclick="Checkbox(' + list.ID + ')"name="checkbox' + list.ID + '" value="B"></td><td>B.' + list.OptionB + '</td></tr>';
//                             }
//                             if (list.OptionC != "") {
//                                 str = str + '<tr><td><input type="checkbox" onclick="Checkbox(' + list.ID + ')"name="checkbox' + list.ID + '" value="C"></td><td>C.' + list.OptionC + '</td></tr>';
//                             }
//                             if (list.OptionD != "") {
//                                 str = str + '<tr><td><input type="checkbox" onclick="Checkbox(' + list.ID + ')"name="checkbox' + list.ID + '" value="D"></td><td>D.' + list.OptionD + '</td></tr>';
//                             }
//                             if (list.OptionE != "") {
//                                 str = str + '<tr><td><input type="checkbox" onclick="Checkbox(' + list.ID + ')"name="checkbox' + list.ID + '" value="E"></td><td>E.' + list.OptionE + '</td></tr>';
//                             }
//                             if (list.OptionF != "") {
//                                 str = str + '<tr><td><input type="checkbox" onclick="Checkbox(' + list.ID + ')"name="checkbox' + list.ID + '" value="F"></td><td>F.' + list.OptionF + '</td></tr>';
//                             }
//                         }
//                         if (list.Type == '判断题') {
//                             if (list.OptionA != "") {
//                                 str = str + '<tr><td><input type="radio" onclick="Judge(' + list.ID + ')"name="judge' + list.ID + '" value="A"></td><td>' + list.OptionA + '</td></tr>';
//                             }
//                             if (list.OptionB != "") {
//                                 str = str + '<tr><td><input type="radio" onclick="Judge(' + list.ID + ')"name="judge' + list.ID + '" value="B"></td><td>' + list.OptionB + '</td></tr>';
//                             }
//                         }
//                         str = str + '</table></form></div>';
//                         but = but + '<button  id="But' + list.ID + '" onclick="GoTopic(' + (i + 1) + ')" >' + (i + 1) + '</button>';
//                     });
//                     // alert(str)
//                     $('#tablebody').html(str);
//                     $('#But').html(but);
//                     // document.getElementById('tablebody');
//                 }
//             }
//             else {
//                 alert("ERROR:" + data.msg);
//                 // msgDiv.insertAdjacentHTML("beforeEnd", data.msg);
//                 return false;
//             }
//         }
//         ,
//         error: function () {
//             tablebody.insertAdjacentHTML("beforeEnd", "服务器没有返回数据，可能服务器忙，请重试");
//         }
//     });
// };



