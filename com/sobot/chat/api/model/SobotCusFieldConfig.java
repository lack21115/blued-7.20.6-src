package com.sobot.chat.api.model;

import com.sobot.chat.api.model.SobotProvinInfo;
import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotCusFieldConfig.class */
public class SobotCusFieldConfig implements Serializable {
    private String companyId;
    private String createId;
    private String createTime;
    private String fieldId;
    private String fieldName;
    private String fieldRemark;
    private int fieldStatus;
    private int fieldType;
    private String fieldVariable;
    private int fillFlag;
    private String id;
    private boolean isChecked;
    private String limitChar;
    private String limitOptions;
    private int operateType;
    private SobotProvinInfo.SobotProvinceModel provinceModel;
    private String showName;
    private int sortNo;
    private String updateId;
    private String updateTime;
    private String value;
    private int workShowFlag;
    private int workSortNo;

    public String getCompanyId() {
        return this.companyId;
    }

    public String getCreateId() {
        return this.createId;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getFieldId() {
        return this.fieldId;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String getFieldRemark() {
        return this.fieldRemark;
    }

    public int getFieldStatus() {
        return this.fieldStatus;
    }

    public int getFieldType() {
        return this.fieldType;
    }

    public String getFieldVariable() {
        return this.fieldVariable;
    }

    public int getFillFlag() {
        return this.fillFlag;
    }

    public String getId() {
        return this.id;
    }

    public String getLimitChar() {
        return this.limitChar;
    }

    public String getLimitOptions() {
        return this.limitOptions;
    }

    public int getOperateType() {
        return this.operateType;
    }

    public SobotProvinInfo.SobotProvinceModel getProvinceModel() {
        return this.provinceModel;
    }

    public String getShowName() {
        return this.showName;
    }

    public int getSortNo() {
        return this.sortNo;
    }

    public String getUpdateId() {
        return this.updateId;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public String getValue() {
        return this.value;
    }

    public int getWorkShowFlag() {
        return this.workShowFlag;
    }

    public int getWorkSortNo() {
        return this.workSortNo;
    }

    public boolean isChecked() {
        return this.isChecked;
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

    public void setFieldId(String str) {
        this.fieldId = str;
    }

    public void setFieldName(String str) {
        this.fieldName = str;
    }

    public void setFieldRemark(String str) {
        this.fieldRemark = str;
    }

    public void setFieldStatus(int i) {
        this.fieldStatus = i;
    }

    public void setFieldType(int i) {
        this.fieldType = i;
    }

    public void setFieldVariable(String str) {
        this.fieldVariable = str;
    }

    public void setFillFlag(int i) {
        this.fillFlag = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLimitChar(String str) {
        this.limitChar = str;
    }

    public void setLimitOptions(String str) {
        this.limitOptions = str;
    }

    public void setOperateType(int i) {
        this.operateType = i;
    }

    public void setProvinceModel(SobotProvinInfo.SobotProvinceModel sobotProvinceModel) {
        this.provinceModel = sobotProvinceModel;
    }

    public void setShowName(String str) {
        this.showName = str;
    }

    public void setSortNo(int i) {
        this.sortNo = i;
    }

    public void setUpdateId(String str) {
        this.updateId = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public void setWorkShowFlag(int i) {
        this.workShowFlag = i;
    }

    public void setWorkSortNo(int i) {
        this.workSortNo = i;
    }

    public String toString() {
        return "SobotCusFieldConfig{companyId='" + this.companyId + "', createId='" + this.createId + "', createTime=" + this.createTime + ", fieldId='" + this.fieldId + "', fieldName='" + this.fieldName + "', fieldRemark='" + this.fieldRemark + "', fieldStatus=" + this.fieldStatus + ", fieldType=" + this.fieldType + ", fieldVariable='" + this.fieldVariable + "', fillFlag=" + this.fillFlag + ", operateType=" + this.operateType + ", sortNo=" + this.sortNo + ", updateId='" + this.updateId + "', updateTime=" + this.updateTime + ", workShowFlag=" + this.workShowFlag + ", workSortNo=" + this.workSortNo + ", isChecked=" + this.isChecked + ", id=" + this.id + ", value=" + this.value + '}';
    }
}
