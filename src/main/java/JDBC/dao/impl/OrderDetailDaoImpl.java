package JDBC.dao.impl;

import JDBC.dao.OrderDetailDao;
import JDBC.utile.DruidUtile;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class OrderDetailDaoImpl implements OrderDetailDao {

    QueryRunner qr =  new QueryRunner(DruidUtile.getDataSource());
    @Override
    public int addGoods(Object... params) {
        try {
            return qr.update("insert into orderdetails(" +
                    "orderId," +     //订单编号
                    "goodsNum," +  // 商品数量
                    "goodsImg," +  //商品图片
                    "goodsPrice," +  //商品价格
                    "goodsName," +  //商品名称
                    "goodsId" +  //商品id
//                    "orderId" +
//                    "orderId" +
//                    "orderId" +
                    ") VALUES (?,?,?,?,?,?)", params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
