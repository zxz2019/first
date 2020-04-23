package demo.pojo;

public class Goods {

    private Integer id;       // 主键id
    private String goodname; // 商品名称
    private String gooddescr;      // 商品描述
    private String goodprice;     // 商品价格

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public String getGooddescr() {
        return gooddescr;
    }

    public void setGooddescr(String gooddescr) {
        this.gooddescr = gooddescr;
    }

    public String getGoodprice() {
        return goodprice;
    }

    public void setGoodprice(String goodprice) {
        this.goodprice = goodprice;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodname='" + goodname + '\'' +
                ", gooddescr='" + gooddescr + '\'' +
                ", goodprice='" + goodprice + '\'' +
                '}';
    }
}
