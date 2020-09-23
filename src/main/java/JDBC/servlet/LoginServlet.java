package JDBC.servlet;

import JDBC.eneity.Book;
import JDBC.eneity.User;
import JDBC.service.impl.BookServiceImpl;
import JDBC.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */

@WebServlet(name = "LoginServlet", urlPatterns = "/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // 登录验证信息   书籍从后台数据库获取获取
    UserServiceImpl usere = new UserServiceImpl(); //用户
    BookServiceImpl book = new BookServiceImpl();  //书籍

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 将输出转换为中文
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Map map = new  HashMap<String,String>();

        String user  ;
        String password  ;
        String seven =request.getParameter("seven");;
        Cookie[] cookies = request.getCookies();
        for (Cookie q : cookies) {
            map.put(q.getName(),q.getValue());
        }
        String name = (String)map.get("_name");  //要是能获取到_name 的化 证明勾选了7天免登录
        if(name != null){//要是能获取到_name 的化 证明勾选了7天免登录
                System.out.println(name+"七天免登录的账号密码");
                String[] split = name.split("#");
                user = split[0];
                password = split[1];


        }else {  //从前台获取
            // 获取参数  账号密码
            user = request.getParameter("user");
            password = request.getParameter("password");
            // 验证是否7天免登录
            seven = request.getParameter("seven");
            System.out.println("看看要不要7天免的登录"+seven);
        }


        User login = usere.Login(user, password); //把账号密码传递给 后台 通过数据库查询获取登录的用户信息




        if (login != null) {
            // 如果验证成功，则转发succeed.jsp页面，并在页面显示用户名
            System.out.println("seven:"+seven+"--");
            Cookie cookie = null;
            if(seven != null && seven != ""){  // 七天免存储
                cookie = new Cookie("_name",user+"#"+password );
                cookie.setMaxAge(60*60*24*7); //保存一个星期
                cookie.setPath(request.getContextPath());
                cookie.setHttpOnly(true);
                response.addCookie(cookie);
                System.out.println("保存了");
            }
            HttpSession session = request.getSession();
            session.setAttribute("user", login);   // 用户信息 保存到 sesstion中



            //分页
            Integer which_page = null; //第几页
            try {
                which_page = Integer.parseInt(request.getParameter("which_page"));
            } catch (NumberFormatException e) {

                e.printStackTrace();
            }

            if(which_page == null){
                System.out.println("没有传递参数 默认是是1");
                which_page = 1;
            }
            //获取一个所有书籍的list 集合
            List<Book> books = book.queryAll();
            int size = books.size();  //总条数
            int PageNum = 10;         //一页有多少条书籍
            int  num =size%PageNum  == 0 ? 0: 1;
            int allPage =  size/PageNum + num;


            System.out.println("一共"+allPage+"这麽多页数");
            System.out.println(which_page+" 当前页");


            List<Book> paging = book.paging(which_page,PageNum);

            session.setAttribute("allPage", allPage);  //一共多少页数据
            session.setAttribute("which_page",which_page); //当前页
            session.setAttribute("paging",paging);



            //页码跳转
            request.getRequestDispatcher("succeed.jsp").forward(request, response);

        } else {
            // 如果验证失败，则重定向到登录页面
            response.sendRedirect("index.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}