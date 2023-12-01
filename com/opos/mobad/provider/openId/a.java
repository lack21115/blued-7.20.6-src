package com.opos.mobad.provider.openId;

import android.content.Context;
import android.net.Uri;
import com.opos.mobad.provider.MobAdGlobalProvider;
import com.opos.process.bridge.provider.b;
import com.opos.process.bridge.provider.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/openId/a.class */
public final class a extends com.opos.process.bridge.provider.a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f13434c = IdModel.class.getName();

    public a(Context context, IdModelIdentify idModelIdentify) {
        this.f13739a = context;
        this.b = idModelIdentify;
    }

    @Override // com.opos.process.bridge.provider.a
    public Uri a(Context context) {
        return MobAdGlobalProvider.getUri(context);
    }

    public final OpenIdData a() throws c, b {
        return (OpenIdData) a(this.f13739a, f13434c, this.b, 1, new Object[0]);
    }

    public final boolean b() throws c, b {
        return ((Boolean) a(this.f13739a, f13434c, this.b, 2, new Object[0])).booleanValue();
    }

    public final String c() throws c, b {
        return (String) a(this.f13739a, f13434c, this.b, 3, new Object[0]);
    }
}
