package JDBC.dao.impl;

import JDBC.dao.BookDao;
import JDBC.eneity.Book;
import JDBC.utile.DruidUtile;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class BookDaoImpl implements BookDao {
    QueryRunner qr = new QueryRunner(DruidUtile.getDataSource());

    @Override
    public List<Book> queryAll() {
        try {
            List<Book> query = qr.query("select id,title,author,publicDate,publisher,isbn,price,picture,cid  from book", new BeanListHandler<Book>(Book.class));
            return  query;
        } catch (SQLException e) {
            throw new RuntimeException("查询全部书籍失败！！！");
        }
    }

    /**
     * 分页查询
     *
     * @param which_page 第几页
     * @param pageNum    一页多少条书籍
     * @return
     */
    @Override
    public List<Book> DaoPaging(int which_page, int pageNum) {
        try {
            return qr.query("SELECT * FROM book ORDER BY id LIMIT ?,?", new BeanListHandler<Book>(Book.class), which_page, pageNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //懒加载
    @Override
    public List<Book> queryAll2(int which_page,int pageNum) {
        try {
            return qr.query("SELECT * FROM book ORDER BY id LIMIT ?,?", new BeanListHandler<Book>(Book.class), which_page, pageNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Book> DaoselectBookName(String name) {
        try {
            return qr.query("select id,title,author,publicDate,publisher,isbn,price,picture,cid  from book where title like  %?%",
                    new BeanListHandler<Book>(Book.class), name);
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new RuntimeException("查询失败");


        }


    }

    @Override
    public Book DaoSelectOneBool(int id) {
        try {
            return qr.query("select id,title,author,publicDate,publisher,isbn,price,picture,cid  from book where id = ?", new BeanHandler<Book>(Book.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int DaoDelBook(int id) {
        try {
            int update = qr.update("DELETE FROM book WHERE id = ?", id);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    /**
     * 修改
     *
     * @param params
     * @return
     */
    @Override
    public int DaoUpdataBool(Object... params) {
        try {               //UPDATE book SET title='123',author="1",publicDate="2020-01-10",publisher="20",isbn="1",price="1",picture="1",cid=17   WHERE id = 43;
            return qr.update("update book set title=?,author=?,publicDate=?,publisher=?,isbn=?,price=?,picture=?,cid=? where id = ?", params);
//        return qr.update("update book set title='12111111111113',author=\"1\",publicDate=\"2020-01-10\",publisher=\"20\",isbn=\"1\",price=\"111\",picture=\"1\",cid=17   where id = 43");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int DaoaddBook(Object... params) {
        try {
            return  qr.update("INSERT INTO book  (title,author,publicDate,publisher,isbn,price,picture,cid) VALUES (?,?,?,?,?,?,?,?) ", params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  -1;
    }


}
