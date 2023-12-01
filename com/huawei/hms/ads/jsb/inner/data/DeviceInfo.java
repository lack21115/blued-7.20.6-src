package com.huawei.hms.ads.jsb.inner.data;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jsb/inner/data/DeviceInfo.class */
public class DeviceInfo {
    private String i18n;
    private boolean isChina;
    private String language;

    public void Code(String str) {
        this.language = str;
    }

    public void Code(boolean z) {
        this.isChina = z;
    }

    public boolean Code() {
        return this.isChina;
    }

    public String I() {
        return this.i18n;
    }

    public String V() {
        return this.language;
    }

    public void V(String str) {
        this.i18n = str;
    }
}
