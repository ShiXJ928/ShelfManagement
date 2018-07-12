package com.zq.sm.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/8.
 */

public class ShelfInfo {

    /**
     * ShelfName : 第一列货架
     * EquipTypeList : [{"EquipTypeId":48,"EquiptypeName":"望远镜","EquipImageUrl":null,"Count":2},{"EquipTypeId":50,"EquiptypeName":"审讯录像设备","EquipImageUrl":null,"Count":1},{"EquipTypeId":53,"EquiptypeName":"夜视仪","EquipImageUrl":null,"Count":5},{"EquipTypeId":135,"EquiptypeName":"38mm防暴短枪","EquipImageUrl":null,"Count":1},{"EquipTypeId":138,"EquiptypeName":"金属手铐","EquipImageUrl":null,"Count":2},{"EquipTypeId":145,"EquiptypeName":"手持抓捕器","EquipImageUrl":null,"Count":4},{"EquipTypeId":147,"EquiptypeName":"长警棍","EquipImageUrl":null,"Count":5},{"EquipTypeId":148,"EquiptypeName":"警戒带","EquipImageUrl":null,"Count":21},{"EquipTypeId":153,"EquiptypeName":"路障","EquipImageUrl":null,"Count":2},{"EquipTypeId":160,"EquiptypeName":"防弹防刺服","EquipImageUrl":null,"Count":10},{"EquipTypeId":166,"EquiptypeName":"防暴头盔","EquipImageUrl":null,"Count":35},{"EquipTypeId":167,"EquiptypeName":"防暴盾牌","EquipImageUrl":null,"Count":35},{"EquipTypeId":176,"EquiptypeName":"反光背心（LED）","EquipImageUrl":null,"Count":14},{"EquipTypeId":225,"EquiptypeName":"手持喊话器","EquipImageUrl":null,"Count":1},{"EquipTypeId":234,"EquiptypeName":"救生衣","EquipImageUrl":null,"Count":3},{"EquipTypeId":238,"EquiptypeName":"急救箱","EquipImageUrl":null,"Count":2},{"EquipTypeId":256,"EquiptypeName":"发电机","EquipImageUrl":null,"Count":2},{"EquipTypeId":260,"EquiptypeName":"（伸缩）发光交通指挥棒","EquipImageUrl":null,"Count":10},{"EquipTypeId":263,"EquiptypeName":"警用急救包","EquipImageUrl":null,"Count":2},{"EquipTypeId":274,"EquiptypeName":"灭火器","EquipImageUrl":null,"Count":6},{"EquipTypeId":275,"EquiptypeName":"停车示意牌","EquipImageUrl":null,"Count":5}]
     */

    private String ShelfName;
    private List<EquipTypeListBean> EquipTypeList;

    public String getShelfName() {
        return ShelfName;
    }

    public void setShelfName(String ShelfName) {
        this.ShelfName = ShelfName;
    }

    public List<EquipTypeListBean> getEquipTypeList() {
        return EquipTypeList;
    }

    public void setEquipTypeList(List<EquipTypeListBean> EquipTypeList) {
        this.EquipTypeList = EquipTypeList;
    }

    public static class EquipTypeListBean {
        /**
         * EquipTypeId : 48
         * EquiptypeName : 望远镜
         * EquipImageUrl : null
         * Count : 2
         */

        private int EquipTypeId;
        private String EquiptypeName;
        private String EquipImageUrl;
        private int Count;

        public int getEquipTypeId() {
            return EquipTypeId;
        }

        public void setEquipTypeId(int EquipTypeId) {
            this.EquipTypeId = EquipTypeId;
        }

        public String getEquiptypeName() {
            return EquiptypeName;
        }

        public void setEquiptypeName(String EquiptypeName) {
            this.EquiptypeName = EquiptypeName;
        }

        public String getEquipImageUrl() {
            if (EquipImageUrl == null) {
                return "";
            }
            return EquipImageUrl;
        }

        public void setEquipImageUrl(String EquipImageUrl) {
            this.EquipImageUrl = EquipImageUrl;
        }

        public int getCount() {
            return Count;
        }

        public void setCount(int Count) {
            this.Count = Count;
        }
    }
}
