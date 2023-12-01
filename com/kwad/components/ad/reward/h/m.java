package com.kwad.components.ad.reward.h;

import com.kwad.components.core.webview.a.kwai.v;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/m.class */
public final class m extends v {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/m$a.class */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String name = "backPressed";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "registerBackPressedListener";
    }

    public final void jc() {
        b(new a());
    }
}
