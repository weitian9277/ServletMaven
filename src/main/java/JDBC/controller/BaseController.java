package JDBC.controller;


import com.google.gson.Gson;
import JDBC.anno.ContentType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class BaseController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //method参数的值对应的就是controller的方法名
        String methodStr = req.getParameter("method");
        System.out.println(methodStr);
        if(methodStr == null){   }
        try {
            //得到当前类对象
            Class  aClass = this.getClass();
            //构建对象
            Object o = aClass.newInstance();
            //得到要处理改业务方法的Method对象   然后要传入res,resp
            Method method = aClass.getMethod(methodStr, HttpServletRequest.class, HttpServletResponse.class);
            //判读有没有自定义注解
            if(method.isAnnotationPresent(ContentType.class)){
                ContentType contentType = method.getAnnotation(ContentType.class);
                String type = contentType.value();
                System.out.println("有没有注解"+type);
                resp.setContentType(type);
            }else {
                resp.setContentType("text/html;charset=utf-8");
            }
            //4.调用方法
            Object result = method.invoke(o, req, resp);
            if(result != null){
                //返回值是String类型的
                if (result.getClass().getSimpleName().equalsIgnoreCase("String")){
                    //然后跳转页面
                }
//                else if(result.getClass().getSimpleName().equalsIgnoreCase("int")){
//                    System.out.println("数字");
//
//                }
                else {
                    //返回JSON  前端的Ajax 请求
                    String s = new Gson().toJson(result);
                    System.out.println("有没有操作成功，给前端返回的数据"+s);
                    resp.getWriter().print(s);
                }

            }



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
