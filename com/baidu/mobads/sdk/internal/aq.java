package com.baidu.mobads.sdk.internal;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/aq.class */
public class aq {

    /* renamed from: c  reason: collision with root package name */
    private static volatile Map<String, aq> f6475c = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f6476a;
    private Method[] b;

    private aq(Context context, String str) {
        this.b = null;
        try {
            Class<?> cls = Class.forName(str, true, bp.a(context));
            this.f6476a = cls;
            this.b = cls.getMethods();
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    public static aq a(Context context, String str) {
        if (!f6475c.containsKey(str) || f6475c.get(str).f6476a == null) {
            synchronized (aq.class) {
                try {
                    if (!f6475c.containsKey(str) || f6475c.get(str).f6476a == null) {
                        f6475c.put(str, new aq(context, str));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6475c.get(str);
    }

    private Method a(String str) {
        Method[] methodArr = this.b;
        if (methodArr == null) {
            return null;
        }
        int length = methodArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Method method = methodArr[i2];
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
            i = i2 + 1;
        }
    }

    public Object a(Class<?>[] clsArr, Object... objArr) {
        Constructor<?> constructor;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    constructor = this.f6476a.getConstructor(clsArr);
                    return constructor.newInstance(objArr);
                }
            } catch (Throwable th) {
                bq.a().a(th);
                return null;
            }
        }
        constructor = this.f6476a.getConstructor(new Class[0]);
        return constructor.newInstance(objArr);
    }

    public void a(Object obj, String str, Object... objArr) {
        try {
            Method a2 = a(str);
            if (a2 != null) {
                if (objArr != null && objArr.length != 0) {
                    a2.invoke(obj, objArr);
                    return;
                }
                a2.invoke(obj, new Object[0]);
            }
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    public Object b(Object obj, String str, Object... objArr) {
        try {
            Method a2 = a(str);
            if (a2 != null) {
                if (objArr != null && objArr.length != 0) {
                    return a2.invoke(obj, objArr);
                }
                return a2.invoke(obj, new Object[0]);
            }
            return null;
        } catch (Throwable th) {
            bq.a().a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031 A[Catch: all -> 0x0038, TRY_LEAVE, TryCatch #0 {all -> 0x0038, blocks: (B:2:0x0000, B:6:0x000e, B:9:0x0016, B:12:0x002b, B:14:0x0031, B:10:0x0020), top: B:20:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String c(java.lang.Object r5, java.lang.String r6, java.lang.Object... r7) {
        /*
            r4 = this;
            r0 = r4
            r1 = r6
            java.lang.reflect.Method r0 = r0.a(r1)     // Catch: java.lang.Throwable -> L38
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L40
            r0 = r7
            if (r0 == 0) goto L20
            r0 = r7
            int r0 = r0.length     // Catch: java.lang.Throwable -> L38
            if (r0 != 0) goto L16
            goto L20
        L16:
            r0 = r6
            r1 = r5
            r2 = r7
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: java.lang.Throwable -> L38
            r5 = r0
            goto L2a
        L20:
            r0 = r6
            r1 = r5
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L38
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: java.lang.Throwable -> L38
            r5 = r0
        L2a:
            r0 = r5
            boolean r0 = r0 instanceof java.lang.String     // Catch: java.lang.Throwable -> L38
            if (r0 == 0) goto L40
            r0 = r5
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L38
            r5 = r0
            r0 = r5
            return r0
        L38:
            r5 = move-exception
            com.baidu.mobads.sdk.internal.bq r0 = com.baidu.mobads.sdk.internal.bq.a()
            r1 = r5
            r0.a(r1)
        L40:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.aq.c(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.String");
    }
}
