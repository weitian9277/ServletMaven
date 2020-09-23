package JDBC.file.Login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
@WebFilter("/index.html")
public class AutoLogin implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest)req;
//        HttpServletResponse response = (HttpServletResponse)resp;
//        HashMap<String, String> hashMap = new HashMap<>();
//        //查看当前的登录状态看是不是属于右cookie
//        Cookie[] cookies = request.getCookies();
//        System.out.println(request.getCookies());
//        if(cookies != null){
//            for (Cookie cookie : cookies) {
//                System.out.println(cookie.getName()+"----"+cookie.getValue());
//                hashMap.put(cookie.getName(),cookie.getValue());
//            }
//            UserServiceImpl userService = new UserServiceImpl();
//            String _name = hashMap.get("_name");
//            String[] split = _name.split("#");
//
//            User login = userService.Login(split[0], split[1]);
//            if(login!= null){  //用户存在
//                req.getRequestDispatcher("/servlet/LoginServlet").forward(req, resp);
//                System.out.println("7天免登录成功");
//            }else {
//                req.getRequestDispatcher("/index.html").forward(req, resp);
//            }
//        }else {
//            System.out.println(request.getContextPath()+"/index.html");
//            response.sendRedirect(request.getContextPath());
            filterChain.doFilter(req, resp);
//        }
//        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
