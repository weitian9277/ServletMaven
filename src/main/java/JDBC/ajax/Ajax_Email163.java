package JDBC.ajax;

import JDBC.utile.StateUtile;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
@WebServlet("/ajax/email163")
public class Ajax_Email163 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            resp.setContentType("utf-8");
            req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        /**
         * 1、设置邮箱的一些属性，关于Properties类的介绍，见末尾博客
         * 2、创建认证对象authenticator，使用自己的邮件账号和授权码
         * 3、获得一个session对象，用来保存认证对象
         * 4、创建邮件消息对象message
         * 	4.1、设置message的发送人，这个要和认证对象的账号一致
         *  4.2、设置message的接收人
         * 	4.3、设置邮件的主题和内容
         */

        //获取收件人的 163邮箱
        String email163 = req.getParameter("email163");  //邮箱地址
        String userName = req.getParameter("userName"); //用户名

        System.out.println("邮箱地址"+email163+"用户名"+userName);
        System.out.println("2939403084@qq.com".equals(email163));
        // 1、创建Properties属性对象，并设置一些邮件的属性
        Properties props = new Properties();
        props.setProperty("mail.host", "smtp.163.com"); // 设置邮箱服务器
        props.setProperty("mail.transport.protocol", "SMTP"); // 设置邮箱发送的协议
        props.setProperty("mail.smtp.auth", "true"); // 设置认证方式



        // 2、创建认证对象authenticator
        Authenticator authenticator = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("15833296874@163.com", "YPLEPSERUAHSFDVB"); // 邮件账号和授权码，注意不是密码。
            }
        };

        // 3、创建会话对象session
        Session session = Session.getInstance(props, authenticator);

        // 4、创建邮件消息对象，设置发送人、接收人、邮件主题、邮件内容
        MimeMessage mess = new MimeMessage(session);
        try {
            mess.setFrom(new InternetAddress("15833296874@163.com")); // 设置邮件的发件人
            mess.setRecipients(Message.RecipientType.TO, email163); // 设置收件人
            mess.setSubject("天天科技股份有限公司"); // 设置邮件标题


            int i = (int) Math.round((Math.random()+1) * 1000);
            mess.setContent("恭喜"+userName+"您已经通过面试请携带你，社保证明，毕业证，学位证，身份证复印件" +
                    "小二寸照片三张，周五到公司一楼前台报道，收到回复！"+i
                    , "text/html;charset=utf-8"); // 设置邮件内容和格式

            // 5、发送邮件
            Transport.send(mess);
            String s = StateUtile.succeedMsg(new Integer(i));
            PrintWriter out = resp.getWriter();
            out.write(s);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            String s = StateUtile.errorMsg(null);
            PrintWriter out = resp.getWriter();
            out.write(s);
        }




    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         doPost(req, resp);
    }



}
