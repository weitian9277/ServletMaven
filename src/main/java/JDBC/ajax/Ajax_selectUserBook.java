package JDBC.ajax;

import JDBC.eneity.ByBook;
import JDBC.service.impl.ByBookServiceImpl;
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
@WebServlet("/ajax/selectUserBook")
public class Ajax_selectUserBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=UTF-8");
        ByBookServiceImpl byBookService = new ByBookServiceImpl();
        String userId = req.getParameter("userId");
        System.out.println("跟据用户id"+userId+"所买的所有书籍");
        List<ByBook> byBooks = byBookService.selectNameBoo(Integer.parseInt(userId));
        String str;
        if(byBooks != null){
            str = StateUtile.succeedMsg(byBooks);
        }else {
            str = StateUtile.errorMsg(null);
        }
        PrintWriter out = resp.getWriter();
        out.write(str);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
