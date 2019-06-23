package koboldblogprovider.koboldblogprovider.dao;

import java.sql.Timestamp;

public class Classify {
    private String id;
    private String classifyName;
    private int sort;
    private Timestamp createTime;
    private boolean isDeleted;
    private boolean isStopped;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }


    public boolean isStopped() {
        return isStopped;
    }

    public void setStopped(boolean stoped) {
        isStopped = stoped;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
