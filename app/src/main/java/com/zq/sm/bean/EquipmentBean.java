package com.zq.sm.bean;

/**
 * Created by Administrator on 2018/6/8.
 */

public class EquipmentBean {

    private String name;
    private String batchNo;
    private int totalNum;
    private int lendNum;
    private int inNum;

    public EquipmentBean() {
    }

    public EquipmentBean(String name, String batchNo, int totalNum, int lendNum, int inNum) {
        this.name = name;
        this.batchNo = batchNo;
        this.totalNum = totalNum;
        this.lendNum = lendNum;
        this.inNum = inNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getLendNum() {
        return lendNum;
    }

    public void setLendNum(int lendNum) {
        this.lendNum = lendNum;
    }

    public int getInNum() {
        return inNum;
    }

    public void setInNum(int inNum) {
        this.inNum = inNum;
    }
}
