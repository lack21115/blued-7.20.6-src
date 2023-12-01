package com.tencent.tmsqmsp.sdk.g.j;

import android.content.Context;
import com.tencent.tmsqmsp.sdk.base.IVendorCallback;
import com.tencent.tmsqmsp.sdk.base.b;
import com.tencent.tmsqmsp.sdk.base.c;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/j/a.class */
public class a implements b {
    private static Class b;

    /* renamed from: c  reason: collision with root package name */
    private static Object f39804c;
    private static Method d;
    private static Method e;

    /* renamed from: a  reason: collision with root package name */
    private Context f39805a;

    public a() {
        try {
            c.c("xm start");
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            f39804c = cls.newInstance();
            d = b.getMethod("getOAID", Context.class);
            e = b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            c.a("xm reflect exception!" + e2);
        }
    }

    private String a(Context context, Object obj, Method method) {
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

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public String a() {
        Method method;
        Object obj = f39804c;
        if (obj == null || (method = d) == null) {
            return null;
        }
        return a(this.f39805a, obj, method);
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f39805a = context;
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public String b() {
        Method method;
        Object obj = f39804c;
        if (obj == null || (method = e) == null) {
            return null;
        }
        return a(this.f39805a, obj, method);
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void c() {
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public boolean d() {
        return true;
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public boolean e() {
        return (b == null || f39804c == null) ? false : true;
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void f() {
    }
}
