package JDBC.service;

import JDBC.eneity.OrderTable;

import java.util.List;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public interface OrderTableService {

    //添加订单
    int addOrderTableService(Object... params);

    //查看订单
    List<OrderTable> seeOrderTableService(int orderId, String buyerName);


    //删除订单   跟据订单id  和 用户名
    int delOrderTableService(int orderId, String buyerName);
}
