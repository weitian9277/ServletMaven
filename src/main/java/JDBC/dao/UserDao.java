package JDBC.dao;

import JDBC.eneity.User;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public interface UserDao {
     User userLoginImp(String name, String pwd);


     User userLoginImp2(String name, String pwd);

    /**
     *  修改  ---转账
     */
    int  update(int name, Double money);


    /**
     * 修改密码
     */
//
    int daoUpdatePwd(User user, String pwd);


    /**
     * 上传图片
     */
    int uploadImgDao(String url, String username);

    /**
     * 注册
     */
    int registerDao(Object[] params);


    /**
     * 删除用户
     */
    int delUserDao(String id);


}
