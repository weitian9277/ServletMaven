package JDBC.view;

import JDBC.eneity.User;
import JDBC.service.impl.BookServiceImpl;
import JDBC.service.impl.UserServiceImpl;

import java.util.Scanner;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class BookShop {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //登录
//        System.out.println("----------欢迎进入ATM系统-------------");
//        System.out.println("-----------1登录 2转账--------------");
        System.out.println("请输入用户名");
        String cardNo = input.next();
        System.out.println("请输入密码");
        String password = input.next();
        UserServiceImpl usi = new UserServiceImpl();
        BookServiceImpl bsi = new BookServiceImpl();
        User account = usi.Login(cardNo, password);

        if (account != null) {
//            System.out.println("登录成功");
//            System.out.println("-------1 查看全部全部图书 2搜索   3购买    4修改密码 5 查看用户信息  0退出-----------");
//            int choice = input.nextInt();
//            switch (choice) {
//                case 1:
//                    bsi.queryAll();
//                    break;
//                case 2:
//                    System.out.println("请输入要重新书籍的名字");
//                    String bookName = input.next();
//                    List<Book> books = bsi.selectBookName(bookName);
//                    for (Book book : books) {
//                        System.out.println(book);
//                    }
//                    break;
//                case 3:
//                    System.out.println("请输入要购买书籍的名字");
//                    String bookName = input.next();
//                    User a = usi.transfer(account.getUsername() , -1000);
//                    break;
//                case 4:
                      System.out.println("修改密码！！！,请输入老密码");

                      String oldPwd = input.next();
                      int i = usi.updatePwd(account, oldPwd);
                      System.out.println(i >= 1 ? "成功" : "失败");
//                    break;
//                case 0:
//                    break;
//                default:
//                    break;
//            }
//
        } else {
            System.out.println("登录失败！！！");
        }

    }
}
