package JDBC.ajax;

import JDBC.eneity.Book;
import JDBC.service.impl.BookServiceImpl;
import JDBC.utile.StateUtile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
@WebServlet("/ajax/bookList")
public class Ajax_BookList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");


        Integer pageNum =  0;
        Integer pageSize =  0;
        System.out.println("----------------------"+req.getParameter("pageNum") == null);
        if(req.getParameter("pageNum") == null ){
            pageNum=1;
            pageSize=10;
        }else {
              pageNum = Integer.parseInt(req.getParameter("pageNum"));    //当前页
              pageSize = Integer.parseInt(req.getParameter("pageSize"));  //每页几条数据
        }

        System.out.println("当前页"+pageNum+"每页几条数据"+pageSize);
        BookServiceImpl bookService = new BookServiceImpl();
        List<Book> books = bookService.queryAll2(pageNum,pageSize);

        String bookList = null;
       if(books != null){
           bookList = StateUtile.succeedMsg(books);
       }else {
           bookList = StateUtile.succeedMsg(null);
       }
        //然后通过respone 返回给页面
        PrintWriter out = resp.getWriter();
        out.write(bookList);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
