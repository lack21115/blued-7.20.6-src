package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdConfig.class */
public final class TTAdConfig implements AdConfig {
    private boolean b;
    private ITTLiveTokenInjectionAuth e;
    private String h;
    private String hj;

    /* renamed from: io  reason: collision with root package name */
    private int f7905io;
    private boolean jb;
    private boolean je;
    private boolean ko;
    private TTCustomController lc;
    private boolean lz;
    private String mb;
    private int nk;
    private Map<String, Object> o;
    private String ox;
    private int u;
    private boolean ww;
    private int[] x;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdConfig$Builder.class */
    public static class Builder {
        private String h;
        private String hj;

        /* renamed from: io  reason: collision with root package name */
        private int f7906io;
        private TTCustomController lc;
        private ITTLiveTokenInjectionAuth m;
        private String mb;
        private String[] nk;
        private String ox;
        private int[] x;
        private boolean b = false;
        private int u = 0;
        private boolean ko = true;
        private boolean ww = false;
        private boolean lz = false;
        private boolean jb = true;
        private boolean je = false;
        private boolean o = false;
        private int e = 2;
        private int l = 0;

        public Builder allowShowNotify(boolean z) {
            this.ko = z;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.lz = z;
            return this;
        }

        public Builder appId(String str) {
            this.mb = str;
            return this;
        }

        public Builder appName(String str) {
            this.ox = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.o = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.mb);
            tTAdConfig.setAppName(this.ox);
            tTAdConfig.setPaid(this.b);
            tTAdConfig.setKeywords(this.hj);
            tTAdConfig.setData(this.h);
            tTAdConfig.setTitleBarTheme(this.u);
            tTAdConfig.setAllowShowNotify(this.ko);
            tTAdConfig.setDebug(this.ww);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.lz);
            tTAdConfig.setDirectDownloadNetworkType(this.x);
            tTAdConfig.setUseTextureView(this.jb);
            tTAdConfig.setSupportMultiProcess(this.je);
            tTAdConfig.setNeedClearTaskReset(this.nk);
            tTAdConfig.setAsyncInit(this.o);
            tTAdConfig.setCustomController(this.lc);
            tTAdConfig.setThemeStatus(this.f7906io);
            tTAdConfig.setExtra("plugin_update_conf", Integer.valueOf(this.e));
            tTAdConfig.setExtra(TTAdConstant.KEY_AGE_GROUP, Integer.valueOf(this.l));
            tTAdConfig.setInjectionAuth(this.m);
            return tTAdConfig;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.lc = tTCustomController;
            return this;
        }

        public Builder data(String str) {
            this.h = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.ww = z;
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.x = iArr;
            return this;
        }

        public Builder injectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
            this.m = iTTLiveTokenInjectionAuth;
            return this;
        }

        public Builder keywords(String str) {
            this.hj = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.nk = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setAgeGroup(int i) {
            this.l = i;
            return this;
        }

        public Builder setPluginUpdateConfig(int i) {
            this.e = i;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.je = z;
            return this;
        }

        public Builder themeStatus(int i) {
            this.f7906io = i;
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.u = i;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.jb = z;
            return this;
        }
    }

    private TTAdConfig() {
        this.b = false;
        this.u = 0;
        this.ko = true;
        this.ww = false;
        this.lz = false;
        this.jb = true;
        this.je = false;
        this.nk = 0;
        HashMap hashMap = new HashMap();
        this.o = hashMap;
        hashMap.put("_sdk_is_p_", true);
        this.o.put("_sdk_v_c_", 5102);
        this.o.put("_sdk_v_n_", "5.1.0.2");
        this.o.put("_sdk_p_n_", "com.byted.pangle");
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.mb;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.ox;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.lc;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public Object getExtra(String str) {
        return this.o.get(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public ITTLiveTokenInjectionAuth getInjectionAuth() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.hj;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public String[] getNeedClearTaskReset() {
        return new String[0];
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public AdConfig.SdkInfo getSdkInfo() {
        return new AdConfig.SdkInfo() { // from class: com.bytedance.sdk.openadsdk.TTAdConfig.1
            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public boolean isPlugin() {
                return true;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public String pluginName() {
                return "com.byted.pangle";
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public int sdkVersionCode() {
                return 5102;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public String sdkVersionName() {
                return "5.1.0.2";
            }
        };
    }

    public int getThemeStatus() {
        return this.f7905io;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.ko;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowPageWhenScreenLock() {
        return this.lz;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public boolean isAsyncInit() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.ww;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.je;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseTextureView() {
        return this.jb;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object removeExtra(String str) {
        return this.o.remove(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public void setAgeGroup(int i) {
        this.o.put(TTAdConstant.KEY_AGE_GROUP, Integer.valueOf(i));
    }

    public void setAllowShowNotify(boolean z) {
        this.ko = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.lz = z;
    }

    public void setAppId(String str) {
        this.mb = str;
    }

    public void setAppName(String str) {
        this.ox = str;
    }

    @Deprecated
    public void setAsyncInit(boolean z) {
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.lc = tTCustomController;
    }

    public void setData(String str) {
        this.h = str;
    }

    public void setDebug(boolean z) {
        this.ww = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.x = iArr;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public void setExtra(String str, Object obj) {
        this.o.put(str, obj);
    }

    public void setInjectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.e = iTTLiveTokenInjectionAuth;
    }

    public void setKeywords(String str) {
        this.hj = str;
    }

    @Deprecated
    public void setNeedClearTaskReset(String... strArr) {
    }

    public void setPaid(boolean z) {
        this.b = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.je = z;
    }

    public void setThemeStatus(int i) {
        this.f7905io = i;
    }

    public void setTitleBarTheme(int i) {
        this.u = i;
    }

    public void setUseTextureView(boolean z) {
        this.jb = z;
    }
}
