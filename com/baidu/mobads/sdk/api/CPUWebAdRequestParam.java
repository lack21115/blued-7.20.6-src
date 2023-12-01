package com.baidu.mobads.sdk.api;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/CPUWebAdRequestParam.class */
public class CPUWebAdRequestParam {
    private static final String DARK_MODE = "dark";
    private static final String LIGHT_MODE = "light";
    private final Map<String, Object> mParameters;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/CPUWebAdRequestParam$Builder.class */
    public static class Builder {
        private HashMap<String, Object> mExtras = new HashMap<>();

        public Builder addExtra(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.mExtras.put(str, str2);
            }
            return this;
        }

        public CPUWebAdRequestParam build() {
            return new CPUWebAdRequestParam(this);
        }

        public Builder setCityIfLocalChannel(String str) {
            this.mExtras.put("city", str);
            return this;
        }

        public Builder setCustomUserId(String str) {
            this.mExtras.put("outerId", str);
            return this;
        }

        public Builder setLpDarkMode(boolean z) {
            this.mExtras.put("preferscolortheme", z ? CPUWebAdRequestParam.DARK_MODE : CPUWebAdRequestParam.LIGHT_MODE);
            return this;
        }

        public Builder setLpFontSize(CpuLpFontSize cpuLpFontSize) {
            this.mExtras.put("prefersfontsize", cpuLpFontSize.getValue());
            return this;
        }

        public Builder setSubChannelId(String str) {
            this.mExtras.put("scid", str);
            return this;
        }
    }

    private CPUWebAdRequestParam(Builder builder) {
        this.mParameters = new HashMap();
        if (builder == null || builder.mExtras == null) {
            return;
        }
        this.mParameters.putAll(builder.mExtras);
    }

    public Map<String, Object> getParameters() {
        return this.mParameters;
    }
}
