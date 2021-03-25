package com.bupt.smbms.service.user;

import com.bupt.smbms.pojo.User;

import java.sql.Connection;
import java.util.List;

public interface UserService {
    public User login(String userCode, String userPassword);

    public boolean updatePwd(int id, String pwd);

    public int getUserCount(String username, int userRole);

    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);
    public boolean modify(User user);
    public boolean add(User user);
    public User selectUserCodeExist(String userCode);
    public boolean deleteUserById(Integer delId);
    public User getUserById(String id);

}
