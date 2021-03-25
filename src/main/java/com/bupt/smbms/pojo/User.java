package com.bupt.smbms.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private int id;
    private String userCode;
    private String userName;
    private String userPassword;
    private int gender;
    private Date birthday;
    private String phone;
    private String address;
    private int userRole;
    private int createdBy;
    private Date creationDate;
    private int modifyBy;
    private Date modifyDate;
    private String userRoleName;    //用户角色名称
    public Integer getAge(){
        Date date = new Date();
        int l = (int) (date.getYear() - birthday.getTime());
        return l;
    }


    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }
}
