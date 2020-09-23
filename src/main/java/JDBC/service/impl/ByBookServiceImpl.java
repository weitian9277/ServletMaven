package JDBC.service.impl;

import JDBC.dao.impl.ByBookDaoImp;
import JDBC.eneity.ByBook;
import JDBC.service.ByBookService;

import java.util.List;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class ByBookServiceImpl implements ByBookService {
    ByBookDaoImp byBookDaoImp =  new ByBookDaoImp();
    @Override
    public int addByBook(Object[] params) {
        return byBookDaoImp.ByBookAdd(params);
    }

    @Override
    public List<ByBook> selectNameBoo(int id) {
        return  byBookDaoImp.selectNameBoo(id);
    }

    @Override
    public int delBuyBook(String userId, String goodsId) {
       return   byBookDaoImp.delCarBook(userId,goodsId);
    }


}
