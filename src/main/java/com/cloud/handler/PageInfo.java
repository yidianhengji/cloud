package com.cloud.handler;
import com.github.pagehelper.Page;
import java.io.Serializable;
import java.util.List;

public class PageInfo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    //当前页
    private int pageNum;

    //每页的数量
    private int pageSize;

    //总记录数
    private long total;

    //总页数
    private int pages;

    //结果集
    private List<T> list;

    //是否为第一页
    private boolean isFirstPage;

    //是否是最后一页
    private boolean isEndPage;

    public PageInfo(List<T> list) {
        Page<T> page = (Page<T>) list;
        this.pageNum = page.getPageNum();
        this.pageSize = page.getPageSize();

        this.pages = page.getPages();
        this.list = page;
        this.total =page.getTotal();
    }

    public PageInfo(int pageNum, int pageSize, long total, int pages, List<T> list, boolean isFirstPage,
                    boolean isEndPage) {
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = pages;
        this.list = list;
        this.isFirstPage = isFirstPage;
        this.isEndPage = isEndPage;
    }

    @Override
    public String toString() {
        return "PageInfo{" + "pageNum=" + pageNum + ", pageSize=" + pageSize + ", total=" + total + ", pages=" + pages + ", list=" + list + ", isFirstPage=" + isFirstPage + ", isEndPage=" + isEndPage + '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isEndPage() {
        return isEndPage;
    }

    public void setEndPage(boolean endPage) {
        isEndPage = endPage;
    }
}
