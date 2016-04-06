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
public class Entity {


    /**
     * Id : 11
     * Pics : category/11/category/20160120135504891970.img
     * Name : 时鲜蔬果
     * Color : #000000
     * Status : 1
     */

    private int Id;
    private String Pics;
    private String Name;
    private String Color;
    private int    Status;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getPics() {
        return Pics;
    }

    public void setPics(String Pics) {
        this.Pics = Pics;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
}
