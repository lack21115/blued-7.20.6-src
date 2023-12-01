package com.tencent.tendinsv.tool;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/tool/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f25358a = "";
    private static volatile d b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f25359c;
    private static volatile String d;
    private static volatile String e;

    private d() {
    }

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                try {
                    if (b == null) {
                        b = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public String a(Context context) {
        if (com.tencent.tendinsv.utils.g.a(context, "operator_sub")) {
            f25359c = com.tencent.tendinsv.utils.g.c(context);
        } else if (f25359c == null) {
            synchronized (d.class) {
                try {
                    if (f25359c == null) {
                        f25359c = com.tencent.tendinsv.utils.g.c(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (f25359c == null) {
            f25359c = "Unknown_Operator";
        }
        com.tencent.tendinsv.utils.l.b(com.tencent.tendinsv.b.O, "current Operator Type", f25359c);
        return f25359c;
    }

    public String b() {
        if (d == null) {
            synchronized (d.class) {
                try {
                    if (d == null) {
                        d = com.tencent.tendinsv.utils.e.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (d == null) {
            d = "";
        }
        com.tencent.tendinsv.utils.l.b(com.tencent.tendinsv.b.O, "d f i p ", d);
        return d;
    }

    public String b(Context context) {
        if (com.tencent.tendinsv.utils.g.a(context, "dataIme_sub")) {
            e = com.tencent.tendinsv.utils.e.a(context);
        } else if (e == null) {
            synchronized (d.class) {
                try {
                    if (e == null) {
                        e = com.tencent.tendinsv.utils.e.a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (e == null) {
            e = "";
        }
        com.tencent.tendinsv.utils.l.b(com.tencent.tendinsv.b.O, "current data ei", e);
        return e;
    }
}
