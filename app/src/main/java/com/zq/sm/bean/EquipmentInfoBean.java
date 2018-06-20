package com.zq.sm.bean;

/**
 * Created by AIERXUAN on 2018/6/20.
 */

public class EquipmentInfoBean {

    private String equipID;
    private String equipName;
    private String imageUrl;
    private String statues;
    private String position;
    private String overdueTime;
    private String manufactureTime;

    public EquipmentInfoBean() {
    }

    public EquipmentInfoBean(String equipID, String equipName, String imageUrl, String statues, String position, String overdueTime, String manufactureTime) {
        this.equipID = equipID;
        this.equipName = equipName;
        this.imageUrl = imageUrl;
        this.statues = statues;
        this.position = position;
        this.overdueTime = overdueTime;
        this.manufactureTime = manufactureTime;
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

    public String getStatues() {
        return statues;
    }

    public void setStatues(String statues) {
        this.statues = statues;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(String overdueTime) {
        this.overdueTime = overdueTime;
    }

    public String getManufactureTime() {
        return manufactureTime;
    }

    public void setManufactureTime(String manufactureTime) {
        this.manufactureTime = manufactureTime;
    }
}
