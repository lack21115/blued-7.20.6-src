package com.bytedance.sdk.openadsdk;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/CSJAdError.class */
public class CSJAdError {
    private int mb;
    private String ox;

    public CSJAdError(int i, String str) {
        this.mb = i;
        this.ox = str;
    }

    public int getCode() {
        return this.mb;
    }

    public String getMsg() {
        return this.ox;
    }
}
