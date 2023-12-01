package com.opos.mobad.provider.monitor;

import android.content.Context;
import android.net.Uri;
import com.opos.cmn.biz.monitor.MonitorEvent;
import com.opos.mobad.provider.MobAdGlobalProvider;
import com.opos.process.bridge.provider.b;
import com.opos.process.bridge.provider.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/monitor/a.class */
public final class a extends com.opos.process.bridge.provider.a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f27116c = MonitorModel.class.getName();

    public a(Context context) {
        this.f27427a = context;
    }

    @Override // com.opos.process.bridge.provider.a
    public Uri a(Context context) {
        return MobAdGlobalProvider.getUri(context);
    }

    public final void a(String str, MonitorEvent monitorEvent) throws c, b {
        b(this.f27427a, f27116c, this.b, 1, str, monitorEvent);
    }
}
