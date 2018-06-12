package com.zq.sm.bean;

/**
 * Created by Administrator on 2018/6/12.
 */

public class LendEquipmentBean {

    private String equipID;
    private String equipName;
    private String userName;
    private String userCompany;
    private String lendTime;
    private String returnTime;

    public LendEquipmentBean() {
    }

    public LendEquipmentBean(String equipID,String equipName, String userName, String userCompany, String lendTime, String returnTime) {
        this.equipID = equipID;
        this.equipName = equipName;
        this.userName = userName;
        this.userCompany = userCompany;
        this.lendTime = lendTime;
        this.returnTime = returnTime;
    }

    public String getEquipName() {
        return equipName;
    }

    public String getEquipID() {
        return equipID;
    }

    public void setEquipID(String equipID) {
        this.equipID = equipID;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(String userCompany) {
        this.userCompany = userCompany;
    }

    public String getLendTime() {
        return lendTime;
    }

    public void setLendTime(String lendTime) {
        this.lendTime = lendTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }
}
