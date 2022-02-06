package com.QuickBuy.common.pojo;

import java.util.List;

public class PageResult<T> {
    private Long total; //总记录数
    private List<T> rows; //一页记录数

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}