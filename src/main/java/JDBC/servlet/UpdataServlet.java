package JDBC.servlet;

import JDBC.eneity.Book;
import JDBC.service.impl.BookServiceImpl;
import JDBC.service.impl.UserServiceImpl;

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
@WebServlet(name = "updataServlet", urlPatterns = "/servlet/updataServlet")
public class UpdataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        UserServiceImpl usere = new UserServiceImpl(); //用户
        BookServiceImpl book = new BookServiceImpl();        //书籍

        //获取页面给传输的数据
        String id = req.getParameter("id");
        System.out.println("要修改的id"+id);
        if(id != null){

            Book oneBook = book.selectOneBook(Integer.parseInt(id));
            System.out.println("oneBook"+oneBook.toString());
            req.setAttribute("book", oneBook);
            req.getRequestDispatcher("updata.jsp").forward(req, resp);

        }

        String method = req.getParameter("method");

        System.out.println("修改钱Method="+method);
        if(method.equals("updata")){//修改
            System.out.println("修改了！！！");

            String cid = req.getParameter("cid");
            int cid2 = Integer.parseInt(cid);

            String id1 = req.getParameter("id");
            int id2 = Integer.parseInt(id1);


            Object[] params= {
                    req.getParameter("title"),
                    req.getParameter("author"),
                    req.getParameter("publicDate"),
                    req.getParameter("publisher"),
                    req.getParameter("isbn"),
                    req.getParameter("price"),
                    req.getParameter("picture"),
                    cid2,
                    id2
            };

            int i = book.updataBool(params);


        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
