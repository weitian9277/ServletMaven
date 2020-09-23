package JDBC.service;

import JDBC.eneity.ByBook;

import java.util.List;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public interface ByBookService {
    //把购买的图书加到书架上
    int addByBook(Object[] params);



    //查询某一个用户下所有的书籍
    List<ByBook> selectNameBoo(int name);

    //删除 已经付钱的书籍
    int delBuyBook(String userId, String goodsId);
}
