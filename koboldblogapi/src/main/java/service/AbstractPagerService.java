package service;

public abstract class AbstractPagerService {
    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    private int pageIndex = 0;
    private int pageSize = 20;

    public void setPager(int index, int size) {
        pageIndex = index;
        pageSize = size;
    }



}
