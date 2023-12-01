package com.qq.e.ads.rewardvideo;

import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/rewardvideo/ServerSideVerificationOptions.class */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* renamed from: a  reason: collision with root package name */
    private String f14207a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private final JSONObject f14208c;

    /* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/rewardvideo/ServerSideVerificationOptions$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f14209a;
        private String b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public Builder setCustomData(String str) {
            this.f14209a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.b = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.f14208c = new JSONObject();
        this.f14207a = builder.f14209a;
        this.b = builder.b;
    }

    public String getCustomData() {
        return this.f14207a;
    }

    public JSONObject getOptions() {
        return this.f14208c;
    }

    public String getUserId() {
        return this.b;
    }
}
