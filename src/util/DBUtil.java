package util;

//���ݿ�����
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * ���ݿ����ӹ���
 * @author Zheng
 *
 */
public class DBUtil {

    private static final String db_url="jdbc:mysql://1.15.91.39:3306/yiqing?useUnicode=true&characterEncoding=GB18030&useSSL=false&serverTimezone=GMT&allowPublicKeyRetrieval=true";
    public static String db_user = "root";
    public static String db_pass = "root";

    public static Connection getConn () {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_pass);
            System.out.println("数据库连接成！");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * �ر�����
     * @param state
     * @param conn
     */
    public static void close (Statement state, Connection conn) {
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close (ResultSet rs, Statement state, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

