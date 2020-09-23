package JDBC.service;

import JDBC.eneity.User;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public interface UserService {
    //登录
    User  Login(String name, String pwd);
    //MD5 的密码
    User  Login2(String name, String pwd);

    //购买书籍
    int ByBook(int id, Double money);

    //修改密码
    int updatePwd(User user, String pwd);

    //上传图片
    int uploadImg(String url, String username);

    //
    int register(Object[] params);

    //删除
    int delUser(String id);
}
