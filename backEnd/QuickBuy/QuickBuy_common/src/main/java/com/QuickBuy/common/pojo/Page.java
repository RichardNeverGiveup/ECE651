package com.QuickBuy.common.pojo;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
    private long currentpage;
    private long total;
    private int size;
    private int next;
    private List<T> list;
    private int last;
    private int lpage;
    private int rpage;
    private long start;
    public int offsize = 2;

    public Page() {
    }

    public void setCurrentpage(long currentpage, long total, long pagesize) {
        long var10000 = total / pagesize;
        int totalPages = (int)(total % pagesize == 0L ? total / pagesize : total / pagesize + 1L);
        this.last = totalPages;
        this.currentpage = Math.min(currentpage, totalPages);

        this.start = (this.currentpage - 1L) * pagesize;
    }

    public long getUpper() {
        return this.currentpage > 1L ? this.currentpage - 1L : this.currentpage;
    }

    public void setLast(int last) {
        this.last = (int)(this.total % (long)this.size == 0L ? this.total / (long)this.size : this.total / (long)this.size + 1L);
    }

    public Page(long total, int currentpage, int pagesize, int offsize) {
        this.offsize = offsize;
        this.initPage(total, currentpage, pagesize);
    }

    public Page(long total, int currentpage, int pagesize) {
        this.initPage(total, currentpage, pagesize);
    }

    public void initPage(long total, int currentpage, int pagesize) {
        this.total = total;
        this.size = pagesize;
        this.setCurrentpage(currentpage, total, pagesize);
        int leftcount = this.offsize;
        int rightcount = this.offsize;
        this.lpage = currentpage - leftcount;
        this.rpage = currentpage + rightcount;
        int topdiv = this.last - this.rpage;
        this.lpage = topdiv < 0 ? this.lpage + topdiv : this.lpage;
        this.rpage = this.lpage <= 0 ? this.rpage + this.lpage * -1 + 1 : this.rpage;
        this.lpage = this.lpage <= 0 ? 1 : this.lpage;
        this.rpage = Math.min(this.rpage, this.last);
    }

    public long getNext() {
        return this.currentpage < (long)this.last ? this.currentpage + 1L : (long)this.last;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public long getCurrentpage() {
        return this.currentpage;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getSize() {
        return (long)this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getLast() {
        return (long)this.last;
    }

    public long getLpage() {
        return (long)this.lpage;
    }

    public void setLpage(int lpage) {
        this.lpage = lpage;
    }

    public long getRpage() {
        return (long)this.rpage;
    }

    public void setRpage(int rpage) {
        this.rpage = rpage;
    }

    public long getStart() {
        return this.start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public void setCurrentpage(long currentpage) {
        this.currentpage = currentpage;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        int cpage = 17;
        Page page = new Page(1001L, cpage, 50, 7);
        System.out.println("Start page: " + page.getLpage() + "__Current page: " + page.getCurrentpage() + "__End page: " + page.getRpage() + "____Total pages: " + page.getLast());
    }
}