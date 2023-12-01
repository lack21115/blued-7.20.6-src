package com.anythink.core.api;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATDebuggerConfig.class */
public class ATDebuggerConfig {
    private int mBannerType;
    private int mInterstitialType;
    private int mNativeType;
    private int mNetworkFirmId;
    private int mRewarderVideoType;
    private int mSplashType;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATDebuggerConfig$Builder.class */
    public static class Builder {
        private int mBannerType;
        private int mInterstitialType;
        private int mNativeType;
        private int mNetworkFirmId;
        private int mRewarderVideoType;
        private int mSplashType;

        public Builder(int i) {
            this.mNetworkFirmId = i;
            fillDefaultType(i);
        }

        private void fillDefaultType(int i) {
            if (i == 1) {
                this.mNativeType = 1;
                return;
            }
            if (i == 2) {
                this.mNativeType = 1;
            } else if (i == 6) {
                this.mNativeType = 1;
            } else if (i == 8) {
                this.mNativeType = 1;
            } else if (i == 15) {
                this.mNativeType = 101;
                this.mInterstitialType = 3;
                return;
            } else if (i == 28) {
                this.mNativeType = 101;
                return;
            } else if (i == 39) {
                this.mNativeType = 1;
            } else if (i == 59) {
                this.mBannerType = 1;
                return;
            } else if (i != 66) {
                if (i == 22) {
                    this.mNativeType = 1;
                    this.mInterstitialType = 2;
                    return;
                } else if (i != 23) {
                    return;
                } else {
                    this.mInterstitialType = 1;
                    return;
                }
            }
            this.mInterstitialType = 1;
        }

        public ATDebuggerConfig build() {
            ATDebuggerConfig aTDebuggerConfig = new ATDebuggerConfig();
            aTDebuggerConfig.mNetworkFirmId = this.mNetworkFirmId;
            aTDebuggerConfig.mNativeType = this.mNativeType;
            aTDebuggerConfig.mBannerType = this.mBannerType;
            aTDebuggerConfig.mSplashType = this.mSplashType;
            aTDebuggerConfig.mInterstitialType = this.mInterstitialType;
            aTDebuggerConfig.mRewarderVideoType = this.mRewarderVideoType;
            return aTDebuggerConfig;
        }

        public Builder setBannerType(int i) {
            this.mBannerType = i;
            return this;
        }

        public Builder setInterstitial(int i) {
            this.mInterstitialType = i;
            return this;
        }

        public Builder setNativeType(int i) {
            this.mNativeType = i;
            return this;
        }

        public Builder setRewardedVideoType(int i) {
            this.mRewarderVideoType = i;
            return this;
        }

        public Builder setSplashType(int i) {
            this.mSplashType = i;
            return this;
        }
    }

    public void fillRequestParam(JSONObject jSONObject) {
        try {
            jSONObject.put("is_test", 1);
            jSONObject.put("test_nw_firm", this.mNetworkFirmId);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", this.mNativeType);
            jSONObject2.put("2", this.mBannerType);
            jSONObject2.put("1", this.mRewarderVideoType);
            jSONObject2.put("3", this.mInterstitialType);
            jSONObject2.put("4", this.mSplashType);
            if (jSONObject2.length() > 0) {
                jSONObject.put("test_format_sub", jSONObject2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getBannerType() {
        return this.mBannerType;
    }

    public int getInterstitialType() {
        return this.mInterstitialType;
    }

    public int getNativeType() {
        return this.mNativeType;
    }

    public int getNetworkFirmId() {
        return this.mNetworkFirmId;
    }

    public int getRewarderVideoType() {
        return this.mRewarderVideoType;
    }

    public int getSplashType() {
        return this.mSplashType;
    }
}
