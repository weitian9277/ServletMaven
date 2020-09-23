package JDBC.service.impl;

import JDBC.dao.impl.OrderDetailDaoImpl;
import JDBC.service.OrderDetailService;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class OrderDetailServiceImpl implements OrderDetailService {

    OrderDetailDaoImpl  orderDetailDao =   new OrderDetailDaoImpl();

    @Override
    public int addOrderDetailService(Object... params) {
        return orderDetailDao.addGoods(params);
    }
}
