package powertool.demo.Util;

//import zxs_service.wxmp.Pojo.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultObj<T> {
    private int code;       //是否成功调用
    private String msg;     //返回文字内容
    private HashMap<String,Object> content; //返回数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HashMap<String, Object> getContent() {
        return content;
    }

    public void setContent(HashMap<String, Object> content) {
        this.content = content;
    }

    public ResultObj() {
    }

    public ResultObj(int code, String msg, HashMap<String, Object> content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }
}
