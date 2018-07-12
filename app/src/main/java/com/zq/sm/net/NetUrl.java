package com.zq.sm.net;

public class NetUrl {
    public static String URL = "http://112.74.179.218:7070";

    public final static String POST_SHELF_INFO = URL + "/APIData/GetEquipCount";//获取货架信息
    public final static String POST_OVERDUE_EQUIPMENT_LIST = URL + "/APIData/GetExpireList";//获取过期装备列表
    public final static String POST_LEND_EQUIPMENT_LIST = URL + "/APIData/GetRevertList";//获取借出装备列表
    public final static String POST_EQUIPMENT_LIST = URL + "/APIData/PostEquipByTypeList";//根据类型获取对应装备列表
}

