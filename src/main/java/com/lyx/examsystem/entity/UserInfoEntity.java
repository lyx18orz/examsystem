package com.lyx.examsystem.entity;

import java.util.Date;

public class UserInfoEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UserInfo.ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UserInfo.Account
     *
     * @mbggenerated
     */
    private String account;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UserInfo.Password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UserInfo.LastTime
     *
     * @mbggenerated
     */
    private Date lasttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UserInfo.CreateTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UserInfo.ID
     *
     * @return the value of UserInfo.ID
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UserInfo.ID
     *
     * @param id the value for UserInfo.ID
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UserInfo.Account
     *
     * @return the value of UserInfo.Account
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UserInfo.Account
     *
     * @param account the value for UserInfo.Account
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UserInfo.Password
     *
     * @return the value of UserInfo.Password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UserInfo.Password
     *
     * @param password the value for UserInfo.Password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UserInfo.LastTime
     *
     * @return the value of UserInfo.LastTime
     *
     * @mbggenerated
     */
    public Date getLasttime() {
        return lasttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UserInfo.LastTime
     *
     * @param lasttime the value for UserInfo.LastTime
     *
     * @mbggenerated
     */
    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UserInfo.CreateTime
     *
     * @return the value of UserInfo.CreateTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UserInfo.CreateTime
     *
     * @param createtime the value for UserInfo.CreateTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}