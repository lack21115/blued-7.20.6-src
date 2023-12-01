package com.igexin.assist.util;

import android.content.Context;
import com.igexin.sdk.PushManager;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/util/AssistUtils.class */
public class AssistUtils {
    public static final String BRAND_HON = "honor";
    public static final String BRAND_HW = "huawei";
    public static final String BRAND_MZ = "meizu";
    public static final String BRAND_OPPO = "oppo";
    public static final String BRAND_STP = "stp";
    public static final String BRAND_VIVO = "vivo";
    public static final String BRAND_XIAOMI = "xiaomi";

    /* renamed from: a  reason: collision with root package name */
    static String f9585a = "";

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
        if (com.igexin.push.f.b.a(r0, com.igexin.assist.util.AssistUtils.BRAND_HON) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getDeviceBrand() {
        /*
            java.lang.String r0 = com.igexin.assist.util.AssistUtils.f9585a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Ld
            java.lang.String r0 = com.igexin.assist.util.AssistUtils.f9585a
            return r0
        Ld:
            boolean r0 = com.igexin.push.config.d.U
            if (r0 == 0) goto L29
            android.content.Context r0 = com.igexin.push.core.ServiceManager.b
            android.content.Context r0 = r0.getApplicationContext()
            r4 = r0
            java.lang.String r0 = "honor"
            r3 = r0
            r0 = r4
            java.lang.String r1 = "honor"
            boolean r0 = com.igexin.push.f.b.a(r0, r1)
            if (r0 == 0) goto L29
            goto L3c
        L29:
            android.content.Context r0 = com.igexin.push.core.ServiceManager.b
            android.content.Context r0 = r0.getApplicationContext()
            r4 = r0
            java.lang.String r0 = "huawei"
            r3 = r0
            r0 = r4
            java.lang.String r1 = "huawei"
            boolean r0 = com.igexin.push.f.b.a(r0, r1)
            if (r0 == 0) goto L43
        L3c:
            r0 = r3
            com.igexin.assist.util.AssistUtils.f9585a = r0
            goto Lb2
        L43:
            android.content.Context r0 = com.igexin.push.core.ServiceManager.b
            android.content.Context r0 = r0.getApplicationContext()
            r4 = r0
            java.lang.String r0 = "xiaomi"
            r3 = r0
            r0 = r4
            java.lang.String r1 = "xiaomi"
            boolean r0 = com.igexin.push.f.b.a(r0, r1)
            if (r0 == 0) goto L59
            goto L3c
        L59:
            android.content.Context r0 = com.igexin.push.core.ServiceManager.b
            android.content.Context r0 = r0.getApplicationContext()
            r4 = r0
            java.lang.String r0 = "oppo"
            r3 = r0
            r0 = r4
            java.lang.String r1 = "oppo"
            boolean r0 = com.igexin.push.f.b.a(r0, r1)
            if (r0 == 0) goto L6f
            goto L3c
        L6f:
            android.content.Context r0 = com.igexin.push.core.ServiceManager.b
            android.content.Context r0 = r0.getApplicationContext()
            r4 = r0
            java.lang.String r0 = "meizu"
            r3 = r0
            r0 = r4
            java.lang.String r1 = "meizu"
            boolean r0 = com.igexin.push.f.b.a(r0, r1)
            if (r0 == 0) goto L85
            goto L3c
        L85:
            android.content.Context r0 = com.igexin.push.core.ServiceManager.b
            android.content.Context r0 = r0.getApplicationContext()
            r4 = r0
            java.lang.String r0 = "vivo"
            r3 = r0
            r0 = r4
            java.lang.String r1 = "vivo"
            boolean r0 = com.igexin.push.f.b.a(r0, r1)
            if (r0 == 0) goto L9b
            goto L3c
        L9b:
            android.content.Context r0 = com.igexin.push.core.ServiceManager.b
            boolean r0 = com.igexin.push.f.b.a(r0)
            if (r0 == 0) goto Laa
            java.lang.String r0 = "stp"
            r3 = r0
            goto Lae
        Laa:
            java.lang.String r0 = android.os.Build.BRAND
            r3 = r0
        Lae:
            r0 = r3
            com.igexin.assist.util.AssistUtils.f9585a = r0
        Lb2:
            java.lang.String r0 = com.igexin.assist.util.AssistUtils.f9585a
            java.lang.String r0 = r0.toLowerCase()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.assist.util.AssistUtils.getDeviceBrand():java.lang.String");
    }

    public static void startGetuiService(Context context) {
        if (context != null) {
            try {
                PushManager.getInstance().initialize(context);
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }
}
