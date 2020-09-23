package JDBC.ajax;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import JDBC.eneity.User;
import JDBC.service.impl.BookServiceImpl;
import JDBC.service.impl.UserServiceImpl;

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
@WebServlet("/ajax/userLogin")
public class Ajax_login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl usere = new UserServiceImpl(); //用户
        BookServiceImpl book = new BookServiceImpl();  //书籍
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //后台接收前端传递的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username---" + username+"password---" + password);



        User userInfo = usere.Login(username, password);
        JSONObject jsonObject = null;
        if(userInfo != null){
              jsonObject = new JSONObject();
              jsonObject.put("userInfo", userInfo);
        }else {
            jsonObject = new JSONObject();
//            State error = new State(0, "密码错误");
            jsonObject.put("userInfo", null);
        }


        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        System.out.println(jsonArray);
        PrintWriter out = resp.getWriter();
        out.write(jsonArray.toString());


        // List<Book> books = book.queryAll();
        // String booksString = JSON.toJSONString(books); //数据转成
        // jsonObject.put("list", booksString);   //把数据传递给前台


    }
}
