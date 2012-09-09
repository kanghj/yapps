package com.vouov.yapps.json.bean;

import java.util.List;

/**
 * User: yuml
 * Date: 12-9-10
 * Time: 上午1:14
 */
public class Pagination<T> {
    private int total;
    private List<T> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
