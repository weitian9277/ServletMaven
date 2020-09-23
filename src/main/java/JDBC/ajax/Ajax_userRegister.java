package JDBC.ajax;

import JDBC.service.impl.UserServiceImpl;
import JDBC.utile.StateUtile;

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
@WebServlet("/ajax/userRegister")
public class Ajax_userRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        UserServiceImpl user = new UserServiceImpl();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String realname = req.getParameter("realname");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");

        System.out.println("注册传递的参数"+username+","+password+","+realname+","+email+","+gender);
        Object[]  params = {username,password,realname,email,gender};
        int register = user.register(params);
        System.out.println("用户注册是否成功的状态"+register);
        if(register>=1){
            String s = StateUtile.succeedMsg(null);
            resp.getWriter().write( s);
        }else {
            String s = StateUtile.errorMsg(null);
            resp.getWriter().write( s);

        }


    }
}
