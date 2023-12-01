package com.cdo.oaps.ad;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.compatible.base.launcher.OapsLog;
import com.cdo.oaps.ad.wrapper.VerifyWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/j.class */
public class j implements l {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21530a = "Y29tLm9wcG8ubWFpbi5BQ1RJT05fTEFVTkNI";
    private static final String b = "b3Bwby9sYXVuY2g=";

    /* renamed from: c  reason: collision with root package name */
    private static final String f21531c = "com.nearme.gamecenter";
    private static final String d = "com.heytap.market";

    private static String a(Context context, OapsWrapper oapsWrapper) {
        String host = oapsWrapper.getHost();
        if (Launcher.Host.GC.equals(host)) {
            return f21531c;
        }
        if ("mk".equals(host)) {
            return p.b(context, "com.heytap.market") ? "com.heytap.market" : a.b();
        } else if (Launcher.Host.MK_OP.equals(host)) {
            return a.a();
        } else {
            return null;
        }
    }

    public static String a(String str, String str2) {
        return i.a(str + str2);
    }

    public static boolean a(Context context, Uri uri, String str) {
        Intent intent;
        List<ResolveInfo> queryIntentServices;
        if (OapsLog.isDebugable()) {
            OapsLog.i("Uri = " + uri);
        }
        try {
            intent = new Intent();
            intent.setAction(a.b("Y29tLm9wcG8ubWFpbi5BQ1RJT05fTEFVTkNI"));
            intent.setDataAndType(uri, a.b("b3Bwby9sYXVuY2g="));
            queryIntentServices = context.getPackageManager().queryIntentServices(intent, 32);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            return false;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            String str2 = resolveInfo.serviceInfo.packageName;
            if (TextUtils.isEmpty(str)) {
                if (!f21531c.equals(str2) && !a.b().equals(str2) && !"com.heytap.market".equalsIgnoreCase(str2)) {
                    ComponentName componentName = new ComponentName(str2, resolveInfo.serviceInfo.name);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    context.startService(intent2);
                    return true;
                }
            } else if (str.equals(str2)) {
                ComponentName componentName2 = new ComponentName(str2, resolveInfo.serviceInfo.name);
                Intent intent22 = new Intent(intent);
                intent22.setComponent(componentName2);
                context.startService(intent22);
                return true;
            }
            th.printStackTrace();
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (com.cdo.oaps.ad.p.a(r3, r4) >= 7200) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "com.heytap.market"
            r1 = r4
            boolean r0 = r0.equalsIgnoreCase(r1)
            r6 = r0
            r0 = 0
            r5 = r0
            r0 = r6
            if (r0 != 0) goto L3a
            java.lang.String r0 = com.cdo.oaps.ad.a.b()
            r1 = r4
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L1a
            goto L3a
        L1a:
            java.lang.String r0 = "com.nearme.gamecenter"
            r1 = r4
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L30
            r0 = r3
            r1 = r4
            int r0 = com.cdo.oaps.ad.p.a(r0, r1)
            r1 = 8300(0x206c, float:1.1631E-41)
            if (r0 >= r1) goto L45
            r0 = 0
            return r0
        L30:
            java.lang.String r0 = com.cdo.oaps.ad.a.a()
            r1 = r4
            boolean r0 = r0.equalsIgnoreCase(r1)
            r0 = 0
            return r0
        L3a:
            r0 = r3
            r1 = r4
            int r0 = com.cdo.oaps.ad.p.a(r0, r1)
            r1 = 7200(0x1c20, float:1.009E-41)
            if (r0 < r1) goto L47
        L45:
            r0 = 1
            r5 = r0
        L47:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdo.oaps.ad.j.a(android.content.Context, java.lang.String):boolean");
    }

    public static boolean b(Context context, Uri uri, String str) {
        Intent intent;
        List<ResolveInfo> queryIntentActivities;
        if (OapsLog.isDebugable()) {
            OapsLog.i("Uri = " + uri);
        }
        try {
            intent = new Intent();
            intent.setAction(a.b("Y29tLm9wcG8ubWFpbi5BQ1RJT05fTEFVTkNI"));
            intent.setFlags(268435456);
            intent.setDataAndType(uri, a.b("b3Bwby9sYXVuY2g="));
            queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return false;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str2 = resolveInfo.activityInfo.packageName;
            if (TextUtils.isEmpty(str)) {
                if (!f21531c.equals(str2) && !a.b().equals(str2) && !"com.heytap.market".equalsIgnoreCase(str2)) {
                    ComponentName componentName = new ComponentName(str2, resolveInfo.activityInfo.name);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    context.startActivity(intent2);
                    return true;
                }
            } else if (str.equals(str2)) {
                ComponentName componentName2 = new ComponentName(str2, resolveInfo.activityInfo.name);
                Intent intent22 = new Intent(intent);
                intent22.setComponent(componentName2);
                context.startActivity(intent22);
                return true;
            }
            th.printStackTrace();
            return false;
        }
        return false;
    }

    public static Map<String, Object> c(Context context, Map<String, Object> map) {
        long currentTimeMillis = System.currentTimeMillis();
        VerifyWrapper wrapper = VerifyWrapper.wrapper((Map<String, Object>) new HashMap());
        wrapper.setId(context.getPackageName());
        wrapper.setTimestamp(String.valueOf(currentTimeMillis));
        OapsWrapper wrapper2 = OapsWrapper.wrapper(map);
        wrapper.setChecksum(a(wrapper.getId(), wrapper.getTimestamp()));
        for (Map.Entry<String, Object> entry : wrapper.getParams().entrySet()) {
            wrapper2.set(entry.getKey(), entry.getValue());
        }
        return map;
    }

    private static boolean c(Context context, Uri uri, String str) {
        if (OapsLog.isDebugable()) {
            OapsLog.i("simple dp, Uri = " + uri);
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setFlags(268435456);
            intent.setData(uri);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.cdo.oaps.ad.l
    public boolean a(Context context, Map<String, Object> map) {
        OapsWrapper wrapper = OapsWrapper.wrapper(map);
        String a2 = a(context, wrapper);
        Map<String, Object> map2 = map;
        if ("oaps".equals(wrapper.getScheme())) {
            map2 = c(context, map);
        }
        return b(context, Uri.parse(OapsParser.encode(map2)), a2);
    }

    @Override // com.cdo.oaps.ad.l
    public boolean b(Context context, Map<String, Object> map) {
        OapsWrapper wrapper = OapsWrapper.wrapper(map);
        Map<String, Object> map2 = map;
        if ("oaps".equals(wrapper.getScheme())) {
            map2 = c(context, map);
        }
        return a(context, Uri.parse(OapsParser.encode(map2)), a(context, wrapper));
    }
}
