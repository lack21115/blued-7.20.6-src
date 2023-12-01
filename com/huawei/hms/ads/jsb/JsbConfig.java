package com.huawei.hms.ads.jsb;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jsb/JsbConfig.class */
public class JsbConfig {
    private boolean Code;
    private String I;
    private String V;
    private boolean Z;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jsb/JsbConfig$Builder.class */
    public static final class Builder {
        private boolean Code = true;
        private String I;
        private String V;
        private boolean Z;

        public final JsbConfig build() {
            return new JsbConfig(this);
        }

        public final Builder enableLog(boolean z) {
            this.Z = z;
            return this;
        }

        public final Builder enableUserInfo(boolean z) {
            this.Code = z;
            return this;
        }

        public final Builder initGrs(String str) {
            this.V = str;
            return this;
        }

        public final Builder initGrs(String str, String str2) {
            this.V = str;
            this.I = str2;
            return this;
        }
    }

    private JsbConfig(Builder builder) {
        this.Code = true;
        this.Code = builder.Code;
        this.V = builder.V;
        this.I = builder.I;
        this.Z = builder.Z;
    }

    public boolean Code() {
        return this.Code;
    }

    public String I() {
        return this.I;
    }

    public String V() {
        return this.V;
    }

    public boolean Z() {
        return this.Z;
    }
}
