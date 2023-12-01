package com.huawei.hms.ads;

import android.net.http.Headers;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/kw.class */
public enum kw {
    BACK("back"),
    FORWARD("forward"),
    SAVE_PAGE("savePage"),
    REFRESH(Headers.REFRESH),
    ADD_TO("addTo"),
    FIND_IN_PAGE("findInPage"),
    TRANSLATE("translate"),
    OPEN_IN_BROWSER("openInBrowser"),
    NONE("none");
    
    private String L;

    kw(String str) {
        this.L = str;
    }

    public String Code() {
        return this.L;
    }
}
