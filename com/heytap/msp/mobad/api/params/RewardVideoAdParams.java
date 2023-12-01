package com.heytap.msp.mobad.api.params;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/params/RewardVideoAdParams.class */
public class RewardVideoAdParams {
    public final long fetchTimeout;

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/params/RewardVideoAdParams$Builder.class */
    public static class Builder {
        private static final long DEFAULT_FETCH_TIMEOUT = 5000;
        private static final long MIX_FETCH_TIMEOUT = 1000;
        private long fetchTimeout = 5000;

        public RewardVideoAdParams build() {
            return new RewardVideoAdParams(this);
        }

        public Builder setFetchTimeout(long j) {
            if (j >= 1000) {
                this.fetchTimeout = j;
            }
            return this;
        }
    }

    public RewardVideoAdParams(Builder builder) {
        this.fetchTimeout = builder.fetchTimeout;
    }
}
