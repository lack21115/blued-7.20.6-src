package com.opos.mobad.service;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Context f27308a;
    private static volatile Context b;

    public static Context a(Context context) {
        if (f27308a != null) {
            context = f27308a;
        }
        return context;
    }

    public static void a() {
        f27308a = null;
        b = null;
    }

    public static void a(Context context, Context context2) {
        f27308a = context;
        b = context2;
    }

    public static Context b(Context context) {
        if (b != null) {
            context = b;
        }
        return context;
    }
}
