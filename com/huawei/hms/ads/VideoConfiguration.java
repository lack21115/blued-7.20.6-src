package com.huawei.hms.ads;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/VideoConfiguration.class */
public class VideoConfiguration {
    private boolean Code;
    private boolean I;
    private boolean V;
    private int Z;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/VideoConfiguration$Builder.class */
    public static final class Builder {
        private boolean Code = true;
        private boolean V = false;
        private boolean I = false;
        private int Z = 1;

        public final VideoConfiguration build() {
            return new VideoConfiguration(this);
        }

        public Builder setAudioFocusType(int i) {
            this.Z = i;
            return this;
        }

        public Builder setClickToFullScreenRequested(boolean z) {
            this.I = z;
            return this;
        }

        public Builder setCustomizeOperateRequested(boolean z) {
            this.V = z;
            return this;
        }

        public Builder setStartMuted(boolean z) {
            this.Code = z;
            return this;
        }
    }

    private VideoConfiguration(Builder builder) {
        this.Code = true;
        this.V = false;
        this.I = false;
        this.Z = 1;
        if (builder != null) {
            this.Code = builder.Code;
            this.I = builder.I;
            this.V = builder.V;
            this.Z = builder.Z;
        }
    }

    public int getAudioFocusType() {
        return this.Z;
    }

    public final boolean isClickToFullScreenRequested() {
        return this.I;
    }

    public final boolean isCustomizeOperateRequested() {
        return this.V;
    }

    public final boolean isStartMuted() {
        return this.Code;
    }
}
