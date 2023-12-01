package com.oplus.instant.router.d;

import com.oplus.instant.router.Instant;
import com.oplus.instant.router.callback.Callback;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/d/a.class */
public abstract class a extends Instant.Req {

    /* renamed from: a  reason: collision with root package name */
    Map<String, String> f10598a;
    Map<String, String> b;

    /* renamed from: c  reason: collision with root package name */
    Map<String, String> f10599c;
    Map<String, String> d;
    Callback e;
    String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        this.f10598a = bVar.f10600a;
        this.b = bVar.b;
        this.f10599c = bVar.f10601c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
    }
}
