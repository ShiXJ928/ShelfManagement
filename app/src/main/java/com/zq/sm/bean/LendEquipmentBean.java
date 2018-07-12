package com.zq.sm.bean;

/**
 * Created by Administrator on 2018/6/12.
 */

public class LendEquipmentBean {


    /**
     * ShowName : 防弹防刺服(03010002)
     * UserName : 张卫良
     * DepartmentName : 苏州市局虎丘分局通安派出所
     * ImageUrl : null
     * LastUseTime : 2018-06-21
     * RevertTime : 2018-06-23
     */

    private String ShowName;
    private String UserName;
    private String DepartmentName;
    private String ImageUrl;
    private String LastUseTime;
    private String RevertTime;

    public String getShowName() {
        return ShowName;
    }

    public void setShowName(String ShowName) {
        this.ShowName = ShowName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    public String getImageUrl() {
        if (ImageUrl == null) {
            return "";
        }
        return ImageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    public String getLastUseTime() {
        return LastUseTime;
    }

    public void setLastUseTime(String LastUseTime) {
        this.LastUseTime = LastUseTime;
    }

    public String getRevertTime() {
        return RevertTime;
    }

    public void setRevertTime(String RevertTime) {
        this.RevertTime = RevertTime;
    }
}
