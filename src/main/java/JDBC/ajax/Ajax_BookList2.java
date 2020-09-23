package JDBC.ajax;

import com.alibaba.fastjson.JSONObject;
import JDBC.eneity.Book;
import JDBC.eneity.Page;
import JDBC.service.impl.BookServiceImpl;

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
@WebServlet("/ajax/bookList2")
public class Ajax_BookList2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BookServiceImpl bookService = new BookServiceImpl();
        List<Book> booksAll = bookService.queryAll();

        Integer thisPage =  0;
        Integer totalPagesDate =  0;
        System.out.println("前端传递的参数 ---当前页"+req.getParameter("thisPage")+ "一页有多少数据"+ req.getParameter("totalPagesDate"));


        if(req.getParameter("thisPage") == null ){ //如果他等于 null的话  没有传递参数  那就默认返回10条数据  一页
            thisPage=1;
            totalPagesDate=10;
        }else { //如果穿了的话 就
            thisPage = Integer.parseInt(req.getParameter("thisPage"));    //当前页
            totalPagesDate = Integer.parseInt(req.getParameter("totalPagesDate"));  //每页几条数据
        }

        System.out.println("当前页"+thisPage+"每页几条数据"+totalPagesDate);


        int size =0;
        if(booksAll.size() % totalPagesDate != 0 ){
            size = (booksAll.size()/totalPagesDate)+1;
        }else {
            size = (booksAll.size()/totalPagesDate);
        }


        List<Book> books = bookService.paging(thisPage,totalPagesDate);  //分页给返回的数据

        Page page = new Page(thisPage, size,books,booksAll.size() );   //你想要的最终数据格式

        //首先创建JSONObject  把书籍的信息转成JSON 格式
        JSONObject jsonObject = new JSONObject();
        String bookList = jsonObject.toJSONString(page);
        // 然后把字符串传到对象中
        System.out.println(bookList);
        jsonObject.put("bookList",bookList);
        //然后通过respone 返回给页面
        PrintWriter out = resp.getWriter();
        out.write(bookList);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
