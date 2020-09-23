package JDBC.servlet;

import JDBC.eneity.User;
import JDBC.service.impl.UserServiceImpl;
import JDBC.utile.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
@WebServlet(name = "UploadServlet",value = "/servlet/upload")
                                //单个个文件大小限制                //总共大小限制
@MultipartConfig(maxFileSize = 1024*1024*5,maxRequestSize = 1024*1024*30)   //添加注解
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        UserServiceImpl userService = new UserServiceImpl();
        resp.setContentType("text/html;charset=utf-8");
//        resp.setHeader();
//        resp.setCharacterEncoding();
        String s = UploadUtils.MakeNewPath();
        String path = req.getServletContext().getRealPath("/upload/" + s);
        File file = new File(path);
        if(!file.exists()){  //如果没有就创建
            file.mkdirs();
        }
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        //数据保存到数据库
//        System.out.println("要保存到数据库的地址"+path);
//        int i = userService.uploadImg(path, user.getUsername());
//        System.err.println(i+"有没有上传成功图片!!!!!!!!!!!!!!");

        //获取数据 通过req.getParts
        Collection<Part> parts = req.getParts();
        //如果他不是空就遍历
        if(parts != null && parts.size() >0){
            for (Part part : parts) {
                String  fileName = part.getSubmittedFileName();  //获取文件名称
                if(fileName == null){  //普通文件
                    String name = part.getName();
                    String parameter = req.getParameter(name);
                    System.out.println("普通的数据"+name+"--"+parameter);
                }else {
                    System.out.println(fileName+"文件名称");

                    //解决IE
                    String dis = part.getHeader("content-disposition");
                    System.out.println(" //获取到请求头中的数据"+dis);
                    //字符串的截取
                    String substring = dis.substring(dis.indexOf("filename")+10, dis.length() - 1);  //截取后的文件
                    System.out.println("截取后的"+substring);
                    fileName = substring.substring(substring.lastIndexOf("\\") + 1);
                    System.out.println("截取后的文件"+fileName);

                    fileName = UploadUtils.MakeNewFileName(fileName);
                    System.out.println("要保存到数据库的地址"+"/upload/"+s+"/"+fileName);
                    int i = userService.uploadImg("/upload/"+s+"/"+fileName, user.getUsername());

                    part.write(path+ File.separator+fileName);

                    //删除
                    part.delete();
                    System.out.println("保存成功");
                    req.getRequestDispatcher("LoginServlet").forward(req, resp);
                }

            }
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
