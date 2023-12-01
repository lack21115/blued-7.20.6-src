package com.opos.mobad.provider.init;

import android.content.Context;
import android.net.Uri;
import com.opos.mobad.provider.MobAdGlobalProvider;
import com.opos.process.bridge.provider.b;
import com.opos.process.bridge.provider.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/init/a.class */
public final class a extends com.opos.process.bridge.provider.a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f13426c = InitModel.class.getName();

    public a(Context context) {
        this.f13739a = context;
    }

    @Override // com.opos.process.bridge.provider.a
    public Uri a(Context context) {
        return MobAdGlobalProvider.getUri(context);
    }

    public final void a(boolean z, boolean z2) throws c, b {
        b(this.f13739a, f13426c, this.b, 1, Boolean.valueOf(z), Boolean.valueOf(z2));
    }
}
