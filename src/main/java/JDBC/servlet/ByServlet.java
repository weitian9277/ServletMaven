package JDBC.servlet;

import JDBC.eneity.User;
import JDBC.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
@WebServlet(name = "ByServlet",value = "/servlet/byservlet")
public class ByServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        UserServiceImpl userService = new UserServiceImpl();

        //获取要购买的id
        String id = req.getParameter("id");
        //获取sesstion 用户信息
        HttpSession session = req.getSession();
        //用户信息
        User user = (User)session.getAttribute("user");
        System.out.println("获取用户名称"+user.getUsername());
        //价格
        Double price = new Double(req.getParameter("price"));
        //书名
        String title = req.getParameter("title");
        String id1 = req.getParameter("id");
       int  id2 = Integer.parseInt(id1);
        req.setAttribute("id",id2);
        req.setAttribute("title",title);
        req.setAttribute("author",user.getUsername());
        req.setAttribute("time","2020-10-01");



        int user1 = userService.ByBook(user.getId(), price);

        if(user1>=0){
            //成功
            req.getRequestDispatcher("meBook").forward(req, resp);
        }else {
            resp.sendRedirect("index.jsp");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
