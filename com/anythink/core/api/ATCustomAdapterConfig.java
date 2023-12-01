package com.anythink.core.api;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATCustomAdapterConfig.class */
public class ATCustomAdapterConfig {
    private long adCacheTime;
    private boolean realTimeBidSwitch;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/ATCustomAdapterConfig$Builder.class */
    public static class Builder {
        private boolean realTimeBidSwitch = false;
        private long adCacheTime = 1800000;

        public Builder adCacheTime(long j) {
            this.adCacheTime = j;
            return this;
        }

        public ATCustomAdapterConfig build() {
            ATCustomAdapterConfig aTCustomAdapterConfig = new ATCustomAdapterConfig();
            aTCustomAdapterConfig.realTimeBidSwitch = this.realTimeBidSwitch;
            aTCustomAdapterConfig.adCacheTime = this.adCacheTime;
            return aTCustomAdapterConfig;
        }

        public Builder realTimeBidSwitch(boolean z) {
            this.realTimeBidSwitch = z;
            return this;
        }
    }

    private ATCustomAdapterConfig() {
    }

    public long getAdCacheTime() {
        return this.adCacheTime;
    }

    public boolean isRealTimeBidSwitch() {
        return this.realTimeBidSwitch;
    }
}
