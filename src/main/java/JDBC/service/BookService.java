package JDBC.service;

import JDBC.eneity.Book;

import java.util.List;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public interface BookService {
    //查询所有
    List<Book> queryAll();

    //分页查询
    List<Book> paging(int which_page, int pageNum);

    //查询所有懒加载
    List<Book> queryAll2(int which_page, int pageNum);


    // 跟据书的名字查询
    List<Book> selectBookName(String name);

    //跟据id 查询书籍
    Book selectOneBook(int id);

    //删除书籍
    int  delBook(int id);

    //修改
    int updataBool(Object... params);

    int addBook(Object... params);
}
