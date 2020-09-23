package JDBC.dao.impl;


import JDBC.dao.ByBookDao;
import JDBC.eneity.ByBook;
import JDBC.utile.DruidUtile;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;


/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class ByBookDaoImp implements ByBookDao {
   QueryRunner qr = new QueryRunner(DruidUtile.getDataSource());  //开启事务

    //添加我购买的书籍
    @Override
    public int ByBookAdd(Object[] params) {

        try {
           return qr.update("insert into by_book (bookId,userId,time)values(?,?,?)", params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  -1;
    }

    @Override
    public List<ByBook> selectNameBoo(int id) {
        try {
           return qr.query("select " +
                   "bb.id as id," +
                   "bookId as bookId," +
                   "userId as userId," +
                   "title as title," +
                   "author as author," +
                   "publicDate as publicDate," +
                   "publisher as publisher," +
                   "isbn as isbn," +
                   "price as price," +
                   "picture as picture," +
                   "time as time," +
                   "cid as cid" +
                   " from by_book bb left join book b on bb.bookId=b.id where bb.userId = ?",new BeanListHandler<ByBook>(ByBook.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delCarBook(String userId, String goodsId) {

        Object[] params = {userId,goodsId};
        try {
          return   qr.update("DELETE from by_book where userId= ? and  bookId = ?",params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
