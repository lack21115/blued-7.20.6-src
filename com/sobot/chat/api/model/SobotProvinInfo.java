package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotProvinInfo.class */
public class SobotProvinInfo implements Serializable {
    List<SobotProvinceModel> areas;
    List<SobotProvinceModel> citys;
    List<SobotProvinceModel> provinces;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotProvinInfo$SobotProvinceModel.class */
    public static class SobotProvinceModel implements Serializable {
        public String areaId;
        public String areaName;
        public String cityId;
        public String cityName;
        public boolean nodeFlag;
        public String provinceId;
        public String provinceName;
        public int level = 0;
        public boolean isChecked = false;

        public String toString() {
            return "SobotProvinceModel{provinceId='" + this.provinceId + "', provinceName='" + this.provinceName + "', cityId='" + this.cityId + "', cityName='" + this.cityName + "', areaId='" + this.areaId + "', areaName='" + this.areaName + "', level=" + this.level + ", isChecked=" + this.isChecked + '}';
        }
    }

    public List<SobotProvinceModel> getAreas() {
        return this.areas;
    }

    public List<SobotProvinceModel> getCitys() {
        return this.citys;
    }

    public List<SobotProvinceModel> getProvinces() {
        return this.provinces;
    }

    public void setAreas(List<SobotProvinceModel> list) {
        this.areas = list;
    }

    public void setCitys(List<SobotProvinceModel> list) {
        this.citys = list;
    }

    public void setProvinces(List<SobotProvinceModel> list) {
        this.provinces = list;
    }
}
