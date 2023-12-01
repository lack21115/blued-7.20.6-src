package com.opos.cmn.biz.ststrategy.entity;

import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/entity/MetaEntity.class */
public class MetaEntity {
    public final int aggrFlag;
    public final int batchNums;
    public final int category;
    public final String dataType;
    public final List<String> eventKeys;
    public final int eventValue;
    public final int immFlag;
    public final List<String> judgePosids;
    public final long modifyTime;
    public final String newDatatype;
    public final List<String> oldMetaNameList;
    public final String setName;
    public final String split;
    public final int uploadFlag;
    public final String url;
    public final String version;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/entity/MetaEntity$Builder.class */
    public static class Builder {
        public int aggrFlag;
        public int batchNums;
        public int category;
        public String dataType;
        public List<String> eventKeys;
        public int eventValue;
        public int immFlag;
        public List<String> judgePosids;
        public long modifyTime;
        public String newDatatype;
        public List<String> oldMetaNameList;
        public String setName;
        public String split;
        public int uploadFlag;
        public String url;
        public String version;

        public MetaEntity build() {
            return new MetaEntity(this);
        }

        public Builder setAggrFlag(int i) {
            this.aggrFlag = i;
            return this;
        }

        public Builder setBatchNums(int i) {
            this.batchNums = i;
            return this;
        }

        public Builder setCategory(int i) {
            this.category = i;
            return this;
        }

        public Builder setDataType(String str) {
            this.dataType = str;
            return this;
        }

        public Builder setEventKeys(List<String> list) {
            this.eventKeys = list;
            return this;
        }

        public Builder setEventValue(int i) {
            this.eventValue = i;
            return this;
        }

        public Builder setImmFlag(int i) {
            this.immFlag = i;
            return this;
        }

        public Builder setJudgePosids(List<String> list) {
            this.judgePosids = list;
            return this;
        }

        public Builder setModifyTime(long j) {
            this.modifyTime = j;
            return this;
        }

        public Builder setName(String str) {
            this.setName = str;
            return this;
        }

        public void setNewDatatype(String str) {
            this.newDatatype = str;
        }

        public void setOldMetaNameList(List<String> list) {
            this.oldMetaNameList = list;
        }

        public Builder setSplit(String str) {
            this.split = str;
            return this;
        }

        public Builder setUploadFlag(int i) {
            this.uploadFlag = i;
            return this;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }

    private MetaEntity(Builder builder) {
        this.dataType = builder.dataType;
        this.category = builder.category;
        this.eventValue = builder.eventValue;
        this.setName = builder.setName;
        this.url = builder.url;
        this.eventKeys = builder.eventKeys;
        this.immFlag = builder.immFlag;
        this.aggrFlag = builder.aggrFlag;
        this.batchNums = builder.batchNums;
        this.uploadFlag = builder.uploadFlag;
        this.modifyTime = builder.modifyTime;
        this.split = builder.split;
        this.judgePosids = builder.judgePosids;
        this.oldMetaNameList = builder.oldMetaNameList;
        this.newDatatype = builder.newDatatype;
        this.version = builder.version;
    }

    public String toString() {
        return "MetaEntity{dataType='" + this.dataType + "', category=" + this.category + ", eventValue=" + this.eventValue + ", setName='" + this.setName + "', url='" + this.url + "', eventKeys=" + this.eventKeys + ", immFlag=" + this.immFlag + ", aggrFlag=" + this.aggrFlag + ", batchNums=" + this.batchNums + ", uploadFlag=" + this.uploadFlag + ", modifyTime=" + this.modifyTime + ", split='" + this.split + "', judgePosids=" + this.judgePosids + ", oldMetaNameList=" + this.oldMetaNameList + ", newDatatype='" + this.newDatatype + "', version='" + this.version + "'}";
    }
}
