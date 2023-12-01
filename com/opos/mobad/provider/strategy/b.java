package com.opos.mobad.provider.strategy;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.opos.mobad.provider.MobAdGlobalProvider;
import com.opos.process.bridge.provider.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/strategy/b.class */
public final class b extends com.opos.process.bridge.provider.a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f27139c = StrategyModel.class.getName();

    public b(Context context) {
        this.f27427a = context;
    }

    @Override // com.opos.process.bridge.provider.a
    public Uri a(Context context) {
        return MobAdGlobalProvider.getUri(context);
    }

    public final Bundle a(String str) throws c, com.opos.process.bridge.provider.b {
        return (Bundle) a(this.f27427a, f27139c, this.b, 3, str);
    }

    public final void a(String str, StrategyInfo strategyInfo) throws c, com.opos.process.bridge.provider.b {
        b(this.f27427a, f27139c, this.b, 2, str, strategyInfo);
    }

    public final void a(String str, String str2, AppInfo appInfo) throws c, com.opos.process.bridge.provider.b {
        b(this.f27427a, f27139c, this.b, 1, str, str2, appInfo);
    }

    public final AppInfo b(String str) throws c, com.opos.process.bridge.provider.b {
        return (AppInfo) a(this.f27427a, f27139c, this.b, 4, str);
    }
}
