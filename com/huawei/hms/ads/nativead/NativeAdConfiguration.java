package com.huawei.hms.ads.nativead;

import com.huawei.hms.ads.AdSize;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.s;
import com.huawei.hms.ads.u;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/NativeAdConfiguration.class */
public class NativeAdConfiguration {
    s Code;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/NativeAdConfiguration$Builder.class */
    public static final class Builder {
        s Code = new u();

        public final NativeAdConfiguration build() {
            return new NativeAdConfiguration(this);
        }

        public final Builder setAdSize(AdSize adSize) {
            this.Code.Code(adSize);
            return this;
        }

        public final Builder setAdType(int i) {
            this.Code.Z(i);
            return this;
        }

        public final Builder setChoicesPosition(int i) {
            this.Code.I(i);
            return this;
        }

        public final Builder setMediaAspect(int i) {
            this.Code.V(i);
            return this;
        }

        public final Builder setMediaDirection(int i) {
            this.Code.Code(i);
            return this;
        }

        public final Builder setRequestCustomDislikeThisAd(boolean z) {
            this.Code.I(z);
            return this;
        }

        public final Builder setRequestMultiImages(boolean z) {
            this.Code.V(z);
            return this;
        }

        public final Builder setReturnUrlsForImages(boolean z) {
            this.Code.Code(z);
            return this;
        }

        public final Builder setVideoConfiguration(VideoConfiguration videoConfiguration) {
            this.Code.Code(videoConfiguration);
            return this;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/NativeAdConfiguration$ChoicesPosition.class */
    public interface ChoicesPosition {
        public static final int BOTTOM_LEFT = 3;
        public static final int BOTTOM_RIGHT = 2;
        public static final int INVISIBLE = 4;
        public static final int TOP_LEFT = 0;
        public static final int TOP_RIGHT = 1;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/NativeAdConfiguration$Direction.class */
    public interface Direction {
        public static final int ANY = 0;
        public static final int LANDSCAPE = 2;
        public static final int PORTRAIT = 1;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/NativeAdConfiguration$MediaAspect.class */
    public interface MediaAspect {
        public static final int ASPECT_ANY = 1;
        public static final int ASPECT_CUSTOM_SIZE = -1;
        public static final int ASPECT_LANDSCAPE = 2;
        public static final int ASPECT_PORTRAIT = 3;
        public static final int ASPECT_SQUARE = 4;
        public static final int ASPECT_UNKNOWN = 0;
    }

    private NativeAdConfiguration(Builder builder) {
        this.Code = builder.Code;
    }

    public final boolean Code() {
        return this.Code.S();
    }

    public Integer V() {
        return this.Code.F();
    }

    public final AdSize getAdSize() {
        return this.Code.D();
    }

    public final int getAdType() {
        return this.Code.L();
    }

    public final int getChoicesPosition() {
        return this.Code.B();
    }

    public final int getMediaAspect() {
        return this.Code.I();
    }

    public final int getMediaDirection() {
        return this.Code.V();
    }

    public final VideoConfiguration getVideoConfiguration() {
        return this.Code.C();
    }

    public final boolean isRequestMultiImages() {
        return this.Code.Z();
    }

    public final boolean isReturnUrlsForImages() {
        return this.Code.Code();
    }
}
