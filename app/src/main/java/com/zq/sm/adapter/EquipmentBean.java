package com.zq.sm.adapter;

/**
 * Created by Administrator on 2018/6/8.
 */

public class EquipmentBean {

    private String name;
    private String batchNo;
    private int totalNum;
    private int lendNum;

    public EquipmentBean() {
    }

    public EquipmentBean(String name, String batchNo, int totalNum, int lendNum) {
        this.name = name;
        this.batchNo = batchNo;
        this.totalNum = totalNum;
        this.lendNum = lendNum;
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
}
