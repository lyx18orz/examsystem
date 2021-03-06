package com.lyx.examsystem.entity;

import java.util.Date;

public class ExamRecordInfoEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ExamRecordInfo.ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ExamRecordInfo.UserID
     *
     * @mbggenerated
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ExamRecordInfo.StartTime
     *
     * @mbggenerated
     */
    private Date starttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ExamRecordInfo.EndTime
     *
     * @mbggenerated
     */
    private Date endtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ExamRecordInfo.Grade
     *
     * @mbggenerated
     */
    private Integer grade;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ExamRecordInfo.ID
     *
     * @return the value of ExamRecordInfo.ID
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ExamRecordInfo.ID
     *
     * @param id the value for ExamRecordInfo.ID
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ExamRecordInfo.UserID
     *
     * @return the value of ExamRecordInfo.UserID
     *
     * @mbggenerated
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ExamRecordInfo.UserID
     *
     * @param userid the value for ExamRecordInfo.UserID
     *
     * @mbggenerated
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ExamRecordInfo.StartTime
     *
     * @return the value of ExamRecordInfo.StartTime
     *
     * @mbggenerated
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ExamRecordInfo.StartTime
     *
     * @param starttime the value for ExamRecordInfo.StartTime
     *
     * @mbggenerated
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ExamRecordInfo.EndTime
     *
     * @return the value of ExamRecordInfo.EndTime
     *
     * @mbggenerated
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ExamRecordInfo.EndTime
     *
     * @param endtime the value for ExamRecordInfo.EndTime
     *
     * @mbggenerated
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ExamRecordInfo.Grade
     *
     * @return the value of ExamRecordInfo.Grade
     *
     * @mbggenerated
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ExamRecordInfo.Grade
     *
     * @param grade the value for ExamRecordInfo.Grade
     *
     * @mbggenerated
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}