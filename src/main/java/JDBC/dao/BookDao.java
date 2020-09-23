package JDBC.dao;

import JDBC.eneity.Book;

import java.util.List;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public interface BookDao {
    /**
     * 查询所有的书籍
     */
    List<Book>  queryAll();

    /**
     * 分页查询
     */

    List<Book>  DaoPaging(int which_page, int pageNum);

    /**
     * 懒加载 接口
     */
    List<Book>  queryAll2(int which_page, int pageNum);




    /**
     * 跟据书名查询
     */
    List<Book> DaoselectBookName(String name);


    /**
     * 跟据书名查询
     */
     Book DaoSelectOneBool(int id);


    /**
     * 删除
     */
    int DaoDelBook(int id);


    /**
     * 修改图书
     */
    int DaoUpdataBool(Object... params);

    /**
     * 新增
     */
    int DaoaddBook(Object... params);



}
