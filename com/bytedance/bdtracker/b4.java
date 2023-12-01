package com.bytedance.bdtracker;

import android.content.Context;
import com.bytedance.bdtracker.s3;
import java.lang.reflect.Method;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/b4.class */
public final class b4 implements s3 {

    /* renamed from: a  reason: collision with root package name */
    public static Object f7592a;
    public static Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f7593c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            f7592a = cls.newInstance();
            f7593c = b.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            z2.a("Api#static reflect exception! ", e);
        }
    }

    public static boolean a() {
        return (b == null || f7592a == null || f7593c == null) ? false : true;
    }

    @Override // com.bytedance.bdtracker.s3
    public s3.a a(Context context) {
        String str;
        Object invoke;
        try {
            s3.a aVar = new s3.a();
            Method method = f7593c;
            Object obj = f7592a;
            if (obj != null && method != null) {
                try {
                    invoke = method.invoke(obj, context);
                } catch (Exception e) {
                }
                if (invoke != null) {
                    str = (String) invoke;
                    aVar.f7699a = str;
                    return aVar;
                }
            }
            str = null;
            aVar.f7699a = str;
            return aVar;
        } catch (Exception e2) {
            z2.a(e2);
            return null;
        }
    }

    @Override // com.bytedance.bdtracker.s3
    public boolean b(Context context) {
        return (b == null || f7592a == null || f7593c == null) ? false : true;
    }
}
