package cn.itsource.until;

import lombok.Data;

@Data
public class JsonReslut {
    private boolean success=true;
    private String msg="操作成功";
    public JsonReslut(){
    }
    public JsonReslut(boolean success,String msg){
        this.success=success;
        this.msg=msg;
    }

}
