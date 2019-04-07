package com.lyx.base.page;

public class Page {
    private Integer PageNum;//当前页数
    private Integer PageSize;//每页记录数(系统默认为20)
    String ListType = "";//列表类型:1:未发布,2:有效,3:失效
    private Integer TotalRows;//总记录数：
    private Integer TotalPages;//总页数：
    private String Content;//查询条件s

    public Integer getPageNum() {
        return PageNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AdminInfo.ID
     *
     * @param pageNum the value for AdminInfo.ID
     * @mbggenerated
     */
    public void setPageNum(Integer pageNum) {
        PageNum = pageNum;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AdminInfo.ID
     *
     * @param pageSize the value for AdminInfo.ID
     * @mbggenerated
     */
    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public String getListType() {
        return ListType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AdminInfo.ID
     *
     * @param listType the value for AdminInfo.ID
     * @mbggenerated
     */
    public void setListType(String listType) {
        ListType = listType;
    }

    public Integer getTotalRows() {
        return TotalRows;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AdminInfo.ID
     *
     * @param totalRows the value for AdminInfo.ID
     * @mbggenerated
     */
    public void setTotalRows(Integer totalRows) {
        TotalRows = totalRows;
    }

    public Integer getTotalPages() {
        return TotalPages;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AdminInfo.ID
     *
     * @param totalPages the value for AdminInfo.ID
     * @mbggenerated
     */
    public void setTotalPages(Integer totalPages) {
        TotalPages = totalPages;
    }

    public String getContent() {
        return Content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column AdminInfo.ID
     *
     * @param content the value for AdminInfo.ID
     * @mbggenerated
     */
    public void setContent(String content) {
        Content = content;
    }


}
