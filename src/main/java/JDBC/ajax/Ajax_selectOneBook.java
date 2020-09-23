package JDBC.ajax;

import JDBC.eneity.Book;
import JDBC.eneity.State;
import JDBC.service.impl.BookServiceImpl;
import JDBC.utile.StateUtile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
@WebServlet("/ajax/selectOneBook")
public class Ajax_selectOneBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        BookServiceImpl book = new BookServiceImpl();  //书籍

        int id =Integer.parseInt(req.getParameter("id")) ;   //获取前端传递的id
        Book book1 = book.selectOneBook(id);

        State state = new State(2200, "成功了 用户和信息", book1);

        System.out.println("查询的"+id+"书籍的信息"+book1.toString());
        PrintWriter out = resp.getWriter();
        if(book1 != null){ //成功
            out.write(StateUtile.succeedMsg(book1));
            out.flush();
        }else {//失败
            out.write(StateUtile.errorMsg(null));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
