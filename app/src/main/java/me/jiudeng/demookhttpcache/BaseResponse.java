package me.jiudeng.demookhttpcache;

/**
 * @Project DemoOkHttpCache
 * @Packate me.jiudeng.demookhttpcache
 * @Author yulongsun
 * @Email yulongsun@gmail.com
 * @Date 2016/4/6
 * @Version 1.0.0
 * @Description
 */
public class BaseResponse {


    /**
     * Code : 0
     * Message :
     * Data : [{"Id":11,"Pics":"category/11/category/20160120135504891970.img","Name":"时鲜蔬果","Color":"#000000","Status":1},{"Id":13,"Pics":"category/13/category/20160122173909358986.img","Name":"肉类禽蛋","Color":"#000000","Status":1},{"Id":14,"Pics":"category/14/category/20160122173921890887.img","Name":"加工食品","Color":"#000000","Status":1},{"Id":15,"Pics":"category/15/category/20160122173935354579.img","Name":"速冻食品","Color":"#000000","Status":1},{"Id":12,"Pics":"category/12/category/20160122173855653351.img","Name":"粮油调味","Color":"#000000","Status":1},{"Id":16,"Pics":"category/16/category/20160120135659420292.img","Name":"不可用分类","Color":"#000000","Status":2},{"Id":17,"Pics":"category/17/category/20160120135705213019.img","Name":"不可用分类","Color":"#000000","Status":2},{"Id":18,"Pics":"category/18/category/20160120135710668038.img","Name":"不可用分类","Color":"#000000","Status":2}]
     */

    private int Code;
    private String Message;
    private String Data;

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }
}
