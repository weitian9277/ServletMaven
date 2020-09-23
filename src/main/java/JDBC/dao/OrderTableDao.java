package JDBC.dao;

import JDBC.eneity.OrderTable;

import java.util.List;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public interface OrderTableDao {
    //新增订单
    int addOrderTableDao(Object... params);

    //查询订单  跟据订单id，或者用户名
    List<OrderTable> seeOrderTableDao(int orderId, String buyerName);


    //删除订单   跟据订单id  和 用户名
    int delOrderTableDao(int orderId, String buyerName);























}
