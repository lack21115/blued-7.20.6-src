package com.oplus.quickgame.sdk.engine.c;

import android.content.Context;
import com.google.common.net.HttpHeaders;
import com.oplus.quickgame.sdk.engine.utils.g;
import com.oplus.quickgame.sdk.engine.utils.j;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/c/d.class */
public class d extends a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        super(bVar);
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Req
    public void preload(Context context) {
        if (this.d == null) {
            this.d = new HashMap(1);
        }
        j.a(context, this.f, this.f10707a, this.b, this.f10708c, this.d, this.e);
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Req
    public void reqCleanGameCache(Context context) {
        g.a(context, this.e, this.b.get(HttpHeaders.ReferrerPolicyValues.ORIGIN), this.b.get("secret"));
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Req
    public void reqCleanOneGameCache(Context context, String str) {
        g.a(context, this.e, this.b.get(HttpHeaders.ReferrerPolicyValues.ORIGIN), this.b.get("secret"), str);
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Req
    public void reqGameCacheSize(Context context) {
        g.b(context, this.e, this.b.get(HttpHeaders.ReferrerPolicyValues.ORIGIN), this.b.get("secret"));
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Req
    public void reqGamePkgList(Context context) {
        g.c(context, this.e, this.b.get(HttpHeaders.ReferrerPolicyValues.ORIGIN), this.b.get("secret"));
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Req
    public void reqReportErrorLog(Context context) {
        g.d(context, this.e, this.b.get(HttpHeaders.ReferrerPolicyValues.ORIGIN), this.b.get("secret"));
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Req
    public void request(Context context) {
        if (this.d == null) {
            this.d = new HashMap(1);
        }
        j.b(context, this.f, this.f10707a, this.b, this.f10708c, this.d, this.e);
    }
}
