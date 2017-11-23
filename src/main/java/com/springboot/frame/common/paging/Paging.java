package com.springboot.frame.common.paging;

/**
 * 分页参数。
 *
 * @author Ewing
 **/
public class Paging {
    private int offset = 0;
    private int limit = 100;
    private boolean count = true;

    public Paging() {
    }

    public Paging(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public Paging(int offset, int limit, boolean count) {
        this.offset = offset;
        this.limit = limit;
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean isCount() {
        return count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }
}
