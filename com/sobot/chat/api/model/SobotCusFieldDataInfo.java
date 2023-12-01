package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotCusFieldDataInfo.class */
public class SobotCusFieldDataInfo implements Serializable {
    private String companyId;
    private String createId;
    private String createTime;
    private String dataId;
    private String dataName;
    private int dataStatus;
    private String dataValue;
    private String fieldId;
    private String fieldVariable;
    private boolean isChecked;
    private boolean isHasNext;
    private String parentDataId;
    private String updateId;
    private String updateTime;

    public String getCompanyId() {
        return this.companyId;
    }

    public String getCreateId() {
        return this.createId;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getDataId() {
        return this.dataId;
    }

    public String getDataName() {
        return this.dataName;
    }

    public int getDataStatus() {
        return this.dataStatus;
    }

    public String getDataValue() {
        return this.dataValue;
    }

    public String getFieldId() {
        return this.fieldId;
    }

    public String getFieldVariable() {
        return this.fieldVariable;
    }

    public String getParentDataId() {
        return this.parentDataId;
    }

    public String getUpdateId() {
        return this.updateId;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isHasNext() {
        return this.isHasNext;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public void setCompanyId(String str) {
        this.companyId = str;
    }

    public void setCreateId(String str) {
        this.createId = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setDataId(String str) {
        this.dataId = str;
    }

    public void setDataName(String str) {
        this.dataName = str;
    }

    public void setDataStatus(int i) {
        this.dataStatus = i;
    }

    public void setDataValue(String str) {
        this.dataValue = str;
    }

    public void setFieldId(String str) {
        this.fieldId = str;
    }

    public void setFieldVariable(String str) {
        this.fieldVariable = str;
    }

    public void setHasNext(boolean z) {
        this.isHasNext = z;
    }

    public void setParentDataId(String str) {
        this.parentDataId = str;
    }

    public void setUpdateId(String str) {
        this.updateId = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public String toString() {
        return "SobotCusFieldDataInfo{companyId='" + this.companyId + "', createId='" + this.createId + "', createTime=" + this.createTime + ", dataId='" + this.dataId + "', dataName='" + this.dataName + "', dataStatus=" + this.dataStatus + ", dataValue='" + this.dataValue + "', fieldId='" + this.fieldId + "', fieldVariable='" + this.fieldVariable + "', parentDataId='" + this.parentDataId + "', updateId='" + this.updateId + "', updateTime=" + this.updateTime + ", isChecked=" + this.isChecked + '}';
    }
}
