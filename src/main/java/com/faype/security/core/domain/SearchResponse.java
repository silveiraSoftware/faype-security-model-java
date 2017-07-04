package com.faype.security.core.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <T>
 * @author wmfsystem
 */
public class SearchResponse<T extends Object> {

    private int pageSize;
    private Long count;
    private int start;
    private List<T> values;

    public SearchResponse() {
        this.pageSize = 10;
        this.count = 0l;
        this.start = 0;
        this.values = new ArrayList();
    }

    public SearchResponse(int pageSize, Long count, int page, List<T> values) {
        this.pageSize = pageSize;
        this.count = count;
        this.start = page;
        this.values = values;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }

}
