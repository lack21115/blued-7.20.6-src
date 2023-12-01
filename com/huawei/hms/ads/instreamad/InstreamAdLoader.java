package com.huawei.hms.ads.instreamad;

import android.content.Context;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.x;
import com.huawei.hms.ads.y;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/instreamad/InstreamAdLoader.class */
public class InstreamAdLoader {
    private x Code;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/instreamad/InstreamAdLoader$Builder.class */
    public static class Builder {
        private x Code;

        public Builder(Context context, String str) {
            this.Code = new y(context, str);
        }

        public InstreamAdLoader build() {
            return new InstreamAdLoader(this);
        }

        public Builder setInstreamAdLoadListener(InstreamAdLoadListener instreamAdLoadListener) {
            this.Code.Code(instreamAdLoadListener);
            return this;
        }

        public Builder setMaxCount(int i) {
            this.Code.V(i);
            return this;
        }

        public Builder setTotalDuration(int i) {
            this.Code.Code(i);
            return this;
        }
    }

    private InstreamAdLoader(Builder builder) {
        this.Code = builder.Code;
    }

    public boolean isLoading() {
        return this.Code.Code();
    }

    public void loadAd(AdParam adParam) {
        this.Code.Code(adParam);
    }
}
