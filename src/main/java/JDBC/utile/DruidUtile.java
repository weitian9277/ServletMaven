package JDBC.utile;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public class DruidUtile {
    private static DataSource dataSource = null;    //创建一个连接池
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    static {

        try {
            Properties properties = new Properties();
            InputStream is = DruidUtile.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);

            dataSource = DruidDataSourceFactory.createDataSource(properties);  //创建一个连接池   获取本地文件进行创建

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接池初始化失败");
        }
    }


    public static DataSource getDataSource() {
        return dataSource;
    }


    //事务相关的方法
    //获取getConnection  对象
    public static Connection getConnection() {
        try {
            Connection conn = threadLocal.get();
            if (conn == null) {
                conn = dataSource.getConnection();
                threadLocal.set(conn);
            }
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeAll(ResultSet rs, Statement stat,Connection conn){
        try {
            if(rs!=null){
                rs.close();
            }
            if(stat!=null){
                stat.close();
            }
            if(conn!=null){
                if(conn.getAutoCommit()){
                     threadLocal.remove();
                     conn.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //开启事务的方法
    public static void startConnection() throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            connection.setAutoCommit(false);
        }
    }

    //提交事务
    public static void commit() throws SQLException {
        Connection connection = getConnection();

        if (connection != null) {
            connection.commit();
        }

    }

    //回滚
    public static void rollback() throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            connection.rollback();
        }
    }
    //关闭

    public static void remove() throws SQLException {
        Connection connection = getConnection();

        if (connection != null) {
            threadLocal.remove();
            connection.close();
        }
    }


}
