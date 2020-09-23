package JDBC.servlet;

import JDBC.eneity.Book;
import JDBC.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
@WebServlet(name = "addservlet", urlPatterns = "/servlet/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");

        BookServiceImpl book = new BookServiceImpl();
        //参数
        String publicDate = req.getParameter("publicDate");
        String price = req.getParameter("price");
        double pri = Double.parseDouble(price);
        BigDecimal bigDecimal = new BigDecimal(pri);
        String cid = req.getParameter("cid");
        int cid2 = Integer.parseInt(cid);

        Object[] params = {req.getParameter("title"),req.getParameter("author"), publicDate,
                req.getParameter("publisher"),req.getParameter("isbn"),bigDecimal,
                req.getParameter("picture"),cid2};
        int i = book.addBook(params);
        System.out.println("是否新增成功,大于等于1 就是成功 否则就是失败！" + i);
        if (i >= 1) {
            System.out.println("添加成功");
            //分页
            Integer which_page = null; //第几页
            try {
                which_page = Integer.parseInt(req.getParameter("which_page"));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            if (which_page == null) {
                System.out.println("没有传递参数 默认是是1");
                which_page = 1;
            }
            //获取一个所有书籍的list 集合
            List<Book> books = book.queryAll();
            int size = books.size();  //总条数
            int PageNum = 10;         //一页有多少条书籍
//            int allPage = (size%PageNum) != 0 ? size/PageNum+1 :size/PageNum;
            int allPage = size / PageNum;
            System.out.println("一共这麽多页数" + allPage);
            List<Book> paging = book.paging(which_page, PageNum);
            req.setAttribute("allPage", allPage);  //一共多少页数据
            req.setAttribute("which_page", which_page); //当前页
            req.setAttribute("bookList", paging);

            req.setAttribute("user", "a");
            req.setAttribute("password", "password");

            //页码跳转
            req.getRequestDispatcher("succeed.jsp").forward(req, resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
