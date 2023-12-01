package com.qq.e.ads.rewardvideo;

import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/rewardvideo/ServerSideVerificationOptions.class */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* renamed from: a  reason: collision with root package name */
    private String f27895a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private final JSONObject f27896c;

    /* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/rewardvideo/ServerSideVerificationOptions$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f27897a;
        private String b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public Builder setCustomData(String str) {
            this.f27897a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.b = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.f27896c = new JSONObject();
        this.f27895a = builder.f27897a;
        this.b = builder.b;
    }

    public String getCustomData() {
        return this.f27895a;
    }

    public JSONObject getOptions() {
        return this.f27896c;
    }

    public String getUserId() {
        return this.b;
    }
}
