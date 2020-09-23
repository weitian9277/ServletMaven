package JDBC.service.impl;

import JDBC.dao.impl.OrderTableDaoImpl;
import JDBC.eneity.OrderTable;
import JDBC.service.OrderTableService;

import java.util.List;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class OrderTableServiceImp implements OrderTableService {
    OrderTableDaoImpl dao =   new OrderTableDaoImpl();
    @Override
    public int addOrderTableService(Object... params) {
        return dao.addOrderTableDao(params);
    }

    @Override
    public List<OrderTable> seeOrderTableService(int orderId, String buyerName) {
        return dao.seeOrderTableDao(orderId, buyerName);
    }

    @Override
    public int delOrderTableService(int orderId, String buyerName) {
        return dao.delOrderTableDao(orderId, buyerName);
    }
}
