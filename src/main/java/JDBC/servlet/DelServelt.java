package JDBC.servlet;

import JDBC.service.impl.BookServiceImpl;

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
@WebServlet(name = "delServlet", urlPatterns = "/servlet/delServlet")
public class DelServelt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 将输出转换为中文
        req.setCharacterEncoding("UTF-8");
        // 设置输出为中文
        resp.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");  //获取id
        System.out.println(id);


        /**
         * 书籍
         */
        BookServiceImpl book = new BookServiceImpl();
//        UserServiceImpl userService = new UserServiceImpl();
        int i = book.delBook(new Integer(id));

        if(i>0){
            PrintWriter out=resp.getWriter();
//            resp.getWriter().println("<script> alert('删除成功');</script>");
            System.out.println("删除成功");
//            resp.sendRedirect(req.getHeader("Referer"));
            resp.sendRedirect("del.jsp");

        }else {
            resp.getWriter().println("<script> alert('shibai');</script>");

            System.out.println("删除失败");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
