package com.heytap.msp.mobad.api.params;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/params/NativeAdParams.class */
public class NativeAdParams {
    public final long fetchTimeout;

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/params/NativeAdParams$Builder.class */
    public static class Builder {
        private static final long MAX_FETCH_TIMEOUT = 30000;
        private static final long MIX_FETCH_TIMEOUT = 500;
        private long fetchTimeout = 30000;

        public NativeAdParams build() {
            return new NativeAdParams(this);
        }

        public Builder setFetchTimeout(long j) {
            if (j >= 500 && j <= 30000) {
                this.fetchTimeout = j;
            }
            return this;
        }
    }

    public NativeAdParams(Builder builder) {
        this.fetchTimeout = builder.fetchTimeout;
    }

    public String toString() {
        return "NativeAdParams{fetchTimeout=" + this.fetchTimeout + '}';
    }
}
