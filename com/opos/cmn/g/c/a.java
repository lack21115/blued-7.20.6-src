package com.opos.cmn.g.c;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.OapsWrapper;
import com.cdo.oaps.ad.compatible.base.launcher.LauncherHelper;
import com.cdo.oaps.ad.wrapper.ResourceWrapper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/g/c/a.class */
public final class a {
    private static void a(Context context, String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap();
        OapsWrapper wrapper = OapsWrapper.wrapper((Map<String, Object>) hashMap);
        wrapper.setScheme("oaps").setHost("mk").setPath(Launcher.Path.DETAIL_DOWN);
        if (!TextUtils.isEmpty(str5)) {
            wrapper.set("tk_con", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            wrapper.set("tk_ref", str6);
        }
        ResourceWrapper wrapper2 = ResourceWrapper.wrapper((Map<String, Object>) hashMap);
        wrapper2.setAutoDown(z);
        wrapper2.setGoBack("1");
        wrapper2.setPkgName(str);
        wrapper2.setEnterId(str7);
        wrapper2.setEnterModule(str2);
        if (!TextUtils.isEmpty(str4)) {
            wrapper2.setTraceId(str4);
        }
        if (!TextUtils.isEmpty(str3)) {
            wrapper2.setChannelPkg(str3);
        }
        LauncherHelper.launchActivity(context, hashMap);
    }

    private static boolean a(Context context) {
        return LauncherHelper.support(context, "mk", Launcher.Path.DETAIL_DOWN);
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return a(context, str, str2, str3, str4, str5, str6, "14");
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (context == null || com.opos.cmn.an.c.a.a(str) || com.opos.cmn.an.c.a.a(str7)) {
            com.opos.cmn.an.f.a.c("OApsTool", "context or pkgName or enterId cannot be null");
            return false;
        }
        try {
            if (a(context)) {
                a(context, str, true, str2, str3, str4, str5, str6, str7);
                return true;
            }
            return false;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("OApsTool", "", e);
            return false;
        }
    }
}
