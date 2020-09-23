package JDBC.ajax;

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
@WebServlet("/ajax/delBook")
public class Ajax_delBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        BookServiceImpl book = new BookServiceImpl();  //书籍

        int id =Integer.parseInt(req.getParameter("id")) ;   //获取前端传递的id
        int i = book.delBook(id);
        System.out.println("要删除的id"+id+"删除的状态"+i);
        PrintWriter out = resp.getWriter();
        if(i>=1){ //成功
            out.write(StateUtile.succeedMsg(null));
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
