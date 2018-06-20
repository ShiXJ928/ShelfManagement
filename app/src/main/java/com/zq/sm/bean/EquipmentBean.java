package com.zq.sm.bean;

/**
 * Created by Administrator on 2018/6/8.
 */

public class EquipmentBean {

    private String name;
    private String imageUrl;
    private int totalNum;

    public EquipmentBean() {
    }

    public EquipmentBean(String name, String imageUrl, int totalNum) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.totalNum = totalNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
}
