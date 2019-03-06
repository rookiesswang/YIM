package top.learn.common;

import lombok.Data;

@Data
public class IMResult {

    //code 0 代表成功 其它为失败
    private Integer code;
    //失败信息
    private String msg;

    private Object data;

}
