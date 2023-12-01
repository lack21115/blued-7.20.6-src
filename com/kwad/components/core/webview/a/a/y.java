package com.kwad.components.core.webview.a.a;

import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/a/y.class */
public class y extends com.kwad.sdk.core.response.kwai.a {
    public String Vp;
    public int errorCode;
    public String errorReason;
    public int nZ;

    public final boolean isFailed() {
        return TextUtils.equals(com.alipay.sdk.util.e.f4661a, this.Vp);
    }

    public final boolean rg() {
        return TextUtils.equals("start", this.Vp);
    }

    public final boolean rh() {
        return TextUtils.equals("end", this.Vp);
    }

    public final boolean ri() {
        return TextUtils.equals("progress", this.Vp);
    }

    public final int rj() {
        String str = this.errorReason;
        if (str != null) {
            return (int) Long.parseLong(str);
        }
        return 0;
    }
}
