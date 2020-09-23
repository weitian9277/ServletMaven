package JDBC.servlet;

import JDBC.service.impl.ByBookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
@WebServlet(name = "MeBookServlet",value = "/servlet/meBook")
public class MeBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type", "text/html;charset=UTF-8");

        int id = (Integer) req.getAttribute("id");
        String title = (String)req.getAttribute("title");
        String autor = (String)req.getAttribute("author");   //购买者的名字
        String time =  (String)req.getAttribute("time");
        System.out.println(autor+"购买的！！");
        Object[] params  =  {id,title,autor,time};

        ByBookServiceImpl byBookService = new ByBookServiceImpl();
        int i = byBookService.addByBook(params);
        System.out.println("最后的结果"+i);

        if(i>=0){
            req.getRequestDispatcher("myBook").forward(req, resp);
            System.out.println("去我的书架");
        }else {
//            req.getRequestDispatcher("byErrory.jsp").forward(req, resp);
            resp.sendRedirect("byErrory.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
