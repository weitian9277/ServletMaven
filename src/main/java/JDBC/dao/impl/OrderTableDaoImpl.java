package JDBC.dao.impl;

import JDBC.dao.OrderTableDao;
import JDBC.eneity.OrderTable;
import JDBC.utile.DruidUtile;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class OrderTableDaoImpl implements OrderTableDao {
     QueryRunner qr =  new QueryRunner(DruidUtile.getDataSource());
    @Override
    public int addOrderTableDao(Object... params) {

        try {
            return qr.update("insert into orderTable(" +
                    "orderId," +     //订单编号
                    "orderStatus," +  // 订单状态
                    "paymentStatus," +  //支付状态
                    "zMoney," +  //总金额
                    "updateTime," +  //更新时间
                    "creationTime," +  //买家地址
                    "buyerAddress," +  //订单编号
                    "buyerTel," + //买家电话
                    "buyerName" + //买家名称
//                    "orderId" +
//                    "orderId" +
//                    "orderId" +
                    ") VALUES (?,?,?,?,?,?,?,?,?)", params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public List<OrderTable> seeOrderTableDao(int orderId, String buyerName) {
        try {
            if(orderId <= 0){
                return  qr.query("select  * from  orderTable where  orderId = ?", new BeanListHandler<OrderTable>(OrderTable.class),orderId);
            }else {
                return  qr.query("select  * from  orderTable where  buyerName = ?", new BeanListHandler<OrderTable>(OrderTable.class),buyerName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delOrderTableDao(int orderId,String buyerName) {
        try {
            if(orderId <= 0){
                return   qr.update("delete FROM orderTable where orderId = ?", orderId);
            }else {
                return   qr.update("delete FROM orderTable where buyerName = ?", buyerName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
