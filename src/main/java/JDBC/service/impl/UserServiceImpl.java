package JDBC.service.impl;

import JDBC.dao.UserDao;
import JDBC.dao.impl.UserDaoImpl;
import JDBC.eneity.User;
import JDBC.service.UserService;
import JDBC.utile.DruidUtile;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User Login(String name, String pwd) {
        return userDao.userLoginImp(name, pwd);
    }

    @Override
    public User Login2(String name, String pwd) {
        return userDao.userLoginImp2(name, pwd);
    }

    @Override
    public int ByBook(int id, Double money) {
        try {
            DruidUtile.startConnection();
            int update = userDao.update(id, money*-1);
//            int i = 10 / 0;
            int admin = userDao.update(1, money);
            DruidUtile.commit();
            return admin;
        } catch (Exception e) {
            try {
                DruidUtile.rollback();
                System.out.println("回滚了...");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                DruidUtile.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return -1;

    }

    /**
     * 修改密码
     *
     * @param user
     * @param pwd
     * @return
     */
    @Override
    public int updatePwd(User user, String pwd) {
        if (user.getPassword().equals(pwd)) {   //老密码相同
            System.out.println("老密码输入正确");
            return updataPWD(user);
        } else {
            System.out.println("密码输入错误 你还有三次输入的机会！！！！");
            for (int i = 1; i <= 3; i++) {
                Scanner input = new Scanner(System.in);
                String password = input.next();
                System.out.println("您" + i + "第输入密码，三次以上密码将锁死！！！");
                if (user.getPassword().equals(password)) {
                    System.out.println("输入正确");
                    return updataPWD(user);
                } else {
                    System.out.println("输入错误");
                }
            }
            System.out.println("账户锁死！！！");
        }
        return  -1;

    }

    @Override
    public int uploadImg(String url, String username) {
       return userDao.uploadImgDao(url,username);
    }

    @Override
    public int register(Object[] params) {
        return  userDao.registerDao(params);
    }

    @Override
    public int delUser(String id) {        return  userDao.delUserDao(id);    }


    public static int updataPWD(User user) {
        UserDao userDao = new UserDaoImpl();
        Scanner input = new Scanner(System.in);
        try {
//            UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
            System.out.println("请输入新密码");
            String next = input.next();
            System.out.println("确认新密码");
            String next2 = input.next();
            if (next2.equals(next)) {  //密码正确
                System.out.println("两次密码一致！！！");
                int i = userDao.daoUpdatePwd(user, next);
                return i;
            } else {
                System.out.println("两次密码输入不一致");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            throw new RuntimeException("修改密码失败");
        }
        return -1;
    }

}
