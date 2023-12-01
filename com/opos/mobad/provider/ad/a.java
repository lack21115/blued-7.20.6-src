package com.opos.mobad.provider.ad;

import android.content.Context;
import android.net.Uri;
import com.opos.mobad.provider.MobAdGlobalProvider;
import com.opos.process.bridge.provider.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/ad/a.class */
public final class a extends com.opos.process.bridge.provider.a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f27112c = AdCacheModel.class.getName();

    public a(Context context) {
        this.f27427a = context;
    }

    @Override // com.opos.process.bridge.provider.a
    public Uri a(Context context) {
        return MobAdGlobalProvider.getUri(context);
    }

    public final AdEntity a(String str) throws c, com.opos.process.bridge.provider.b {
        return (AdEntity) a(this.f27427a, f27112c, this.b, 2, str);
    }

    public final void a(String str, AdEntity adEntity) throws c, com.opos.process.bridge.provider.b {
        b(this.f27427a, f27112c, this.b, 1, str, adEntity);
    }
}
