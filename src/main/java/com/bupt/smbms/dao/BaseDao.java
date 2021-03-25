package com.bupt.smbms.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;





    static {//加载静态资源
        Properties properties = new Properties();
        String configFile = "db.properties";
        InputStream resourceAsStream = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    public static Connection getConnection(){//获取连接对象
        Connection connection =null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 执行查询
     * @param connection
     * @param pstm
     * @param sql
     * @param rs
     * @param values
     * @return
     */
    public static ResultSet execute(Connection connection, PreparedStatement pstm,String sql,ResultSet rs,Object[] values){
        try {
            pstm = connection.prepareStatement(sql);
            for (int i = 0; i < values.length; i++) {
                pstm.setObject(i+1,values[i]);
            }
            rs = pstm.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    /**
     * 执行更新
     * @param connection
     * @param pstm
     * @param sql
     * @param values
     * @return
     */
    public static int execute(Connection connection,PreparedStatement pstm, String sql, Object[] values){
        int updateRows = 0;
        try {
            pstm = connection.prepareStatement(sql);
            for (int i = 0; i < values.length; i++) {
                pstm.setObject(i+1,values[i]);
            }
            updateRows = pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return updateRows;
    }

    /**
     * 关闭资源
     */
    public static  boolean closeResource(Connection connection,PreparedStatement pstm,ResultSet rs){
        boolean flag = true;

        if(rs!=null){
            try {
                rs.close();
                rs = null; //gc回收
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }

        if(pstm != null){
            try {
                pstm.close();
                pstm = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }

        if(connection != null){
            try {
                connection.close();
                connection = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }


        return flag;
    }

}
