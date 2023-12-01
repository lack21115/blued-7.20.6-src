package com.tencent.open;

import android.content.Context;
import android.location.Location;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private d f38260a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/c$a.class */
    public interface a {
        void onLocationUpdate(Location location);
    }

    public void a(Context context, a aVar) {
        this.f38260a = new d(aVar);
        com.tencent.map.a.a.a.a().a(context, this.f38260a);
    }

    public boolean a() {
        return com.tencent.map.a.a.a.a().a("OpenSdk", "WQMPF-XMH66-ISQXP-OIGMM-BNL7M");
    }

    public void b() {
        com.tencent.map.a.a.a.a().b();
        this.f38260a = null;
    }
}
