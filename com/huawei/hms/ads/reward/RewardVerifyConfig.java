package com.huawei.hms.ads.reward;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/reward/RewardVerifyConfig.class */
public class RewardVerifyConfig {
    private String Code;
    private String V;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/reward/RewardVerifyConfig$Builder.class */
    public static final class Builder {
        private String Code;
        private String V;

        public RewardVerifyConfig build() {
            return new RewardVerifyConfig(this);
        }

        public Builder setData(String str) {
            this.Code = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.V = str;
            return this;
        }
    }

    private RewardVerifyConfig() {
    }

    private RewardVerifyConfig(Builder builder) {
        if (builder != null) {
            this.Code = builder.Code;
            this.V = builder.V;
        }
    }

    public String getData() {
        return this.Code;
    }

    public String getUserId() {
        return this.V;
    }
}
