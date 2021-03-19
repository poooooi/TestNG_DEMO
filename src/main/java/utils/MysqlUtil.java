package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: TestNG_DEMO
 * @description: mysql连接
 * @author: poooooi
 * @create: 2021-03-19 23:08
 **/

public class MysqlUtil {
    public static Connection initConnection(String url, String user, String password){
        Connection con = null;
        try {
            // 加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
//                System.out.println("Succeeded connecting to the Database!");
                return con;
        }catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            System.out.println("数据库数据成功获取！！");
            return con;
        }
    }
}
