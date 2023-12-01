package com.bytedance.sdk.openadsdk.api.plugin;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/b.class */
public class b extends Exception {
    private final int mb;

    public b(int i, String str) {
        super(str);
        this.mb = i;
    }

    public int mb() {
        return this.mb;
    }
}
