package JDBC.servlet;


import JDBC.utile.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * wgy
 * 2020/9/3
 * 17:34
 */
@WebServlet(name = "PictureServlet",value = "/picture")
public class PictureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pic = request.getParameter("pic");
        if(StringUtils.isEmpty(pic)){
            return;
        }
        String realPath = request.getServletContext().getRealPath("/WEB-INF/pictures/" + pic);
        File file=new File(realPath);
        if(file.exists()){
            ServletOutputStream os = response.getOutputStream();
            FileInputStream fis=new FileInputStream(file);
            byte[] buf=new byte[1024*4];
            int len=0;
            while((len=fis.read(buf))!=-1) {
                os.write(buf, 0, len);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
