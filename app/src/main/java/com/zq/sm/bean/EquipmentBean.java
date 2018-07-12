package com.zq.sm.bean;

/**
 * Created by AIERXUAN on 2018/6/20.
 */

public class EquipmentBean {


    /**
     * RFID : 03140002
     * StatusName : 领用
     * Site : null
     * Purchasedate : 2018-06-21
     * Expirydate : 2018-05-24
     * Productdate : 2018-06-21
     */

    private String RFID;
    private String StatusName;
    private String Site;
    private String Purchasedate;
    private String Expirydate;
    private String Productdate;

    public String getRFID() {
        return RFID;
    }

    public void setRFID(String RFID) {
        this.RFID = RFID;
    }

    public String getStatusName() {
        return StatusName;
    }

    public void setStatusName(String StatusName) {
        this.StatusName = StatusName;
    }

    public String getSite() {
        if (Site == null) {
            return "";
        }
        return Site;
    }

    public void setSite(String Site) {
        this.Site = Site;
    }

    public String getPurchasedate() {
        return Purchasedate;
    }

    public void setPurchasedate(String Purchasedate) {
        this.Purchasedate = Purchasedate;
    }

    public String getExpirydate() {
        return Expirydate;
    }

    public void setExpirydate(String Expirydate) {
        this.Expirydate = Expirydate;
    }

    public String getProductdate() {
        return Productdate;
    }

    public void setProductdate(String Productdate) {
        this.Productdate = Productdate;
    }
}
