package JDBC.servlet;

import JDBC.eneity.ByBook;
import JDBC.service.impl.ByBookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
@WebServlet(name = "MyBook",value = "/servlet/myBook")
public class MyBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        String user = req.getParameter("user");
        if(user == null){
            System.out.println("请登录");
            resp.sendRedirect("index.jsp");
            return;
        }
        ByBookServiceImpl byBookService = new ByBookServiceImpl();
        List<ByBook> meBookList = byBookService.selectNameBoo(Integer.parseInt(user));
        for (ByBook byBook : meBookList) {
            System.out.println(byBook);
        }
        req.setAttribute("meBookList",meBookList);
        req.getRequestDispatcher("meBook.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
