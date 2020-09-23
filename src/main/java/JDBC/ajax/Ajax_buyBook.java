package JDBC.ajax;

import JDBC.eneity.State;
import JDBC.service.impl.ByBookServiceImpl;
import JDBC.service.impl.UserServiceImpl;
import JDBC.utile.GetTime;
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
@WebServlet("/ajax/byBook")
public class Ajax_buyBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         req.setCharacterEncoding("utf-8");

        resp.setContentType("text/html;charset=UTF-8");
        UserServiceImpl user = new UserServiceImpl();
        ByBookServiceImpl byBookService = new ByBookServiceImpl();




//       图书的信息  添加到我的书架
        String userId = req.getParameter("userId") ;     //购买者的id
        String bookId = req.getParameter("bookId") ;     //书籍的id
        Double price =Double.parseDouble(req.getParameter("price")) ;     //价格


        String time = GetTime.getThisTime();        //购买的时间
        System.out.println("购买图书的参数"+bookId+","+userId+","+time);
        Object[] params = {bookId,userId,time}; //书籍的参数参数





        //扣钱
        int i = user.ByBook(Integer.parseInt(userId), price);

        System.out.println("要购买人的id"+userId+"要书籍的价格"+price);
        PrintWriter out = resp.getWriter();
        if(i>=1){ //成功
            int i1 = byBookService.addByBook(params);
            if(i1<=1){
                State success = new State(200, "添加到我的书库成功");
                out.write(StateUtile.succeedMsg(success));
                out.flush();
            }else {
                State error = new State(-1, "添加到我的书库购买失败");
                out.write(StateUtile.errorMsg(error));
            }
//            out.write(StateUtile.succeedMsg(null));
//            out.flush();
        }else {//失败
            State error = new State(-1, "扣费失败！！！");
            out.write(StateUtile.errorMsg(error));
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
