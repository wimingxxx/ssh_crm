package com.qwm.ssh_crm.utils;

import java.util.List;

/**
 * @author：qiwenming
 * @date：2017/11/5 0005   0:21
 * @description：
 * 分页使用的bean
 */
public class PageBean {
    //当前页数
    private Integer currentPage;
    //总记录数
    private Integer totalCount;
    //每页显示条数
    private Integer pageSize;
    //总页数
    private Integer totalPage;
    //分页列表数据
    private List list;

    public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;

        //如果页面没有指定显示哪一页，那么显示第一页
        if(this.currentPage==null){
            this.currentPage = 1;
        }

        //如果每页显示条数没有指定，默认每页显示5条
        if(this.pageSize==null){
            this.pageSize = 5;
        }

        //计算总页数
        this.totalPage = (this.totalCount+this.pageSize-1)/this.pageSize;

        //判断当前页是否超出了范围
        //不能小于1 不能大于最大页数
        if(this.currentPage<1){
            this.currentPage = 1;
        }else if(this.currentPage>this.totalPage){
            this.currentPage = this.totalPage;
        }
    }

    //计算起始索引
    public int getStart(){
        return (this.currentPage-1)*this.pageSize;
    }

    public Integer getCurrentPage() { return currentPage; }

    public void setCurrentPage(Integer currentPage) { this.currentPage = currentPage; }

    public Integer getTotalCount() { return totalCount; }

    public void setTotalCount(Integer totalCount) { this.totalCount = totalCount; }

    public Integer getPageSize() { return pageSize; }

    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }

    public Integer getTotalPage() { return totalPage; }

    public void setTotalPage(Integer totalPage) { this.totalPage = totalPage; }

    public List getList() { return list; }

    public void setList(List list) { this.list = list; }
}
