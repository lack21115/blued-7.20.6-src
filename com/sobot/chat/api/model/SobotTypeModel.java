package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotTypeModel.class */
public class SobotTypeModel implements Serializable {
    private String companyId;
    private String createId;
    private String createTime;
    private boolean isChecked;
    private ArrayList<SobotTypeModel> items;
    private int nodeFlag;
    private String parentId;
    private String remark;
    private String typeId;
    private int typeLevel;
    private String typeName;
    private String updateId;
    private String updateTime;
    private int validFlag;

    public String getCompanyId() {
        return this.companyId;
    }

    public String getCreateId() {
        return this.createId;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public ArrayList<SobotTypeModel> getItems() {
        return this.items;
    }

    public int getNodeFlag() {
        return this.nodeFlag;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getTypeId() {
        return this.typeId;
    }

    public int getTypeLevel() {
        return this.typeLevel;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public String getUpdateId() {
        return this.updateId;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public int getValidFlag() {
        return this.validFlag;
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

    public void setItems(ArrayList<SobotTypeModel> arrayList) {
        this.items = arrayList;
    }

    public void setNodeFlag(int i) {
        this.nodeFlag = i;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setTypeId(String str) {
        this.typeId = str;
    }

    public void setTypeLevel(int i) {
        this.typeLevel = i;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }

    public void setUpdateId(String str) {
        this.updateId = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public void setValidFlag(int i) {
        this.validFlag = i;
    }

    public String toString() {
        return "SobotTypeModel{companyId='" + this.companyId + "', createId='" + this.createId + "', createTime=" + this.createTime + ", nodeFlag=" + this.nodeFlag + ", parentId='" + this.parentId + "', remark='" + this.remark + "', typeId='" + this.typeId + "', typeLevel=" + this.typeLevel + ", typeName='" + this.typeName + "', updateId='" + this.updateId + "', updateTime=" + this.updateTime + ", validFlag=" + this.validFlag + ", isChecked=" + this.isChecked + ", items=" + this.items + '}';
    }
}
