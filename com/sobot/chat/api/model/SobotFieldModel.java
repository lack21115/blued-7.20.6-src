package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotFieldModel.class */
public class SobotFieldModel implements Serializable {
    private SobotCusFieldConfig cusFieldConfig;
    private List<SobotCusFieldDataInfo> cusFieldDataInfoList;

    public SobotCusFieldConfig getCusFieldConfig() {
        return this.cusFieldConfig;
    }

    public List<SobotCusFieldDataInfo> getCusFieldDataInfoList() {
        return this.cusFieldDataInfoList;
    }

    public void setCusFieldConfig(SobotCusFieldConfig sobotCusFieldConfig) {
        this.cusFieldConfig = sobotCusFieldConfig;
    }

    public void setCusFieldDataInfoList(List<SobotCusFieldDataInfo> list) {
        this.cusFieldDataInfoList = list;
    }

    public String toString() {
        return "SobotFieldModel{cusFieldConfig=" + this.cusFieldConfig + ", cusFieldDataInfoList=" + this.cusFieldDataInfoList + '}';
    }
}
