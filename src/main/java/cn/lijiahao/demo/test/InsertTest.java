package cn.lijiahao.demo.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import org.apache.shiro.crypto.hash.Md5Hash;

import com.mysql.jdbc.PreparedStatement;

import cn.lijiahao.demo.utils.SnowFlake;
 
public class InsertTest {
 
   /* public static void main(String[] args) throws ClassNotFoundException, SQLException {
        final String url = "jdbc:mysql://localhost:3306/shirodemo?useUnicode=true&characterEncoding=utf8"; 
        final String name = "com.mysql.jdbc.Driver"; 
        final String user = "root"; 
        final String password = "123456"; 
        Connection conn = null; 
        Class.forName(name);//指定连接类型 
        conn = DriverManager.getConnection(url, user, password);//获取连接 
        if (conn!=null) {
            System.out.println("获取连接成功");
            insert(conn);
        }else {
            System.out.println("获取连接失败");
        }
 
    }*/
    public static void insert(Connection conn) {
        // 开始时间
        Long begin = new Date().getTime();
        // sql前缀
        String prefix = "INSERT INTO sys_user (id,username,password,name,age,gender) VALUES ";
        String prefix2="INSERT INTO sys_moments (id,sys_uid,sys_cid,title,content) VALUES ";
        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            StringBuffer suffix2 = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // 比起st，pst会更好些
            PreparedStatement  pst = (PreparedStatement) conn.prepareStatement("");//准备执行语句
            PreparedStatement  pst2 = (PreparedStatement) conn.prepareStatement("");//准备执行语句
            // 外层循环，总提交事务次数
            for (int i = 1; i <= 100; i++) {
                suffix = new StringBuffer();
                suffix2 = new StringBuffer();
                // 第j次提交步长
                for (int j = 1; j <= 100000; j++) {
                    // 构建SQL后缀
                	long userid=SnowFlake.snowflake.nextId();
                	String salt = "iaeiwfsjkfhewui";
            		Md5Hash md5 = new Md5Hash("123456", salt, 1);
                    suffix.append("('" + userid+"','"+"test"+i+j+"','"+md5.toString()+"','"+"test"+"','"+"20"+"','"+"男'" +"),");
                 for(int t=1;t<=5;t++){
                	// 构建SQL后缀
                     suffix2.append("('" + SnowFlake.snowflake.nextId()+"','"+userid+"','"+t+"','"+"Test"+"','"+"Test'" +"),");
                 }
                 
                 
                 
                }
                // 构建完整SQL
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                String sql2 = prefix2+suffix2.substring(0, suffix2.length() - 1);
                //System.out.println(sql2);
                // 添加执行SQL
                pst.addBatch(sql);
                pst2.addBatch(sql2);
                // 执行操作
                pst.executeBatch();
                pst2.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();
                suffix2 = new StringBuffer();
            }
            // 头等连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = new Date().getTime();
        // 耗时
        System.out.println("1000万条数据插入花费时间 : " + (end - begin) / 1000 + " s");
        System.out.println("插入完成");
    }
}