package com.lyx.examsystem.dao;

import com.lyx.examsystem.entity.ExamRecordInfoEntity;

public interface ExamRecordInfoEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ExamRecordInfo
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ExamRecordInfo
     *
     * @mbggenerated
     */
    int insert(ExamRecordInfoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ExamRecordInfo
     *
     * @mbggenerated
     */
    int insertSelective(ExamRecordInfoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ExamRecordInfo
     *
     * @mbggenerated
     */
    ExamRecordInfoEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ExamRecordInfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ExamRecordInfoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ExamRecordInfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ExamRecordInfoEntity record);
}