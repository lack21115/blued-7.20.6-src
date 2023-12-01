package com.tencent.thumbplayer.core.demuxer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/demuxer/TPNativeJitterBufferConfig.class */
public class TPNativeJitterBufferConfig {
    private long mAdjustIntervalThresholdMs;
    private long mFrozenThresholdMs;
    private long mMaxIncreaseDurationMs;
    private long mMinDecreaseDurationMs;
    private long mPerDecreaseDurationMs;
    private long mPerIncreaseDurationMs;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/demuxer/TPNativeJitterBufferConfig$Builder.class */
    public static final class Builder {
        public static final long DEFAULT_ADJUST_INTERVAL_THRESHOLD_MS = 60000;
        public static final long DEFAULT_FROZEN_THRESHOLD_MS = 800;
        public static final long DEFAULT_MAX_DECREASE_DURATION_MS = 8000;
        public static final long DEFAULT_MIN_DECREASE_DURATION_MS = 2000;
        public static final long DEFAULT_PER_DECREASE_DURATION_MS = 500;
        public static final long DEFAULT_PER_INCREASE_DURATION_MS = 1000;
        private long mMinDecreaseDurationMs = 2000;
        private long mMaxIncreaseDurationMs = 8000;
        private long mPerIncreaseDurationMs = 1000;
        private long mPerDecreaseDurationMs = 500;
        private long mAdjustIntervalThresholdMs = 60000;
        private long mFrozenThresholdMs = 800;

        public final TPNativeJitterBufferConfig build() {
            return new TPNativeJitterBufferConfig(this.mMinDecreaseDurationMs, this.mMaxIncreaseDurationMs, this.mPerIncreaseDurationMs, this.mPerDecreaseDurationMs, this.mAdjustIntervalThresholdMs, this.mFrozenThresholdMs);
        }

        public final Builder setAdjustIntervalThresholdMs(long j) {
            this.mAdjustIntervalThresholdMs = j;
            return this;
        }

        public final Builder setFrozenThresholdMs(long j) {
            this.mFrozenThresholdMs = j;
            return this;
        }

        public final Builder setMaxIncreaseDurationMs(long j) {
            this.mMaxIncreaseDurationMs = j;
            return this;
        }

        public final Builder setMinDecreaseDurationMs(long j) {
            this.mMinDecreaseDurationMs = j;
            return this;
        }

        public final Builder setPerDecreaseDurationMs(long j) {
            this.mPerDecreaseDurationMs = j;
            return this;
        }

        public final Builder setPerIncreaseDurationMs(long j) {
            this.mPerIncreaseDurationMs = j;
            return this;
        }
    }

    protected TPNativeJitterBufferConfig(long j, long j2, long j3, long j4, long j5, long j6) {
        this.mMinDecreaseDurationMs = j;
        this.mMaxIncreaseDurationMs = j2;
        this.mPerIncreaseDurationMs = j3;
        this.mPerDecreaseDurationMs = j4;
        this.mAdjustIntervalThresholdMs = j5;
        this.mFrozenThresholdMs = j6;
    }
}
