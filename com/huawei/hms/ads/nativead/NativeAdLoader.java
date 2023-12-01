package com.huawei.hms.ads.nativead;

import android.content.Context;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.h;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.o;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/NativeAdLoader.class */
public class NativeAdLoader {
    private o Code;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/NativeAdLoader$Builder.class */
    public static class Builder {
        private o Code;

        public Builder(Context context, String str) {
            this.Code = new h(context, str);
        }

        public NativeAdLoader build() {
            return new NativeAdLoader(this);
        }

        public Builder setAdListener(AdListener adListener) {
            this.Code.Code(adListener);
            return this;
        }

        public Builder setAdsReturnedFromThread(boolean z) {
            this.Code.Code(z);
            return this;
        }

        public Builder setNativeAdLoadedListener(NativeAd.NativeAdLoadedListener nativeAdLoadedListener) {
            this.Code.Code(nativeAdLoadedListener);
            return this;
        }

        public Builder setNativeAdOptions(NativeAdConfiguration nativeAdConfiguration) {
            this.Code.Code(nativeAdConfiguration);
            return this;
        }
    }

    private NativeAdLoader(Builder builder) {
        this.Code = builder.Code;
    }

    public boolean isLoading() {
        return this.Code.Code();
    }

    public void loadAd(AdParam adParam) {
        this.Code.Code(adParam);
    }

    public void loadAds(AdParam adParam, int i) {
        this.Code.Code(adParam, i);
    }
}
