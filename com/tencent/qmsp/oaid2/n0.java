package com.tencent.qmsp.oaid2;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/n0.class */
public class n0 implements b {
    public static Class b;

    /* renamed from: c  reason: collision with root package name */
    public static Object f24803c;
    public static Method d;
    public static Method e;

    /* renamed from: a  reason: collision with root package name */
    public Context f24804a;

    public n0() {
        try {
            c.c("xm start");
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            f24803c = cls.newInstance();
            d = b.getMethod("getOAID", Context.class);
            e = b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            c.a("xm reflect exception!" + e2);
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String a() {
        Method method;
        Object obj = f24803c;
        if (obj == null || (method = d) == null) {
            return null;
        }
        return a(this.f24804a, obj, method);
    }

    public final String a(Context context, Object obj, Method method) {
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f24804a = context;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String d() {
        Method method;
        Object obj = f24803c;
        if (obj == null || (method = e) == null) {
            return null;
        }
        return a(this.f24804a, obj, method);
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean e() {
        return (b == null || f24803c == null) ? false : true;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void j() {
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean k() {
        return true;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void l() {
    }
}
