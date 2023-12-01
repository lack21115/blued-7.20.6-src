package com.tencent.thumbplayer.api;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPInitParams.class */
public class TPInitParams {
    private String mDeviceName;
    private String mGuid;
    private int mPlatform;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPInitParams$Builder.class */
    public static class Builder {
        private String mGuid = "";
        private int mPlatform = 0;
        private String mDeviceName = "";

        public TPInitParams build() {
            TPInitParams tPInitParams = new TPInitParams();
            tPInitParams.mPlatform = this.mPlatform;
            tPInitParams.mGuid = this.mGuid;
            tPInitParams.mDeviceName = this.mDeviceName;
            return tPInitParams;
        }

        public Builder setDeviceName(String str) {
            this.mDeviceName = str;
            return this;
        }

        public Builder setGuid(String str) {
            this.mGuid = str;
            return this;
        }

        public Builder setPlatform(int i) {
            this.mPlatform = i;
            return this;
        }
    }

    private TPInitParams() {
        this.mGuid = "";
        this.mPlatform = 0;
        this.mDeviceName = "";
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public String getGuid() {
        return this.mGuid;
    }

    public int getPlatform() {
        return this.mPlatform;
    }
}
