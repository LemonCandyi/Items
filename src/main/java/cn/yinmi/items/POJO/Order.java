package cn.yinmi.items.POJO;

public class Order {
    private int order_no;
    private int item_no;
    private String item_name;
    private String user_name;
    private String tel;
    private String addr;
    private String yn_fh;
    private String yn_sk;

    public int getItem_no() {
        return item_no;
    }

    public void setItem_no(int item_no) {
        this.item_no = item_no;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getYn_fh() {
        return yn_fh;
    }

    public void setYn_fh(String yn_fh) {
        this.yn_fh = yn_fh;
    }

    public String getYn_sk() {
        return yn_sk;
    }

    public void setYn_sk(String yn_sk) {
        this.yn_sk = yn_sk;
    }

    public int getOrder_no() {
        return order_no;
    }

    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }
}
