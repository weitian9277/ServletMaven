package JDBC.eneity;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class OrderDetail {
    private  int id;
    private  String  orderId;
    private  int goodsNum;
    private  String  goodsImg;
    private  String  goodsPrice;
    private  String  goodsName;
    private  String  goodsId;
    private  String  b1;
    private  String  b2;
    private  String  b3;

    public OrderDetail() {
    }

    public OrderDetail(int id, String orderId, int goodsNum, String goodsImg, String goodsPrice, String goodsName, String goodsId, String b1, String b2, String b3) {
        this.id = id;
        this.orderId = orderId;
        this.goodsNum = goodsNum;
        this.goodsImg = goodsImg;
        this.goodsPrice = goodsPrice;
        this.goodsName = goodsName;
        this.goodsId = goodsId;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    public String getB3() {
        return b3;
    }

    public void setB3(String b3) {
        this.b3 = b3;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", goodsNum=" + goodsNum +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", b1='" + b1 + '\'' +
                ", b2='" + b2 + '\'' +
                ", b3='" + b3 + '\'' +
                '}';
    }
}
