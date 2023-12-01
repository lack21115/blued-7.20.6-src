package com.bytedance.pangle.b.b;

import com.bytedance.pangle.log.ZeusLogger;
import java.lang.reflect.Method;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/b/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Method f21359a;
    private static Method b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f21360c;
    private static Method d;

    static {
        try {
            f21359a = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            f21360c = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            d = Class.class.getDeclaredMethod("forName", String.class);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "DoubleReflectorinit failed", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Constructor a(java.lang.Class<?> r7, java.lang.Class<?>... r8) {
        /*
            java.lang.reflect.Method r0 = com.bytedance.pangle.b.b.a.f21360c
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L4d
            r0 = r9
            r1 = r7
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L1c
            r3 = r2
            r4 = 0
            r5 = r8
            r3[r4] = r5     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: java.lang.Throwable -> L1c
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0     // Catch: java.lang.Throwable -> L1c
            r9 = r0
            goto L4f
        L1c:
            r9 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "DoubleReflector"
            r1.<init>(r2)
            r10 = r0
            r0 = r10
            java.lang.String r1 = "getConstructor %s<init>%s failed !!!"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r7
            java.lang.String r5 = r5.getName()
            r3[r4] = r5
            r3 = r2
            r4 = 1
            r5 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3[r4] = r5
            java.lang.String r1 = java.lang.String.format(r1, r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "Zeus_pangle"
            r1 = r10
            java.lang.String r1 = r1.toString()
            r2 = r9
            com.bytedance.pangle.log.ZeusLogger.w(r0, r1, r2)
        L4d:
            r0 = 0
            r9 = r0
        L4f:
            r0 = r9
            if (r0 == 0) goto L55
            r0 = r9
            return r0
        L55:
            r0 = r7
            r1 = r8
            java.lang.reflect.Constructor r0 = com.bytedance.pangle.b.a.a.a(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.b.b.a.a(java.lang.Class, java.lang.Class[]):java.lang.reflect.Constructor");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Field a(java.lang.Class<?> r7, java.lang.String r8) {
        /*
            java.lang.reflect.Method r0 = com.bytedance.pangle.b.b.a.f21359a
            r10 = r0
            r0 = 0
            r9 = r0
            r0 = r10
            if (r0 == 0) goto L68
            r0 = r10
            r1 = r7
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L35
            r3 = r2
            r4 = 0
            r5 = r8
            r3[r4] = r5     // Catch: java.lang.Throwable -> L35
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: java.lang.Throwable -> L35
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0     // Catch: java.lang.Throwable -> L35
            r10 = r0
            r0 = r10
            r9 = r0
            r0 = r10
            if (r0 == 0) goto L68
            r0 = r10
            r1 = 1
            r0.setAccessible(r1)     // Catch: java.lang.Throwable -> L2b
            r0 = r10
            r9 = r0
            goto L68
        L2b:
            r11 = move-exception
            r0 = r10
            r9 = r0
            r0 = r11
            r10 = r0
            goto L38
        L35:
            r10 = move-exception
            r0 = 0
            r9 = r0
        L38:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "DoubleReflector"
            r1.<init>(r2)
            r11 = r0
            r0 = r11
            java.lang.String r1 = "getField %s#%s failed !!!"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r7
            java.lang.String r5 = r5.getName()
            r3[r4] = r5
            r3 = r2
            r4 = 1
            r5 = r8
            r3[r4] = r5
            java.lang.String r1 = java.lang.String.format(r1, r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "Zeus_pangle"
            r1 = r11
            java.lang.String r1 = r1.toString()
            r2 = r10
            com.bytedance.pangle.log.ZeusLogger.w(r0, r1, r2)
        L68:
            r0 = r9
            if (r0 == 0) goto L6e
            r0 = r9
            return r0
        L6e:
            r0 = r7
            r1 = r8
            java.lang.reflect.Field r0 = com.bytedance.pangle.b.a.a.a(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.b.b.a.a(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Method a(java.lang.Class<?> r7, java.lang.String r8, java.lang.Class<?>... r9) {
        /*
            java.lang.reflect.Method r0 = com.bytedance.pangle.b.b.a.b
            r11 = r0
            r0 = 0
            r10 = r0
            r0 = r11
            if (r0 == 0) goto L78
            r0 = r11
            r1 = r7
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L43
            r3 = r2
            r4 = 0
            r5 = r8
            r3[r4] = r5     // Catch: java.lang.Throwable -> L43
            r3 = r2
            r4 = 1
            r5 = r9
            r3[r4] = r5     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: java.lang.Throwable -> L43
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch: java.lang.Throwable -> L43
            r11 = r0
            r0 = r11
            r10 = r0
            r0 = r11
            if (r0 == 0) goto L78
            r0 = r11
            r1 = 1
            r0.setAccessible(r1)     // Catch: java.lang.Throwable -> L37
            r0 = r11
            r10 = r0
            goto L78
        L37:
            r12 = move-exception
            r0 = r11
            r10 = r0
            r0 = r12
            r11 = r0
            goto L47
        L43:
            r11 = move-exception
            r0 = 0
            r10 = r0
        L47:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "DoubleReflector"
            r1.<init>(r2)
            r12 = r0
            r0 = r12
            java.lang.String r1 = "getMethod %s#%s failed !!!"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r7
            java.lang.String r5 = r5.getName()
            r3[r4] = r5
            r3 = r2
            r4 = 1
            r5 = r8
            r3[r4] = r5
            java.lang.String r1 = java.lang.String.format(r1, r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "Zeus_pangle"
            r1 = r12
            java.lang.String r1 = r1.toString()
            r2 = r11
            com.bytedance.pangle.log.ZeusLogger.w(r0, r1, r2)
        L78:
            r0 = r10
            if (r0 == 0) goto L7e
            r0 = r10
            return r0
        L7e:
            r0 = r7
            r1 = r8
            r2 = r9
            java.lang.reflect.Method r0 = com.bytedance.pangle.b.a.a.a(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.b.b.a.a(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }
}
