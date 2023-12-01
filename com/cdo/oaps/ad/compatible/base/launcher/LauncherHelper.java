package com.cdo.oaps.ad.compatible.base.launcher;

import android.content.Context;
import android.net.Uri;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.OapsParser;
import com.cdo.oaps.ad.OapsWrapper;
import com.cdo.oaps.ad.ad;
import com.cdo.oaps.ad.m;
import com.cdo.oaps.ad.s;
import com.cdo.oaps.ad.v;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/compatible/base/launcher/LauncherHelper.class */
public class LauncherHelper {
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
        if (com.cdo.oaps.ad.Launcher.Host.MK_OP.equals(r4) != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r3, java.lang.String r4) {
        /*
            r0 = r4
            r5 = r0
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L43
            java.lang.String r0 = "mk"
            r1 = r4
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1d
            r0 = r4
            r5 = r0
            java.lang.String r0 = "mk_op"
            r1 = r4
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L43
        L1d:
            r0 = r3
            java.lang.String r1 = com.cdo.oaps.ad.a.b()
            boolean r0 = com.cdo.oaps.ad.p.b(r0, r1)
            if (r0 != 0) goto L40
            r0 = r3
            java.lang.String r1 = "com.heytap.market"
            boolean r0 = com.cdo.oaps.ad.p.b(r0, r1)
            if (r0 == 0) goto L33
            goto L40
        L33:
            r0 = r3
            java.lang.String r1 = com.cdo.oaps.ad.a.a()
            boolean r0 = com.cdo.oaps.ad.p.b(r0, r1)
            if (r0 == 0) goto L40
            java.lang.String r0 = "mk_op"
            return r0
        L40:
            java.lang.String r0 = "mk"
            r5 = r0
        L43:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdo.oaps.ad.compatible.base.launcher.LauncherHelper.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static boolean launchActivity(Context context, String str) {
        return launchActivity(context, OapsParser.decode(str));
    }

    public static boolean launchActivity(Context context, Map<String, Object> map) {
        BaseWrapper.wrapper(map).setHost(a(context, BaseWrapper.wrapper(map).getHost()));
        return m.a(OapsWrapper.wrapper(map).getHost()).a(context, map);
    }

    public static boolean launchService(Context context, String str) {
        return launchService(context, OapsParser.decode(str));
    }

    public static boolean launchService(Context context, Map<String, Object> map) {
        BaseWrapper.wrapper(map).setHost(a(context, BaseWrapper.wrapper(map).getHost()));
        return m.a(OapsWrapper.wrapper(map).getHost()).b(context, map);
    }

    public static boolean support(Context context, String str) {
        String str2;
        String str3;
        Uri parse;
        try {
            parse = Uri.parse(str);
            str2 = parse.getHost();
        } catch (Throwable th) {
            th = th;
            str2 = null;
        }
        try {
            str3 = parse.getPath();
        } catch (Throwable th2) {
            th = th2;
            th.printStackTrace();
            str3 = null;
            return support(context, str2, str3);
        }
        return support(context, str2, str3);
    }

    public static boolean support(Context context, String str, String str2) {
        if (Launcher.Host.GC.equals(str)) {
            return v.a(context, str2);
        }
        String a2 = a(context, str);
        if ("mk".equals(a2)) {
            return ad.a(context, str2);
        }
        if (Launcher.Host.MK_OP.equals(a2)) {
            return s.a(context, str2);
        }
        return false;
    }
}
