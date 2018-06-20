package com.zq.sm.bean;

/**
 * Created by Administrator on 2018/6/12.
 */

public class OverdueEquipmentBean {

    private String equipID;
    private String equipName;
    private String imageUrl;
    private String overdueTime;

    public OverdueEquipmentBean() {
    }

    public OverdueEquipmentBean(String equipID, String equipName, String imageUrl, String overdueTime) {
        this.equipID = equipID;
        this.overdueTime = overdueTime;
        this.imageUrl = imageUrl;
        this.equipName = equipName;
    }

    public String getEquipID() {
        return equipID;
    }

    public void setEquipID(String equipID) {
        this.equipID = equipID;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(String overdueTime) {
        this.overdueTime = overdueTime;
    }
}
