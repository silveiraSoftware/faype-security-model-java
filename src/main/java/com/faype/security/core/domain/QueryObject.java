package com.faype.security.core.domain;

import org.springframework.data.domain.Sort;

/**
 * @author wmfsystem
 */
public class QueryObject {

    private int start;
    private int pageSize;
    private Sort sort;
    private String filter;
    private Boolean showUpdated;

    public QueryObject() {
        this.start = 0;
        this.pageSize = 10;
        this.showUpdated = Boolean.FALSE;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Boolean getShowUpdated() {
        return showUpdated;
    }

    public void setShowUpdated(Boolean showUpdated) {
        this.showUpdated = showUpdated;
    }

}
