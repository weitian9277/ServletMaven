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
@WebServlet("/ajax/updateBook")
public class Ajax_updateBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String title = req.getParameter("title");           //书名
        String author = req.getParameter("author");          //作者
        String publicDate = req.getParameter("publicDate");  //出版日期
        String publisher = req.getParameter("publisher");   //出版社
        String isbn = req.getParameter("isbn");              //序列号
        String price = req.getParameter("price");             //价格
        String picture = req.getParameter("picture");        // 图片
        String cid = req.getParameter("cid");                //图书类别
        String id = req.getParameter("id");                //id

        System.out.println("要修改的接口 前台给传递的书籍"+title+","+author+","+publicDate+","+publisher+","+isbn+","+price+","+picture+","+cid+","+id);
        BookServiceImpl book = new BookServiceImpl();  //书籍
        Object[] params = {title,author,publicDate,publisher,isbn,price,picture,cid,id};

        //把书籍的信息转成JSON 格式   首先创建JSONObject  然后转成String
        // 然后把字符串传到对象中
        //然后通过respone 返回给页面
        PrintWriter out = resp.getWriter();
        int i = book.updataBool(params);  //有没有添加成功
        if(i>=1){
            out.write(StateUtile.succeedMsg(null));
        }else {
            out.write(StateUtile.errorMsg(null));
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
