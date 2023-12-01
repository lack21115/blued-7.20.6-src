package com.opos.mobad.provider.statistic;

import android.content.Context;
import android.net.Uri;
import com.opos.mobad.provider.MobAdGlobalProvider;
import com.opos.process.bridge.provider.b;
import com.opos.process.bridge.provider.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/statistic/a.class */
public final class a extends com.opos.process.bridge.provider.a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f13444c = StatisticModel.class.getName();

    public a(Context context, StatisticModelIdentify statisticModelIdentify) {
        this.f13739a = context;
        this.b = statisticModelIdentify;
    }

    @Override // com.opos.process.bridge.provider.a
    public Uri a(Context context) {
        return MobAdGlobalProvider.getUri(context);
    }

    public final void a(String str) throws c, b {
        b(this.f13739a, f13444c, this.b, 2, str);
    }

    public final void a(String str, String str2) throws c, b {
        b(this.f13739a, f13444c, this.b, 1, str, str2);
    }
}
