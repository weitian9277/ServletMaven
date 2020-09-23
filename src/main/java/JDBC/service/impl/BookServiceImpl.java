package JDBC.service.impl;

import JDBC.dao.impl.BookDaoImpl;
import JDBC.eneity.Book;
import JDBC.service.BookService;

import java.util.List;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class BookServiceImpl implements BookService {

    BookDaoImpl bookDao = new BookDaoImpl();


    @Override
    public List<Book> queryAll() {
        List<Book> books = bookDao.queryAll();
        return  books;
    }

    @Override
    public List<Book> paging(int which_page, int pageNum) {
       return  bookDao.DaoPaging(  which_page,   pageNum);
    }

    @Override
    public List<Book> queryAll2(int which_page, int pageNum) {
        List<Book> books = bookDao.queryAll2(which_page,pageNum);
        return  books;
    }


    @Override
    public List<Book> selectBookName(String name) {
        return null;
    }

    @Override
    public Book selectOneBook(int id) {
        return bookDao.DaoSelectOneBool(id);
    }

    @Override
    public int delBook(int id) {
       return bookDao.DaoDelBook(id);
    }

    @Override
    public int updataBool(Object... params) {
       return bookDao.DaoUpdataBool(params);
    }

    @Override
    public int addBook(Object... params) {
        return bookDao.DaoaddBook(params);
    }


}
