package JDBC.controller;

import JDBC.anno.ContentType;
import JDBC.eneity.User;
import JDBC.service.impl.ByBookServiceImpl;
import JDBC.service.impl.UserServiceImpl;
import JDBC.utile.MD5Utils;
import JDBC.utile.StateUtile;
import JDBC.utile.UploadUtils;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.util.Collection;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
@WebServlet("/ajax/userContorller")
@MultipartConfig(maxFileSize = 1024*1024*5,maxRequestSize = 1024*1024*30)   //添加注解
public class UserContorller extends  BaseController {

    private static UserServiceImpl userService  = new UserServiceImpl();
    private static ByBookServiceImpl byBookService  = new ByBookServiceImpl();



    /**
     * 删除用户
     * @param req
     * @param resp
     * @return
     */
    @ContentType(value = "application/json;charset=utf-8")
    public  static  Object delUser(HttpServletRequest req, HttpServletResponse resp){
        String id = req.getParameter("id");
        Object s;
        int i = userService.delUser(id);
        if(i>=1){
              s = StateUtile.succeedMsg2(new Integer(i));
        }else {
              s = StateUtile.errorMsg2(new Integer(i));
        }
        return  s;
    }

    /**
     * 修改密码
     * @param req
     * @param resp
     * @return
     */
    @ContentType(value = "application/json;charset=utf-8")
    public  static  Object changePwd(HttpServletRequest req, HttpServletResponse resp){
//        req.getParameter("")
        return null;
    }

    /**
     * 注册
     * @param req
     * @param resp
     * @return
     */
    @ContentType(value = "application/json;charset=utf-8")
    public  static  Object register(HttpServletRequest req, HttpServletResponse resp){
        String username = req.getParameter("username");
        String password   = MD5Utils.stringToMD5(req.getParameter("password"));  // 加密后的
        String realname = req.getParameter("realname");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");



        System.out.println("注册传递的参数"+username+","+password+","+realname+","+email+","+gender);
        Object[]  params = {username,password,realname,email,gender};
        int register = userService.register(params);
        System.out.println("用户注册是否成功的状态"+register);
        Object s;
        if(register>=1){
              s = StateUtile.succeedMsg2(null);
        }else {
              s = StateUtile.errorMsg2(null);
        }
        return s;
    }

    /**
     *  登录
     * @param req
     * @param resp
     * @return
     */
    @ContentType(value = "application/json;charset=utf-8")
    public  static  Object login(HttpServletRequest req, HttpServletResponse resp){
        //后台接收前端传递的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username---" + username+"password---" + password);
        User login = userService.Login(username, password);
        Object o;
        if(login == null){
              o = StateUtile.errorMsg(null);
        }else {
            o = StateUtile.succeedMsg2(login);
        }
        return  o;
    }

    /**
     * 前端传递MD5的密码
     * @param req
     * @param resp
     * @return
     */
    @ContentType(value = "application/json;charset=utf-8")
    public  static  Object login2(HttpServletRequest req, HttpServletResponse resp){
        //后台接收前端传递的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username---" + username+"password---" + password);
        User login = userService.Login2(username, password);
        Object o;
        if(login == null){
            o = StateUtile.errorMsg(null);
        }else {
            o = StateUtile.succeedMsg2(login);
        }
        return  o;
    }

    /**
     * 上传图片
     * @param req
     * @param resp
     * @return
     */

    @ContentType(value = "application/json;charset=utf-8")
    public  static  Object uploadImg(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");


        String s = UploadUtils.MakeNewPath();   //返回当前的日期
        String path = req.getServletContext().getRealPath("/upload/"+s);

        File file = new File(path);
        if (!file.exists()){
            file.mkdirs(); //创建文件夹
        }
//
//        HttpSession session = req.getSession();
//        Object user = session.getAttribute("user");


        Collection<Part> parts = req.getParts();   //获取前端传递的  multipart/form-data格式传递的http请求的请求体，通常用于获取上传文件。
        String id = "";
        if(parts != null && parts.size() > 0 ) { //不是空就变量这个文件
            for (Part part : parts) {
                String fileName = part.getSubmittedFileName();  //获取文件的名字
                if(fileName == null){
                    String name = part.getName();
                    String parameter = req.getParameter(name);
                    id = req.getParameter("id");
                    System.out.println("其他的参数"+name+":"+parameter);
                }else{
                    System.out.println("文件名称"+fileName);

                    //解决IE
                    String dis = part.getHeader("content-disposition");
                    System.out.println("获取到请求头中的数据"+dis);

                    //字符串的截取
                    String substring = dis.substring(dis.indexOf("filename")+10, dis.length() - 1);  //截取后的文件
                    System.out.println("截取后的文件名字"+substring);
                    fileName = substring.substring(substring.lastIndexOf("\\") + 1);
                    System.out.println("截取后的文件"+fileName);



                    fileName = UploadUtils.MakeNewFileName(fileName);
                    String strBackUrl = "http://" + req.getServerName() + ":"+ req.getServerPort()  + req.getContextPath();
                    System.out.println("要保存到数据库的图片地址"+strBackUrl+"/upload/"+s+"/"+fileName);
                    System.out.println("要给"+id+"上传头像");
                    userService.uploadImg(strBackUrl+"/upload/"+s+"/"+fileName,id);

                    part.write(path+File.separator+fileName);

                    //删除
                    part.delete();

                    System.out.println("保存成功");

                    return  StateUtile.succeedMsg2(null);
                }



            }

        }


        return null;
    }

    /**
     * 删除购物车中的 已经购买的图片
     */
    @ContentType(value = "application/json;charset=utf-8")
    public  static  Object delCarIsBuy(HttpServletRequest req, HttpServletResponse resp){
        String userId = req.getParameter("userId");
        String goodsId = req.getParameter("goodsId");
        System.out.println("要从购物车删除的用户id 是" +userId+"和商品id"+goodsId);
        return  byBookService.delBuyBook(userId, goodsId);
    }
}
