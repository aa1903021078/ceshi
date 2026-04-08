package com.example.order.model;

import java.util.List;

/**
 * 分页结果封装
 */
public class PageResult<T> {

    /** 当前页码 */
    private int page;

    /** 每页大小 */
    private int size;

    /** 总记录数 */
    private long total;

    /** 总页数 */
    private int totalPages;

    /** 数据列表 */
    private List<T> records;

    public PageResult(int page, int size, long total, List<T> records) {
        this.page = page;
        this.size = size;
        this.total = total;
        this.records = records;
        this.totalPages = (int) Math.ceil((double) total / size);
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public long getTotal() {
        return total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<T> getRecords() {
        return records;
    }
}
