package com.opos.mobad.service;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f13635a;
    private Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private Context f13636c;

    private d() {
    }

    public static final d a() {
        d dVar;
        d dVar2 = f13635a;
        if (dVar2 == null) {
            synchronized (d.class) {
                try {
                    d dVar3 = f13635a;
                    dVar = dVar3;
                    if (dVar3 == null) {
                        dVar = new d();
                        f13635a = dVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return dVar;
        }
        return dVar2;
    }

    public com.opos.cmn.func.b.b.e a(com.opos.cmn.func.b.b.d dVar) {
        return null;
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        this.f13636c = context;
    }
}
