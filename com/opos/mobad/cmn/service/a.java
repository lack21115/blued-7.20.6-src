package com.opos.mobad.cmn.service;

import com.opos.mobad.cmn.a.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/service/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f12227a;
    private volatile d b;

    /* renamed from: c  reason: collision with root package name */
    private volatile com.opos.mobad.activity.webview.a f12228c;

    public static final a a() {
        a aVar;
        a aVar2 = f12227a;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (a.class) {
            try {
                a aVar3 = f12227a;
                aVar = aVar3;
                if (aVar3 == null) {
                    aVar = new a();
                    f12227a = aVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public void a(d dVar, com.opos.mobad.activity.webview.a aVar) {
        this.b = dVar;
        this.f12228c = aVar;
    }

    public d b() {
        return this.b;
    }

    public com.opos.mobad.activity.webview.a c() {
        return this.f12228c;
    }
}
