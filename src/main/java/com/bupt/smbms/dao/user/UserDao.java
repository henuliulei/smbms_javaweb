package com.bupt.smbms.dao.user;

import com.bupt.smbms.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //获取登入用户的信息
    User getLoginUser(Connection connection, String userCode);
    //更新密码
    int updatePwd(Connection connection, int id, String pwd);

    public int getUserCount(Connection connection,String username,int userRole) throws Exception;

    public List<User> getUserList(Connection connection, String userName, int userRole,int currentPageNo, int pageSize) throws SQLException;
    int modify(Connection connection, User user) throws Exception;
    User getUserById(Connection connection, String id) throws Exception;
    int deleteUserById(Connection connection, Integer delId) throws Exception;
    int add(Connection connection, User user) throws Exception;

}


