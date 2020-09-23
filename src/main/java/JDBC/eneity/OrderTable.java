package JDBC.eneity;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class OrderTable {
    private int id;
    private String orderId;
    private String orderStatus;
    private String paymentStatus;
    private String zMoney;
    private String updateTime;
    private String creationTime;
    private String buyerAddress;
    private String buyerTel;
    private String buyerName;
    private String b1;
    private String b2;
    private String b3;

    public OrderTable() {
    }

    public OrderTable(int id, String orderId, String orderStatus, String paymentStatus, String zMoney, String updateTime, String creationTime, String buyerAddress, String buyerTel, String buyerName, String b1, String b2, String b3) {
        this.id = id;
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.zMoney = zMoney;
        this.updateTime = updateTime;
        this.creationTime = creationTime;
        this.buyerAddress = buyerAddress;
        this.buyerTel = buyerTel;
        this.buyerName = buyerName;
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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getzMoney() {
        return zMoney;
    }

    public void setzMoney(String zMoney) {
        this.zMoney = zMoney;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerTel() {
        return buyerTel;
    }

    public void setBuyerTel(String buyerTel) {
        this.buyerTel = buyerTel;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
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
        return "Order{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", zMoney='" + zMoney + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", buyerAddress='" + buyerAddress + '\'' +
                ", buyerTel='" + buyerTel + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", b1='" + b1 + '\'' +
                ", b2='" + b2 + '\'' +
                ", b3='" + b3 + '\'' +
                '}';
    }
}
