package com.opos.cmn.biz.ststrategy.entity;

import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/entity/EncryptEntity.class */
public class EncryptEntity {
    public final List<String> aesKeys;
    public final List<String> md5Keys;
    public final List<String> noKeys;
    public final List<String> sha256Keys;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/entity/EncryptEntity$Builder.class */
    public static class Builder {
        public List<String> aesKeys;
        public List<String> md5Keys;
        public List<String> noKeys;
        public List<String> sha256Keys;

        public EncryptEntity build() {
            return new EncryptEntity(this);
        }

        public Builder setAesKeys(List<String> list) {
            this.aesKeys = list;
            return this;
        }

        public Builder setMd5Keys(List<String> list) {
            this.md5Keys = list;
            return this;
        }

        public Builder setNoKeys(List<String> list) {
            this.noKeys = list;
            return this;
        }

        public Builder setSha256Keys(List<String> list) {
            this.sha256Keys = list;
            return this;
        }
    }

    public EncryptEntity(Builder builder) {
        this.aesKeys = builder.aesKeys;
        this.sha256Keys = builder.sha256Keys;
        this.md5Keys = builder.md5Keys;
        this.noKeys = builder.noKeys;
    }

    public String toString() {
        return "EncryptEntity{aesKeys=" + this.aesKeys + ", sha256Keys=" + this.sha256Keys + ", md5Keys=" + this.md5Keys + ", noKeys=" + this.noKeys + '}';
    }
}
