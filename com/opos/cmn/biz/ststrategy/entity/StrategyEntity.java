package com.opos.cmn.biz.ststrategy.entity;

import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/entity/StrategyEntity.class */
public class StrategyEntity {
    public final List<String> aesKeys;
    public final int batchNums;
    public final int blaLimit;
    public final List<String> bodyKeys;
    public final List<String> commonKeys;
    public final List<String> dmKeys;
    public final int dtLimit;
    public final List<String> extKeys;
    public final int frequencyTime;
    public final List<String> headKeys;
    public final List<String> md5Keys;
    public final long modifyTime;
    public final List<String> noKeys;
    public final int prtflg;
    public final int reportLimit;
    public final List<String> sha256Keys;
    public final int triggerNums;
    public final int wfTime;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/entity/StrategyEntity$Builder.class */
    public static class Builder {
        public List<String> aesKeys;
        public int batchNums;
        public int blaLimit;
        public List<String> bodyKeys;
        public List<String> commonKeys;
        public List<String> dmKeys;
        public int dtLimit;
        public List<String> extKeys;
        public int frequencyTime;
        public List<String> headKeys;
        public List<String> md5Keys;
        public long modifyTime;
        public List<String> noKeys;
        public int prtflg;
        public int reportLimit;
        public List<String> sha256Keys;
        public int triggerNums;
        public int wfTime;

        public StrategyEntity build() {
            return new StrategyEntity(this);
        }

        public Builder setAesKeys(List<String> list) {
            this.aesKeys = list;
            return this;
        }

        public Builder setBatchNums(int i) {
            this.batchNums = i;
            return this;
        }

        public Builder setBodyKeys(List<String> list) {
            this.bodyKeys = list;
            return this;
        }

        public Builder setCommonKeys(List<String> list) {
            this.commonKeys = list;
            return this;
        }

        public Builder setDmKeys(List<String> list) {
            this.dmKeys = list;
            return this;
        }

        public Builder setExtKeys(List<String> list) {
            this.extKeys = list;
            return this;
        }

        public Builder setFrequencyTime(int i) {
            this.frequencyTime = i;
            return this;
        }

        public Builder setHeadKeys(List<String> list) {
            this.headKeys = list;
            return this;
        }

        public Builder setMd5Keys(List<String> list) {
            this.md5Keys = list;
            return this;
        }

        public Builder setModifyTime(long j) {
            this.modifyTime = j;
            return this;
        }

        public Builder setNoKeys(List<String> list) {
            this.noKeys = list;
            return this;
        }

        public Builder setPrtflg(int i) {
            this.prtflg = i;
            return this;
        }

        public Builder setReportLimit(int i) {
            this.reportLimit = i;
            return this;
        }

        public Builder setSha256Keys(List<String> list) {
            this.sha256Keys = list;
            return this;
        }

        public Builder setTriggerNums(int i) {
            this.triggerNums = i;
            return this;
        }

        public Builder setWfTime(int i) {
            this.wfTime = i;
            return this;
        }
    }

    private StrategyEntity(Builder builder) {
        this.frequencyTime = builder.frequencyTime;
        this.batchNums = builder.batchNums;
        this.headKeys = builder.headKeys;
        this.bodyKeys = builder.bodyKeys;
        this.commonKeys = builder.commonKeys;
        this.dmKeys = builder.dmKeys;
        this.modifyTime = builder.modifyTime;
        this.wfTime = builder.wfTime;
        this.triggerNums = builder.triggerNums;
        this.prtflg = builder.prtflg;
        this.aesKeys = builder.aesKeys;
        this.sha256Keys = builder.sha256Keys;
        this.md5Keys = builder.md5Keys;
        this.noKeys = builder.noKeys;
        this.reportLimit = builder.reportLimit;
        this.extKeys = builder.extKeys;
        this.blaLimit = builder.blaLimit;
        this.dtLimit = builder.dtLimit;
    }

    public String toString() {
        return "StrategyEntity{frequencyTime=" + this.frequencyTime + ", batchNums=" + this.batchNums + ", headKeys=" + this.headKeys + ", bodyKeys=" + this.bodyKeys + ", commonKeys=" + this.commonKeys + ", dmKeys=" + this.dmKeys + ", modifyTime=" + this.modifyTime + ", wfTime=" + this.wfTime + ", triggerNums=" + this.triggerNums + ", prtflg=" + this.prtflg + ", aesKeys=" + this.aesKeys + ", sha256Keys=" + this.sha256Keys + ", md5Keys=" + this.md5Keys + ", noKeys=" + this.noKeys + ", reportLimit=" + this.reportLimit + ", extKeys=" + this.extKeys + ", dtLimit=" + this.dtLimit + ", blaLimit=" + this.blaLimit + '}';
    }
}
