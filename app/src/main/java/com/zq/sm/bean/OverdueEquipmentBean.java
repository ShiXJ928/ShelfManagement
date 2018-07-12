package com.zq.sm.bean;

/**
 * Created by Administrator on 2018/6/12.
 */

public class OverdueEquipmentBean {


    /**
     * ShowName : 警戒带(03020015)
     * ImageUrl : null
     * Expirydate : /Date(1529596800000)/
     * Site : 第一列货架-1-4
     * days : -5
     */

    private String ShowName;
    private String ImageUrl;
    private String Expirydate;
    private String Site;
    private int days;

    public String getShowName() {
        return ShowName;
    }

    public void setShowName(String ShowName) {
        this.ShowName = ShowName;
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

    public String getExpirydate() {
        return Expirydate;
    }

    public void setExpirydate(String Expirydate) {
        this.Expirydate = Expirydate;
    }

    public String getSite() {
        return Site;
    }

    public void setSite(String Site) {
        this.Site = Site;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
