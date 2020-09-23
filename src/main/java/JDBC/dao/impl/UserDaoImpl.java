package JDBC.dao.impl;

import JDBC.dao.UserDao;
import JDBC.eneity.User;
import JDBC.utile.DruidUtile;
import JDBC.utile.MD5Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 * id        int(11)       (NULL)              NO      PRI     (NULL)   auto_increment  select,insert,update,references
 * username  varchar(20)   utf8mb4_general_ci  NO              (NULL)                   select,insert,update,references
 * password  varchar(32)   utf8mb4_general_ci  NO              (NULL)                   select,insert,update,references
 * realname  varchar(20)   utf8mb4_general_ci  YES             (NULL)                   select,insert,update,references
 * email     varchar(50)   utf8mb4_general_ci  NO              (NULL)                   select,insert,update,references
 * gender    varchar(50)   utf8mb4_general_ci  NO              (NULL)                   select,insert,update,references
 * flag      int(11)       (NULL)              YES             (NULL)                   select,insert,update,references
 * role      int(11)       (NULL)              YES             (NULL)                   select,insert,update,references
 * money     double(10,2)  (NULL)              YES             (NULL)                   select,insert,update,references
 */
public class UserDaoImpl implements UserDao {
    QueryRunner qr = new QueryRunner(DruidUtile.getDataSource());

    @Override
    public User userLoginImp(String name, String pwd) {
        String pwd2 = MD5Utils.stringToMD5(pwd);
        System.out.println("加密的密码"+pwd2);
        String sql = "select id,username,password,realname,email,gender,flag,role,money,img,bookArr from user where username = ? and password = ?";
        Object[] params = {name, pwd2};
        try {
            User s = qr.query(sql, new BeanHandler<User>(User.class), params);
            System.out.println(s == null ? "密码错误":"密码正确");
            return s;
        } catch (Exception e) {
            throw new RuntimeException("查询失败");
        }
    }

    @Override
    public User userLoginImp2(String name, String pwd) {
        String sql = "select id,username,password,realname,email,gender,flag,role,money,img,bookArr from user where username = ? and password = ?";
        Object[] params = {name, pwd};
        try {
            User s = qr.query(sql, new BeanHandler<User>(User.class), params);
            System.out.println(s == null ? "密码错误":"密码正确");
            return s;
        } catch (Exception e) {
            throw new RuntimeException("查询失败");
        }
    }

    /**
     *  扣钱
     * @param id
     * @param money
     * @return
     */
    @Override
    public int update(int id, Double money) {
        Connection connection = DruidUtile.getConnection();
        try {
            String sql = "update user set money=money+? where id=?";
            Object[] params = {money, id};
            System.out.println("人的名字"+id+"--书的价格"+money);
            int update = qr.update(connection, sql, params);

            System.out.println("有没有扣钱成功"+update);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("没有查询到该用户，转账失败！！");
        }
    }

    @Override
    public int daoUpdatePwd(User user, String pwd) {
        Object[] params = {pwd,user.getId()};
        try {
            int update = qr.update("update   user set PASSWORD = ? where id = ?", params);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //穿图片地址存储到数据库
    @Override
    public int uploadImgDao(String url,String username) {
        Object[] params = {url,username};
        try {
            int update = qr.update("update   user set img = ? where id = ?", params);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int registerDao(Object[] params) {

        try {
           return     qr.update("INSERT into user(username,PASSWORD,realname,email,gender) values(?,?,?,?,?)",params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //删除用户
    @Override
    public int delUserDao(String id) {
        try {
            qr.update("DELETE FROM USER WHERE id =  ?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  -1;
    }


}
