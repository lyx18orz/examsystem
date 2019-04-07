package com.lyx.base.result;

import com.alibaba.fastjson.JSONObject;

public class ResultData {
    private JSONObject data=null;//传输的内容参数
    private String code;//指令通用返回状态码(Code)：0：指令执行成功1：指令格式有误2：服务端请求其他链接超时（如极光服务）3：校验失败4：Token过期5：指令不存在9：其他错误
    private String msg=null;//返回消息
    private String expin;//token过期时间,格式”yyyyMMddHHmmss”

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getExpin() {
        return expin;
    }

    public void setExpin(String expin) {
        this.expin = expin;
    }

}
