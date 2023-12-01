package com.huawei.hms.ads.templatead;

import android.content.Context;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.h;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.o;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/templatead/TemplateAdLoader.class */
public class TemplateAdLoader {
    private o Code;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/templatead/TemplateAdLoader$Builder.class */
    public static class Builder {
        private o Code;

        public Builder(Context context, String str) {
            this.Code = new h(context, str);
        }

        public TemplateAdLoader build() {
            return new TemplateAdLoader(this);
        }

        public Builder setAdListener(AdListener adListener) {
            this.Code.Code(adListener);
            return this;
        }

        public Builder setAdsReturnedFromThread(boolean z) {
            this.Code.Code(z);
            return this;
        }

        public Builder setNativeAdOptions(NativeAdConfiguration nativeAdConfiguration) {
            this.Code.Code(nativeAdConfiguration);
            return this;
        }

        public Builder setTemplateAdListener(TemplateAdListener templateAdListener) {
            return this;
        }
    }

    private TemplateAdLoader(Builder builder) {
        this.Code = builder.Code;
    }

    public void loadNativeAd(AdParam adParam) {
        this.Code.Code(adParam);
    }
}
