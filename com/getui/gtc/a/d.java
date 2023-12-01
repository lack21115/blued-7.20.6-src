package com.getui.gtc.a;

import android.content.Context;
import com.getui.gtc.BuildConfig;
import com.getui.gtc.base.GtcProvider;
import java.lang.reflect.Method;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/a/d.class */
public final class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f8278a;
    private boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private long f8279c = 43200000;

    private static String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(BuildConfig.VERSION_NAME);
        sb.append(",");
        try {
            Class<?> cls = Class.forName("com.igexin.sdk.PushManager");
            Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = cls.getDeclaredMethod("getVersion", Context.class);
            declaredMethod2.setAccessible(true);
            sb.append("GT-".concat(String.valueOf((String) declaredMethod2.invoke(invoke, GtcProvider.context()))));
            sb.append(",");
        } catch (Throwable th) {
        }
        try {
            Class<?> cls2 = Class.forName("com.getui.gis.sdk.GInsightManager");
            Method declaredMethod3 = cls2.getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod3.setAccessible(true);
            Object invoke2 = declaredMethod3.invoke(null, new Object[0]);
            Method declaredMethod4 = cls2.getDeclaredMethod("version", new Class[0]);
            declaredMethod4.setAccessible(true);
            sb.append((String) declaredMethod4.invoke(invoke2, new Object[0]));
            sb.append(",");
        } catch (Throwable th2) {
        }
        try {
            Class<?> cls3 = Class.forName("com.getui.gs.sdk.GsManager");
            Method declaredMethod5 = cls3.getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod5.setAccessible(true);
            Object invoke3 = declaredMethod5.invoke(null, new Object[0]);
            Method declaredMethod6 = cls3.getDeclaredMethod("getVersion", new Class[0]);
            declaredMethod6.setAccessible(true);
            sb.append((String) declaredMethod6.invoke(invoke3, new Object[0]));
            sb.append(",");
        } catch (Throwable th3) {
        }
        try {
            Class<?> cls4 = Class.forName("com.g.gysdk.GYManager");
            Method declaredMethod7 = cls4.getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod7.setAccessible(true);
            Object invoke4 = declaredMethod7.invoke(null, new Object[0]);
            Method declaredMethod8 = cls4.getDeclaredMethod("getVersion", new Class[0]);
            declaredMethod8.setAccessible(true);
            sb.append((String) declaredMethod8.invoke(invoke4, new Object[0]));
            sb.append(",");
        } catch (Throwable th4) {
        }
        try {
            Class<?> cls5 = Class.forName("com.getui.ctid.CTIDManager");
            Method declaredMethod9 = cls5.getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod9.setAccessible(true);
            Object invoke5 = declaredMethod9.invoke(null, new Object[0]);
            Method declaredMethod10 = cls5.getDeclaredMethod("getVersion", new Class[0]);
            declaredMethod10.setAccessible(true);
            sb.append((String) declaredMethod10.invoke(invoke5, new Object[0]));
            sb.append(",");
        } catch (Throwable th5) {
        }
        try {
            Method declaredMethod11 = Class.forName("com.getui.iop.IopManager").getDeclaredMethod("getVersion", new Class[0]);
            declaredMethod11.setAccessible(true);
            sb.append((String) declaredMethod11.invoke(null, new Object[0]));
            sb.append(",");
        } catch (Throwable th6) {
        }
        try {
            Class<?> cls6 = Class.forName("com.sdk.plus.WusManager");
            Method declaredMethod12 = cls6.getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod12.setAccessible(true);
            Object invoke6 = declaredMethod12.invoke(null, new Object[0]);
            Method declaredMethod13 = cls6.getDeclaredMethod("getVersion", new Class[0]);
            declaredMethod13.setAccessible(true);
            sb.append((String) declaredMethod13.invoke(invoke6, new Object[0]));
            sb.append(",");
        } catch (Throwable th7) {
        }
        String sb2 = sb.toString();
        String str = sb2;
        if (sb2.endsWith(",")) {
            str = sb2.substring(0, sb2.length() - 1);
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0179 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x017a A[Catch: Exception -> 0x019b, TRY_ENTER, TryCatch #1 {Exception -> 0x019b, blocks: (B:35:0x0162, B:38:0x017a, B:40:0x0195), top: B:47:0x0162 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 443
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.a.d.run():void");
    }
}
