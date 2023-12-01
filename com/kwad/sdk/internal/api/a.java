package com.kwad.sdk.internal.api;

import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/internal/api/a.class */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public int aaM;
    public int aaN;
    public String aaO;
    public String aaP;
    public String aaQ;
    public String aaR;
    public String aaS;
    public long aaT;

    public final boolean AA() {
        return this.aaM == 0 && this.aaN == 0 && TextUtils.isEmpty(this.aaO);
    }

    public final boolean AB() {
        return TextUtils.isEmpty(this.aaP) && TextUtils.isEmpty(this.aaQ) && TextUtils.isEmpty(this.aaS) && TextUtils.isEmpty(this.aaR);
    }
}
